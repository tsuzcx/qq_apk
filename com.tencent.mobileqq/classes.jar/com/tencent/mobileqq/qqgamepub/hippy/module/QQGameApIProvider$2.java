package com.tencent.mobileqq.qqgamepub.hippy.module;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class QQGameApIProvider$2
  implements Provider<HippyNativeModuleBase>
{
  QQGameApIProvider$2(QQGameApIProvider paramQQGameApIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new GamePubAccountModule(this.jdField_a_of_type_ComTencentMttHippyHippyEngineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.module.QQGameApIProvider.2
 * JD-Core Version:    0.7.0.1
 */