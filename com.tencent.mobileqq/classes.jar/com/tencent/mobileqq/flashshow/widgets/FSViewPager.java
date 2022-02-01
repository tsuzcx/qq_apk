package com.tencent.mobileqq.flashshow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.richframework.widget.FixedSpeedScroller;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;

public class FSViewPager
  extends ViewPagerCompat
{
  float a;
  float b;
  float c;
  float d;
  private FSViewPager.OnSlideListener e;
  private int f;
  private int g;
  
  public FSViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FSViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    FixedSpeedScroller localFixedSpeedScroller = new FixedSpeedScroller(getContext());
    localFixedSpeedScroller.a(400);
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(this, localFixedSpeedScroller);
    }
    catch (Exception localException)
    {
      QLog.e("FSViewPager", 1, "initViewPager error:", localException);
    }
    this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.g = ImmersiveUtils.getScreenWidth();
  }
  
  public void a(FSViewPager.OnSlideListener paramOnSlideListener)
  {
    this.e = paramOnSlideListener;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        float f2 = Math.abs(this.a - f1);
        f3 = Math.abs(this.b - f3);
        if ((this.e.a()) && (this.a - f1 > this.f))
        {
          double d1 = f2;
          double d2 = Math.tan(0.5235987755982988D);
          Double.isNaN(d1);
          if (d1 * d2 > f3) {
            return true;
          }
        }
      }
    }
    else
    {
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      if (this.e.a())
      {
        float f1 = this.a;
        float f2 = this.c;
        if ((f1 - f2 > 0.0F) && (f1 - f2 >= this.g / 4.0F)) {
          this.e.b();
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.FSViewPager
 * JD-Core Version:    0.7.0.1
 */