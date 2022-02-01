package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    WebUiUtils.WebViewProviderInterface localWebViewProviderInterface = this.this$0.mRuntime.e();
    if ((localWebViewProviderInterface != null) && (localWebViewProviderInterface.getWebTitleBarInterface() != null)) {
      QQToast.makeText(this.this$0.activity, this.this$0.activity.getString(2131889169), 0).show(localWebViewProviderInterface.getWebTitleBarInterface().m());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */