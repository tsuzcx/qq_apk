package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    WebUiBaseInterface localWebUiBaseInterface = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface))) {
      QQToast.a(this.this$0.activity, this.this$0.activity.getString(2131432992), 0).b(((WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface).b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */