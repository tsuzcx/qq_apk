package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import beou;
import beoy;
import besl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppBrandProxyImpl$4
  implements Runnable
{
  public AppBrandProxyImpl$4(beou parambeou, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      beou.a(this.this$0).a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidOsBundle, new AppBrandProxyImpl.4.1(this, new Handler(Looper.getMainLooper())));
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("minisdk-start_AppBrandProxy", "startMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */