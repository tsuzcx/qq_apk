package com.tencent.open.appcommon.js;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

class AppInterface$1$1
  implements Runnable
{
  AppInterface$1$1(AppInterface.1 param1, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.b.b.webView != null) && (!TextUtils.isEmpty(this.a)))
      {
        this.b.b.webView.loadUrl(this.a);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.a("AppInterface", "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.1.1
 * JD-Core Version:    0.7.0.1
 */