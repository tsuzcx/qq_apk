package com.tencent.mobileqq.msf.core.quicksend;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class b$a
  implements Runnable
{
  private ToServiceMsg b;
  
  public b$a(b paramb, ToServiceMsg paramToServiceMsg)
  {
    this.b = paramToServiceMsg;
  }
  
  public void run()
  {
    if (this.b == null)
    {
      QLog.d("MSF.C.QuickSendManager", 1, "req null, return.");
      return;
    }
    try
    {
      if ((b.b(this.a).quicksender != null) && (b.b(this.a).quicksender.b(this.b))) {
        b.b(this.a).quicksender.f.b(this.b);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.a.a(this.b);
    a locala = QuickSendStrategy.getStragegyArgs(this.b.getQuickSendStrategy());
    if ((com.tencent.mobileqq.msf.core.a.a.bp()) && (locala != null) && (locala.d)) {
      this.a.a(com.tencent.mobileqq.msf.core.a.a.G());
    }
    if ((com.tencent.mobileqq.msf.core.a.a.aH()) && (this.b.getServiceCmd().equals("MessageSvc.PbSendMsg"))) {
      com.tencent.mobileqq.a.a.d.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.b.a
 * JD-Core Version:    0.7.0.1
 */