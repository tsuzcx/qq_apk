package com.tencent.mobileqq.startup.director;

import amxv;
import com.tencent.qphone.base.util.QLog;

public final class StartupDirector$5
  extends Thread
{
  public void run()
  {
    long l2 = amxv.a("-1");
    long l4 = System.currentTimeMillis();
    long l1 = l2;
    try
    {
      for (;;)
      {
        Thread.sleep(2000L);
        long l3 = amxv.a("-1");
        QLog.d("Perf", 1, new Object[] { "ProcCpu,proc;", Long.valueOf(System.currentTimeMillis() - l4), ";cost cpu;", Long.valueOf(l3 - l2), ";", Long.valueOf(l3 - l1) });
        l1 = l3;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.5
 * JD-Core Version:    0.7.0.1
 */