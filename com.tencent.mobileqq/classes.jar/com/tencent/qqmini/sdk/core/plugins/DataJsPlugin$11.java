package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$11
  implements AsyncResult
{
  DataJsPlugin$11(DataJsPlugin paramDataJsPlugin, String paramString, bgkd parambgkd) {}
  
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
        this.val$req.a(paramJSONObject);
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
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */