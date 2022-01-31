package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class NestViewPager
  extends QQViewPager
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
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
    boolean bool1 = false;
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getX() + 0.5F));
      this.b = ((int)(paramMotionEvent.getY() + 0.5F));
      this.jdField_a_of_type_Boolean = true;
      i = 0;
      if (i != 0) {}
    }
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      int j;
      int k;
      return false;
    }
    if (i == 2)
    {
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      i = Math.abs(i - this.jdField_a_of_type_Int);
      j = Math.abs(j - this.b);
      k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if ((!this.jdField_a_of_type_Boolean) || (i <= k)) {
        break label184;
      }
      if ((j / i >= 0.6F) || (this.jdField_a_of_type_Int <= (int)(ScreenUtil.jdField_a_of_type_Int * 0.1F))) {
        break label192;
      }
    }
    label184:
    label192:
    for (i = 1;; i = 0)
    {
      this.jdField_a_of_type_Boolean = false;
      break;
      if ((i == 1) || (i == 3)) {
        this.jdField_a_of_type_Boolean = false;
      }
      i = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {}
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      if ((i == 1) || (i == 3)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NestViewPager
 * JD-Core Version:    0.7.0.1
 */