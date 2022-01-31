package com.tencent.qqmini.sdk.core.plugins;

import android.bluetooth.BluetoothGatt;
import bgkd;

class BluetoothJsPlugin$BluetoothDeviceExtend$2
  implements Runnable
{
  BluetoothJsPlugin$BluetoothDeviceExtend$2(BluetoothJsPlugin.BluetoothDeviceExtend paramBluetoothDeviceExtend, bgkd parambgkd) {}
  
  public void run()
  {
    if (!this.this$1.gatt.discoverServices()) {
      this.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BluetoothJsPlugin.BluetoothDeviceExtend.2
 * JD-Core Version:    0.7.0.1
 */