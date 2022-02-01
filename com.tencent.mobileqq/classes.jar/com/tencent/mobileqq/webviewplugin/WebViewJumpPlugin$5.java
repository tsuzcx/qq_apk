package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import bifw;
import bikp;

public class WebViewJumpPlugin$5
  implements Runnable
{
  public WebViewJumpPlugin$5(bikp parambikp) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.5
 * JD-Core Version:    0.7.0.1
 */