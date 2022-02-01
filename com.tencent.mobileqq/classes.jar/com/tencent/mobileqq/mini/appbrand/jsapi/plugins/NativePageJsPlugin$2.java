package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class NativePageJsPlugin$2
  implements MiniAppCmdInterface
{
  NativePageJsPlugin$2(NativePageJsPlugin paramNativePageJsPlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, String paramString3, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("retCode", -1);
      QLog.i("NativePageJsPlugin", 1, paramJSONObject.optString("key_Msg"));
      if ((!paramBoolean) || (i != 0)) {
        break label117;
      }
      if (paramJSONObject.optInt("key_check_State") != 0)
      {
        if ("group".equals(this.val$cardType))
        {
          this.this$0.jumpToGroup(this.val$uin);
          return;
        }
        if (!"public_account".equals(this.val$cardType)) {
          return;
        }
        this.this$0.jumpToPublic(this.val$uin);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "fail no permission", this.val$callbackId);
    return;
    label117:
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "checkBindingState request fail", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NativePageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */