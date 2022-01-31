package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.HashMap;
import org.json.JSONObject;

class BaseJsPluginEngine$2
  implements MiniAppCmdInterface
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str = "0";
    if (paramJSONObject != null)
    {
      str = paramJSONObject.optString("purePhoneNumber");
      paramJSONObject.optString("countryCode");
    }
    if ((paramBoolean) && (!"0".equals(str)))
    {
      AuthorizeCenter.scopeDescMap.put("scope.getPhoneNumber", str);
      BaseJsPluginEngine.access$100(this.this$0, this.val$eventName, this.val$jsonParams, this.val$webview, this.val$callbackId, this.val$granted);
      return;
    }
    if ("0".equals(str))
    {
      this.this$0.callbackJsEventFail(this.val$webview, this.val$eventName, new JSONObject(), this.this$0.getActivityContext().getString(2131628622), this.val$callbackId);
      return;
    }
    this.this$0.callbackJsEventFail(this.val$webview, this.val$eventName, paramJSONObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */