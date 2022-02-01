import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nfk
  extends abiv
{
  static final String[] a = { "ProfileService", "OnlinePush" };
  private final HashMap<String, nfl> b = new HashMap();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (nfl localnfl = (nfl)this.b.get(str);; localnfl = null)
    {
      if (localnfl != null) {}
      for (paramToServiceMsg = localnfl.a(paramToServiceMsg, paramFromServiceMsg);; paramToServiceMsg = null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "decode, cmd[" + str + "], coder[" + localnfl + "], result[" + paramToServiceMsg + "]");
        }
        return paramToServiceMsg;
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (nfl localnfl = (nfl)this.b.get(str);; localnfl = null)
    {
      if (localnfl != null) {}
      for (boolean bool = localnfl.a(paramToServiceMsg, paramUniPacket);; bool = false)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "encodeReqMsg, cmd[" + str + "], coder[" + localnfl + "], ret[" + bool + "]");
        }
        return bool;
      }
    }
  }
  
  public String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfk
 * JD-Core Version:    0.7.0.1
 */