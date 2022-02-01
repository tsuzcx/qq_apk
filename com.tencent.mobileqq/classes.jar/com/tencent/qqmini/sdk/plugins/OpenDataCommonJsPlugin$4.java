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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUserCloudStorage callback appid:");
    localStringBuilder.append(OpenDataCommonJsPlugin.access$300(this.this$0).appId);
    localStringBuilder.append(", isSuc");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ret:");
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = "";
    }
    localStringBuilder.append(paramJSONObject);
    QMLog.i("OpenDataCommonJsPlugin", localStringBuilder.toString());
    paramJSONObject = new JSONObject();
    if (paramBoolean) {}
    try
    {
      paramJSONObject.put("state", "success");
      this.val$req.ok(paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUserCloudStorage error ");
      localStringBuilder.append(paramJSONObject.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
      this.val$req.fail();
    }
    paramJSONObject.put("state", "fail");
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */