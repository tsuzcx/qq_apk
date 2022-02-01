package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CustomViewPager
  extends ViewPager
{
  public float a;
  public float b;
  public float c;
  public float d;
  float e;
  float f;
  
  public CustomViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getCurrentItem()
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)getAdapter();
      return super.getCurrentItem() - 50 + localVideoPlayerPagerAdapter.h;
    }
    return super.getCurrentItem();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j;
    int i;
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)getAdapter();
      j = super.getCurrentItem() - 50 + localVideoPlayerPagerAdapter.h;
      i = localVideoPlayerPagerAdapter.d.size();
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k == 2)
      {
        float f1 = paramMotionEvent.getX();
        if ((this.f < f1) && (j <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CustomViewPager", 2, " 右滑到头");
          }
          return false;
        }
        if ((this.f > f1) && (j >= i - 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CustomViewPager", 2, " 左滑到头");
          }
          return false;
        }
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
    }
    else {
      this.f = paramMotionEvent.getX();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.a += Math.abs(f1 - this.c);
        this.b += Math.abs(f2 - this.d);
        this.c = f1;
        this.d = f2;
        if (this.a <= this.b)
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
        return super.onTouchEvent(paramMotionEvent);
      }
    }
    else
    {
      this.b = 0.0F;
      this.a = 0.0F;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      this.e = this.c;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCurrentItem(int paramInt)
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      super.setCurrentItem(paramInt + 50 - ((VideoPlayerPagerAdapter)getAdapter()).h);
      return;
    }
    super.setCurrentItem(paramInt);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      super.setCurrentItem(paramInt + 50 - ((VideoPlayerPagerAdapter)getAdapter()).h, paramBoolean);
      return;
    }
    super.setCurrentItem(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */