package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import bgpo;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandProxyImpl$4
  implements Runnable
{
  public AppBrandProxyImpl$4(bgpo parambgpo, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      bgpo.a(this.this$0).startMiniApp(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidOsBundle, new AppBrandProxyImpl.4.1(this, new Handler(Looper.getMainLooper())));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */