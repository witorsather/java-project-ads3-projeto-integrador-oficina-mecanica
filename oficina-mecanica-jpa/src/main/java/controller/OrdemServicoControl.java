package controller;

import java.util.List;

import domain.OrdemServico;
import domain.OrdemServicoServico;
import domain.Pessoa;
import domain.Servico;
import domain.Veiculo;
import repository.PessoaImplRepository;
import repository.PessoaRepository;
import repository.ServicoRepository;
import repository.VeiculoRepository;

public class OrdemServicoControl {
	
	private Integer pessoaId;

	private Integer servicoId;

	private Integer funcionarioId;
	
	private PessoaRepository PessoaRepository;
	
	private VeiculoRepository veiculoRepository;
	
	private String placa;
	
	private OrdemServico ordemServico = new OrdemServico();
	
	private OrdemServicoServico ordemServicoServico = new OrdemServicoServico();
	
	private PessoaImplRepository PessoaImplRepository;
	
	private ServicoRepository servicoRepository;
	
	public void atualizarVeiculo() {
		Veiculo veiculo = veiculoRepository.consultarPorPlaca(placa);
		ordemServico.setVeiculo(veiculo);
	}
	
	public void selecionarServico() {
		Servico servico = servicoRepository.findById(servicoId).get();
		ordemServicoServico.setServico(servico);
		ordemServicoServico.setPreco(servico.getPreco());
	}
	
	public void addServico() {
		ordemServico.getServicos().add(ordemServicoServico);
		servicoId = null;
		ordemServicoServico = new OrdemServicoServico();
	}
	
    public List<Pessoa> completePessoa(String query) {
    	return PessoaImplRepository.listarPorNome("%" + query + "%", null);
    }	

    public List<Servico> completeServico(String query) {
    	return servicoRepository.listarPorNome("%" + query + "%");
    }	
    
    public List<Pessoa> completeFuncionario(String query) {
    	return PessoaImplRepository.listarPorNome("%" + query + "%", true);
    }	

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public OrdemServicoServico getOrdemServicoServico() {
		return ordemServicoServico;
	}

	public void setOrdemServicoServico(OrdemServicoServico ordemServicoServico) {
		this.ordemServicoServico = ordemServicoServico;
	}
	
}