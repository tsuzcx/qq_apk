package com.tencent.mobileqq.kandian.biz.hippy.module;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

@HippyNativeModule(name="TKDToastModule")
public class TKDToastModule
  extends HippyNativeModuleBase
{
  public TKDToastModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private int getIconType(int paramInt)
  {
    int i = 1;
    if (paramInt != 1)
    {
      i = 2;
      if (paramInt != 2) {
        return 0;
      }
    }
    return i;
  }
  
  @HippyMethod(name="show")
  public void show(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, Promise paramPromise)
  {
    UIThreadUtils.runOnUiThread(new TKDToastModule.1(this, paramInt2, paramString1, paramInt1, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDToastModule
 * JD-Core Version:    0.7.0.1
 */