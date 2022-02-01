package com.tencent.mobileqq.kandian.biz.hippy.provider;

import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class TKDApiProvider$1
  implements Provider<HippyNativeModuleBase>
{
  TKDApiProvider$1(TKDApiProvider paramTKDApiProvider, TKDApiProvider.NativeModule paramNativeModule) {}
  
  public HippyNativeModuleBase get()
  {
    return this.val$nativeModule.getModuleInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.provider.TKDApiProvider.1
 * JD-Core Version:    0.7.0.1
 */