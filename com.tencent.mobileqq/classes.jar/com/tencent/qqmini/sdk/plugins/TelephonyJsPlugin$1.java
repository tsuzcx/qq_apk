package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.action.PhoneNumberAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONObject;

class TelephonyJsPlugin$1
  implements AsyncResult
{
  TelephonyJsPlugin$1(TelephonyJsPlugin paramTelephonyJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCmdListener isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("; result = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QMLog.d("TelephonyJsPlugin", ((StringBuilder)localObject).toString());
    JSONArray localJSONArray = new JSONArray();
    if (paramJSONObject != null)
    {
      localObject = paramJSONObject.optString("errMsg");
      localJSONArray = paramJSONObject.optJSONArray("phoneLists");
    }
    else
    {
      localObject = null;
    }
    if (paramBoolean)
    {
      if ((localJSONArray != null) && (localJSONArray.length() != 0)) {
        try
        {
          localObject = new JSONObject(this.val$req.jsonParams);
          ((JSONObject)localObject).put("getPhoneNumber", paramJSONObject);
          this.val$req.jsonParams = ((JSONObject)localObject).toString();
          TelephonyJsPlugin.access$000(this.this$0).performAction(PhoneNumberAction.obtain(this.val$req, new TelephonyJsPlugin.1.1(this)));
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QMLog.e("TelephonyJsPlugin", "getPhoneNumber error", paramJSONObject);
          return;
        }
      }
      this.val$req.fail("no binding Phone number");
      return;
    }
    this.val$req.fail((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */