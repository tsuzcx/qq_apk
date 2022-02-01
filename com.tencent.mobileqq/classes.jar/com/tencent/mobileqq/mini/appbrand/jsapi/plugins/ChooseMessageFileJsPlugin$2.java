package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class ChooseMessageFileJsPlugin$2
  implements MiniAppController.ActivityResultListener
{
  ChooseMessageFileJsPlugin$2(ChooseMessageFileJsPlugin paramChooseMessageFileJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 6001)
    {
      ChooseMessageFileJsPlugin.access$000(this.this$0, paramInt2, paramIntent, this.val$webview, this.val$event, this.val$callbackId);
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ChooseMessageFileJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */