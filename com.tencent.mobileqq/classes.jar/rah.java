import com.tencent.litetransfersdk.LiteTransferWrapper;

public class rah
  implements Runnable
{
  public rah(LiteTransferWrapper paramLiteTransferWrapper, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetServicePathToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rah
 * JD-Core Version:    0.7.0.1
 */