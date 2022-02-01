package com.tencent.mobileqq.msf.core.net.d.a;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class a
  implements b
{
  private static final String a = "FromServiceMsgParamFill";
  
  public FromServiceMsg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    if (paramToServiceMsg != null)
    {
      int i = paramToServiceMsg.getRequestSsoSeq();
      paramFromServiceMsg.setRequestSsoSeq(i);
      if (QLog.isColorLevel()) {
        QLog.d("FromServiceMsgParamFill", 2, new Object[] { "[filter] set from message ssoSeq: ", Integer.valueOf(i) });
      }
    }
    return paramFromServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.a
 * JD-Core Version:    0.7.0.1
 */