package com.tencent.qqmini.sdk.core.plugins;

import bdcy;
import bdey;
import bdfd;
import bdfz;
import bdgg;
import bdnw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2$1
  implements bdfd
{
  VoIPJsPlugin$2$1(VoIPJsPlugin.2 param2) {}
  
  public void onError(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      this.this$1.val$req.jdField_a_of_type_Bdcy.a(this.this$1.val$req.b, bdgg.b(this.this$1.val$req.jdField_a_of_type_JavaLangString, localJSONObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public void onJoinRoom(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$1.val$req.jdField_a_of_type_Bdcy.a(this.this$1.val$req.b, bdgg.a(this.this$1.val$req.jdField_a_of_type_JavaLangString, localJSONObject).toString());
      bdey.a().a(new VoIPJsPlugin.2.1.1(this));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        bdnw.d("[mini] VoIPJsPlugin", "JSONException", paramJSONArray);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */