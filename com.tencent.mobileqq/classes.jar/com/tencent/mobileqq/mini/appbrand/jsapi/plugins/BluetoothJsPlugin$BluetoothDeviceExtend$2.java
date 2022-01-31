package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.bluetooth.BluetoothGatt;

class BluetoothJsPlugin$BluetoothDeviceExtend$2
  implements Runnable
{
  BluetoothJsPlugin$BluetoothDeviceExtend$2(BluetoothJsPlugin.BluetoothDeviceExtend paramBluetoothDeviceExtend, int paramInt) {}
  
  public void run()
  {
    if (!this.this$1.gatt.discoverServices()) {
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.this$0.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin.BluetoothDeviceExtend.2
 * JD-Core Version:    0.7.0.1
 */