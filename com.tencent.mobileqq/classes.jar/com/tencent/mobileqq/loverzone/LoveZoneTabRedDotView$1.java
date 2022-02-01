package com.tencent.mobileqq.loverzone;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class LoveZoneTabRedDotView$1
  implements Drawable.Callback
{
  LoveZoneTabRedDotView$1(LoveZoneTabRedDotView paramLoveZoneTabRedDotView) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.a.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.unscheduleDrawable(paramDrawable, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView.1
 * JD-Core Version:    0.7.0.1
 */