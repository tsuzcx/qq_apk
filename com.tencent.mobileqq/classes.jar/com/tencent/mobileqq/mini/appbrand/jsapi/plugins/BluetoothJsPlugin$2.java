package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class BluetoothJsPlugin$2
  extends BroadcastReceiver
{
  BluetoothJsPlugin$2(BluetoothJsPlugin paramBluetoothJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (BluetoothJsPlugin.access$300(this.this$0) == null) {}
    while (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction())) {
      return;
    }
    paramContext = new JSONObject();
    try
    {
      paramContext.put("available", BluetoothJsPlugin.access$300(this.this$0).isEnabled());
      paramContext.put("discovering", BluetoothJsPlugin.BLEScan.access$000(BluetoothJsPlugin.access$400(this.this$0)));
      paramContext = paramContext.toString();
      QLog.d("[mini] BluetoothJsPlugin", 2, "onReceive state change data=" + paramContext);
      this.this$0.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS("onBluetoothAdapterStateChange", paramContext);
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */