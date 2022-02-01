package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TabWidget;
import com.tencent.qphone.base.util.QLog;

public class QQTabWidget
  extends TabWidget
{
  private float jdField_a_of_type_Float = 0.0F;
  private QQTabWidget.onTabWidgetTouchMoveListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float b = 0.0F;
  
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
      i = paramMotionEvent.getAction();
      if ((i == 0) || (i == 1) || (i == 3)) {
        try
        {
          throw new RuntimeException();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("QQTabWidget onInterceptTouchEvent. action=");
          localStringBuilder.append(i);
          localStringBuilder.append(",x=");
          localStringBuilder.append(paramMotionEvent.getRawX());
          localStringBuilder.append(",y=");
          localStringBuilder.append(paramMotionEvent.getRawY());
          QLog.d("QQTabWidget", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = this.b;
        if ((f2 < f3) && (f3 - f2 > 50.0F) && (f3 - f2 > Math.abs(this.jdField_a_of_type_Float - f1)))
        {
          QQTabWidget.onTabWidgetTouchMoveListener localonTabWidgetTouchMoveListener = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener;
          if ((localonTabWidgetTouchMoveListener != null) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = true;
            localonTabWidgetTouchMoveListener.a();
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTabWidgetMoveListener(QQTabWidget.onTabWidgetTouchMoveListener paramonTabWidgetTouchMoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = paramonTabWidgetTouchMoveListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabWidget
 * JD-Core Version:    0.7.0.1
 */