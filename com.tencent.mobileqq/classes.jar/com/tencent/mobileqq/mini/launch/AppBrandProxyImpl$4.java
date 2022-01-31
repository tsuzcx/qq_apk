package com.tencent.mobileqq.mini.launch;

import android.os.RemoteException;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

class AppBrandProxyImpl$4
  implements Runnable
{
  AppBrandProxyImpl$4(AppBrandProxyImpl paramAppBrandProxyImpl, IAppBrandService paramIAppBrandService, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      this.val$service.preloadPackage(this.val$appInfo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "preloadPackage exception.", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */