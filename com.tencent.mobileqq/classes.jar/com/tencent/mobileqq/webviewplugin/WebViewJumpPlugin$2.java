package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import bcdb;
import bchy;

public class WebViewJumpPlugin$2
  implements Runnable
{
  public WebViewJumpPlugin$2(bchy parambchy) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2
 * JD-Core Version:    0.7.0.1
 */