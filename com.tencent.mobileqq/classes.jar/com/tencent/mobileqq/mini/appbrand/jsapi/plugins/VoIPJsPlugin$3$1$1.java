package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$3$1$1
  implements VoIPManager.EventListener
{
  VoIPJsPlugin$3$1$1(VoIPJsPlugin.3.1 param1) {}
  
  public void onInterrupt(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramString);
      this.this$2.this$1.val$webview.evaluateSubcribeJS("onVoIPChatInterrupted", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", paramString);
      }
    }
  }
  
  public void onRoomMemberChange(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$2.this$1.val$webview.evaluateSubcribeJS("onVoIPChatMembersChanged", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", paramJSONArray);
      }
    }
  }
  
  public void onRoomMemberSpeaking(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$2.this$1.val$webview.evaluateSubcribeJS("onVoIPChatSpeakersChanged", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", paramJSONArray);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin.3.1.1
 * JD-Core Version:    0.7.0.1
 */