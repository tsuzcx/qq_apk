package com.tencent.mobileqq.troop.quickat.ui;

import agej;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import bgjj;
import com.tencent.qphone.base.util.QLog;

public class AtPanelTouchController
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 1;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private bgjj jdField_a_of_type_Bgjj;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  private boolean d;
  private boolean e;
  
  public AtPanelTouchController(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AtPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public AtPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a()
  {
    int i = 0;
    int k;
    for (int j = 0; i < getChildCount(); j = k)
    {
      View localView = getChildAt(i);
      k = j;
      if (localView.getVisibility() == 0) {
        k = j + localView.getHeight();
      }
      i += 1;
    }
    this.jdField_b_of_type_Int = j;
    return j / 3;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      return false;
      i = (int)paramMotionEvent.getRawY();
      j = (int)paramMotionEvent.getRawX();
      paramMotionEvent = new int[2];
      paramView.getLocationOnScreen(paramMotionEvent);
      k = paramMotionEvent[0];
      m = paramMotionEvent[1];
      n = paramView.getMeasuredWidth();
      i1 = paramView.getMeasuredHeight();
    } while ((i < m) || (i > i1 + m) || (j < k) || (j > n + k));
    return true;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if ((!this.c) || (a(paramView, paramMotionEvent)))
    {
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public float a(float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean) {}
    int i;
    int j;
    for (float f = 0.0F;; f = 20.0F)
    {
      i = agej.a(f, getContext().getResources());
      j = (int)(getScrollY() + paramFloat);
      if (j >= i) {
        break;
      }
      return paramFloat;
    }
    if (j >= i)
    {
      if (this.jdField_a_of_type_Bgjj != null) {
        this.jdField_a_of_type_Bgjj.a();
      }
      return i - getScrollY();
    }
    return 0.0F;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller != null)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller != null)
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, getScrollY(), 0, paramInt1 - getScrollY(), paramInt2);
      invalidate();
      return;
    }
    scrollTo(0, paramInt1);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if ((this.jdField_a_of_type_AndroidWidgetScroller != null) && (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()))
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      invalidate();
    }
    do
    {
      do
      {
        return;
      } while (!this.e);
      this.e = false;
    } while (this.jdField_a_of_type_Bgjj == null);
    this.jdField_a_of_type_Bgjj.a(this.jdField_a_of_type_Int);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if ((!b(getChildAt(0), paramMotionEvent)) && (this.jdField_a_of_type_Int != 1)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.d = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      float f2 = -(f1 - this.jdField_a_of_type_Float);
      float f3 = a(f2);
      if (QLog.isColorLevel()) {
        QLog.d("UUUU", 2, "NKSS=" + f3 + " differ=" + f2);
      }
      if ((this.jdField_b_of_type_Boolean) && (f3 != 0.0F)) {
        scrollBy(0, (int)f3);
      }
      for (;;)
      {
        if (Math.abs(f2) > 5.0F) {
          this.d = true;
        }
        if (this.jdField_a_of_type_Bgjj != null)
        {
          paramMotionEvent = this.jdField_a_of_type_Bgjj;
          if (getScrollY() > 0) {
            bool = true;
          }
          paramMotionEvent.a(bool);
        }
        this.jdField_a_of_type_Float = f1;
        return true;
        if (f3 > 0.0F) {
          scrollBy(0, (int)f3);
        }
      }
      this.jdField_b_of_type_Boolean = false;
      if (!this.d) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < a()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label303;
        }
        a(0);
        break;
      }
      label303:
      if (this.jdField_a_of_type_Bgjj != null)
      {
        this.e = true;
        a(-this.jdField_b_of_type_Int);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAtPanelTouchListener(bgjj parambgjj)
  {
    this.jdField_a_of_type_Bgjj = parambgjj;
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController
 * JD-Core Version:    0.7.0.1
 */