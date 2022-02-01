package cooperation.wadl.ipc;

import android.os.Bundle;
import bize;
import bmww;
import bmxf;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class WadlProxyServiceMonitor
  extends Thread
  implements bmww
{
  private long jdField_a_of_type_Long = 10000L;
  private bmxf jdField_a_of_type_Bmxf;
  private volatile AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private long jdField_b_of_type_Long;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public WadlProxyServiceMonitor(bmxf parambmxf)
  {
    this.jdField_a_of_type_Bmxf = parambmxf;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        bize.c("WadlProxyServiceMonitor", "stopMonitoring isAnyTaskActive=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    finally {}
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramBundle == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          boolean bool = paramBundle.getBoolean("WADL_UNFINISHED_RUNING_TASK_FLAG");
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool);
          if (QLog.isColorLevel())
          {
            bize.c("WadlProxyServiceMonitor", "onReportFromDownloadTask isTaskActive=" + bool);
            return;
          }
        }
        catch (Throwable paramBundle) {}
      }
    } while (!QLog.isColorLevel());
    bize.a("WadlProxyServiceMonitor", "onReportFromDownloadTask exception", paramBundle);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    try
    {
      if (b()) {
        if (QLog.isColorLevel()) {
          bize.b("WadlProxyServiceMonitor", "startMonitoring,but is running");
        }
      }
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          bize.c("WadlProxyServiceMonitor", "startMonitoring...");
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        setName("WadlProxyService.Monitor.Thread");
        start();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          bize.a("WadlProxyServiceMonitor", "startMonitoring exception", localThrowable);
        }
      }
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void run()
  {
    try
    {
      while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        Thread.sleep(this.jdField_a_of_type_Long);
        long l = System.currentTimeMillis();
        if ((this.jdField_b_of_type_Long != 0L) && (l - this.jdField_b_of_type_Long > 30000L) && (a()) && (this.jdField_a_of_type_Bmxf != null))
        {
          if (QLog.isColorLevel()) {
            bize.c("WadlProxyServiceMonitor", "MonitorWorkingThread check ipc service status...");
          }
          this.jdField_a_of_type_Bmxf.b();
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */