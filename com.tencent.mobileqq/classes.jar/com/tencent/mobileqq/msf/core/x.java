package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;

class x
  extends Thread
{
  x(u paramu) {}
  
  public void run()
  {
    u.b(this.a, true);
    int i = 0;
    while (i < u.b(this.a).h)
    {
      i += 1;
      if (u.c(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
        }
        try
        {
          Thread.sleep(u.b(this.a).i);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQWiFiScanManager", 2, "accScan, count=" + i + ", stopped");
      }
    }
    u.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.x
 * JD-Core Version:    0.7.0.1
 */