package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bejq;
import bejy;
import bers;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;

class ShareJsPlugin$3
  implements bejq
{
  ShareJsPlugin$3(ShareJsPlugin paramShareJsPlugin, bers parambers, AsyncResult paramAsyncResult) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.val$shareData.b = this.this$0.mApkgInfo.e;
      ShareJsPlugin.access$000(this.this$0).onJsShareAppMessage(this.val$shareData, this.val$shareListener);
      besl.d("ShareJsPlugin", "getScreenshot failed, savedScreenshotPath = null");
      return;
    }
    this.val$shareData.b = paramString;
    ShareJsPlugin.access$000(this.this$0).onJsShareAppMessage(this.val$shareData, this.val$shareListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */