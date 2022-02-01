package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$4
  implements AsyncResult
{
  DataJsPlugin$4(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCmdListener() called with: isSuc = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], ret = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    QMLog.d("DataJsPlugin", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.val$req.ok(paramJSONObject);
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */