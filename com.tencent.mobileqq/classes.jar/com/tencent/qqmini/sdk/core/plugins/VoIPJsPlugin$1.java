package com.tencent.qqmini.sdk.core.plugins;

import behp;
import bejp;
import bejw;
import bekr;
import bekx;
import betc;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$1
  implements bejw
{
  VoIPJsPlugin$1(VoIPJsPlugin paramVoIPJsPlugin, JSONObject paramJSONObject, bekr parambekr) {}
  
  public void onFail(int paramInt)
  {
    try
    {
      this.val$res.put("errCode", paramInt);
      this.val$req.jdField_a_of_type_Behp.a(this.val$req.jdField_b_of_type_Int, bekx.a(this.val$req.jdField_a_of_type_JavaLangString, this.val$res, "状态错误").toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        betc.d("[mini] VoIPJsPlugin", "参数错误 " + this.val$req.jdField_b_of_type_JavaLangString, localJSONException);
      }
    }
  }
  
  public void onSuccess()
  {
    try
    {
      this.val$res.put("muteMicrophone", bejp.a().a());
      this.val$res.put("muteEarphone", bejp.a().b());
      this.val$req.jdField_a_of_type_Behp.a(this.val$req.jdField_b_of_type_Int, bekx.a(this.val$req.jdField_a_of_type_JavaLangString, this.val$res).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        betc.d("[mini] VoIPJsPlugin", "参数错误 " + this.val$req.jdField_b_of_type_JavaLangString, localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */