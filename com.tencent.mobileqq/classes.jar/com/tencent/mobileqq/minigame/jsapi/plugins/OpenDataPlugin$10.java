package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

class OpenDataPlugin$10
  implements MiniAppCmdInterface
{
  OpenDataPlugin$10(OpenDataPlugin paramOpenDataPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("OpenDataPlugin", "getGroupCloudStorage callback appid:" + this.val$appid + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
          localJSONObject.put("data", paramJSONObject.get("data"));
        }
        for (;;)
        {
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "getGroupCloudStorage", localJSONObject, this.val$callbackId);
          return;
          localJSONObject.put("data", paramJSONObject);
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataPlugin", "getGroupCloudStorage error " + paramJSONObject.getMessage());
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getGroupCloudStorage", null, this.val$callbackId);
        return;
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getGroupCloudStorage", localJSONObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.10
 * JD-Core Version:    0.7.0.1
 */