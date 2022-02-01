package com.tencent.proxyinner.plugin.loader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.MultiLoaderPpsController;
import com.tencent.shadow.dynamic.host.QShadowMultiLoaderPluginProcessService;
import cooperation.plugin.HighPluginCrashException;

public class ShadowPluginsProcessService
  extends QShadowMultiLoaderPluginProcessService
{
  private long jdField_a_of_type_Long = 0L;
  private MultiLoaderPpsController jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController;
  
  public static void a(Context paramContext)
  {
    try
    {
      paramContext.startService(new Intent(paramContext.getApplicationContext(), ShadowPluginsProcessService.class));
      return;
    }
    catch (Exception paramContext)
    {
      CaughtExceptionReport.a(new HighPluginCrashException("插件预加载异常", paramContext), "start ShadowPluginsProcessService Exception");
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = super.onBind(paramIntent);
    this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController = wrapBinder(paramIntent);
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
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController.exit();
      label24:
      this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label24;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return 2;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
    if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 1000L)
    {
      QLog.i("ShadowPluginsProcessService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
      return;
    }
    QLog.i("ShadowPluginsProcessService", 2, "onTaskRemoved");
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController != null) {
      try
      {
        this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController.exit();
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    QLog.i("ShadowPluginsProcessService", 2, "ppsController null System.exit");
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.ShadowPluginsProcessService
 * JD-Core Version:    0.7.0.1
 */