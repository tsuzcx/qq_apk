package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class DataJsPlugin$11
  implements MiniProgramShareUtils.OnShareListener
{
  DataJsPlugin$11(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      }
    }
    else {
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */