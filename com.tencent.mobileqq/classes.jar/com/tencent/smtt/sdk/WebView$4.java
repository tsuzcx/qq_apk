package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.smtt.sdk.stat.MttLoader;

class WebView$4
  implements android.webkit.DownloadListener
{
  WebView$4(WebView paramWebView, DownloadListener paramDownloadListener) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    DownloadListener localDownloadListener = this.a;
    if (localDownloadListener == null)
    {
      if (WebView.a(this.b) == null) {
        paramString2 = null;
      } else {
        paramString2 = WebView.a(this.b).getApplicationInfo();
      }
      if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
        MttLoader.loadUrl(WebView.a(this.b), paramString1, null, null);
      }
    }
    else
    {
      localDownloadListener.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.4
 * JD-Core Version:    0.7.0.1
 */