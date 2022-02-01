package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.JoinRoomListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$3
  implements VoIPManager.JoinRoomListener
{
  VoIPJsPlugin$3(VoIPJsPlugin paramVoIPJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onError(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramInt);
      this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, ApiUtil.wrapCallbackFail(this.val$req.event, localJSONObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public void onJoinRoom(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      localJSONObject.put("errCode", 0);
      this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, ApiUtil.wrapCallbackOk(this.val$req.event, localJSONObject).toString());
      VoIPManager.getInstance().setEventListener(new VoIPJsPlugin.3.1(this));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", paramJSONArray);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */