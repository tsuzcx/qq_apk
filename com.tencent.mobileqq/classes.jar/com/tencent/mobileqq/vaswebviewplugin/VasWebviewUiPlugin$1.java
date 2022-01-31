package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class VasWebviewUiPlugin$1
  implements Runnable
{
  VasWebviewUiPlugin$1(VasWebviewUiPlugin paramVasWebviewUiPlugin, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mRuntime.a() != null) {
      this.this$0.mRuntime.a().loadUrl(this.val$url);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("VasWebviewUiPlugin", 2, "mRuntime.getWebView() still null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */