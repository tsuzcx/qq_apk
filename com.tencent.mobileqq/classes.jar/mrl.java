import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;

public class mrl
  extends mta
{
  public lij a;
  public lme a;
  public meu a;
  
  mrl(mrt parammrt)
  {
    super(parammrt);
  }
  
  void a()
  {
    this.jdField_a_of_type_Lme = new mrm(this);
    this.jdField_a_of_type_Lij = new mrn(this);
    this.jdField_a_of_type_Meu = new mro(this);
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication()).a(this.jdField_a_of_type_Lme);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lij);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Meu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mrl
 * JD-Core Version:    0.7.0.1
 */