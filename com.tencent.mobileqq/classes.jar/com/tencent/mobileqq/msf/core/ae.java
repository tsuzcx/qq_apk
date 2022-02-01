package com.tencent.mobileqq.msf.core;

import com.tencent.qphone.base.util.QLog;

class ae
  extends Thread
{
  ae(ab paramab) {}
  
  public void run()
  {
    ab.b(this.a, true);
    int i = 0;
    while (i < ab.b(this.a).h)
    {
      i += 1;
      if (ab.c(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQWiFiScanManager", 2, "accScan, launch count=" + i);
        }
        try
        {
          Thread.sleep(ab.b(this.a).i);
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
    ab.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ae
 * JD-Core Version:    0.7.0.1
 */