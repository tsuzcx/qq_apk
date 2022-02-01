package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class PayJsPlugin$3
  implements AsyncResult
{
  PayJsPlugin$3(PayJsPlugin paramPayJsPlugin, String paramString1, String paramString2, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("retCode")) {
          break label256;
        }
        i = paramJSONObject.getInt("retCode");
        if ((paramJSONObject == null) || (!paramJSONObject.has("errMsg"))) {
          break label261;
        }
        str = paramJSONObject.getString("errMsg");
        if ((!paramBoolean) || (i != 0)) {
          break label217;
        }
        if ((paramJSONObject == null) || (!paramJSONObject.has("key_url_valid"))) {
          break label268;
        }
        j = paramJSONObject.getInt("key_url_valid");
        if (j == 1)
        {
          if (PayJsPlugin.access$900(this.this$0).getAttachedActivity() != null)
          {
            PayJsPlugin.access$1100(this.this$0, PayJsPlugin.access$1000(this.this$0).getAttachedActivity(), this.val$payUrl, this.val$referer, this.val$req);
            QMLog.i("PayJsPlugin", "requestWxPayment urlValid=" + j);
            QMLog.i("PayJsPlugin", "requestWxPayment error=" + i + ", msg=" + str);
            return;
          }
          QMLog.i("PayJsPlugin", "context is null");
          continue;
        }
        this.val$req.fail("url is invalid");
      }
      catch (Exception paramJSONObject)
      {
        this.val$req.fail("pay fail");
        return;
      }
      continue;
      label217:
      paramJSONObject = new JSONObject();
      paramJSONObject.put("resultCode", i);
      paramJSONObject.put("resultMsg", str);
      this.val$req.fail(paramJSONObject, "pay fail");
      continue;
      label256:
      int i = -1;
      continue;
      label261:
      String str = "";
      continue;
      label268:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */