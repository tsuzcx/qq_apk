package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class r$b
  implements Runnable
{
  private ToServiceMsg b;
  
  public r$b(r paramr, ToServiceMsg paramToServiceMsg)
  {
    this.b = paramToServiceMsg;
  }
  
  public void run()
  {
    if (this.b == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "req null, add preDetTimeout failed! return.");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq()));
          if ((localToServiceMsg != null) && (localToServiceMsg.isNeedCallback()))
          {
            localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq()));
            if (localToServiceMsg == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("MSF.C.NetConnTag", 2, "timeout msg " + localToServiceMsg + " also received resp, return.");
            }
          }
        }
        catch (Exception localException)
        {
          QLog.d("MSF.C.NetConnTag", 1, "got fail msg. " + localException, localException);
          return;
        }
      }
      this.a.a.sender.f(localException);
    } while (localException == null);
    localException.getAttributes().remove("to_predetect_timeoutCallbacker");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.r.b
 * JD-Core Version:    0.7.0.1
 */