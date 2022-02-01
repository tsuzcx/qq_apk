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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("accScan, launch count=");
          localStringBuilder1.append(i);
          QLog.d("QQWiFiScanManager", 2, localStringBuilder1.toString());
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
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("accScan, count=");
        localStringBuilder2.append(i);
        localStringBuilder2.append(", stopped");
        QLog.d("QQWiFiScanManager", 2, localStringBuilder2.toString());
      }
    }
    u.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.x
 * JD-Core Version:    0.7.0.1
 */