package com.tencent.qqmini.sdk.core.plugins;

import bglu;
import bgok;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.EventListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2$1$1
  implements VoIPManager.EventListener
{
  VoIPJsPlugin$2$1$1(VoIPJsPlugin.2.1 param1) {}
  
  public void onInterrupt(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramString);
      this.this$2.this$1.val$req.a.a("onVoIPChatInterrupted", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", paramString);
      }
    }
  }
  
  public void onRoomMemberChange(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$2.this$1.val$req.a.a("onVoIPChatMembersChanged", localJSONObject.toString(), 0);
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
  
  public void onRoomMemberSpeaking(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$2.this$1.val$req.a.a("onVoIPChatSpeakersChanged", localJSONObject.toString(), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.2.1.1
 * JD-Core Version:    0.7.0.1
 */