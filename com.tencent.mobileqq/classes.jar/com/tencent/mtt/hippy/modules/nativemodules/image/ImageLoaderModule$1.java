package com.tencent.mtt.hippy.modules.nativemodules.image;

import android.graphics.Bitmap;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

class ImageLoaderModule$1
  implements HippyImageLoader.Callback
{
  ImageLoaderModule$1(ImageLoaderModule paramImageLoaderModule, Promise paramPromise, String paramString) {}
  
  public void a(HippyDrawable paramHippyDrawable) {}
  
  public void b(HippyDrawable paramHippyDrawable)
  {
    if (paramHippyDrawable != null)
    {
      Object localObject = paramHippyDrawable.getBitmap();
      if (localObject != null)
      {
        int i = ((Bitmap)localObject).getWidth();
        int j = ((Bitmap)localObject).getHeight();
        localObject = new HippyMap();
        ((HippyMap)localObject).pushInt("width", i);
        ((HippyMap)localObject).pushInt("height", j);
        this.a.resolve(localObject);
      }
      for (;;)
      {
        paramHippyDrawable.onDrawableDetached();
        return;
        this.a.reject("bitmap is null " + paramHippyDrawable.getSource());
      }
    }
    this.a.reject("fetch image fail " + this.b);
  }
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    this.a.reject("fetch image fail " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule.1
 * JD-Core Version:    0.7.0.1
 */