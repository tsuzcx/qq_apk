package com.tencent.mtt.hippy.modules.nativemodules.image;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="ImageLoaderModule")
public class ImageLoaderModule
  extends HippyNativeModuleBase
{
  HippyImageLoader a;
  
  public ImageLoaderModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.a = paramHippyEngineContext.getGlobalConfigs().getImageLoaderAdapter();
  }
  
  @HippyMethod(name="getSize")
  public void getSize(String paramString, Promise paramPromise)
  {
    if (this.a != null) {
      this.a.fetchImage(paramString, new ImageLoaderModule.1(this, paramPromise, paramString), null);
    }
  }
  
  @HippyMethod(name="prefetch")
  public void prefetch(String paramString)
  {
    this.a.fetchImage(paramString, new ImageLoaderModule.2(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule
 * JD-Core Version:    0.7.0.1
 */