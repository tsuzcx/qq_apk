package com.tencent.mobileqq.vaswebviewplugin;

import android.bluetooth.BluetoothDevice;

class QWalletBluetoothJsPlugin$BluetoothDeviceExtend
{
  private BluetoothDevice mBluetoothDevice;
  private int mRssi;
  private byte[] mScanRecord;
  
  QWalletBluetoothJsPlugin$BluetoothDeviceExtend(QWalletBluetoothJsPlugin paramQWalletBluetoothJsPlugin, BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    this.mBluetoothDevice = paramBluetoothDevice;
    this.mRssi = paramInt;
    this.mScanRecord = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof BluetoothDeviceExtend)) && (((BluetoothDeviceExtend)paramObject).getBluetoothDevice().getAddress().equals(this.mBluetoothDevice.getAddress()));
  }
  
  BluetoothDevice getBluetoothDevice()
  {
    return this.mBluetoothDevice;
  }
  
  public int getRssi()
  {
    return this.mRssi;
  }
  
  byte[] getScanRecord()
  {
    return this.mScanRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.BluetoothDeviceExtend
 * JD-Core Version:    0.7.0.1
 */