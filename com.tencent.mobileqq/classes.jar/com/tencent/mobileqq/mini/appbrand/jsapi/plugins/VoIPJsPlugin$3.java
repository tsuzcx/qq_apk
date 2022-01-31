package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$3
  implements MiniAppCmdInterface
{
  VoIPJsPlugin$3(VoIPJsPlugin paramVoIPJsPlugin, JsRuntime paramJsRuntime, int paramInt, String paramString1, VoIPManager.RoomConfig paramRoomConfig, String paramString2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    }
    Object localObject3;
    int i;
    for (;;)
    {
      QLog.i("[mini] VoIPJsPlugin", 1, String.format("succ: %s ret:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 }));
      if (!paramBoolean) {
        break label376;
      }
      localObject1 = VoIPJsPlugin.access$000(this.this$0, paramJSONObject);
      if (localObject1 == null)
      {
        localObject3 = new StringBuilder().append("idResult null ");
        if (paramJSONObject != null)
        {
          localObject1 = paramJSONObject.toString();
          QLog.e("[mini] VoIPJsPlugin", 1, (String)localObject1);
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("errCode", -1000);
          localObject1 = this.val$webview;
          i = this.val$callbackId;
          localObject3 = this.val$eventName;
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.optString("errMsg", "idResult failed");
            ((JsRuntime)localObject1).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail((String)localObject3, null, paramJSONObject).toString());
            return;
            localObject1 = "";
            continue;
            localObject1 = "";
          }
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException1);
            continue;
            paramJSONObject = "internal error";
          }
        }
      }
    }
    if (this.val$roomConfig.muteConfig == null)
    {
      QLog.e("[mini] VoIPJsPlugin", 1, "muteConfig null " + this.val$jsonParams);
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("errCode", -1000);
        localObject2 = this.val$webview;
        i = this.val$callbackId;
        localObject3 = this.val$eventName;
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("errMsg", "muteConfig failed");
          ((JsRuntime)localObject2).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail((String)localObject3, null, paramJSONObject).toString());
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException2);
          continue;
          paramJSONObject = "internal error";
        }
      }
    }
    VoIPManager.getInstance().joinRoom(localJSONException2, this.val$roomConfig.muteConfig, VoIPJsPlugin.access$100(this.this$0, this.this$0.jsPluginEngine.appBrandRuntime.appId, this.val$roomConfig), new VoIPJsPlugin.3.1(this));
    return;
    label376:
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", -1000);
      localObject3 = this.val$webview;
      i = this.val$callbackId;
      String str = this.val$eventName;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("errMsg", "transfer roomId err");
        ((JsRuntime)localObject3).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail(str, localJSONObject, paramJSONObject).toString());
        return;
      }
    }
    catch (JSONException localJSONException3)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException3);
        continue;
        paramJSONObject = "internal error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */