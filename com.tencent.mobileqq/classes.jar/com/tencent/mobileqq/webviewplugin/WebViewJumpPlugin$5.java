package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

class WebViewJumpPlugin$5
  implements Runnable
{
  WebViewJumpPlugin$5(WebViewJumpPlugin paramWebViewJumpPlugin) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.5
 * JD-Core Version:    0.7.0.1
 */