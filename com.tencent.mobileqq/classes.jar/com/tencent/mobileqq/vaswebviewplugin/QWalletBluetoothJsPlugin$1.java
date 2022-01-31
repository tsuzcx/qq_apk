package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONObject;

class QWalletBluetoothJsPlugin$1
  extends BroadcastReceiver
{
  QWalletBluetoothJsPlugin$1(QWalletBluetoothJsPlugin paramQWalletBluetoothJsPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    paramContext = paramIntent.getAction();
    if ("com.tencent.qwallet.bluetooth.scan.changed".equals(paramContext)) {}
    for (;;)
    {
      if (i != 0) {
        paramContext = new JSONObject();
      }
      try
      {
        paramContext.put("available", QWalletBluetoothJsPlugin.access$000());
        paramContext.put("discovering", QWalletBluetoothJsPlugin.access$100());
        QWalletBluetoothJsPlugin.access$200(this.this$0, "onBluetoothAdapterStateChange", paramContext.toString());
        return;
      }
      catch (JSONException paramContext) {}
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext)) {}
      switch (paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0))
      {
      case 11: 
      default: 
        i = 0;
        break;
      case 12: 
        QWalletBluetoothJsPlugin.access$002(true);
        break;
      case 10: 
        QWalletBluetoothJsPlugin.access$002(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */