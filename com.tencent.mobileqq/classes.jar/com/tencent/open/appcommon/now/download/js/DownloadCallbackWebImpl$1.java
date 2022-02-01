package com.tencent.open.appcommon.now.download.js;

import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class DownloadCallbackWebImpl$1
  implements Runnable
{
  DownloadCallbackWebImpl$1(DownloadCallbackWebImpl paramDownloadCallbackWebImpl, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b != null) && (CallBackEvent.a().b())) {
      try
      {
        this.a.loadUrl(this.b);
        return;
      }
      catch (Exception localException)
      {
        LogUtility.a("DownloadCallbackWebImpl", "doJsCallBack >>> ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl.1
 * JD-Core Version:    0.7.0.1
 */