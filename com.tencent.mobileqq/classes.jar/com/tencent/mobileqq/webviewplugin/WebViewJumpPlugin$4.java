package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import bcdb;
import bchy;

public class WebViewJumpPlugin$4
  implements Runnable
{
  public WebViewJumpPlugin$4(bchy parambchy) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4
 * JD-Core Version:    0.7.0.1
 */