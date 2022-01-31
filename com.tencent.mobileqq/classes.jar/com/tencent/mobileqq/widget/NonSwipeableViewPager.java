package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipeableViewPager
  extends QQViewPager
{
  private boolean a = true;
  
  public NonSwipeableViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setPagingEnabled(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NonSwipeableViewPager
 * JD-Core Version:    0.7.0.1
 */