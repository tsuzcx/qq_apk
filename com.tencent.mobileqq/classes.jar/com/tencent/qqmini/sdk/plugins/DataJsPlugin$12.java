package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$12
  implements AsyncResult
{
  DataJsPlugin$12(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.ok(paramJSONObject);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call getUserInfoExtra failed:");
    localStringBuilder.append(paramJSONObject);
    QMLog.e("DataJsPlugin", localStringBuilder.toString());
    if (paramJSONObject != null)
    {
      this.val$req.fail(paramJSONObject, paramJSONObject.optString("errMsg", ""));
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */