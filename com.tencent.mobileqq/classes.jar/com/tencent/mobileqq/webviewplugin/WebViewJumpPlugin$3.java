package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import bbac;
import bbey;

public class WebViewJumpPlugin$3
  implements Runnable
{
  public WebViewJumpPlugin$3(bbey parambbey) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.3
 * JD-Core Version:    0.7.0.1
 */