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
  int a = this.c;
  boolean b = true;
  private int c = 0;
  private int d = -2;
  private float e;
  private float f;
  private Scroller g = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
  private int h = 0;
  private VelocityTracker i;
  private WorkSpaceView.OnScreenChangeListener j;
  private int k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean l;
  private Handler m = new WorkSpaceView.1(this);
  private boolean n = true;
  
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
    int i1 = getWidth();
    a((getScrollX() + i1 / 2) / i1);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getChildCount());
  }
  
  public void a(int paramInt)
  {
    boolean bool = this.b;
    int i1 = 1;
    if (!bool)
    {
      a(paramInt, true);
      return;
    }
    if (!this.g.isFinished()) {
      return;
    }
    int i2 = Math.max(-1, Math.min(paramInt, getChildCount()));
    if (i2 != this.a) {
      paramInt = i1;
    } else {
      paramInt = 0;
    }
    this.d = i2;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.a))) {
      ((View)localObject).clearFocus();
    }
    paramInt = getWidth();
    i1 = getScrollX();
    this.g.startScroll(getScrollX(), 0, paramInt * i2 - i1, 0, 400);
    localObject = this.j;
    if (localObject != null) {
      ((WorkSpaceView.OnScreenChangeListener)localObject).a(i2);
    }
    invalidate();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!this.g.isFinished()) {
      return;
    }
    int i1 = Math.min(paramInt, getChildCount() - 1);
    paramInt = 0;
    i1 = Math.max(0, i1);
    if (i1 != this.a) {
      paramInt = 1;
    }
    this.d = i1;
    Object localObject = getFocusedChild();
    if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.a))) {
      ((View)localObject).clearFocus();
    }
    paramInt = getWidth();
    int i2 = getScrollX();
    this.g.startScroll(getScrollX(), 0, paramInt * i1 - i2, 0, 400);
    localObject = this.j;
    if (localObject != null) {
      ((WorkSpaceView.OnScreenChangeListener)localObject).a(i1);
    }
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.g.computeScrollOffset())
    {
      scrollTo(this.g.getCurrX(), this.g.getCurrY());
      postInvalidate();
      return;
    }
    int i1 = this.d;
    if (i1 != -2)
    {
      if (i1 == -1)
      {
        this.a = (getChildCount() - 1);
        scrollTo(this.a * getWidth(), getScrollY());
      }
      else if (i1 == getChildCount())
      {
        this.a = 0;
        scrollTo(0, getScrollY());
      }
      else
      {
        this.a = Math.max(0, Math.min(this.d, getChildCount() - 1));
      }
      this.d = -2;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i1 = this.h;
    int i3 = 0;
    int i2 = 0;
    int i5 = 1;
    if ((i1 != 1) && (this.d == -2)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if ((paramCanvas != null) && (getChildAt(this.a) != null)) {
        drawChild(paramCanvas, getChildAt(this.a), getDrawingTime());
      }
    }
    else
    {
      long l1 = getDrawingTime();
      int i7 = getWidth();
      float f1 = getScrollX() / i7;
      boolean bool = this.b;
      int i8 = getChildCount();
      if ((f1 < 0.0F) && (bool))
      {
        i3 = i8 - 1;
        i1 = i2;
        i2 = i3;
      }
      else
      {
        i2 = Math.min((int)f1, i8 - 1);
        int i6 = i2 + 1;
        if (bool)
        {
          i1 = i3;
          i4 = i5;
          i3 = i2;
          if (i8 == 0) {
            break label199;
          }
          i1 = i6 % i8;
          i4 = i5;
          i3 = i2;
          break label199;
        }
        i1 = i6;
      }
      int i4 = 0;
      i3 = i2;
      label199:
      if (b(i3)) {
        if ((i1 == 0) && (i4 == 0))
        {
          i2 = i8 * i7;
          paramCanvas.translate(-i2, 0.0F);
          drawChild(paramCanvas, getChildAt(i3), l1);
          paramCanvas.translate(i2, 0.0F);
        }
        else
        {
          drawChild(paramCanvas, getChildAt(i3), l1);
        }
      }
      if ((f1 != i3) && (b(i1)))
      {
        if ((bool) && (i1 == 0) && (i4 != 0))
        {
          i2 = i8 * i7;
          paramCanvas.translate(i2, 0.0F);
          drawChild(paramCanvas, getChildAt(i1), l1);
          paramCanvas.translate(-i2, 0.0F);
          return;
        }
        drawChild(paramCanvas, getChildAt(i1), l1);
      }
    }
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (getCurrentScreen() > 0)
      {
        a(getCurrentScreen() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (getCurrentScreen() < getChildCount() - 1))
    {
      a(getCurrentScreen() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool = false;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 == 2)
        {
          int i1 = (int)Math.abs(f1 - this.e);
          int i2 = (int)Math.abs(f2 - this.f);
          int i4 = this.k;
          if (i1 > i4) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (i2 > i4) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if ((i1 == 0) && (i2 == 0)) {
            this.h = 0;
          } else {
            this.h = 1;
          }
        }
      }
      else {
        this.h = 0;
      }
    }
    else
    {
      this.e = f1;
      this.f = f2;
      this.l = true;
      this.h = (this.g.isFinished() ^ true);
    }
    if (i3 == 0) {
      FrameHelperActivity.c(false);
    } else if ((i3 == 1) || (i3 == 3)) {
      FrameHelperActivity.c(true);
    }
    if (this.h != 0) {
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
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).measure(paramInt1, paramInt2);
      i1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.n) {
      return false;
    }
    if (this.i == null) {
      this.i = VelocityTracker.obtain();
    }
    this.i.addMovement(paramMotionEvent);
    int i2 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    if (i2 != 0)
    {
      int i3;
      int i1;
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label341;
          }
        }
        else
        {
          if (this.h != 1) {
            break label341;
          }
          i3 = (int)(this.e - f1);
          this.e = f1;
          i1 = getScrollX();
          if (i3 < 0)
          {
            if (i1 > 0)
            {
              scrollBy(Math.max(-i1, i3), 0);
              break label341;
            }
            if (i1 <= -getWidth()) {
              break label341;
            }
            scrollBy(i3, 0);
            break label341;
          }
          if (i3 <= 0) {
            break label341;
          }
          int i4 = getChildCount();
          if (i4 > 0)
          {
            paramMotionEvent = getChildAt(i4 - 1);
            if (paramMotionEvent != null)
            {
              i1 = paramMotionEvent.getRight() - i1;
              break label179;
            }
          }
          i1 = 0;
          label179:
          if (i1 <= 0) {
            break label341;
          }
          scrollBy(Math.min(i1, i3), 0);
          break label341;
        }
      }
      if (this.h == 1)
      {
        paramMotionEvent = this.i;
        paramMotionEvent.computeCurrentVelocity(1000);
        i1 = (int)paramMotionEvent.getXVelocity();
        if (i1 > 500)
        {
          i3 = this.a;
          if (i3 > -1)
          {
            a(i3 - 1);
            break label288;
          }
        }
        if ((i1 < -500) && (this.a < getChildCount())) {
          a(this.a + 1);
        } else {
          a();
        }
        label288:
        paramMotionEvent = this.i;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.recycle();
          this.i = null;
        }
      }
      this.h = 0;
    }
    else
    {
      if (!this.g.isFinished()) {
        this.g.abortAnimation();
      }
      this.e = f1;
      this.h = 1;
    }
    label341:
    if (i2 == 0)
    {
      FrameHelperActivity.c(false);
      return true;
    }
    if ((i2 == 1) || (i2 == 3)) {
      FrameHelperActivity.c(true);
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
    int i1 = indexOfChild(paramView);
    if ((i1 == this.a) && (this.g.isFinished())) {
      return false;
    }
    a(i1);
    return true;
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setOnScreenChangeListener(WorkSpaceView.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.j = paramOnScreenChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */