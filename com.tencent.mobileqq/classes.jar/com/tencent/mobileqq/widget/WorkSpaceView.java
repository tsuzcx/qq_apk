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
import com.tencent.mobileqq.app.FrameHelperActivity;

public class WorkSpaceView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = this.jdField_b_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new WorkSpaceView.1(this);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
  private WorkSpaceView.OnScreenChangeListener jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
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
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 1;
    if (!bool)
    {
      a(paramInt, true);
      return;
    }
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    int j = Math.max(-1, Math.min(paramInt, getChildCount()));
    if (j != this.jdField_a_of_type_Int) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    this.jdField_c_of_type_Int = j;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.jdField_a_of_type_Int))) {
      ((View)localObject).clearFocus();
    }
    paramInt = getWidth();
    i = getScrollX();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt * j - i, 0, 400);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener;
    if (localObject != null) {
      ((WorkSpaceView.OnScreenChangeListener)localObject).a(j);
    }
    invalidate();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      return;
    }
    int i = Math.min(paramInt, getChildCount() - 1);
    paramInt = 0;
    i = Math.max(0, i);
    if (i != this.jdField_a_of_type_Int) {
      paramInt = 1;
    }
    this.jdField_c_of_type_Int = i;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.jdField_a_of_type_Int))) {
      ((View)localObject).clearFocus();
    }
    paramInt = getWidth();
    int j = getScrollX();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt * i - j, 0, 400);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener;
    if (localObject != null) {
      ((WorkSpaceView.OnScreenChangeListener)localObject).a(i);
    }
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      return;
    }
    int i = this.jdField_c_of_type_Int;
    if (i != -2)
    {
      if (i == -1)
      {
        this.jdField_a_of_type_Int = (getChildCount() - 1);
        scrollTo(this.jdField_a_of_type_Int * getWidth(), getScrollY());
      }
      else if (i == getChildCount())
      {
        this.jdField_a_of_type_Int = 0;
        scrollTo(0, getScrollY());
      }
      else
      {
        this.jdField_a_of_type_Int = Math.max(0, Math.min(this.jdField_c_of_type_Int, getChildCount() - 1));
      }
      this.jdField_c_of_type_Int = -2;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = this.d;
    int k = 0;
    int j = 0;
    int n = 1;
    if ((i != 1) && (this.jdField_c_of_type_Int == -2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((paramCanvas != null) && (getChildAt(this.jdField_a_of_type_Int) != null)) {
        drawChild(paramCanvas, getChildAt(this.jdField_a_of_type_Int), getDrawingTime());
      }
    }
    else
    {
      long l = getDrawingTime();
      int i2 = getWidth();
      float f = getScrollX() / i2;
      boolean bool = this.jdField_a_of_type_Boolean;
      int i3 = getChildCount();
      if ((f < 0.0F) && (bool))
      {
        k = i3 - 1;
        i = j;
        j = k;
      }
      else
      {
        j = Math.min((int)f, i3 - 1);
        int i1 = j + 1;
        if (bool)
        {
          i = k;
          m = n;
          k = j;
          if (i3 == 0) {
            break label199;
          }
          i = i1 % i3;
          m = n;
          k = j;
          break label199;
        }
        i = i1;
      }
      int m = 0;
      k = j;
      label199:
      if (a(k)) {
        if ((i == 0) && (m == 0))
        {
          j = i3 * i2;
          paramCanvas.translate(-j, 0.0F);
          drawChild(paramCanvas, getChildAt(k), l);
          paramCanvas.translate(j, 0.0F);
        }
        else
        {
          drawChild(paramCanvas, getChildAt(k), l);
        }
      }
      if ((f != k) && (a(i)))
      {
        if ((bool) && (i == 0) && (m != 0))
        {
          j = i3 * i2;
          paramCanvas.translate(j, 0.0F);
          drawChild(paramCanvas, getChildAt(i), l);
          paramCanvas.translate(-j, 0.0F);
          return;
        }
        drawChild(paramCanvas, getChildAt(i), l);
      }
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
    boolean bool = false;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2)
        {
          int i = (int)Math.abs(f1 - this.jdField_a_of_type_Float);
          int j = (int)Math.abs(f2 - this.jdField_b_of_type_Float);
          int m = this.e;
          if (i > m) {
            i = 1;
          } else {
            i = 0;
          }
          if (j > m) {
            j = 1;
          } else {
            j = 0;
          }
          if ((i == 0) && (j == 0)) {
            this.d = 0;
          } else {
            this.d = 1;
          }
        }
      }
      else {
        this.d = 0;
      }
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_b_of_type_Boolean = true;
      this.d = (this.jdField_a_of_type_AndroidWidgetScroller.isFinished() ^ true);
    }
    if (k == 0) {
      FrameHelperActivity.b(false);
    } else if ((k == 1) || (k == 3)) {
      FrameHelperActivity.b(true);
    }
    if (this.d != 0) {
      bool = true;
    }
    return bool;
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
        paramInt3 = getMeasuredWidth() + paramInt2;
        localView.layout(paramInt2, 0, paramInt3, getMeasuredHeight());
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
    if (j != 0)
    {
      int k;
      int i;
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3) {
            break label341;
          }
        }
        else
        {
          if (this.d != 1) {
            break label341;
          }
          k = (int)(this.jdField_a_of_type_Float - f);
          this.jdField_a_of_type_Float = f;
          i = getScrollX();
          if (k < 0)
          {
            if (i > 0)
            {
              scrollBy(Math.max(-i, k), 0);
              break label341;
            }
            if (i <= -getWidth()) {
              break label341;
            }
            scrollBy(k, 0);
            break label341;
          }
          if (k <= 0) {
            break label341;
          }
          int m = getChildCount();
          if (m > 0)
          {
            paramMotionEvent = getChildAt(m - 1);
            if (paramMotionEvent != null)
            {
              i = paramMotionEvent.getRight() - i;
              break label179;
            }
          }
          i = 0;
          label179:
          if (i <= 0) {
            break label341;
          }
          scrollBy(Math.min(i, k), 0);
          break label341;
        }
      }
      if (this.d == 1)
      {
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        i = (int)paramMotionEvent.getXVelocity();
        if (i > 500)
        {
          k = this.jdField_a_of_type_Int;
          if (k > -1)
          {
            a(k - 1);
            break label288;
          }
        }
        if ((i < -500) && (this.jdField_a_of_type_Int < getChildCount())) {
          a(this.jdField_a_of_type_Int + 1);
        } else {
          a();
        }
        label288:
        paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
      }
      this.d = 0;
    }
    else
    {
      if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
        this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      }
      this.jdField_a_of_type_Float = f;
      this.d = 1;
    }
    label341:
    if (j == 0)
    {
      FrameHelperActivity.b(false);
      return true;
    }
    if ((j == 1) || (j == 3)) {
      FrameHelperActivity.b(true);
    }
    return true;
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
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_AndroidWidgetScroller.isFinished())) {
      return false;
    }
    a(i);
    return true;
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView$OnScreenChangeListener = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */