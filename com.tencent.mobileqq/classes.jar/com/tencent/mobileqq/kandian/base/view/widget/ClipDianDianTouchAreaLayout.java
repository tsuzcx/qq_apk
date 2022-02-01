package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class ClipDianDianTouchAreaLayout
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean = false;
  int b = 1;
  private int c;
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClipDianDianTouchAreaLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledMinimumFlingVelocity();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    Object localObject;
    if (k == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      k = this.c;
      ((Rect)localObject).inset(k, k);
      this.jdField_a_of_type_Boolean = false;
      this.b = 1;
      localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (localObject == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      } else {
        ((VelocityTracker)localObject).clear();
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    }
    else if (k == 2)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (localObject != null)
      {
        ((VelocityTracker)localObject).addMovement(paramMotionEvent);
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        if (Math.abs((int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity()) >= this.jdField_a_of_type_Int) {
          this.b = 2;
        }
      }
      if (this.b == 2) {
        return true;
      }
    }
    else if ((k == 1) || (k == 3))
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j)) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if ((k == 1) || (k == 3)) {
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      if (k == 0)
      {
        ((View)localObject).getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        i = this.c;
        ((Rect)localObject).inset(i, i);
        this.jdField_a_of_type_Boolean = false;
      }
      else if (k == 2)
      {
        if (this.b == 2)
        {
          paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.clear();
            this.jdField_a_of_type_AndroidViewVelocityTracker = null;
          }
          return false;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.clear();
            this.jdField_a_of_type_AndroidViewVelocityTracker = null;
          }
          return false;
        }
        if (!this.jdField_a_of_type_AndroidGraphicsRect.contains(i, j))
        {
          this.jdField_a_of_type_Boolean = true;
          super.onTouchEvent(paramMotionEvent);
          setPressed(false);
          return false;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setTouchWidget(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ClipDianDianTouchAreaLayout
 * JD-Core Version:    0.7.0.1
 */