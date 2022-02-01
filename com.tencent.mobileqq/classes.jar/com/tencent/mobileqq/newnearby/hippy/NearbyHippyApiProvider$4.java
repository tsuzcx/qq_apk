package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.newnearby.hippy.module.NearbyHippyDataModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class NearbyHippyApiProvider$4
  implements Provider<HippyNativeModuleBase>
{
  NearbyHippyApiProvider$4(NearbyHippyApiProvider paramNearbyHippyApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new NearbyHippyDataModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.NearbyHippyApiProvider.4
 * JD-Core Version:    0.7.0.1
 */