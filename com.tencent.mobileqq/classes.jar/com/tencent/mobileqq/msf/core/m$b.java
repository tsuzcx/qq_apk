package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class m$b
  implements Runnable
{
  private ToServiceMsg b;
  
  public m$b(m paramm, ToServiceMsg paramToServiceMsg)
  {
    this.b = paramToServiceMsg;
  }
  
  public void run()
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "req null, add preDetTimeout failed! return.");
      }
      return;
    }
    try
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq()));
      if (localToServiceMsg != null)
      {
        if (!localToServiceMsg.isNeedCallback()) {
          return;
        }
        localToServiceMsg = (ToServiceMsg)this.a.a.sender.d.get(Integer.valueOf(this.b.getRequestSsoSeq()));
        if (localToServiceMsg == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("timeout msg ");
          localStringBuilder.append(localToServiceMsg);
          localStringBuilder.append(" also received resp, return.");
          QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
          return;
        }
        this.a.a.sender.f(localToServiceMsg);
        if (localToServiceMsg != null)
        {
          localToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("got fail msg. ");
      localStringBuilder.append(localException);
      QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString(), localException);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m.b
 * JD-Core Version:    0.7.0.1
 */