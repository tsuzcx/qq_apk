package com.tencent.mobileqq.msf.core.push;

import com.tencent.qphone.base.util.QLog;

class g$b
  extends Thread
{
  g$b(g paramg) {}
  
  public void run()
  {
    try
    {
      synchronized (this.a.z)
      {
        this.a.z.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.C.PushManager", 2, localInterruptedException.toString(), localInterruptedException);
      }
      this.a.f();
    }
    for (;;)
    {
      throw localInterruptedException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.g.b
 * JD-Core Version:    0.7.0.1
 */