package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
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
      int i = super.getCurrentItem();
      return localVideoPlayerPagerAdapter.jdField_a_of_type_Int + (i - 50);
    }
    return super.getCurrentItem();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int j;
    int i;
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)getAdapter();
      j = super.getCurrentItem() - 50 + localVideoPlayerPagerAdapter.jdField_a_of_type_Int;
      i = localVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size();
    }
    for (;;)
    {
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        bool = super.onInterceptTouchEvent(paramMotionEvent);
      }
      label136:
      do
      {
        float f1;
        do
        {
          return bool;
          this.f = paramMotionEvent.getX();
          break;
          f1 = paramMotionEvent.getX();
          if ((this.f >= f1) || (j > 0)) {
            break label136;
          }
        } while (!QLog.isColorLevel());
        QLog.d("CustomViewPager", 2, " 右滑到头");
        return false;
        if ((this.f <= f1) || (j < i - 1)) {
          break label169;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CustomViewPager", 2, " 左滑到头");
      return false;
      label169:
      return super.onInterceptTouchEvent(paramMotionEvent);
      i = 0;
      j = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
    case 0: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.b = 0.0F;
        this.a = 0.0F;
        this.c = paramMotionEvent.getX();
        this.d = paramMotionEvent.getY();
        this.e = this.c;
      }
    }
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
  
  public void setCurrentItem(int paramInt)
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      super.setCurrentItem(paramInt + 50 - ((VideoPlayerPagerAdapter)getAdapter()).jdField_a_of_type_Int);
      return;
    }
    super.setCurrentItem(paramInt);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((getAdapter() instanceof VideoPlayerPagerAdapter))
    {
      super.setCurrentItem(paramInt + 50 - ((VideoPlayerPagerAdapter)getAdapter()).jdField_a_of_type_Int, paramBoolean);
      return;
    }
    super.setCurrentItem(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */