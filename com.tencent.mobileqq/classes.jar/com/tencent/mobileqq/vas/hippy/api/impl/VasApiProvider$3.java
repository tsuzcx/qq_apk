package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.hippy.qq.module.vas.VasPersonalizedModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class VasApiProvider$3
  implements Provider<HippyNativeModuleBase>
{
  VasApiProvider$3(VasApiProvider paramVasApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new VasPersonalizedModule(this.jdField_a_of_type_ComTencentMttHippyHippyEngineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.impl.VasApiProvider.3
 * JD-Core Version:    0.7.0.1
 */