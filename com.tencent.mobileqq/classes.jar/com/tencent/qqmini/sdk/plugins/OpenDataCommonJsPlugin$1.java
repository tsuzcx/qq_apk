package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$1
  implements AsyncResult
{
  OpenDataCommonJsPlugin$1(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("OpenDataCommonJsPlugin", "getUserCloudStorage callback appid:" + OpenDataCommonJsPlugin.access$000(this.this$0).appId + ", isSuc" + paramBoolean + ", ret:" + String.valueOf(paramJSONObject));
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean) {
      try
      {
        localJSONObject.put("state", "success");
        if ((paramJSONObject != null) && (paramJSONObject.has("KVDataList"))) {
          localJSONObject.put("KVDataList", paramJSONObject.get("KVDataList"));
        }
        for (;;)
        {
          this.val$req.ok(localJSONObject);
          return;
          localJSONObject.put("KVDataList", "[]");
        }
        localJSONObject.put("state", "fail");
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "getUserCloudStorage error " + paramJSONObject.getMessage());
        this.val$req.fail();
        return;
      }
    }
    this.val$req.fail(localJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */