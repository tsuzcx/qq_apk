package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

class OpenDataPlugin$12
  implements MiniAppCmdInterface
{
  OpenDataPlugin$12(OpenDataPlugin paramOpenDataPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage callback appid:").append(this.val$appid).append(", isSuc").append(paramBoolean).append(", ret:");
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      localGameLog.i("OpenDataPlugin", paramJSONObject);
      paramJSONObject = new JSONObject();
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramJSONObject.put("state", "success");
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "setUserCloudStorage", paramJSONObject, this.val$callbackId);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataPlugin", "setUserCloudStorage error " + paramJSONObject.getMessage());
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "setUserCloudStorage", null, this.val$callbackId);
      }
    }
    paramJSONObject.put("state", "fail");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "setUserCloudStorage", paramJSONObject, this.val$callbackId);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.12
 * JD-Core Version:    0.7.0.1
 */