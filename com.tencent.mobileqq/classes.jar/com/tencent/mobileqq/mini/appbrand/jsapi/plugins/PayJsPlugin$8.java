package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PayJsPlugin$8
  implements MiniAppCmdInterface
{
  PayJsPlugin$8(PayJsPlugin paramPayJsPlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, String paramString3, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("retCode")) {
          break label217;
        }
        i = paramJSONObject.getInt("retCode");
        if ((paramJSONObject == null) || (!paramJSONObject.has("errMsg"))) {
          break label222;
        }
        str = paramJSONObject.getString("errMsg");
        if ((!paramBoolean) || (i != 0)) {
          break label173;
        }
        if ((paramJSONObject == null) || (!paramJSONObject.has("key_url_valid"))) {
          break label229;
        }
        i = paramJSONObject.getInt("key_url_valid");
        if (i == 1)
        {
          if (this.this$0.jsPluginEngine.activityContext != null)
          {
            PayJsPlugin.access$600(this.this$0, this.this$0.jsPluginEngine.activityContext, this.val$payUrl, this.val$referer, this.val$webview, this.val$eventName, this.val$callbackId);
            return;
          }
          QLog.i("PayJsPlugin", 1, "context is null");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, "pay fail");
        return;
      }
      PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, "url is invalid");
      return;
      label173:
      paramJSONObject = new JSONObject();
      paramJSONObject.put("resultCode", i);
      paramJSONObject.put("resultMsg", str);
      PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, "pay fail");
      return;
      label217:
      int i = -1;
      continue;
      label222:
      String str = "";
      continue;
      label229:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */