package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class QQViewPager
  extends ViewPager
{
  private boolean a;
  
  public QQViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    ViewGroup localViewGroup;
    if (this.a)
    {
      i = paramMotionEvent.getAction();
      if (i != 0) {
        break label44;
      }
      localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null) {
        localViewGroup.requestDisallowInterceptTouchEvent(true);
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        label44:
        paramMotionEvent.printStackTrace();
      }
      if ((i == 1) || (i == 3))
      {
        localViewGroup = (ViewGroup)getParent();
        if (localViewGroup != null) {
          localViewGroup.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQViewPager
 * JD-Core Version:    0.7.0.1
 */