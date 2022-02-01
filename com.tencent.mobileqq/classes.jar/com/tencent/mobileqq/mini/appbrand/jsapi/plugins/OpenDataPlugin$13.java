package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONObject;

class OpenDataPlugin$13
  implements MiniAppCmdInterface
{
  OpenDataPlugin$13(OpenDataPlugin paramOpenDataPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("OpenDataPlugin", "removeUserCloudStorage callback appid:" + this.val$appid + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    paramJSONObject = new JSONObject();
    if (paramBoolean) {}
    try
    {
      paramJSONObject.put("state", "success");
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "removeUserCloudStorage", paramJSONObject, this.val$callbackId);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      GameLog.getInstance().e("OpenDataPlugin", "removeUserCloudStorage error " + paramJSONObject.getMessage());
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "removeUserCloudStorage", null, this.val$callbackId);
    }
    paramJSONObject.put("state", "fail");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "removeUserCloudStorage", paramJSONObject, this.val$callbackId);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin.13
 * JD-Core Version:    0.7.0.1
 */