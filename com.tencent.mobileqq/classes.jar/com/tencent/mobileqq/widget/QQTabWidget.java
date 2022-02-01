package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TabWidget;
import bisq;
import com.tencent.qphone.base.util.QLog;

public class QQTabWidget
  extends TabWidget
{
  private float jdField_a_of_type_Float;
  private bisq jdField_a_of_type_Bisq;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  
  public QQTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      int i = paramMotionEvent.getAction();
      if ((i == 0) || (i == 1) || (i == 3)) {
        try
        {
          throw new RuntimeException();
        }
        catch (Exception localException)
        {
          QLog.d("QQTabWidget", 2, "QQTabWidget onInterceptTouchEvent. action=" + i + ",x=" + paramMotionEvent.getRawX() + ",y=" + paramMotionEvent.getRawY(), localException);
        }
      }
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((f2 < this.b) && (this.b - f2 > 50.0F) && (this.b - f2 > Math.abs(this.jdField_a_of_type_Float - f1)) && (this.jdField_a_of_type_Bisq != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bisq.a();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTabWidgetMoveListener(bisq parambisq)
  {
    this.jdField_a_of_type_Bisq = parambisq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabWidget
 * JD-Core Version:    0.7.0.1
 */