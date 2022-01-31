package com.tencent.sharp.jni;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.text.TextUtils;
import bflm;
import bflq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TraeAudioManager$BluetoohHeadsetCheck$1
  implements Runnable
{
  public TraeAudioManager$BluetoohHeadsetCheck$1(bflm parambflm) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {}
    for (;;)
    {
      try
      {
        List localList = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
        if (localList == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + localList.size() + " _profile:" + this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        int i = 0;
        if (i >= localList.size()) {
          break;
        }
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)localList.get(i);
        int j = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectionState(localBluetoothDevice);
        if (j == 2) {
          this.a.jdField_a_of_type_Bflq.a(localBluetoothDevice.getName());
        }
        if (QLog.isColorLevel()) {
          QLog.w("BluetoohHeadsetCheck", 2, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + j);
        }
        i += 1;
        continue;
        str = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BluetoohHeadsetCheck", 2, "onServiceConnected.run e = " + localException);
        }
      }
    }
    if (this.a.jdField_a_of_type_Bflq != null) {
      if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bflq == null) {
        break label346;
      }
    }
    label346:
    for (String str = this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bflq.a();; str = null)
    {
      if (TextUtils.isEmpty(str))
      {
        this.a.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      }
      if (this.a.a())
      {
        this.a.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", true);
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
      this.a.jdField_a_of_type_Bflq.a("DEVICE_BLUETOOTHHEADSET", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.BluetoohHeadsetCheck.1
 * JD-Core Version:    0.7.0.1
 */