package com.tencent.sharp.jni;

import java.util.HashMap;

class TraeAudioManager$DeviceConnectStatusListener
  implements DeviceSwitchThread.IDeviceConnectStatusListener
{
  private HashMap<String, Object> b;
  
  public TraeAudioManager$DeviceConnectStatusListener(HashMap<String, Object> paramHashMap)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void a(String paramString)
  {
    TraeAudioManager.a(this.a, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.b == null)
    {
      TraeAudioManager.a(this.a);
      return;
    }
    paramString = this.a;
    paramString.k = paramString.a.h();
    paramString = this.b;
    paramString.put("EXTRA_CONNECT_DEVICE_NAME", paramString.get("PARAM_DEVICE_NAME"));
    if (TraeAudioManager.a(this.a, this.b, paramInt) == 0) {
      TraeAudioManager.a(this.a);
    }
    if (paramInt != 0) {
      TraeAudioManager.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.DeviceConnectStatusListener
 * JD-Core Version:    0.7.0.1
 */