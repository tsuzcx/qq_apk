import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ndr
  extends aber
{
  static final String[] a = { "ProfileService", "OnlinePush" };
  private final HashMap<String, nds> b = new HashMap();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (nds localnds = (nds)this.b.get(str);; localnds = null)
    {
      if (localnds != null) {}
      for (paramToServiceMsg = localnds.a(paramToServiceMsg, paramFromServiceMsg);; paramToServiceMsg = null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "decode, cmd[" + str + "], coder[" + localnds + "], result[" + paramToServiceMsg + "]");
        }
        return paramToServiceMsg;
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (nds localnds = (nds)this.b.get(str);; localnds = null)
    {
      if (localnds != null) {}
      for (boolean bool = localnds.a(paramToServiceMsg, paramUniPacket);; bool = false)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "encodeReqMsg, cmd[" + str + "], coder[" + localnds + "], ret[" + bool + "]");
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
 * Qualified Name:     ndr
 * JD-Core Version:    0.7.0.1
 */