package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$5
  implements AsyncResult
{
  OpenDataCommonJsPlugin$5(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeUserCloudStorage callback appid:");
    localStringBuilder.append(OpenDataCommonJsPlugin.access$400(this.this$0).appId);
    localStringBuilder.append(", isSuc");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ret:");
    localStringBuilder.append(String.valueOf(paramJSONObject));
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
      localStringBuilder.append("removeUserCloudStorage error ");
      localStringBuilder.append(paramJSONObject.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
      this.val$req.fail();
    }
    paramJSONObject.put("state", "fail");
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */