package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.input.WebInputHandler;

class InputJsPlugin$5
  implements Runnable
{
  InputJsPlugin$5(InputJsPlugin paramInputJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    WebInputHandler.getInstance().setKeyboardValue(this.this$0.jsPluginEngine, this.val$webview, this.val$jsonParams, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InputJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */