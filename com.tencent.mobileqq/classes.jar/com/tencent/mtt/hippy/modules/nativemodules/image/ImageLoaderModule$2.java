package com.tencent.mtt.hippy.modules.nativemodules.image;

import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;

class ImageLoaderModule$2
  implements HippyImageLoader.Callback
{
  ImageLoaderModule$2(ImageLoaderModule paramImageLoaderModule) {}
  
  public void a(HippyDrawable paramHippyDrawable) {}
  
  public void b(HippyDrawable paramHippyDrawable)
  {
    paramHippyDrawable.onDrawableDetached();
  }
  
  public void onRequestFail(Throwable paramThrowable, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule.2
 * JD-Core Version:    0.7.0.1
 */