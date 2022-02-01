package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$7
  implements AsyncResult
{
  DataJsPlugin$7(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyPlugin : ");
      String str;
      if (paramJSONObject != null) {
        str = paramJSONObject.toString();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      QMLog.e("DataJsPlugin", localStringBuilder.toString());
      this.val$req.ok(paramJSONObject);
      return;
    }
    this.val$req.fail("verifyPlugin failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */