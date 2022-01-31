package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.AddShortcutCallback;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class OtherJsPlugin$2
  implements ShortcutUtils.AddShortcutCallback
{
  OtherJsPlugin$2(OtherJsPlugin paramOtherJsPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onAddResult(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      paramString = new JSONObject();
      paramString = ApiUtil.wrapCallbackOk(this.val$eventName, paramString);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, paramString.toString());
      return;
    }
    paramString = ApiUtil.wrapCallbackFail(this.val$eventName, null, paramString);
    this.val$webview.evaluateCallbackJs(this.val$callbackId, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */