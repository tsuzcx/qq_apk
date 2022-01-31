package cooperation.wadl.ipc;

import android.os.Bundle;
import anow;
import com.tencent.open.wadl.WLog;
import com.tencent.qphone.base.util.QLog;

public class WadlProxyServiceMonitor
  implements IWadlProxyServiceMonitor
{
  private static String jdField_a_of_type_JavaLangString = "WadlProxyServiceMonitor";
  private long jdField_a_of_type_Long = 10000L;
  private anow jdField_a_of_type_Anow;
  private WadlProxyServiceManager jdField_a_of_type_CooperationWadlIpcWadlProxyServiceManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  
  public WadlProxyServiceMonitor(WadlProxyServiceManager paramWadlProxyServiceManager)
  {
    this.jdField_a_of_type_CooperationWadlIpcWadlProxyServiceManager = paramWadlProxyServiceManager;
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      WLog.b(jdField_a_of_type_JavaLangString, "##@stopMonitoring(), isAnyTaskActive:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Anow != null) {
      this.jdField_a_of_type_Anow.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Anow = null;
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
    WLog.b(jdField_a_of_type_JavaLangString, "##@onReportFromDownloadTask(), isAnyTaskActive:" + this.jdField_a_of_type_Boolean);
  }
  
  public boolean a()
  {
    return c();
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        WLog.b(jdField_a_of_type_JavaLangString, "##@startMonitoring()");
      }
      if (b())
      {
        if (QLog.isColorLevel()) {
          WLog.b(jdField_a_of_type_JavaLangString, "##@startMonitoring():Monitor is running");
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Anow = new anow(this, null);
        this.jdField_a_of_type_Anow.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Anow.setName("WadlProxyService.Monitor.Thread");
        this.jdField_a_of_type_Anow.start();
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Anow != null) {
      return this.jdField_a_of_type_Anow.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceMonitor
 * JD-Core Version:    0.7.0.1
 */