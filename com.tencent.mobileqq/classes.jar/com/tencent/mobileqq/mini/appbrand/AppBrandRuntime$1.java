package com.tencent.mobileqq.mini.appbrand;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class AppBrandRuntime$1
  implements AppBrandRuntime.JsErrorListener
{
  AppBrandRuntime$1(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void onJsError()
  {
    if ((!this.this$0.isFirstDomReady) && (this.this$0.apkgInfo != null) && (this.this$0.apkgInfo.appConfig != null))
    {
      MiniAppConfig localMiniAppConfig = this.this$0.apkgInfo.appConfig;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("app_config", localMiniAppConfig);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "launch_report_js_error", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.1
 * JD-Core Version:    0.7.0.1
 */