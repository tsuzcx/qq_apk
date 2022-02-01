package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$10
  implements MiniAppController.ActivityResultListener
{
  PayJsPlugin$10(PayJsPlugin paramPayJsPlugin, int paramInt, MiniAppConfig paramMiniAppConfig, JsRuntime paramJsRuntime, String paramString) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("PayJsPlugin", 1, "doOnActivityResult requestCode" + paramInt1 + " resultCode:" + paramInt2 + " callbackId:" + this.val$callbackId);
    if (paramInt1 == 3003)
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getInt("errCode");
          String str = paramIntent.getString("errMsg");
          if ((paramIntent.getLong("errType", -1L) == 8589934612L) && (this.val$miniAppConfig != null)) {
            MiniProgramLpReportDC04239.reportUserClick(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "midas", "h5midas", "openfail");
          }
          try
          {
            localJSONObject.put("resultCode", paramInt1);
            localJSONObject.put("resultMsg", str);
            if (paramInt1 == 0)
            {
              this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
              MiniAppController.getInstance().removeActivityResultListener(this);
              return true;
            }
          }
          catch (JSONException paramIntent)
          {
            for (;;)
            {
              paramIntent.printStackTrace();
            }
          }
        }
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */