package com.tencent.qqmini.sdk.core.plugins;

import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$10
  implements AsyncResult
{
  DataJsPlugin$10(DataJsPlugin paramDataJsPlugin, String paramString, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      bdnw.a("DataJsPlugin", "call getUserInfo ： " + paramJSONObject.toString());
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
          bdnw.d("DataJsPlugin", "webapi_getuserinfo_opendata error, ", localThrowable);
        }
      }
    }
    bdnw.a("DataJsPlugin", "call getUserInfo failed. ");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */