package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule.InvokeDefaultBackPress;

class HippyEngineManagerImpl$2
  implements HippyEngine.BackPressHandler
{
  HippyEngineManagerImpl$2(HippyEngineManagerImpl paramHippyEngineManagerImpl, DeviceEventModule.InvokeDefaultBackPress paramInvokeDefaultBackPress) {}
  
  public void handleBackPress()
  {
    if (this.val$invokeImp != null) {
      this.val$invokeImp.callSuperOnBackPress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */