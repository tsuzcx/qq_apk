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
import axpg;
import axpm;
import axpv;

public class GestureFrameLayout
  extends FrameLayout
{
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private View jdField_a_of_type_AndroidViewView;
  private final GestureProxy jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy = new GestureProxy(this);
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private final Matrix b = new Matrix();
  private final Matrix c = new Matrix();
  private final Matrix d = new Matrix();
  
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
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a().a(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a(new axpg(this));
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
    this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
    this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    paramMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setLocation(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1]);
    return paramMotionEvent;
  }
  
  private void a(Rect paramRect, Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    paramMatrix.mapRect(this.jdField_a_of_type_AndroidGraphicsRectF);
    paramRect.set(Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.left), Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.top), Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.right), Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.bottom));
  }
  
  public GestureProxy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.invalidate();
      }
    }
  }
  
  @TargetApi(16)
  public void a(axpv paramaxpv)
  {
    if ((!isHardwareAccelerated()) || (this.jdField_a_of_type_AndroidViewView == null))
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramaxpv.a());
      this.jdField_a_of_type_AndroidGraphicsMatrix.invert(this.b);
      if (a().a() != null) {
        a().a().a(this.b);
      }
      invalidate();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setPivotX(0.0F);
      this.jdField_a_of_type_AndroidViewView.setPivotY(0.0F);
      this.jdField_a_of_type_AndroidViewView.setScaleX(paramaxpv.c());
      this.jdField_a_of_type_AndroidViewView.setScaleY(paramaxpv.c());
      this.jdField_a_of_type_AndroidViewView.setTranslationX(paramaxpv.a());
      this.jdField_a_of_type_AndroidViewView.setTranslationY(paramaxpv.b());
      this.c.set(paramaxpv.a());
      this.c.invert(this.d);
    } while (a().a() == null);
    a().a().a(this.d);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() != 0) {
      throw new IllegalArgumentException("GestureFrameLayout can contain only one child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
    paramMotionEvent = a(paramMotionEvent, this.b);
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
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    a(paramRect, this.jdField_a_of_type_AndroidGraphicsMatrix);
    return super.invalidateChildInParent(paramArrayOfInt, paramRect);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = localMarginLayoutParams.leftMargin;
    int m = localMarginLayoutParams.rightMargin;
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    int i2 = localMarginLayoutParams.topMargin;
    int i3 = localMarginLayoutParams.bottomMargin;
    paramView.measure(a(paramInt1, i + j + k + m + paramInt2, localMarginLayoutParams.width), a(paramInt3, n + i1 + i2 + i3 + paramInt4, localMarginLayoutParams.height));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a(this, this.jdField_a_of_type_AndroidViewMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 0) {}
    for (View localView = null;; localView = getChildAt(0))
    {
      this.jdField_a_of_type_AndroidViewView = localView;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a().b(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a();
      }
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a().a(paramInt1 - getPaddingLeft() - getPaddingRight(), paramInt2 - getPaddingTop() - getPaddingBottom());
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.b(this, this.jdField_a_of_type_AndroidViewMotionEvent);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(this.jdField_a_of_type_AndroidViewMotionEvent);
      localMotionEvent.setAction(3);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureProxy.a(this, localMotionEvent);
      localMotionEvent.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout
 * JD-Core Version:    0.7.0.1
 */