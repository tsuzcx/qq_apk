package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AuthJsPlugin$2
  implements AsyncResult
{
  AuthJsPlugin$2(AuthJsPlugin paramAuthJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QMLog.d("AuthJsPlugin", "call API_REFRESH_SESSION success.");
      this.val$req.ok(paramJSONObject);
      return;
    }
    QMLog.d("AuthJsPlugin", "call API_REFRESH_SESSION success.");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AuthJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */