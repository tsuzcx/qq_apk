package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Field;

class AvatarWallViewPager$RollScroller
  extends Scroller
{
  public AvatarWallViewPager$RollScroller(AvatarWallViewPager paramAvatarWallViewPager, Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void a()
  {
    try
    {
      Field localField = AvatarWallViewPager.RollViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(this.a.d, this);
      localField.setAccessible(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a.o);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager.RollScroller
 * JD-Core Version:    0.7.0.1
 */