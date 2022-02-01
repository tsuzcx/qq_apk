import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nnk
  extends aauq
{
  static final String[] a = { "ProfileService", "OnlinePush" };
  private final HashMap<String, nnl> b = new HashMap();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (nnl localnnl = (nnl)this.b.get(str);; localnnl = null)
    {
      if (localnnl != null) {}
      for (paramToServiceMsg = localnnl.a(paramToServiceMsg, paramFromServiceMsg);; paramToServiceMsg = null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "decode, cmd[" + str + "], coder[" + localnnl + "], result[" + paramToServiceMsg + "]");
        }
        return paramToServiceMsg;
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (!TextUtils.isEmpty(str)) {}
    for (nnl localnnl = (nnl)this.b.get(str);; localnnl = null)
    {
      if (localnnl != null) {}
      for (boolean bool = localnnl.a(paramToServiceMsg, paramUniPacket);; bool = false)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameProtocolCoder", 4, "encodeReqMsg, cmd[" + str + "], coder[" + localnnl + "], ret[" + bool + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnk
 * JD-Core Version:    0.7.0.1
 */