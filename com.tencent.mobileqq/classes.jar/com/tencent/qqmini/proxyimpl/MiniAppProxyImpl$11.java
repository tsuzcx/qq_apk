package com.tencent.qqmini.proxyimpl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class MiniAppProxyImpl$11
  extends BroadcastReceiver
{
  MiniAppProxyImpl$11(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scanResult: ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("----scan_type: ");
    ((StringBuilder)localObject).append(paramIntent);
    QLog.d("MiniAppProxyImpl", 2, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", str);
      localJSONObject.put("scanType", paramIntent);
      localJSONObject.put("rawData", MD5.a(str));
      localJSONObject.put("charSet", "utf-8");
      ((JSONObject)localObject).put("detail", localJSONObject);
      ((JSONObject)localObject).put("result", str);
      ((JSONObject)localObject).put("scanType", paramIntent);
      ((JSONObject)localObject).put("rawData", MD5.a(str));
      ((JSONObject)localObject).put("charSet", "utf-8");
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(true, (JSONObject)localObject);
      paramContext.unregisterReceiver(MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl));
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("scan result error.");
      paramIntent.append(paramContext);
      QLog.e("MiniAppProxyImpl", 1, paramIntent.toString());
    }
    MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.11
 * JD-Core Version:    0.7.0.1
 */