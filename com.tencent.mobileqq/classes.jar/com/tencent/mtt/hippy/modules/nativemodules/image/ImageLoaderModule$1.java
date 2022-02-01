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
      localObject = paramHippyDrawable.getBitmap();
      if (localObject != null)
      {
        int i = ((Bitmap)localObject).getWidth();
        int j = ((Bitmap)localObject).getHeight();
        localObject = new HippyMap();
        ((HippyMap)localObject).pushInt("width", i);
        ((HippyMap)localObject).pushInt("height", j);
        this.a.resolve(localObject);
      }
      else
      {
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bitmap is null ");
        localStringBuilder.append(paramHippyDrawable.getSource());
        ((Promise)localObject).reject(localStringBuilder.toString());
      }
      paramHippyDrawable.onDrawableDetached();
      return;
    }
    paramHippyDrawable = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fetch image fail ");
    ((StringBuilder)localObject).append(this.b);
    paramHippyDrawable.reject(((StringBuilder)localObject).toString());
  }
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    paramThrowable = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetch image fail ");
    localStringBuilder.append(paramString);
    paramThrowable.reject(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.image.ImageLoaderModule.1
 * JD-Core Version:    0.7.0.1
 */