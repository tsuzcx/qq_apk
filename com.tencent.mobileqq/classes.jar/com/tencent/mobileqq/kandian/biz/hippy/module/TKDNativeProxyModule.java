package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.hippy.qq.api.INativeProxy;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="TKDNativeProxyModule")
public class TKDNativeProxyModule
  extends HippyNativeModuleBase
{
  public TKDNativeProxyModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="callNativeMethod")
  public void callNativeMethod(String paramString1, String paramString2, HippyMap paramHippyMap, Promise paramPromise)
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    if (localHippyQQEngine != null) {
      localHippyQQEngine.getNativeProxy().callNativeMethod(paramString1, paramString2, paramHippyMap, paramPromise);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDNativeProxyModule
 * JD-Core Version:    0.7.0.1
 */