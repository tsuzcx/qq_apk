package com.tencent.mobileqq.qqaudio.audioplayer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import java.util.List;

class AudioPlayer$1
  implements BluetoothProfile.ServiceListener
{
  AudioPlayer$1(AudioPlayer paramAudioPlayer, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      Object localObject = paramBluetoothProfile.getConnectedDevices();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (BluetoothDevice)((List)localObject).get(0);
        if ((localObject != null) && (((BluetoothDevice)localObject).getBluetoothClass() != null)) {
          AudioDeviceHelper.jdField_a_of_type_Int = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
        } else {
          AudioDeviceHelper.jdField_a_of_type_Int = 0;
        }
      }
      else
      {
        AudioDeviceHelper.jdField_a_of_type_Int = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */