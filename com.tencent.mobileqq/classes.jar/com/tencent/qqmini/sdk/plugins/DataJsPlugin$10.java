package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$10
  implements AsyncResult
{
  DataJsPlugin$10(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      if (QMLog.isColorLevel()) {
        QMLog.d("DataJsPlugin", "call checkNavigateRight ： " + paramJSONObject.toString());
      }
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("data", paramJSONObject.toString());
        localJSONObject1.put("respData", localJSONObject2);
        QMLog.d("DataJsPlugin", "call checkNavigateRight real： " + localJSONObject1.toString());
        this.val$req.ok(localJSONObject1);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    QMLog.d("DataJsPlugin", "call checkNavigateRight failed. ");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */