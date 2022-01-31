package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class QQViewPager
  extends ViewPager
{
  private byte jdField_a_of_type_Byte = 0;
  private final int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public QQViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public QQViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.jdField_a_of_type_Int) || (paramFloat2 > this.jdField_a_of_type_Int)) {
      if ((paramFloat1 <= this.jdField_a_of_type_Int) || (paramFloat2 / paramFloat1 >= 0.6F)) {
        break label79;
      }
    }
    label79:
    for (this.jdField_a_of_type_Byte = 1;; this.jdField_a_of_type_Byte = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQViewPager", 2, "judgeScrollDirection : mSlideDir -> " + this.jdField_a_of_type_Byte);
      }
      return;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        this.jdField_b_of_type_Int = i;
        this.c = j;
        return;
        if (this.jdField_a_of_type_Byte == 0) {
          a(Math.abs(i - this.jdField_b_of_type_Int), Math.abs(j - this.c));
        }
      } while (this.jdField_a_of_type_Byte != 1);
      c(true);
      return;
    }
    this.jdField_a_of_type_Byte = 0;
    c(false);
  }
  
  private void c(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQViewPager", 2, "doInterceptTouchEvent : " + paramBoolean);
      }
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      a(paramMotionEvent);
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
        int i;
        paramMotionEvent.printStackTrace();
      }
      if (this.jdField_b_of_type_Boolean)
      {
        i = paramMotionEvent.getAction();
        if (i == 0) {
          c(true);
        } else if ((i == 1) || (i == 3)) {
          c(false);
        }
      }
    }
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQViewPager
 * JD-Core Version:    0.7.0.1
 */