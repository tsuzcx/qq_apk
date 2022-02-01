package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class LiteLiveSdkWebViewBaseBuilder$3
  implements TeleScreenRunnable
{
  LiteLiveSdkWebViewBaseBuilder$3(LiteLiveSdkWebViewBaseBuilder paramLiteLiveSdkWebViewBaseBuilder, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      LiteLiveSdkWebViewBaseBuilder.a(this.this$0).startActivity(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AbsWebView", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewBaseBuilder.3
 * JD-Core Version:    0.7.0.1
 */