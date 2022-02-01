package com.tencent.mobileqq.microapp.out.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class a
  extends BroadcastReceiver
{
  a(OtherJsPlugin paramOtherJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 0);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("scan_result: ");
      paramIntent.append(str);
      paramIntent.append("----scan_type: ");
      paramIntent.append(i);
      QLog.d("OtherJsPlugin", 2, paramIntent.toString());
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("result", str);
      paramIntent.put("scanType", i);
      this.a.handleNativeResponse("scanCode", paramIntent.toString(), OtherJsPlugin.access$000(this.a));
      paramContext.unregisterReceiver(OtherJsPlugin.access$100(this.a));
      label123:
      OtherJsPlugin.access$102(this.a, null);
      return;
    }
    catch (Exception paramContext)
    {
      break label123;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.plugins.a
 * JD-Core Version:    0.7.0.1
 */