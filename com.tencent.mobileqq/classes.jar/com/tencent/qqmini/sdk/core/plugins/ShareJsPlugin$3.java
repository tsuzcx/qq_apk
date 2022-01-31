package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgib;
import bgkc;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

class ShareJsPlugin$3
  implements bgib
{
  ShareJsPlugin$3(ShareJsPlugin paramShareJsPlugin, bgkc parambgkc) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("ShareJsPlugin", "getScreenshot failed, savedScreenshotPath = null");
      if (this.this$0.mMiniAppInfo != null)
      {
        this.val$shareDataBuilder.c(this.this$0.mMiniAppInfo.iconUrl).a(false).a().b();
        return;
      }
      QMLog.e("ShareJsPlugin", "getScreenshot failed, apkgInfo is null");
      return;
    }
    this.val$shareDataBuilder.c(paramString).a(true).a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */