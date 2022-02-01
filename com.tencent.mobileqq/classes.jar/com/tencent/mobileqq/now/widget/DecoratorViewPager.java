package com.tencent.mobileqq.now.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

public class DecoratorViewPager
  extends ViewPager
{
  private ViewGroup a;
  
  public DecoratorViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public DecoratorViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.requestDisallowInterceptTouchEvent(true);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setNestedpParent(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.widget.DecoratorViewPager
 * JD-Core Version:    0.7.0.1
 */