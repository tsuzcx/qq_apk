package com.tencent.proxyinner.plugin.loader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.shadow.dynamic.host.MultiLoaderPpsController;
import com.tencent.shadow.dynamic.host.QShadowMultiLoaderPluginProcessService;
import cooperation.plugin.HighPluginCrashException;

public class ShadowPluginsProcessService
  extends QShadowMultiLoaderPluginProcessService
{
  private MultiLoaderPpsController a;
  private long b = 0L;
  
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
    this.a = wrapBinder(paramIntent);
    return paramIntent;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.b = SystemClock.elapsedRealtime();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Process.killProcess(Process.myPid());
    MultiLoaderPpsController localMultiLoaderPpsController = this.a;
    if (localMultiLoaderPpsController != null) {}
    try
    {
      localMultiLoaderPpsController.exit();
      label23:
      this.a = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label23;
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
    if (SystemClock.elapsedRealtime() - this.b < 1000L)
    {
      QLog.i("ShadowPluginsProcessService", 2, "onTaskRemoved, SystemClock.elapsedRealtime() - mOnCreateTimeStamp < 1000");
      return;
    }
    QLog.i("ShadowPluginsProcessService", 2, "onTaskRemoved");
    paramIntent = this.a;
    if (paramIntent != null) {
      try
      {
        paramIntent.exit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.ShadowPluginsProcessService
 * JD-Core Version:    0.7.0.1
 */