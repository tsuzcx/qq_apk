package com.tencent.mobileqq.msf.core.net.d.a;

import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class i
  implements d
{
  private static final String a = "RetryFilter";
  
  public ToServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    Integer localInteger2 = (Integer)paramToServiceMsg.getAttribute("attr_udp_retry_count");
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    localInteger2 = Integer.valueOf(localInteger1.intValue() + 1);
    QLog.d("RetryFilter", 1, new Object[] { "[filter] retry: ", localInteger1, ", max: ", Integer.valueOf(com.tencent.mobileqq.msf.core.i.a().b()), a.a(paramToServiceMsg) });
    paramToServiceMsg.addAttribute("attr_udp_retry_count", localInteger2);
    if (localInteger2.intValue() > com.tencent.mobileqq.msf.core.i.a().b())
    {
      QLog.d("RetryFilter", 1, new Object[] { "[filter] stop retry: ", a.a(paramToServiceMsg) });
      return null;
    }
    return paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.i
 * JD-Core Version:    0.7.0.1
 */