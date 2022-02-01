package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class VideoShareHelper$3
  implements URLDrawable.URLDrawableListener
{
  VideoShareHelper$3(VideoShareHelper paramVideoShareHelper) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((VideoShareHelper.d(this.a) != null) && (VideoShareHelper.d(this.a).getStatus() == 1) && ((VideoShareHelper.d(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)VideoShareHelper.d(this.a).getCurrDrawable();
      VideoShareHelper.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.3
 * JD-Core Version:    0.7.0.1
 */