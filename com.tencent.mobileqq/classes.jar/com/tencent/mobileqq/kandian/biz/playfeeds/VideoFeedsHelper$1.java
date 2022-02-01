package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class VideoFeedsHelper$1
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.1
 * JD-Core Version:    0.7.0.1
 */