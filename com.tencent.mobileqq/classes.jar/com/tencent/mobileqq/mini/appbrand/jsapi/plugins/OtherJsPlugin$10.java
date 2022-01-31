package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bfhh;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class OtherJsPlugin$10
  extends BroadcastReceiver
{
  OtherJsPlugin$10(OtherJsPlugin paramOtherJsPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType");
    QLog.d(OtherJsPlugin.access$000(), 2, "scanResult: " + str + "----scan_type: " + paramIntent);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("result", str);
      localJSONObject2.put("scanType", paramIntent);
      localJSONObject2.put("rawData", bfhh.a(str));
      localJSONObject2.put("charSet", "utf-8");
      localJSONObject1.put("detail", localJSONObject2);
      localJSONObject1.put("result", str);
      localJSONObject1.put("scanType", paramIntent);
      localJSONObject1.put("rawData", bfhh.a(str));
      localJSONObject1.put("charSet", "utf-8");
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webView, "scanCode", localJSONObject1, this.val$callbackId);
      paramContext.unregisterReceiver(OtherJsPlugin.access$700(this.this$0));
      OtherJsPlugin.access$702(this.this$0, null);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e(OtherJsPlugin.access$000(), 1, "scan result error." + paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */