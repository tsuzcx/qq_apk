package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.input.WebInputHandler;

class InputJsPlugin$4
  implements Runnable
{
  InputJsPlugin$4(InputJsPlugin paramInputJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (WebInputHandler.getInstance().updateInput(this.val$jsonParams))
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InputJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */