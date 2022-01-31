package com.tencent.qqmini.sdk.core.plugins;

import begy;
import beiy;
import bejf;
import beka;
import bekg;
import besl;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$1
  implements bejf
{
  VoIPJsPlugin$1(VoIPJsPlugin paramVoIPJsPlugin, JSONObject paramJSONObject, beka parambeka) {}
  
  public void onFail(int paramInt)
  {
    try
    {
      this.val$res.put("errCode", paramInt);
      this.val$req.jdField_a_of_type_Begy.a(this.val$req.jdField_b_of_type_Int, bekg.a(this.val$req.jdField_a_of_type_JavaLangString, this.val$res, "状态错误").toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        besl.d("[mini] VoIPJsPlugin", "参数错误 " + this.val$req.jdField_b_of_type_JavaLangString, localJSONException);
      }
    }
  }
  
  public void onSuccess()
  {
    try
    {
      this.val$res.put("muteMicrophone", beiy.a().a());
      this.val$res.put("muteEarphone", beiy.a().b());
      this.val$req.jdField_a_of_type_Begy.a(this.val$req.jdField_b_of_type_Int, bekg.a(this.val$req.jdField_a_of_type_JavaLangString, this.val$res).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        besl.d("[mini] VoIPJsPlugin", "参数错误 " + this.val$req.jdField_b_of_type_JavaLangString, localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */