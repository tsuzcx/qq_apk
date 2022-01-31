package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class DataJsPlugin$24
  implements Handler.Callback
{
  DataJsPlugin$24(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.24
 * JD-Core Version:    0.7.0.1
 */