package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule;

class d$12
  implements Provider<HippyNativeModuleBase>
{
  d$12(d paramd, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new StorageModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.d.12
 * JD-Core Version:    0.7.0.1
 */