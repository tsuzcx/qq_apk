package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;

class aa
  extends Thread
{
  aa(x paramx) {}
  
  public void run()
  {
    x.b(this.a, true);
    int i = 0;
    while (i < x.b(this.a).h)
    {
      i += 1;
      if (x.c(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
        }
        try
        {
          Thread.sleep(x.b(this.a).i);
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
    x.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aa
 * JD-Core Version:    0.7.0.1
 */