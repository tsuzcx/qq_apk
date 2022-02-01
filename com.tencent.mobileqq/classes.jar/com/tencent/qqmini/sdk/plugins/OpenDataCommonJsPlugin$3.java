package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$3
  implements AsyncResult
{
  OpenDataCommonJsPlugin$3(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getGroupCloudStorage callback appid:");
    ((StringBuilder)localObject).append(OpenDataCommonJsPlugin.access$200(this.this$0).appId);
    ((StringBuilder)localObject).append(", isSuc");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ret:");
    ((StringBuilder)localObject).append(String.valueOf(paramJSONObject));
    QMLog.i("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    if (paramBoolean) {}
    try
    {
      ((JSONObject)localObject).put("state", "success");
      if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
        ((JSONObject)localObject).put("data", paramJSONObject.get("data"));
      } else {
        ((JSONObject)localObject).put("data", paramJSONObject);
      }
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGroupCloudStorage error ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
      this.val$req.fail();
    }
    ((JSONObject)localObject).put("state", "fail");
    this.val$req.fail((JSONObject)localObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */