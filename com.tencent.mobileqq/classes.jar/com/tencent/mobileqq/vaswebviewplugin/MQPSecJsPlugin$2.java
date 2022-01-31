package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;

class MQPSecJsPlugin$2
  implements Runnable
{
  MQPSecJsPlugin$2(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    try
    {
      if ((MQPSecJsPlugin.access$100(this.this$0) == null) && (!this.this$0.activity.isFinishing()))
      {
        WebUiBaseInterface localWebUiBaseInterface = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
        if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebTitleBarInterface)))
        {
          MQPSecJsPlugin.access$102(this.this$0, new QQProgressDialog(this.this$0.activity, ((WebUiUtils.WebTitleBarInterface)localWebUiBaseInterface).b()));
          MQPSecJsPlugin.access$100(this.this$0).setCancelable(false);
          MQPSecJsPlugin.access$100(this.this$0).c(2131435053);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if ((MQPSecJsPlugin.access$100(this.this$0) != null) && (!MQPSecJsPlugin.access$100(this.this$0).isShowing())) {
      MQPSecJsPlugin.access$100(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */