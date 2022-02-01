package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager.IdResult;
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
    Object localObject1 = "";
    if (paramJSONObject != null) {
      str1 = paramJSONObject.toString();
    } else {
      str1 = "";
    }
    QMLog.i("[mini] VoIPJsPlugin", String.format("succ: %s ret:%s", new Object[] { Boolean.valueOf(paramBoolean), str1 }));
    String str1 = "internal error";
    if (paramBoolean)
    {
      Object localObject4 = VoIPJsPlugin.access$000(this.this$0, paramJSONObject);
      Object localObject2;
      if (localObject4 == null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("idResult null ");
        if (paramJSONObject != null) {
          localObject1 = paramJSONObject.toString();
        }
        ((StringBuilder)localObject4).append((String)localObject1);
        QMLog.e("[mini] VoIPJsPlugin", ((StringBuilder)localObject4).toString());
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("errCode", -1000);
        }
        catch (JSONException localJSONException1)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
        }
        localObject2 = this.val$req.jsService;
        i = this.val$req.callbackId;
        localObject4 = this.val$req.event;
        if (paramJSONObject != null) {
          str1 = paramJSONObject.optString("errMsg", "idResult failed");
        }
        ((IJsService)localObject2).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail((String)localObject4, null, str1).toString());
        return;
      }
      if (this.val$roomConfig.muteConfig == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("muteConfig null ");
        ((StringBuilder)localObject2).append(this.val$req.jsonParams);
        QMLog.e("[mini] VoIPJsPlugin", ((StringBuilder)localObject2).toString());
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("errCode", -1000);
        }
        catch (JSONException localJSONException2)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
        }
        localObject3 = this.val$req.jsService;
        i = this.val$req.callbackId;
        localObject4 = this.val$req.event;
        if (paramJSONObject != null) {
          str1 = paramJSONObject.optString("errMsg", "muteConfig failed");
        }
        ((IJsService)localObject3).evaluateCallbackJs(i, ApiUtil.wrapCallbackFail((String)localObject4, null, str1).toString());
        return;
      }
      VoIPJsPlugin.access$100(this.this$0, (VoIPManager.IdResult)localObject4, this.val$roomConfig, this.val$req);
      return;
    }
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("errCode", -1000);
    }
    catch (JSONException localJSONException3)
    {
      QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException3);
    }
    IJsService localIJsService = this.val$req.jsService;
    int i = this.val$req.callbackId;
    String str2 = this.val$req.event;
    if (paramJSONObject != null) {
      str1 = paramJSONObject.optString("errMsg", "transfer roomId err");
    }
    localIJsService.evaluateCallbackJs(i, ApiUtil.wrapCallbackFail(str2, (JSONObject)localObject3, str1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */