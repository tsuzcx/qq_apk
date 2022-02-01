package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class AppJsPlugin$5
  implements AppJsPlugin.IWaldlCallback
{
  AppJsPlugin$5(AppJsPlugin paramAppJsPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onResult(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = ApiUtil.wrapCallbackOk(this.val$eventName, null);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, paramObject.toString());
      return;
    }
    paramObject = ApiUtil.wrapCallbackFail(this.val$eventName, null);
    this.val$webview.evaluateCallbackJs(this.val$callbackId, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */