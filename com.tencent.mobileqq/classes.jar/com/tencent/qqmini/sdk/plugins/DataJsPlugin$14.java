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
      QMLog.d("DataJsPlugin", "call getUserInfo ： " + paramJSONObject.toString());
      if (("webapi_getuserinfo_opendata".equals(this.val$apiName)) && (paramJSONObject != null)) {}
      try
      {
        paramJSONObject.remove("signature");
        paramJSONObject.remove("encryptedData");
        paramJSONObject.remove("iv");
        paramJSONObject.remove("cloudID");
        if (paramJSONObject.has("data"))
        {
          JSONObject localJSONObject = new JSONObject(paramJSONObject.get("data").toString());
          localJSONObject.remove("signature");
          paramJSONObject.put("data", localJSONObject);
        }
        this.val$req.ok(paramJSONObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QMLog.e("DataJsPlugin", "webapi_getuserinfo_opendata error, ", localThrowable);
        }
      }
    }
    QMLog.d("DataJsPlugin", "call getUserInfo failed. ");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */