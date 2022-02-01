package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AuthJsPlugin$1
  implements AsyncResult
{
  AuthJsPlugin$1(AuthJsPlugin paramAuthJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("call API_LOGIN  code:");
      localStringBuilder.append(paramJSONObject.toString());
      QMLog.d("AuthJsPlugin", localStringBuilder.toString());
      this.val$req.ok(paramJSONObject);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call API_LOGIN failed:");
    localStringBuilder.append(paramJSONObject);
    QMLog.e("AuthJsPlugin", localStringBuilder.toString());
    if (paramJSONObject != null)
    {
      this.val$req.fail(paramJSONObject, paramJSONObject.optString("errMsg", ""));
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AuthJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */