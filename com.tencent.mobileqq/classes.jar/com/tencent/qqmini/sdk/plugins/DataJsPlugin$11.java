package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$11
  implements AsyncResult
{
  DataJsPlugin$11(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webapi_plugin_getuserinfo ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramJSONObject);
    QMLog.d("DataJsPlugin", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.val$req.ok(paramJSONObject);
      AuthState.setAllowPluginScopeName(null);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("call getUserInfo failed:");
    localStringBuilder.append(paramJSONObject);
    QMLog.d("DataJsPlugin", localStringBuilder.toString());
    if (paramJSONObject != null) {
      this.val$req.fail(paramJSONObject, paramJSONObject.optString("errMsg", ""));
    } else {
      this.val$req.fail();
    }
    AuthState.setAllowPluginScopeName(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */