package com.tencent.sharp.jni;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.text.TextUtils;
import bjlf;
import bjlj;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TraeAudioManager$BluetoothHeadsetCheck$1
  implements Runnable
{
  public TraeAudioManager$BluetoothHeadsetCheck$1(bjlf parambjlf) {}
  
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
          QLog.w("BluetoothHeadsetCheck", 2, "TRAEBluetoothProxy: HEADSET Connected devs:" + localList.size() + " _profile:" + this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        int i = 0;
        if (i >= localList.size()) {
          break;
        }
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)localList.get(i);
        int j = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectionState(localBluetoothDevice);
        if (j == 2) {
          this.a.jdField_a_of_type_Bjlj.a(localBluetoothDevice.getName());
        }
        if (QLog.isColorLevel()) {
          QLog.w("BluetoothHeadsetCheck", 2, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + j);
        }
        i += 1;
        continue;
        str = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BluetoothHeadsetCheck", 2, "onServiceConnected.run e = " + localException);
        }
      }
    }
    if (this.a.jdField_a_of_type_Bjlj != null) {
      if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bjlj == null) {
        break label346;
      }
    }
    label346:
    for (String str = this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bjlj.a();; str = null)
    {
      if (TextUtils.isEmpty(str))
      {
        this.a.jdField_a_of_type_Bjlj.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      }
      if (this.a.a())
      {
        this.a.jdField_a_of_type_Bjlj.a("DEVICE_BLUETOOTHHEADSET", true);
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
      this.a.jdField_a_of_type_Bjlj.a("DEVICE_BLUETOOTHHEADSET", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.BluetoothHeadsetCheck.1
 * JD-Core Version:    0.7.0.1
 */