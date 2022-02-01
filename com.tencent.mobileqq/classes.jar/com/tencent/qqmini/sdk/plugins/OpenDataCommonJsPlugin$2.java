package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$2
  implements AsyncResult
{
  OpenDataCommonJsPlugin$2(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFriendCloudStorage callback appid:");
    localStringBuilder.append(OpenDataCommonJsPlugin.access$100(this.this$0).appId);
    localStringBuilder.append(", isSuc:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ret:");
    if (paramJSONObject != null) {
      localObject = paramJSONObject.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    QMLog.i("OpenDataCommonJsPlugin", localStringBuilder.toString());
    Object localObject = new JSONObject();
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
      ((StringBuilder)localObject).append("getFriendCloudStorage error ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject).toString());
      this.val$req.fail();
    }
    ((JSONObject)localObject).put("state", "fail");
    this.val$req.fail((JSONObject)localObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */