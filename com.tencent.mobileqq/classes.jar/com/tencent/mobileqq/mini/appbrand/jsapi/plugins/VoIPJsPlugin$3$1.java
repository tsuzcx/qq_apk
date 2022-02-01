package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$3$1
  implements VoIPManager.JoinRoomListener
{
  VoIPJsPlugin$3$1(VoIPJsPlugin.3 param3) {}
  
  public void onError(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      this.this$1.val$webview.evaluateCallbackJs(this.this$1.val$callbackId, ApiUtil.wrapCallbackFail(this.this$1.val$eventName, localJSONObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "JSONException", localJSONException);
      }
    }
  }
  
  public void onJoinRoom(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$1.val$webview.evaluateCallbackJs(this.this$1.val$callbackId, ApiUtil.wrapCallbackOk(this.this$1.val$eventName, localJSONObject).toString());
      VoIPManager.getInstance().setEventListener(new VoIPJsPlugin.3.1.1(this));
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */