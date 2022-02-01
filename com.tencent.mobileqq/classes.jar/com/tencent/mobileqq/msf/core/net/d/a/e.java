package com.tencent.mobileqq.msf.core.net.d.a;

import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.b.a;
import com.tencent.mobileqq.msf.core.m;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class e
  implements b, d
{
  private static final String a = "MessageTimeoutFilter";
  
  public static e a()
  {
    return e.a.a();
  }
  
  public FromServiceMsg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
    if (localRunnable != null) {
      MsfService.core.getMsfAlarmer().b().removeCallbacks(localRunnable);
    }
    QLog.d("MessageTimeoutFilter", 1, new Object[] { "[filter] remove callback ssoSeq: ", a.a(paramToServiceMsg) });
    return paramFromServiceMsg;
  }
  
  public ToServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    long l = paramToServiceMsg.getTimeout();
    if ((l != -1L) && ((Runnable)paramToServiceMsg.getAttribute("to_timeoutCallbacker") == null))
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", MsfService.core.getMsfAlarmer().a(paramToServiceMsg, l, new f(this)));
      QLog.d("MessageTimeoutFilter", 1, new Object[] { "[filter] setTimeout ", Long.valueOf(l), a.a(paramToServiceMsg) });
    }
    return paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.a.e
 * JD-Core Version:    0.7.0.1
 */