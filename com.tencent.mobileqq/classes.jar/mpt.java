import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;

public class mpt
  extends mri
{
  public lfk a;
  public ljr a;
  public mcx a;
  
  mpt(mqb parammqb)
  {
    super(parammqb);
  }
  
  void a()
  {
    this.jdField_a_of_type_Ljr = new mpu(this);
    this.jdField_a_of_type_Lfk = new mpv(this);
    this.jdField_a_of_type_Mcx = new mpw(this);
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication()).a(this.jdField_a_of_type_Ljr);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfk);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mcx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpt
 * JD-Core Version:    0.7.0.1
 */