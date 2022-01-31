package com.tencent.open.appstore.js;

import android.os.Build.VERSION;
import bdhh;
import bdht;
import com.tencent.smtt.sdk.WebView;

public class DownloadInterfaceNew$2
  implements Runnable
{
  DownloadInterfaceNew$2(DownloadInterfaceNew paramDownloadInterfaceNew, String paramString) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        DownloadInterfaceNew.a(this.this$0).loadUrl(this.a);
        return;
      }
      DownloadInterfaceNew.a(this.this$0).evaluateJavascript(this.a, new bdhh(this));
      return;
    }
    catch (Exception localException)
    {
      bdht.a("DownloadInterfaceNew", "[jsCallBack] e>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew.2
 * JD-Core Version:    0.7.0.1
 */