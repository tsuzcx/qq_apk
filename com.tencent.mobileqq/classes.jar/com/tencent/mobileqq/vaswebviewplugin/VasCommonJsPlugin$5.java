package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.smtt.sdk.WebView;

final class VasCommonJsPlugin$5
  implements Runnable
{
  VasCommonJsPlugin$5(WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if (this.val$webView != null) {}
    try
    {
      this.val$webView.loadUrl("javascript:" + this.val$script);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */