package com.tencent.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class TraeAudioManager$BluetoothHeadsetCheckFake
  extends TraeAudioManager.BluetoothHeadsetCheckInterface
{
  TraeAudioManager$BluetoothHeadsetCheckFake(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "BluetoohHeadsetCheckFake";
  }
  
  public void a() {}
  
  void a(Context paramContext, Intent paramIntent) {}
  
  void a(IntentFilter paramIntentFilter) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.BluetoothHeadsetCheckFake
 * JD-Core Version:    0.7.0.1
 */