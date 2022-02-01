package com.tencent.mobileqq.mini.appbrand.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.sdk.LaunchParam;

class AppBrandFragment$6$1
  implements Runnable
{
  AppBrandFragment$6$1(AppBrandFragment.6 param6, MiniAppStateManager.MiniAppStateMsg paramMiniAppStateMsg) {}
  
  public void run()
  {
    switch (this.val$msg.state)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
      } while ((this.val$msg.apkgInfo == null) || (this.this$1.this$0 != AppLoaderFactory.getAppUIProxy().getAppBrandFragment()));
      AppBrandFragment.access$002(this.this$1.this$0, false);
      this.this$1.this$0.appBrandRuntimeContainer.init(this.val$msg.apkgInfo, this.val$msg.apkgInfo.appConfig.launchParam.entryPath, AppBrandFragment.access$100(this.this$1.this$0));
      MiniGdtReporter.report(this.this$1.this$0.miniConfig, 0);
      return;
    }
    if (!TextUtils.isEmpty(this.val$msg.appId)) {
      this.this$1.this$0.appBrandRuntimeContainer.getAppBrandRunTime(this.val$msg.appId, this.val$msg.versionType);
    }
    AppBrandFragment.access$002(this.this$1.this$0, true);
    AppBrandFragment.access$200(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.6.1
 * JD-Core Version:    0.7.0.1
 */