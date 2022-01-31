package com.tencent.qqmini.sdk.ipc;

import android.os.RemoteException;
import bdkr;
import bdku;
import bdnw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxyImpl$2
  implements Runnable
{
  public AppBrandProxyImpl$2(bdkr parambdkr, bdku parambdku, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Bdku.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "preloadPackage exception.", localRemoteException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */