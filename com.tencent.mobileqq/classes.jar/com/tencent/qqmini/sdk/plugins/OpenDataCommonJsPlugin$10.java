package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$10
  implements AsyncResult
{
  OpenDataCommonJsPlugin$10(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
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
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      ((JSONObject)localObject).putOpt("list", paramJSONObject);
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    long l = paramJSONObject.optLong("retCode");
    Object localObject = paramJSONObject.optString("errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getReactiveFriendList fail, retCode: ");
    localStringBuilder.append(l);
    localStringBuilder.append("; errMsg : ");
    localStringBuilder.append((String)localObject);
    QMLog.e("OpenDataCommonJsPlugin", localStringBuilder.toString());
    this.val$req.fail(paramJSONObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */