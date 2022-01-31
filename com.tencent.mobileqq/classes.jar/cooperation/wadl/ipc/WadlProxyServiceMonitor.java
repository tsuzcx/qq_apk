package cooperation.wadl.ipc;

import android.os.Bundle;
import bdot;
import bibz;
import bici;
import com.tencent.qphone.base.util.QLog;

public class WadlProxyServiceMonitor
  implements bibz
{
  private static String jdField_a_of_type_JavaLangString = "WadlProxyServiceMonitor";
  private long jdField_a_of_type_Long = 10000L;
  private bici jdField_a_of_type_Bici;
  private WadlProxyServiceMonitor.MonitorWorkingThread jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  
  public WadlProxyServiceMonitor(bici parambici)
  {
    this.jdField_a_of_type_Bici = parambici;
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        bdot.b(jdField_a_of_type_JavaLangString, "##@stopMonitoring(), isAnyTaskActive:" + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread != null) {
        this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread = null;
      return;
    }
    finally {}
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = System.currentTimeMillis();
    if (paramBundle == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("WADL_UNFINISHED_RUNING_TASK_FLAG");
    } while (!QLog.isColorLevel());
    bdot.b(jdField_a_of_type_JavaLangString, "##@onReportFromDownloadTask(), isAnyTaskActive:" + this.jdField_a_of_type_Boolean);
  }
  
  public boolean a()
  {
    return c();
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          bdot.b(jdField_a_of_type_JavaLangString, "##@startMonitoring()");
        }
        if (!b()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          bdot.b(jdField_a_of_type_JavaLangString, "##@startMonitoring():Monitor is running");
        }
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      finally {}
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread = new WadlProxyServiceMonitor.MonitorWorkingThread(this, null);
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.setName("WadlProxyService.Monitor.Thread");
      this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.start();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread != null) {
      return this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceMonitor$MonitorWorkingThread.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */