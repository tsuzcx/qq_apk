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
  private static ThreadRegulator jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator;
  private final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(ThreadRegulator.CpuBusyness.class, 2);
  private volatile ThreadRegulator.CpuBusyness jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new ThreadRegulator.2(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ThreadRegulator.1(this, ThreadManager.getSubThreadLooper());
  
  public static ThreadRegulator a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator == null) {
        jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator = new ThreadRegulator();
      }
      ThreadRegulator localThreadRegulator = jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator;
      return localThreadRegulator;
    }
    finally {}
  }
  
  public void a()
  {
    MqqHandler.sRegulatorCallback = this;
    mqq.app.MainService.sRegulatorCallback = this;
  }
  
  public void a(int paramInt)
  {
    if (!ThreadOptimizer.a().a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness == null)
    {
      this.jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness = ((ThreadRegulator.CpuBusyness)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(ThreadRegulator.CpuBusyness.class));
      this.jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness.jdField_a_of_type_Long = SystemClock.uptimeMillis();
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
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
    }
    ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness == null) {
      return;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqperfOptThreadpriorityThreadRegulator$CpuBusyness != null) {}
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    return;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void checkInRegulatorMsg()
  {
    b();
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
        if (ThreadOptimizer.a().b()) {
          paramThread.setPriority(1);
        }
        return true;
      }
      return "Rejected_Handler".equals(paramThread.getName());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadRegulator
 * JD-Core Version:    0.7.0.1
 */