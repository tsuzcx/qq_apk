package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bejq;
import bers;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class ShareJsPlugin$5
  implements bejq
{
  ShareJsPlugin$5(ShareJsPlugin paramShareJsPlugin, bers parambers, AsyncResult paramAsyncResult) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      besl.d("ShareJsPlugin", "getScreenshot failed, savedScreenshotPath = null");
      if (this.this$0.mMiniAppInfo != null)
      {
        this.val$shareData.b = this.this$0.mMiniAppInfo.iconUrl;
        this.val$shareData.a = false;
        ShareJsPlugin.access$000(this.this$0).onJsShareAppPictureMessage(this.val$shareData, this.val$shareListener);
        return;
      }
      besl.d("ShareJsPlugin", "getScreenshot failed, apkgInfo is null");
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