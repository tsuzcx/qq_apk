package com.tencent.mobileqq.qqaudio.audioplayer;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import java.util.List;

class AudioBluetoothSCOHelper$1
  implements BluetoothProfile.ServiceListener
{
  AudioBluetoothSCOHelper$1(AudioBluetoothSCOHelper paramAudioBluetoothSCOHelper, AudioPlayerBase paramAudioPlayerBase, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      Object localObject = paramBluetoothProfile.getConnectedDevices();
      int i = 0;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (BluetoothDevice)((List)localObject).get(0);
        paramInt = i;
        if (localObject != null) {
          if (((BluetoothDevice)localObject).getBluetoothClass() == null) {
            paramInt = i;
          } else {
            paramInt = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
          }
        }
        AudioDeviceHelper.jdField_a_of_type_Int = paramInt;
      }
      else
      {
        AudioDeviceHelper.jdField_a_of_type_Int = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase.d(true);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioBluetoothSCOHelper.1
 * JD-Core Version:    0.7.0.1
 */