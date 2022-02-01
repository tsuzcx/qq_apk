package com.tencent.qqmini.sdk.ipc;

import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class LaunchManagerClient$3
  implements Runnable
{
  LaunchManagerClient$3(LaunchManagerClient paramLaunchManagerClient, ILaunchManager paramILaunchManager, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    try
    {
      this.val$service.preloadDownloadPackage(this.val$appInfo, this.val$resultReceiver);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "preloadPackage exception.", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.3
 * JD-Core Version:    0.7.0.1
 */