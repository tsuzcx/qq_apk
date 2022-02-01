package com.tencent.viola.ui.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class PageSliderScroller
  extends Scroller
{
  private int mDuration = 250;
  
  public PageSliderScroller(Context paramContext)
  {
    super(paramContext);
  }
  
  public PageSliderScroller(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public int getChangeDuration()
  {
    return this.mDuration;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.PageSliderScroller
 * JD-Core Version:    0.7.0.1
 */