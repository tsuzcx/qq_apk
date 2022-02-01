package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager.EventListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$3$1
  implements VoIPManager.EventListener
{
  VoIPJsPlugin$3$1(VoIPJsPlugin.3 param3) {}
  
  public void onInterrupt(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramString);
    }
    catch (JSONException paramString)
    {
      QMLog.e("[mini] VoIPJsPlugin", "JSONException", paramString);
    }
    this.this$1.val$req.jsService.evaluateSubscribeJS("onVoIPChatInterrupted", localJSONObject.toString(), 0);
  }
  
  public void onRoomMemberChange(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      localJSONObject.put("errCode", 0);
    }
    catch (JSONException paramJSONArray)
    {
      QMLog.e("[mini] VoIPJsPlugin", "JSONException", paramJSONArray);
    }
    this.this$1.val$req.jsService.evaluateSubscribeJS("onVoIPChatMembersChanged", localJSONObject.toString(), 0);
  }
  
  public void onRoomMemberSpeaking(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      localJSONObject.put("errCode", 0);
    }
    catch (JSONException paramJSONArray)
    {
      QMLog.e("[mini] VoIPJsPlugin", "JSONException", paramJSONArray);
    }
    this.this$1.val$req.jsService.evaluateSubscribeJS("onVoIPChatSpeakersChanged", localJSONObject.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */