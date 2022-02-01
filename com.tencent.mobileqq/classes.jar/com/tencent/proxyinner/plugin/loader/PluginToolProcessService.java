package com.tencent.proxyinner.plugin.loader;

import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.MultiLoaderPluginProcessService;
import com.tencent.shadow.dynamic.host.MultiLoaderPpsController;

public class PluginToolProcessService
  extends MultiLoaderPluginProcessService
{
  private long jdField_a_of_type_Long = 0L;
  private MultiLoaderPpsController jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController;
  
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
    ((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).addJumpCallback();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Process.killProcess(Process.myPid());
    MultiLoaderPpsController localMultiLoaderPpsController = this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController;
    if (localMultiLoaderPpsController != null) {}
    try
    {
      localMultiLoaderPpsController.exit();
      label23:
      this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController = null;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label23;
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
    paramIntent = this.jdField_a_of_type_ComTencentShadowDynamicHostMultiLoaderPpsController;
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
    QLog.i("QTProxyService", 2, "ppsController null System.exit");
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.loader.PluginToolProcessService
 * JD-Core Version:    0.7.0.1
 */