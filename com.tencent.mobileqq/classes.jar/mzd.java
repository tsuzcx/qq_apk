import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class mzd
  extends mzj
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  
  public FaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzd
 * JD-Core Version:    0.7.0.1
 */