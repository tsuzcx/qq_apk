package cooperation.wadl.ipc;

import android.os.Bundle;
import android.os.SystemClock;
import bifn;
import bldj;
import blds;
import bldt;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class WadlProxyServiceMonitor
  extends Thread
  implements bldj
{
  private static final String jdField_a_of_type_JavaLangString = bldt.b + "WadlProxyServiceMonitor";
  private final int jdField_a_of_type_Int = 3;
  private final long jdField_a_of_type_Long = 30000L;
  private blds jdField_a_of_type_Blds;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 30000L;
  private final long c = 60000L;
  private final long d = 120000L;
  private long e;
  private long f;
  
  public WadlProxyServiceMonitor(blds paramblds)
  {
    this.jdField_a_of_type_Blds = paramblds;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        bifn.c(jdField_a_of_type_JavaLangString, "stopMonitoring");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    finally {}
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    long l = (30000.0F * paramFloat);
    try
    {
      this.jdField_b_of_type_Long = l;
      if (QLog.isColorLevel()) {
        bifn.c(jdField_a_of_type_JavaLangString, "setCheckRate rate=" + paramFloat + ",checkInterval=" + this.jdField_b_of_type_Long + ",isServiceDied=" + paramBoolean);
      }
      if (paramBoolean) {
        this.jdField_b_of_type_Int = 0;
      }
      return;
    }
    finally {}
  }
  
  public void a(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    this.e = l;
    if (this.f == 0L) {
      this.f = l;
    }
    if (l - this.f > 120000L)
    {
      this.f = l;
      if (this.jdField_b_of_type_Int >= 3) {
        this.jdField_a_of_type_Blds.a();
      }
    }
    for (this.jdField_b_of_type_Int = 0;; this.jdField_b_of_type_Int += 1)
    {
      if (QLog.isColorLevel()) {
        bifn.c(jdField_a_of_type_JavaLangString, "onRecvHeart lastRecvReportTime=" + this.e + ",lastCheckTime=" + this.f + ",lastReportCount=" + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          bifn.c(jdField_a_of_type_JavaLangString, "startMonitoring...");
        }
        setName("WadlProxyService.Monitor.Thread");
        start();
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        bifn.a(jdField_a_of_type_JavaLangString, "startMonitoring exception", localThrowable);
        continue;
      }
      finally {}
      return;
      if (QLog.isColorLevel()) {
        bifn.b(jdField_a_of_type_JavaLangString, "startMonitoring,but is running");
      }
    }
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          Thread.sleep(this.jdField_b_of_type_Long);
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            break label101;
          }
          long l = SystemClock.elapsedRealtime();
          if ((this.e == 0L) || (l - this.e > 60000L))
          {
            if (QLog.isColorLevel()) {
              bifn.c(jdField_a_of_type_JavaLangString, "MonitorWorkingThread startWadlService");
            }
            this.jdField_a_of_type_Blds.a(1);
          }
        }
        else
        {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        bifn.c(jdField_a_of_type_JavaLangString, "MonitorWorkingThread is running");
        continue;
        label101:
        if (QLog.isColorLevel()) {
          bifn.c(jdField_a_of_type_JavaLangString, "MonitorWorkingThread not running");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */