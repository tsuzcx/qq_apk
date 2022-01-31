package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bekh;
import besj;
import betc;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;

class ShareJsPlugin$2
  implements bekh
{
  ShareJsPlugin$2(ShareJsPlugin paramShareJsPlugin, besj parambesj, AsyncResult paramAsyncResult) {}
  
  public void onGetScreenshot(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.val$shareData.b = paramString;
      ShareJsPlugin.access$000(this.this$0).onJsShareAppMessage(this.val$shareData, this.val$shareListener);
      betc.d("ShareJsPlugin", "getScreenshot for QzoneShare failed, savedScreenshotPath = null");
      return;
    }
    this.val$shareData.b = paramString;
    ShareJsPlugin.access$000(this.this$0).onJsShareAppMessage(this.val$shareData, this.val$shareListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */