import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;

public class rcu
  implements Runnable
{
  public rcu(LiteTransferWrapper paramLiteTransferWrapper, MsgCSBody paramMsgCSBody) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L) {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.PbMsgReciveToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ComTencentLitetransfersdkMsgCSBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rcu
 * JD-Core Version:    0.7.0.1
 */