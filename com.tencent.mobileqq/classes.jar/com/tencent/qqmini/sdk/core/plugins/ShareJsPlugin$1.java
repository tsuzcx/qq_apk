package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgib;
import bgkc;
import com.tencent.qqmini.sdk.core.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

class ShareJsPlugin$1
  implements bgib
{
  ShareJsPlugin$1(ShareJsPlugin paramShareJsPlugin, bgkc parambgkc) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.val$shareDataBuilder.c(this.this$0.mMiniAppInfo.iconUrl).a().a();
      QMLog.e("ShareJsPlugin", "getScreenshot for QzoneShare failed, savedScreenshotPath = null");
      return;
    }
    this.val$shareDataBuilder.c(paramString).a(true).a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */