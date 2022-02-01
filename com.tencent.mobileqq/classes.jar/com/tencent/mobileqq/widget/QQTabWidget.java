package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TabWidget;
import com.tencent.qphone.base.util.QLog;

public class QQTabWidget
  extends TabWidget
{
  private float a = 0.0F;
  private float b = 0.0F;
  private QQTabWidget.onTabWidgetTouchMoveListener c;
  private boolean d = false;
  
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
        if ((f2 < f3) && (f3 - f2 > 50.0F) && (f3 - f2 > Math.abs(this.a - f1)))
        {
          QQTabWidget.onTabWidgetTouchMoveListener localonTabWidgetTouchMoveListener = this.c;
          if ((localonTabWidgetTouchMoveListener != null) && (!this.d))
          {
            this.d = true;
            localonTabWidgetTouchMoveListener.a();
          }
        }
      }
    }
    else
    {
      this.d = false;
      this.a = paramMotionEvent.getX();
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
    this.c = paramonTabWidgetTouchMoveListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabWidget
 * JD-Core Version:    0.7.0.1
 */