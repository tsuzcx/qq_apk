package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule.InvokeDefaultBackPress;

class HippyEngineManagerImpl$3
  implements HippyEngine.BackPressHandler
{
  HippyEngineManagerImpl$3(HippyEngineManagerImpl paramHippyEngineManagerImpl, DeviceEventModule.InvokeDefaultBackPress paramInvokeDefaultBackPress) {}
  
  public void handleBackPress()
  {
    DeviceEventModule.InvokeDefaultBackPress localInvokeDefaultBackPress = this.val$invokeImp;
    if (localInvokeDefaultBackPress != null) {
      localInvokeDefaultBackPress.callSuperOnBackPress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */