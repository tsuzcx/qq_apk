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
    paramContext = paramIntent.getAction();
    boolean bool = "com.tencent.qwallet.bluetooth.scan.changed".equals(paramContext);
    int i = 1;
    if (!bool)
    {
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramContext))
      {
        int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        if (j != 10)
        {
          if (j == 12)
          {
            QWalletBluetoothJsPlugin.access$002(true);
            break label76;
          }
        }
        else
        {
          QWalletBluetoothJsPlugin.access$002(false);
          break label76;
        }
      }
      i = 0;
    }
    label76:
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */