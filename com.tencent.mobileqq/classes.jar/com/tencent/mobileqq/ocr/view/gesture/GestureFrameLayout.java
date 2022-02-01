package com.tencent.mobileqq.ocr.view.gesture;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.control.OnGestureListener;
import com.tencent.mobileqq.ocr.view.gesture.state.State;

public class GestureFrameLayout
  extends FrameLayout
  implements GestureView
{
  private final GestureProxy a = new GestureProxy(this);
  private final Matrix b = new Matrix();
  private final Matrix c = new Matrix();
  private final Matrix d = new Matrix();
  private final Matrix e = new Matrix();
  private final RectF f = new RectF();
  private final float[] g = new float[2];
  private MotionEvent h;
  private View i;
  
  public GestureFrameLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public GestureFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.b().a(paramContext, paramAttributeSet);
    this.a.a(new GestureFrameLayout.1(this));
  }
  
  protected static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == -2) {
      return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
    }
    return getChildMeasureSpec(paramInt1, paramInt2, paramInt3);
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    this.g[0] = paramMotionEvent.getX();
    this.g[1] = paramMotionEvent.getY();
    paramMatrix.mapPoints(this.g);
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMatrix = this.g;
    paramMotionEvent.setLocation(paramMatrix[0], paramMatrix[1]);
    return paramMotionEvent;
  }
  
  private void a(Rect paramRect, Matrix paramMatrix)
  {
    this.f.set(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramMatrix.mapRect(this.f);
    paramRect.set(Math.round(this.f.left), Math.round(this.f.top), Math.round(this.f.right), Math.round(this.f.bottom));
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    int k = paramViewGroup.getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = paramViewGroup.getChildAt(j);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView);
      } else {
        localView.invalidate();
      }
      j += 1;
    }
  }
  
  @TargetApi(16)
  protected void a(State paramState)
  {
    if (isHardwareAccelerated())
    {
      View localView = this.i;
      if (localView != null)
      {
        localView.setPivotX(0.0F);
        this.i.setPivotY(0.0F);
        this.i.setScaleX(paramState.d());
        this.i.setScaleY(paramState.d());
        this.i.setTranslationX(paramState.b());
        this.i.setTranslationY(paramState.c());
        this.d.set(paramState.a());
        this.d.invert(this.e);
        if (getGestureProxy().a() == null) {
          return;
        }
        getGestureProxy().a().a(this.e);
        return;
      }
    }
    this.b.set(paramState.a());
    this.b.invert(this.c);
    if (getGestureProxy().a() != null) {
      getGestureProxy().a().a(this.c);
    }
    invalidate();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() == 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalArgumentException("GestureFrameLayout can contain only one child");
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.b);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.h = paramMotionEvent;
    paramMotionEvent = a(paramMotionEvent, this.c);
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      paramMotionEvent.recycle();
    }
  }
  
  public GestureProxy getGestureProxy()
  {
    return this.a;
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    a(paramRect, this.b);
    return super.invalidateChildInParent(paramArrayOfInt, paramRect);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = localMarginLayoutParams.leftMargin;
    int n = localMarginLayoutParams.rightMargin;
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    int i3 = localMarginLayoutParams.topMargin;
    int i4 = localMarginLayoutParams.bottomMargin;
    paramView.measure(a(paramInt1, j + k + m + n + paramInt2, localMarginLayoutParams.width), a(paramInt3, i1 + i2 + i3 + i4 + paramInt4, localMarginLayoutParams.height));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.a(this, this.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView;
    if (getChildCount() == 0) {
      localView = null;
    } else {
      localView = getChildAt(0);
    }
    this.i = localView;
    if (this.i != null)
    {
      this.a.b().b(this.i.getMeasuredWidth(), this.i.getMeasuredHeight());
      this.a.d();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.b().a(paramInt1 - getPaddingLeft() - getPaddingRight(), paramInt2 - getPaddingTop() - getPaddingBottom());
    this.a.d();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.b(this, this.h);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(this.h);
      localMotionEvent.setAction(3);
      this.a.a(this, localMotionEvent);
      localMotionEvent.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout
 * JD-Core Version:    0.7.0.1
 */