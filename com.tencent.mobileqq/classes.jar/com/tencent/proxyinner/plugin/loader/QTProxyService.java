package com.tencent.proxyinner.plugin.loader;

import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;

public class QTProxyService
  extends PluginProcessService
{
  private long jdField_a_of_type_Long = 0L;
  private PpsController jdField_a_of_type_ComTencentShadowDynamicHostPpsController;
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = super.onBind(paramIntent);
    this.jdField_a_of_type_ComTencentShadowDynamicHostPpsController = wrapBinder(paramIntent);
    return paramIntent;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Process.killProcess(Process.myPid());
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostPpsController != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentShadowDynamicHostPpsController.exit();
      label24:
      this.jdField_a_of_type_ComTencentShadowDynamicHostPpsController = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label24;
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 1000L)
    {
      QLog.i("QTProxyService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
      return;
    }
    QLog.i("QTProxyService", 2, "onTaskRemoved");
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostPpsController != null) {
      try
      {
        this.jdField_a_of_type_ComTencentShadowDynamicHostPpsController.exit();
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    QLog.i("QTProxyService", 2, "ppsController null System.exit");
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.QTProxyService
 * JD-Core Version:    0.7.0.1
 */