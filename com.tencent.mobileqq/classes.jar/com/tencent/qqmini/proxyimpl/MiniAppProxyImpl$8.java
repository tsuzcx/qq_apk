package com.tencent.qqmini.proxyimpl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bflq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class MiniAppProxyImpl$8
  extends BroadcastReceiver
{
  MiniAppProxyImpl$8(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType");
    QLog.d("MiniAppProxyImpl", 2, "scanResult: " + str + "----scan_type: " + paramIntent);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("result", str);
      localJSONObject2.put("scanType", paramIntent);
      localJSONObject2.put("rawData", bflq.a(str));
      localJSONObject2.put("charSet", "utf-8");
      localJSONObject1.put("detail", localJSONObject2);
      localJSONObject1.put("result", str);
      localJSONObject1.put("scanType", paramIntent);
      localJSONObject1.put("rawData", bflq.a(str));
      localJSONObject1.put("charSet", "utf-8");
      this.val$asyncResult.onReceiveResult(true, localJSONObject1);
      paramContext.unregisterReceiver(MiniAppProxyImpl.access$900(this.this$0));
      MiniAppProxyImpl.access$902(this.this$0, null);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("MiniAppProxyImpl", 1, "scan result error." + paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.8
 * JD-Core Version:    0.7.0.1
 */