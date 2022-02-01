package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2
  implements AsyncResult
{
  VoIPJsPlugin$2(VoIPJsPlugin paramVoIPJsPlugin, RequestEvent paramRequestEvent, VoIPManager.RoomConfig paramRoomConfig) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    }
    Object localObject3;
    int i;
    for (;;)
    {
      QMLog.i("[mini] VoIPJsPlugin", String.format("succ: %s ret:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 }));
      if (!paramBoolean) {
        break label362;
      }
      localObject1 = VoIPJsPlugin.access$000(this.this$0, paramJSONObject);
      if (localObject1 == null)
      {
        localObject3 = new StringBuilder().append("idResult null ");
        if (paramJSONObject != null)
        {
          localObject1 = paramJSONObject.toString();
          QMLog.e("[mini] VoIPJsPlugin", (String)localObject1);
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("errCode", -1000);
          localObject1 = this.val$req.jsService;
          i = this.val$req.callbackId;
          localObject3 = this.val$req.event;
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.optString("errMsg", "idResult failed");
            ((IJsService)localObject1).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail((String)localObject3, null, paramJSONObject).toString());
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
            QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
            continue;
            paramJSONObject = "internal error";
          }
        }
      }
    }
    if (this.val$roomConfig.muteConfig == null)
    {
      QMLog.e("[mini] VoIPJsPlugin", "muteConfig null " + this.val$req.jsonParams);
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("errCode", -1000);
        localObject2 = this.val$req.jsService;
        i = this.val$req.callbackId;
        localObject3 = this.val$req.event;
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("errMsg", "muteConfig failed");
          ((IJsService)localObject2).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail((String)localObject3, null, paramJSONObject).toString());
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
          continue;
          paramJSONObject = "internal error";
        }
      }
    }
    VoIPJsPlugin.access$100(this.this$0, localJSONException2, this.val$roomConfig, this.val$req);
    return;
    label362:
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", -1000);
      localObject3 = this.val$req.jsService;
      i = this.val$req.callbackId;
      String str = this.val$req.event;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("errMsg", "transfer roomId err");
        ((IJsService)localObject3).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail(str, localJSONObject, paramJSONObject).toString());
        return;
      }
    }
    catch (JSONException localJSONException3)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException3);
        continue;
        paramJSONObject = "internal error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */