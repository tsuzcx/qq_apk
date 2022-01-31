package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import bdkr;
import bdku;
import bdnw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxyImpl$3
  implements Runnable
{
  public AppBrandProxyImpl$3(bdkr parambdkr, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      bdkr.a(this.this$0).a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidOsBundle, new AppBrandProxyImpl.3.1(this, new Handler(Looper.getMainLooper())));
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "startMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */