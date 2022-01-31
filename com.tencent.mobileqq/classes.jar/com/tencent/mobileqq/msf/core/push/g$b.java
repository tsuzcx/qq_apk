package com.tencent.mobileqq.msf.core.push;

import com.tencent.qphone.base.util.QLog;

class g$b
  extends Thread
{
  g$b(g paramg) {}
  
  public void run()
  {
    synchronized (this.a.y)
    {
      try
      {
        this.a.y.wait();
        this.a.h();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("MSF.C.PushManager", 2, localInterruptedException.toString(), localInterruptedException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.g.b
 * JD-Core Version:    0.7.0.1
 */