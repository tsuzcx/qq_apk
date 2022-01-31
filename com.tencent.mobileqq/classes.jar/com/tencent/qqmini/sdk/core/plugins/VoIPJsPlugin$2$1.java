package com.tencent.qqmini.sdk.core.plugins;

import bghn;
import bgkd;
import bgki;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.JoinRoomListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2$1
  implements VoIPManager.JoinRoomListener
{
  VoIPJsPlugin$2$1(VoIPJsPlugin.2 param2) {}
  
  public void onError(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      this.this$1.val$req.jdField_a_of_type_Bghn.a(this.this$1.val$req.b, bgki.b(this.this$1.val$req.jdField_a_of_type_JavaLangString, localJSONObject).toString());
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
      this.this$1.val$req.jdField_a_of_type_Bghn.a(this.this$1.val$req.b, bgki.a(this.this$1.val$req.jdField_a_of_type_JavaLangString, localJSONObject).toString());
      VoIPManager.getInstance().setEventListener(new VoIPJsPlugin.2.1.1(this));
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
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */