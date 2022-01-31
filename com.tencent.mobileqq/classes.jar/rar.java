import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgSCBody;

public class rar
  implements Runnable
{
  public rar(LiteTransferWrapper paramLiteTransferWrapper, int paramInt, MsgSCBody paramMsgSCBody) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.DoPbMsgReplyToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentLitetransfersdkMsgSCBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rar
 * JD-Core Version:    0.7.0.1
 */