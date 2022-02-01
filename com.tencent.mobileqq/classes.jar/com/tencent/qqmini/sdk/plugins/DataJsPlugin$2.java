package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$2
  implements AsyncResult
{
  DataJsPlugin$2(DataJsPlugin paramDataJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      try
      {
        paramJSONObject = paramJSONObject.optString("extra_json_data");
        this.val$resultObj.put("extInfo", paramJSONObject);
        this.val$req.ok(this.val$resultObj);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QMLog.e("DataJsPlugin", "getUserGroupInfo result exception.", paramJSONObject);
        return;
      }
    }
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("errMsg");
    } else {
      paramJSONObject = "getUserGroupInfo failed.";
    }
    this.val$req.fail(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */