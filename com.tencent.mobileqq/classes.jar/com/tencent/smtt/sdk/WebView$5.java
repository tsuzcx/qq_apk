package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.smtt.sdk.stat.MttLoader;

class WebView$5
  implements android.webkit.DownloadListener
{
  WebView$5(WebView paramWebView, DownloadListener paramDownloadListener) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (this.val$listener == null)
    {
      if (WebView.access$300(this.this$0) == null) {}
      for (paramString2 = null;; paramString2 = WebView.access$300(this.this$0).getApplicationInfo())
      {
        if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
          MttLoader.loadUrl(WebView.access$300(this.this$0), paramString1, null, null);
        }
        return;
      }
    }
    this.val$listener.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.5
 * JD-Core Version:    0.7.0.1
 */