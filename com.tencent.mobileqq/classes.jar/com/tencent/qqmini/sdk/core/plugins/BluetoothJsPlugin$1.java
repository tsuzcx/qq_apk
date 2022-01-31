package com.tencent.qqmini.sdk.core.plugins;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bdnw;
import org.json.JSONException;
import org.json.JSONObject;

class BluetoothJsPlugin$1
  extends BroadcastReceiver
{
  BluetoothJsPlugin$1(BluetoothJsPlugin paramBluetoothJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (BluetoothJsPlugin.access$000(this.this$0) == null) {}
    while (!"android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction())) {
      return;
    }
    paramContext = new JSONObject();
    try
    {
      paramContext.put("available", BluetoothJsPlugin.access$000(this.this$0).isEnabled());
      paramContext.put("discovering", BluetoothJsPlugin.BLEScan.access$200(BluetoothJsPlugin.access$100(this.this$0)));
      paramContext = paramContext.toString();
      bdnw.a("BluetoothJsPlugin", "onReceive state change data=" + paramContext);
      this.this$0.sendSubscribeEvent("onBluetoothAdapterStateChange", paramContext);
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BluetoothJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */