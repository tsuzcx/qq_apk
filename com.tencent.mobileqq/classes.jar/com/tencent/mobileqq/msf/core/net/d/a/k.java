package com.tencent.mobileqq.msf.core.net.d.a;

import android.text.TextUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class k
  implements d
{
  private static final String a = "UdpOutboundCommandFilte";
  
  public static k a()
  {
    return k.a.a();
  }
  
  public ToServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    if (b(paramToServiceMsg)) {
      return paramToServiceMsg;
    }
    QLog.d("UdpOutboundCommandFilte", 1, new Object[] { "[filter] message deprecated, cmd: ", paramToServiceMsg.getServiceCmd(), ", ssoSeq: ", Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()) });
    return null;
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    return (!TextUtils.isEmpty(paramToServiceMsg)) && (paramToServiceMsg.equals("MessageSvc.PbSendMsg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.k
 * JD-Core Version:    0.7.0.1
 */