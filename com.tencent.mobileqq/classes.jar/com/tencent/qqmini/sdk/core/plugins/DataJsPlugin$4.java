package com.tencent.qqmini.sdk.core.plugins;

import beka;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class DataJsPlugin$4
  implements AsyncResult
{
  DataJsPlugin$4(DataJsPlugin paramDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    long l = paramJSONObject.optLong("retCode");
    String str = paramJSONObject.optString("errMsg");
    besl.d("DataJsPlugin", "getTcbTicket fail, retCode: " + l + "; errMsg : " + str);
    this.val$req.a(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */