package com.tencent.qqperf.opt.threadpriority;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.os.MqqRegulatorCallback;

public class ThreadRegulator
  implements MqqRegulatorCallback
{
  private static ThreadRegulator b;
  Runnable a = new ThreadRegulator.2(this);
  private final RecyclablePool c = new RecyclablePool(ThreadRegulator.CpuBusyness.class, 2);
  private volatile ThreadRegulator.CpuBusyness d = null;
  private MqqHandler e = new ThreadRegulator.1(this, ThreadManager.getSubThreadLooper());
  
  public static ThreadRegulator a()
  {
    try
    {
      if (b == null) {
        b = new ThreadRegulator();
      }
      ThreadRegulator localThreadRegulator = b;
      return localThreadRegulator;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (!ThreadOptimizer.a().d()) {
      return;
    }
    if (this.d == null)
    {
      this.d = ((ThreadRegulator.CpuBusyness)this.c.obtain(ThreadRegulator.CpuBusyness.class));
      this.d.a = paramInt;
      this.d.b = SystemClock.uptimeMillis();
      try
      {
        ThreadExcutor.getInstance().shrinkMaxPoolSize(true);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ThreadManager.Regulaotr", 1, "markBusyState: invoked. ", localThrowable);
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramLong == 0L)
    {
      this.a.run();
      return;
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.a, paramLong);
  }
  
  public void b()
  {
    MqqHandler.sRegulatorCallback = this;
    mqq.app.MainService.sRegulatorCallback = this;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void c()
  {
    if (this.d == null) {
      return;
    }
    for (;;)
    {
      if (this.d != null) {}
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    return;
  }
  
  public void checkInRegulatorMsg()
  {
    c();
  }
  
  public boolean regulatorThread(Thread paramThread)
  {
    if (paramThread != ThreadManager.getFileThread())
    {
      if (paramThread == ThreadManager.getSubThread()) {
        return true;
      }
      if ("MSF-Receiver".equals(paramThread.getName()))
      {
        if (ThreadOptimizer.a().e()) {
          paramThread.setPriority(1);
        }
        return true;
      }
      return "Rejected_Handler".equals(paramThread.getName());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadRegulator
 * JD-Core Version:    0.7.0.1
 */