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
    QMLog.i("OpenDataCommonJsPlugin", "getGroupCloudStorage callback appid:" + OpenDataCommonJsPlugin.access$200(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.get("data") != null)) {
          localJSONObject.put("data", paramJSONObject.get("data"));
        }
        for (;;)
        {
          this.val$req.ok(localJSONObject);
          return;
          localJSONObject.put("data", paramJSONObject);
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "getGroupCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.fail();
        return;
      }
    }
    this.val$req.fail(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */