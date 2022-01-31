import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.Session;

public class rao
  implements Runnable
{
  public rao(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession, NFCInfo[] paramArrayOfNFCInfo, FTNInfo[] paramArrayOfFTNInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper) != 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.SetProxyToJni();
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.RecvGroupToJNI(LiteTransferWrapper.access$200(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper), this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkSession, this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkNFCInfo, this.jdField_a_of_type_ArrayOfComTencentLitetransfersdkFTNInfo, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     rao
 * JD-Core Version:    0.7.0.1
 */