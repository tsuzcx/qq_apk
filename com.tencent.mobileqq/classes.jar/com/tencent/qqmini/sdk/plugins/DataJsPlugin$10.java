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
      if (QMLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("call checkNavigateRight ： ");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QMLog.d("DataJsPlugin", ((StringBuilder)localObject).toString());
      }
      Object localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("data", paramJSONObject.toString());
        ((JSONObject)localObject).put("respData", localJSONObject);
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("call checkNavigateRight real： ");
      paramJSONObject.append(((JSONObject)localObject).toString());
      QMLog.d("DataJsPlugin", paramJSONObject.toString());
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    QMLog.d("DataJsPlugin", "call checkNavigateRight failed. ");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */