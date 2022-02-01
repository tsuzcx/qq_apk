package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.hippy.qq.module.vas.QQTenPayModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class VasApiProvider$1
  implements Provider<HippyNativeModuleBase>
{
  VasApiProvider$1(VasApiProvider paramVasApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new QQTenPayModule(this.jdField_a_of_type_ComTencentMttHippyHippyEngineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.impl.VasApiProvider.1
 * JD-Core Version:    0.7.0.1
 */