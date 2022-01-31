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
    if (QLog.isColorLevel()) {
      QLog.d("OtherJsPlugin", 2, "scan_result: " + str + "----scan_type: " + i);
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("result", str);
      paramIntent.put("scanType", i);
      this.a.handleNativeResponse("scanCode", paramIntent.toString(), OtherJsPlugin.access$000(this.a));
      paramContext.unregisterReceiver(OtherJsPlugin.access$100(this.a));
      label113:
      OtherJsPlugin.access$102(this.a, null);
      return;
    }
    catch (Exception paramContext)
    {
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.plugins.a
 * JD-Core Version:    0.7.0.1
 */