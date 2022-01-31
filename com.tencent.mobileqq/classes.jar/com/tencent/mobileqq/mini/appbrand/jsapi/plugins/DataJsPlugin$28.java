package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class DataJsPlugin$28
  implements MiniAppController.ActivityResultListener
{
  DataJsPlugin$28(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9)
    {
      if (paramInt2 == 0) {
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      }
      for (;;)
      {
        MiniAppController.getInstance().removeActivityResultListener(this);
        return true;
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.28
 * JD-Core Version:    0.7.0.1
 */