package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import begz;
import belw;

public class WebViewJumpPlugin$2
  implements Runnable
{
  public WebViewJumpPlugin$2(belw parambelw) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2
 * JD-Core Version:    0.7.0.1
 */