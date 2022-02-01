package com.tencent.rtmp.sharp.jni;

public class TraeAudioManager$DeviceConfigManager$DeviceConfig
{
  String deviceName = "DEVICE_NONE";
  int priority = 0;
  boolean visible = false;
  
  public TraeAudioManager$DeviceConfigManager$DeviceConfig(TraeAudioManager.DeviceConfigManager paramDeviceConfigManager) {}
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public boolean getVisible()
  {
    return this.visible;
  }
  
  public boolean init(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      if (TraeAudioManager.checkDevName(paramString) != true) {
        return false;
      }
      this.deviceName = paramString;
      this.priority = paramInt;
      return true;
    }
    return false;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.DeviceConfigManager.DeviceConfig
 * JD-Core Version:    0.7.0.1
 */