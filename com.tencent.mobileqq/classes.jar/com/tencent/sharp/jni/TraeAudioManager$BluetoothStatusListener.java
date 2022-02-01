package com.tencent.sharp.jni;

class TraeAudioManager$BluetoothStatusListener
  implements BluetoothHelper.IStateChangeListener
{
  private TraeAudioManager$BluetoothStatusListener(TraeAudioManager paramTraeAudioManager) {}
  
  public void a(boolean paramBoolean)
  {
    TraeAudioManager.a(this.a, "DEVICE_BLUETOOTH_HEADSET", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.BluetoothStatusListener
 * JD-Core Version:    0.7.0.1
 */