package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class VideoFeedsShareController$7
  implements URLDrawable.URLDrawableListener
{
  VideoFeedsShareController$7(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((VideoFeedsShareController.j(this.a) != null) && (VideoFeedsShareController.j(this.a).getStatus() == 1) && ((VideoFeedsShareController.j(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)VideoFeedsShareController.j(this.a).getCurrDrawable();
      VideoFeedsShareController.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.7
 * JD-Core Version:    0.7.0.1
 */