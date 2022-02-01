package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$4
  implements AsyncResult
{
  OpenDataCommonJsPlugin$4(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setUserCloudStorage callback appid:").append(OpenDataCommonJsPlugin.access$300(this.this$0).appId).append(", isSuc").append(paramBoolean).append(", ret:");
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      QMLog.i("OpenDataCommonJsPlugin", paramJSONObject);
      paramJSONObject = new JSONObject();
      if (!paramBoolean) {
        break;
      }
      try
      {
        paramJSONObject.put("state", "success");
        this.val$req.ok(paramJSONObject);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "setUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.fail();
      }
    }
    paramJSONObject.put("state", "fail");
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */