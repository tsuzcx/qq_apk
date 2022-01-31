package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.ShareScreenshotCallback;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qphone.base.util.QLog;

class DataJsPlugin$12
  implements BaseAppBrandRuntime.ShareScreenshotCallback
{
  DataJsPlugin$12(DataJsPlugin paramDataJsPlugin, ApkgInfo paramApkgInfo, Activity paramActivity, String paramString, int paramInt, MiniProgramShareUtils.OnShareListener paramOnShareListener) {}
  
  public void onGetShareScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("[mini] DataJsPlugin", 1, "getShareScreenshot failed, savedScreenshotPath = null");
      if (this.val$apkgInfo != null)
      {
        DataJsPlugin.access$000(this.this$0, this.val$finalContext, this.val$title, this.val$apkgInfo.iconUrl, this.val$finalShareType, this.val$shareListener);
        return;
      }
      QLog.e("[mini] DataJsPlugin", 1, "getShareScreenshot failed, apkgInfo is null");
      return;
    }
    DataJsPlugin.access$100(this.this$0, this.val$title, paramString, this.val$finalShareType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */