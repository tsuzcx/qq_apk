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
          AudioDeviceHelper.c = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
        } else {
          AudioDeviceHelper.c = 0;
        }
      }
      else
      {
        AudioDeviceHelper.c = 0;
      }
      this.d.a(this.a, this.b);
      this.c.closeProfileProxy(1, paramBluetoothProfile);
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */