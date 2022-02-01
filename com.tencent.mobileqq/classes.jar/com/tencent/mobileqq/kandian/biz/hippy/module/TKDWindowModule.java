package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="TKDWindowModule")
public class TKDWindowModule
  extends HippyNativeModuleBase
{
  public TKDWindowModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="loadUrl")
  public void loadUrl(String paramString, HippyMap paramHippyMap)
  {
    ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpFromSelf(BaseApplicationImpl.getApplication(), paramString);
  }
  
  @HippyMethod(name="showPic")
  public void showPic(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDWindowModule
 * JD-Core Version:    0.7.0.1
 */