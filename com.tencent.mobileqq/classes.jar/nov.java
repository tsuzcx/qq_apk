import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class nov
  extends nou
{
  protected byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = super.a(paramFromServiceMsg);
    if (paramFromServiceMsg != null)
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      try
      {
        localStQWebRsp.mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = localStQWebRsp.busiBuff.get().toByteArray();
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nov
 * JD-Core Version:    0.7.0.1
 */