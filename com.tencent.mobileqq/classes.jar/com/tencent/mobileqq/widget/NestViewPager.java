package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class NestViewPager
  extends QQViewPager
{
  private int a;
  private int b;
  private boolean c;
  
  public NestViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public NestViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool1 = false;
    if (i == 0)
    {
      this.a = ((int)(paramMotionEvent.getX() + 0.5F));
      this.b = ((int)(paramMotionEvent.getY() + 0.5F));
      this.c = true;
    }
    else if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      int j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.a);
      j = Math.abs(j - this.b);
      int k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((this.c) && (i > k))
      {
        if ((j / i < 0.6F) && (this.a > (int)(ScreenUtil.SCREEN_WIDTH * 0.1F))) {
          i = 1;
        } else {
          i = 0;
        }
        this.c = false;
        break label170;
      }
    }
    else if ((i == 1) || (i == 3))
    {
      this.c = false;
    }
    i = 0;
    label170:
    if (i == 0) {}
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && ((i == 1) || (i == 3))) {
      this.c = false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NestViewPager
 * JD-Core Version:    0.7.0.1
 */