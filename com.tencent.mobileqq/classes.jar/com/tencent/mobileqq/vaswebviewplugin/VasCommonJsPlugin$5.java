package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.smtt.sdk.WebView;

final class VasCommonJsPlugin$5
  implements Runnable
{
  VasCommonJsPlugin$5(WebView paramWebView, String paramString) {}
  
  public void run()
  {
    WebView localWebView = this.val$webView;
    if (localWebView != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(this.val$script);
        localWebView.loadUrl(localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */