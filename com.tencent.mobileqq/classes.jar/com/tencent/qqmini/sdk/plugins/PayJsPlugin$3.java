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
          break label288;
        }
        i = paramJSONObject.getInt("retCode");
        String str;
        if ((paramJSONObject != null) && (paramJSONObject.has("errMsg"))) {
          str = paramJSONObject.getString("errMsg");
        } else {
          str = "";
        }
        if ((paramBoolean) && (i == 0))
        {
          if ((paramJSONObject == null) || (!paramJSONObject.has("key_url_valid"))) {
            break label293;
          }
          j = paramJSONObject.getInt("key_url_valid");
          if (j == 1)
          {
            if (PayJsPlugin.access$900(this.this$0).getAttachedActivity() != null) {
              PayJsPlugin.access$1100(this.this$0, PayJsPlugin.access$1000(this.this$0).getAttachedActivity(), this.val$payUrl, this.val$referer, this.val$req);
            } else {
              QMLog.i("PayJsPlugin", "context is null");
            }
          }
          else {
            this.val$req.fail("url is invalid");
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("requestWxPayment urlValid=");
          paramJSONObject.append(j);
          QMLog.i("PayJsPlugin", paramJSONObject.toString());
        }
        else
        {
          paramJSONObject = new JSONObject();
          paramJSONObject.put("resultCode", i);
          paramJSONObject.put("resultMsg", str);
          this.val$req.fail(paramJSONObject, "pay fail");
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("requestWxPayment error=");
        paramJSONObject.append(i);
        paramJSONObject.append(", msg=");
        paramJSONObject.append(str);
        QMLog.i("PayJsPlugin", paramJSONObject.toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        continue;
      }
      this.val$req.fail("pay fail");
      return;
      label288:
      int i = -1;
      continue;
      label293:
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */