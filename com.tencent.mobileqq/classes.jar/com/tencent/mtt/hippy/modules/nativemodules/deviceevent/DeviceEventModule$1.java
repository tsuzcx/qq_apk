package com.tencent.mtt.hippy.modules.nativemodules.deviceevent;

import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;

class DeviceEventModule$1
  implements Runnable
{
  DeviceEventModule$1(DeviceEventModule paramDeviceEventModule) {}
  
  public void run()
  {
    HippyEngine.BackPressHandler localBackPressHandler = this.a.a;
    if (localBackPressHandler != null) {
      localBackPressHandler.handleBackPress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule.1
 * JD-Core Version:    0.7.0.1
 */