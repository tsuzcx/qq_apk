package com.tencent.tmassistant.a;

import com.tencent.tmassistant.common.jce.AppDataReportConfig;

class c
  implements Runnable
{
  c(b paramb, AppDataReportConfig paramAppDataReportConfig) {}
  
  public void run()
  {
    long l = (int)(System.currentTimeMillis() % 5L + 5L) * 1000;
    try
    {
      Thread.sleep(l);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        try
        {
          b.a(this.b, this.a);
          return;
        }
        catch (Throwable localThrowable)
        {
          b.a(this.b, false);
        }
        localInterruptedException = localInterruptedException;
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.a.c
 * JD-Core Version:    0.7.0.1
 */