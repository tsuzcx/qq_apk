import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.Session;

public class rdc
  implements Runnable
{
  public rdc(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SyncGroupToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rdc
 * JD-Core Version:    0.7.0.1
 */