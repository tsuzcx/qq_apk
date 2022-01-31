import com.tencent.litetransfersdk.LiteTransferWrapper;

public class rcv
  implements Runnable
{
  public rcv(LiteTransferWrapper paramLiteTransferWrapper, String paramString) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetDefaultPathToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rcv
 * JD-Core Version:    0.7.0.1
 */