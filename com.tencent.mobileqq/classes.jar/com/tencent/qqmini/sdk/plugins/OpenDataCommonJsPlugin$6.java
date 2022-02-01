package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$6
  implements AsyncResult
{
  OpenDataCommonJsPlugin$6(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      localObject = new JSONObject();
      paramJSONObject = paramJSONObject.optJSONArray("key_result_data");
      if (paramJSONObject == null) {}
      try
      {
        ((JSONObject)localObject).putOpt("list", new JSONArray());
        for (;;)
        {
          this.val$req.ok((JSONObject)localObject);
          return;
          ((JSONObject)localObject).putOpt("list", paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
    long l = paramJSONObject.optLong("retCode");
    Object localObject = paramJSONObject.optString("errMsg");
    QMLog.e("OpenDataCommonJsPlugin", "getReactiveFriendList fail, retCode: " + l + "; errMsg : " + (String)localObject);
    this.val$req.fail(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */