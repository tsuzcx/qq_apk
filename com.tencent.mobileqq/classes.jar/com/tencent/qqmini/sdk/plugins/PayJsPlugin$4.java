package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$4
  implements AsyncResult
{
  PayJsPlugin$4(PayJsPlugin paramPayJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("result");
      String str1 = paramJSONObject.optString("errMsg");
      String str2 = paramJSONObject.optString("firstRefer");
      paramJSONObject = paramJSONObject.optString("firstVia");
      try
      {
        this.val$paramsObject.put("firstRefer", str2);
        this.val$paramsObject.put("firstVia", paramJSONObject);
        if (i == 1)
        {
          paramJSONObject = PayJsPlugin.access$1200(this.this$0, this.val$paramsObject);
          PayJsPlugin.access$1400(this.this$0, PayJsPlugin.access$1300(this.this$0).getAttachedActivity(), this.val$req, paramJSONObject);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        do
        {
          for (;;)
          {
            QMLog.e("PayJsPlugin", "put refer via error ", paramJSONObject);
          }
        } while ((i != 0) && (i != 2));
        AppBrandTask.runTaskOnUiThread(new PayJsPlugin.4.1(this, str1));
        QMLog.e("PayJsPlugin", "handleNativeRequest result = " + i);
        PayJsPlugin.access$700(this.this$0, this.val$req, null, str1);
        return;
      }
    }
    QMLog.e("PayJsPlugin", "checkOfferId isSuc = " + paramBoolean);
    PayJsPlugin.access$700(this.this$0, this.val$req, null, "checkOfferId fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */