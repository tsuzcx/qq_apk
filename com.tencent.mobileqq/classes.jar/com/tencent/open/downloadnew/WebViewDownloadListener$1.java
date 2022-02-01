package com.tencent.open.downloadnew;

import android.os.Build.VERSION;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class WebViewDownloadListener$1
  implements Runnable
{
  WebViewDownloadListener$1(WebViewDownloadListener paramWebViewDownloadListener, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b != null) && (CallBackEvent.a().b())) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wb.loadUrl(loadJs):");
        localStringBuilder.append(this.b);
        LogUtility.a("WebViewDownloadListener", localStringBuilder.toString());
        if (Build.VERSION.SDK_INT < 19)
        {
          this.a.loadUrl(this.b);
          return;
        }
        this.a.evaluateJavascript(this.b, new WebViewDownloadListener.1.1(this));
        return;
      }
      catch (Exception localException)
      {
        LogUtility.a("WebViewDownloadListener", "doJsCallBack >>> ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.WebViewDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */