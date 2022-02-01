package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$5
  implements MiniAppCmdInterface
{
  PayJsPlugin$5(PayJsPlugin paramPayJsPlugin, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("result");
      String str1 = paramJSONObject.optString("errMsg");
      String str2 = paramJSONObject.optString("firstRefer", "");
      paramJSONObject = paramJSONObject.optString("firstVia", "");
      if (i == 1) {}
      while ((i != 0) && (i != 2)) {
        try
        {
          this.val$paramsObject.put("firstRefer", str2);
          this.val$paramsObject.put("firstVia", paramJSONObject);
          paramJSONObject = PayJsPlugin.access$300(this.this$0, this.val$paramsObject);
          PayJsPlugin.access$400(this.this$0, this.this$0.jsPluginEngine.getActivityContext(), paramJSONObject, this.val$webview, this.val$eventName, this.val$callbackId, this.val$paramsObject);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            QLog.e("PayJsPlugin", 1, "put refer via error ", paramJSONObject);
          }
        }
      }
      AppBrandTask.runTaskOnUiThread(new PayJsPlugin.5.1(this, str1));
      QLog.e("PayJsPlugin", 1, "handleNativeRequest result = " + i);
      PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, str1);
      return;
    }
    QLog.e("PayJsPlugin", 1, "checkOfferId isSuc = " + paramBoolean);
    PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, "checkOfferId fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */