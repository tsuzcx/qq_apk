package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;

class ab
  extends Thread
{
  ab(y paramy) {}
  
  public void run()
  {
    y.b(this.a, true);
    int i = 0;
    while (i < y.b(this.a).h)
    {
      i += 1;
      if (y.c(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
        }
        try
        {
          Thread.sleep(y.b(this.a).i);
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
    y.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ab
 * JD-Core Version:    0.7.0.1
 */