package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule;

class d$3
  implements Provider<HippyNativeModuleBase>
{
  d$3(d paramd, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new DeviceEventModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.d.3
 * JD-Core Version:    0.7.0.1
 */