import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;

public class mdv
  extends mfk
{
  public kvw a;
  public kzq a;
  public lru a;
  
  mdv(med parammed)
  {
    super(parammed);
  }
  
  void a()
  {
    this.jdField_a_of_type_Kzq = new mdw(this);
    this.jdField_a_of_type_Kvw = new mdx(this);
    this.jdField_a_of_type_Lru = new mdy(this);
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication()).a(this.jdField_a_of_type_Kzq);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kvw);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdv
 * JD-Core Version:    0.7.0.1
 */