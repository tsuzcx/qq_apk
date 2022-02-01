package com.tencent.sharp.jni;

import java.util.HashMap;

class TraeAudioManager$DeviceConnectStatusListener
  implements DeviceSwitchThread.IDeviceConnectStatusListener
{
  private HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  
  public TraeAudioManager$DeviceConnectStatusListener(HashMap<String, Object> paramHashMap)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
  }
  
  public void a(String paramString)
  {
    TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager;
    paramString.c = paramString.a.c();
    paramString = this.jdField_a_of_type_JavaUtilHashMap;
    paramString.put("EXTRA_CONNECT_DEVICE_NAME", paramString.get("PARAM_DEVICE_NAME"));
    if (TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, this.jdField_a_of_type_JavaUtilHashMap, paramInt) == 0) {
      TraeAudioManager.a(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
    }
    if (paramInt != 0) {
      TraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.DeviceConnectStatusListener
 * JD-Core Version:    0.7.0.1
 */