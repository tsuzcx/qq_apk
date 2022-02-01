package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$5
  implements AsyncResult
{
  DataJsPlugin$5(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.ok(paramJSONObject);
      return;
    }
    long l = paramJSONObject.optLong("retCode");
    String str = paramJSONObject.optString("errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTcbTicket fail, retCode: ");
    localStringBuilder.append(l);
    localStringBuilder.append("; errMsg : ");
    localStringBuilder.append(str);
    QMLog.e("DataJsPlugin", localStringBuilder.toString());
    this.val$req.fail(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */