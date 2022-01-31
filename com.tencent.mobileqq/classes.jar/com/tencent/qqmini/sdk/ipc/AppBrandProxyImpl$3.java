package com.tencent.qqmini.sdk.ipc;

import android.os.RemoteException;
import bepl;
import bepp;
import betc;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxyImpl$3
  implements Runnable
{
  public AppBrandProxyImpl$3(bepl parambepl, bepp parambepp, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Bepp.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      betc.d("minisdk-start_AppBrandProxy", "preloadPackage exception.", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */