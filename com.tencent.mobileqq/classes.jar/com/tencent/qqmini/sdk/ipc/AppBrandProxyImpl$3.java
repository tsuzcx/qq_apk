package com.tencent.qqmini.sdk.ipc;

import android.os.RemoteException;
import bgtv;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandProxyImpl$3
  implements Runnable
{
  public AppBrandProxyImpl$3(bgtv parambgtv, IAppMainService paramIAppMainService, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.preloadDownloadPackage(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "preloadPackage exception.", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */