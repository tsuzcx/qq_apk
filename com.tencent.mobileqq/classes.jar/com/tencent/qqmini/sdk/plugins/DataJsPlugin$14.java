package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$14
  implements AsyncResult
{
  DataJsPlugin$14(DataJsPlugin paramDataJsPlugin, String paramString, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call getUserInfo ： ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QMLog.d("DataJsPlugin", ((StringBuilder)localObject).toString());
      if (("webapi_getuserinfo_opendata".equals(this.val$apiName)) && (paramJSONObject != null)) {
        try
        {
          paramJSONObject.remove("signature");
          paramJSONObject.remove("encryptedData");
          paramJSONObject.remove("iv");
          paramJSONObject.remove("cloudID");
          if (paramJSONObject.has("data"))
          {
            localObject = new JSONObject(paramJSONObject.get("data").toString());
            ((JSONObject)localObject).remove("signature");
            paramJSONObject.put("data", localObject);
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("DataJsPlugin", "webapi_getuserinfo_opendata error, ", localThrowable);
        }
      }
      this.val$req.ok(paramJSONObject);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("call getUserInfo failed:");
    localStringBuilder.append(paramJSONObject);
    QMLog.d("DataJsPlugin", localStringBuilder.toString());
    if (paramJSONObject != null)
    {
      this.val$req.fail(paramJSONObject, paramJSONObject.optString("errMsg", ""));
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */