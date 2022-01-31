package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

class OpenDataPlugin$8
  implements MiniAppCmdInterface
{
  OpenDataPlugin$8(OpenDataPlugin paramOpenDataPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("OpenDataPlugin", "getUserCloudStorage callback appid:" + GameInfoManager.g().getAppId() + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.has("KVDataList"))) {
          localJSONObject.put("KVDataList", paramJSONObject.get("KVDataList"));
        }
        for (;;)
        {
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "getUserCloudStorage", localJSONObject, this.val$callbackId);
          return;
          localJSONObject.put("KVDataList", "[]");
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataPlugin", "getUserCloudStorage error " + paramJSONObject.getMessage());
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getUserCloudStorage", null, this.val$callbackId);
        return;
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getUserCloudStorage", localJSONObject, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.8
 * JD-Core Version:    0.7.0.1
 */