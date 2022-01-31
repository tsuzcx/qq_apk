package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class AuthJsPlugin$2
  implements AsyncResult
{
  AuthJsPlugin$2(AuthJsPlugin paramAuthJsPlugin, bgok parambgok) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QMLog.d("AuthJsPlugin", "call API_REFRESH_SESSION success.");
      this.val$req.a(paramJSONObject);
      return;
    }
    QMLog.d("AuthJsPlugin", "call API_REFRESH_SESSION success.");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AuthJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */