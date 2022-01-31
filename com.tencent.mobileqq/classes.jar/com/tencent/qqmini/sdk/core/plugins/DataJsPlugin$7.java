package com.tencent.qqmini.sdk.core.plugins;

import beka;
import besl;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$7
  implements AsyncResult
{
  DataJsPlugin$7(DataJsPlugin paramDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      if (besl.a()) {
        besl.a("DataJsPlugin", "call checkNavigateRight ： " + paramJSONObject.toString());
      }
      paramJSONObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("data", "{\"action_code\":1,\"skip_local_check\":1,\"wording\":\"\"}");
        paramJSONObject.put("respData", localJSONObject);
        besl.a("DataJsPlugin", "call checkNavigateRight real： " + paramJSONObject.toString());
        this.val$req.a(paramJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    besl.a("DataJsPlugin", "call checkNavigateRight failed. ");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */