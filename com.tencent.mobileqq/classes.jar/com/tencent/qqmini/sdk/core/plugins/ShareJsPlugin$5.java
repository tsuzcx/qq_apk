package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdfq;
import bdng;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ShareJsPlugin$5
  implements bdfq
{
  ShareJsPlugin$5(ShareJsPlugin paramShareJsPlugin, bdng parambdng, AsyncResult paramAsyncResult) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bdnw.d("ShareJsPlugin", "getScreenshot failed, savedScreenshotPath = null");
      if (this.this$0.mMiniAppInfo != null)
      {
        this.val$shareData.b = this.this$0.mMiniAppInfo.iconUrl;
        this.val$shareData.a = false;
        ShareJsPlugin.access$000(this.this$0).onJsShareAppPictureMessage(this.val$shareData, this.val$shareListener);
        return;
      }
      bdnw.d("ShareJsPlugin", "getScreenshot failed, apkgInfo is null");
      return;
    }
    this.val$shareData.b = paramString;
    this.val$shareData.a = true;
    ShareJsPlugin.access$000(this.this$0).onJsShareAppPictureMessage(this.val$shareData, this.val$shareListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */