package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import bcsu;
import bcsv;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class WorkSpaceView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new bcsu(this);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
  private bcsv jdField_a_of_type_Bcsv;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -2;
  private boolean jdField_c_of_type_Boolean = true;
  private int d = 0;
  private int e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  
  public WorkSpaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  private void a()
  {
    int i = getWidth();
    a((getScrollX() + i / 2) / i);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getChildCount());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    if (!this.jdField_a_of_type_Boolean) {
      a(paramInt, true);
    }
    while (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    int j = Math.max(-1, Math.min(paramInt, getChildCount()));
    if (j != this.jdField_a_of_type_Int) {}
    for (paramInt = i;; paramInt = 0)
    {
      this.jdField_c_of_type_Int = j;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_a_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth();
      i = getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt * j - i, 0, 400);
      if (this.jdField_a_of_type_Bcsv != null) {
        this.jdField_a_of_type_Bcsv.a(j);
      }
      invalidate();
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i != this.jdField_a_of_type_Int) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.jdField_c_of_type_Int = i;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.jdField_a_of_type_Int))) {
        localView.clearFocus();
      }
      paramInt = getWidth();
      int j = getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt * i - j, 0, 400);
      if (this.jdField_a_of_type_Bcsv != null) {
        this.jdField_a_of_type_Bcsv.a(i);
      }
      invalidate();
      return;
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    while (this.jdField_c_of_type_Int == -2) {
      return;
    }
    if (this.jdField_c_of_type_Int == -1)
    {
      this.jdField_a_of_type_Int = (getChildCount() - 1);
      scrollTo(this.jdField_a_of_type_Int * getWidth(), getScrollY());
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = -2;
      return;
      if (this.jdField_c_of_type_Int == getChildCount())
      {
        this.jdField_a_of_type_Int = 0;
        scrollTo(0, getScrollY());
      }
      else
      {
        this.jdField_a_of_type_Int = Math.max(0, Math.min(this.jdField_c_of_type_Int, getChildCount() - 1));
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int m = 0;
    int k = 0;
    if ((this.d != 1) && (this.jdField_c_of_type_Int == -2)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if ((paramCanvas != null) && (getChildAt(this.jdField_a_of_type_Int) != null)) {
        drawChild(paramCanvas, getChildAt(this.jdField_a_of_type_Int), getDrawingTime());
      }
      return;
    }
    long l = getDrawingTime();
    int i1 = getWidth();
    float f = getScrollX() / i1;
    boolean bool = this.jdField_a_of_type_Boolean;
    int i2 = getChildCount();
    int j;
    if ((f < 0.0F) && (bool))
    {
      j = i2 - 1;
      i = 0;
    }
    for (;;)
    {
      if (a(j))
      {
        if ((i != 0) || (k != 0)) {
          break label287;
        }
        m = i2 * i1;
        paramCanvas.translate(-m, 0.0F);
        drawChild(paramCanvas, getChildAt(j), l);
        paramCanvas.translate(m, 0.0F);
      }
      int n;
      for (;;)
      {
        if ((f == j) || (!a(i))) {
          break label302;
        }
        if ((!bool) || (i != 0) || (k == 0)) {
          break label304;
        }
        j = i2 * i1;
        paramCanvas.translate(j, 0.0F);
        drawChild(paramCanvas, getChildAt(i), l);
        paramCanvas.translate(-j, 0.0F);
        return;
        j = Math.min((int)f, i2 - 1);
        n = j + 1;
        if (!bool) {
          break label318;
        }
        i = m;
        if (i2 != 0) {
          i = n % i2;
        }
        k = 1;
        break;
        label287:
        drawChild(paramCanvas, getChildAt(j), l);
      }
      label302:
      break;
      label304:
      drawChild(paramCanvas, getChildAt(i), l);
      return;
      label318:
      i = n;
    }
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (a() > 0)
      {
        a(a() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (a() < getChildCount() - 1))
    {
      a(a() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (k)
    {
    default: 
      if (k == 0) {
        FrameHelperActivity.c(false);
      }
      break;
    }
    for (;;)
    {
      if (this.d == 0) {
        break label236;
      }
      return true;
      int m = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
      int n = (int)Math.abs(f2 - this.jdField_b_of_type_Float);
      int j = this.e;
      if (m > j)
      {
        i = 1;
        label108:
        if (n <= j) {
          break label150;
        }
      }
      label150:
      for (j = 1;; j = 0)
      {
        double d1 = n / m;
        if ((i == 0) && (j == 0)) {
          break label156;
        }
        this.d = 1;
        break;
        i = 0;
        break label108;
      }
      label156:
      this.d = 0;
      break;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {}
      for (int i = 0;; i = 1)
      {
        this.d = i;
        break;
      }
      this.d = 0;
      break;
      if ((k == 1) || (k == 3)) {
        FrameHelperActivity.c(true);
      }
    }
    label236:
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    label85:
    int k;
    switch (j)
    {
    default: 
    case 0: 
    case 2: 
      while (j == 0)
      {
        FrameHelperActivity.c(false);
        return true;
        if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
          this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
        }
        this.jdField_a_of_type_Float = f;
        this.d = 1;
        continue;
        if (this.d == 1)
        {
          k = (int)(this.jdField_a_of_type_Float - f);
          this.jdField_a_of_type_Float = f;
          i = getScrollX();
          if (k < 0)
          {
            if (i > 0) {
              scrollBy(Math.max(-i, k), 0);
            } else if (i > -getWidth()) {
              scrollBy(k, 0);
            }
          }
          else if (k > 0)
          {
            int m = getChildCount();
            if (m <= 0) {
              break label376;
            }
            paramMotionEvent = getChildAt(m - 1);
            if (paramMotionEvent == null) {
              break label376;
            }
          }
        }
      }
    }
    label319:
    label376:
    for (int i = paramMotionEvent.getRight() - i; i > 0; i = 0)
    {
      scrollBy(Math.min(i, k), 0);
      break;
      if (this.d == 1)
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        i = (int)paramMotionEvent.getXVelocity();
        if ((i <= 500) || (this.jdField_a_of_type_Int <= -1)) {
          break label319;
        }
        a(this.jdField_a_of_type_Int - 1);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        this.d = 0;
        break;
        if ((i < -500) && (this.jdField_a_of_type_Int < getChildCount())) {
          a(this.jdField_a_of_type_Int + 1);
        } else {
          a();
        }
      }
      if ((j != 1) && (j != 3)) {
        break label85;
      }
      FrameHelperActivity.c(true);
      break label85;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i = indexOfChild(paramView);
    if ((i != this.jdField_a_of_type_Int) || (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()))
    {
      a(i);
      return true;
    }
    return false;
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScreenChangeListener(bcsv parambcsv)
  {
    this.jdField_a_of_type_Bcsv = parambcsv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */