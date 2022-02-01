package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$22
  implements MiniAppCmdInterface
{
  DataJsPlugin$22(DataJsPlugin paramDataJsPlugin, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      try
      {
        paramJSONObject = paramJSONObject.optString("extra_json_data");
        this.val$resultObj.put("extInfo", paramJSONObject);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, this.val$resultObj, this.val$callbackId);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    String str = "getUserGroupInfo failed.";
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("errMsg");
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, paramJSONObject, str, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.22
 * JD-Core Version:    0.7.0.1
 */