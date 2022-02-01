package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.MuteConfigListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$1
  implements VoIPManager.MuteConfigListener
{
  VoIPJsPlugin$1(VoIPJsPlugin paramVoIPJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void onFail(int paramInt)
  {
    try
    {
      this.val$res.put("errCode", paramInt);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("参数错误 ");
      localStringBuilder.append(this.val$req.jsonParams);
      QMLog.e("[mini] VoIPJsPlugin", localStringBuilder.toString(), localJSONException);
    }
    this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, ApiUtil.wrapCallbackFail(this.val$req.event, this.val$res, "状态错误").toString());
  }
  
  public void onSuccess()
  {
    try
    {
      this.val$res.put("muteMicrophone", VoIPManager.getInstance().isMicMute());
      this.val$res.put("muteEarphone", VoIPManager.getInstance().isEarPhoneMute());
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("参数错误 ");
      localStringBuilder.append(this.val$req.jsonParams);
      QMLog.e("[mini] VoIPJsPlugin", localStringBuilder.toString(), localJSONException);
    }
    this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, ApiUtil.wrapCallbackOk(this.val$req.event, this.val$res).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */