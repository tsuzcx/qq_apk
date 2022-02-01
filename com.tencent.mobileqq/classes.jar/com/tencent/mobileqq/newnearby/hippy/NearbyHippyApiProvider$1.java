package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.newnearby.hippy.module.NearbyHippySSOModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class NearbyHippyApiProvider$1
  implements Provider<HippyNativeModuleBase>
{
  NearbyHippyApiProvider$1(NearbyHippyApiProvider paramNearbyHippyApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new NearbyHippySSOModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.NearbyHippyApiProvider.1
 * JD-Core Version:    0.7.0.1
 */