package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.hippy.qq.module.vas.VasModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class VasApiProvider$2
  implements Provider<HippyNativeModuleBase>
{
  VasApiProvider$2(VasApiProvider paramVasApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new VasModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.impl.VasApiProvider.2
 * JD-Core Version:    0.7.0.1
 */