package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import anzj;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2
  implements VoIPManager.MuteConfigListener
{
  VoIPJsPlugin$2(VoIPJsPlugin paramVoIPJsPlugin, JSONObject paramJSONObject, String paramString1, JsRuntime paramJsRuntime, int paramInt, String paramString2) {}
  
  public void onFail(int paramInt)
  {
    try
    {
      this.val$res.put("errCode", paramInt);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, ApiUtil.wrapCallbackFail(this.val$eventName, this.val$res, anzj.a(2131715638)).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "参数错误 " + this.val$jsonParams, localJSONException);
      }
    }
  }
  
  public void onSuccess()
  {
    try
    {
      this.val$res.put("muteMicrophone", VoIPManager.getInstance().isMicMute());
      this.val$res.put("muteEarphone", VoIPManager.getInstance().isEarPhoneMute());
      this.val$webview.evaluateCallbackJs(this.val$callbackId, ApiUtil.wrapCallbackOk(this.val$eventName, this.val$res).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("[mini] VoIPJsPlugin", 1, "参数错误 " + this.val$jsonParams, localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */