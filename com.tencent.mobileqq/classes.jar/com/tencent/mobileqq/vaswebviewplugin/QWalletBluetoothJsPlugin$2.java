package com.tencent.mobileqq.vaswebviewplugin;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;

class QWalletBluetoothJsPlugin$2
  implements Runnable
{
  QWalletBluetoothJsPlugin$2(QWalletBluetoothJsPlugin paramQWalletBluetoothJsPlugin) {}
  
  public void run()
  {
    if (QWalletBluetoothJsPlugin.access$300(this.this$0) != null)
    {
      QWalletBluetoothJsPlugin.access$300(this.this$0).stopLeScan(QWalletBluetoothJsPlugin.access$400(this.this$0));
      QWalletBluetoothJsPlugin.access$102(false);
      QWalletBluetoothJsPlugin.access$500(this.this$0).sendBroadcast(new Intent().setAction("com.tencent.qwallet.bluetooth.scan.changed"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */