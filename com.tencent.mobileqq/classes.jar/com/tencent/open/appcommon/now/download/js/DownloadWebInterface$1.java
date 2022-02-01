package com.tencent.open.appcommon.now.download.js;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class DownloadWebInterface$1
  implements Runnable
{
  DownloadWebInterface$1(DownloadWebInterface paramDownloadWebInterface, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.webview != null) && (!TextUtils.isEmpty(this.a)))
      {
        this.this$0.webview.loadUrl(this.a);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.a(this.this$0.TAG, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadWebInterface.1
 * JD-Core Version:    0.7.0.1
 */