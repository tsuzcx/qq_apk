package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PayJsPlugin$9
  implements MiniAppController.ActivityResultListener
{
  PayJsPlugin$9(PayJsPlugin paramPayJsPlugin, int paramInt, JsRuntime paramJsRuntime, String paramString) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("PayJsPlugin", 1, "doOnActivityResult requestCode" + paramInt1 + " resultCode:" + paramInt2 + " callbackId:" + this.val$callbackId);
    if (paramInt1 == 3005)
    {
      paramIntent = new JSONObject();
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramIntent, this.val$callbackId);
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */