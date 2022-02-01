package com.tencent.mobileqq.troop.widget;

import com.tencent.qphone.base.util.QLog;

public class CountdownTimeTask
  implements Runnable
{
  protected long a = 1000L;
  protected Object b = new Object();
  protected Runnable c = null;
  
  public CountdownTimeTask(Runnable paramRunnable, int paramInt)
  {
    this.c = paramRunnable;
    a(paramInt);
  }
  
  public void a()
  {
    a(this.a);
  }
  
  public void a(long paramLong)
  {
    synchronized (this.b)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetTimer: ");
        localStringBuilder.append(paramLong);
        QLog.d("CountDownTimeTask", 2, localStringBuilder.toString());
      }
      this.a = paramLong;
      return;
    }
  }
  
  public void b()
  {
    a(-1L);
  }
  
  public long c()
  {
    return this.a;
  }
  
  public void run()
  {
    long l;
    for (;;)
    {
      l = this.a;
      if (l <= 0L) {
        break;
      }
      try
      {
        Thread.sleep(100L);
        synchronized (this.b)
        {
          this.a -= 100L;
          if (!QLog.isColorLevel()) {
            continue;
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("run: ");
          ((StringBuilder)???).append(this.a);
          QLog.d("CountDownTimeTask", 2, ((StringBuilder)???).toString());
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      QLog.d("CountDownTimeTask", 2, QLog.getStackTraceString(localInterruptedException));
    }
    if (l != -1L)
    {
      Runnable localRunnable = this.c;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.CountdownTimeTask
 * JD-Core Version:    0.7.0.1
 */