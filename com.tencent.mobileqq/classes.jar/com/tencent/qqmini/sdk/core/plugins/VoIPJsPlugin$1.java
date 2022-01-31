package com.tencent.qqmini.sdk.core.plugins;

import bghn;
import bgkd;
import bgki;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfigListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$1
  implements VoIPManager.MuteConfigListener
{
  VoIPJsPlugin$1(VoIPJsPlugin paramVoIPJsPlugin, JSONObject paramJSONObject, bgkd parambgkd) {}
  
  public void onFail(int paramInt)
  {
    try
    {
      this.val$res.put("errCode", paramInt);
      this.val$req.jdField_a_of_type_Bghn.a(this.val$req.jdField_b_of_type_Int, bgki.a(this.val$req.jdField_a_of_type_JavaLangString, this.val$res, "状态错误").toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "参数错误 " + this.val$req.jdField_b_of_type_JavaLangString, localJSONException);
      }
    }
  }
  
  public void onSuccess()
  {
    try
    {
      this.val$res.put("muteMicrophone", VoIPManager.getInstance().isMicMute());
      this.val$res.put("muteEarphone", VoIPManager.getInstance().isEarPhoneMute());
      this.val$req.jdField_a_of_type_Bghn.a(this.val$req.jdField_b_of_type_Int, bgki.a(this.val$req.jdField_a_of_type_JavaLangString, this.val$res).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "参数错误 " + this.val$req.jdField_b_of_type_JavaLangString, localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */