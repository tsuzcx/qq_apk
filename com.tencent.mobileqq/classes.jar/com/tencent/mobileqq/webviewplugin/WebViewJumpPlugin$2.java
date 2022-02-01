package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

class WebViewJumpPlugin$2
  implements Runnable
{
  WebViewJumpPlugin$2(WebViewJumpPlugin paramWebViewJumpPlugin) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2
 * JD-Core Version:    0.7.0.1
 */