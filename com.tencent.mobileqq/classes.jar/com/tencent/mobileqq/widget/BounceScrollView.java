package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ScrollView;

public class BounceScrollView
  extends ScrollView
{
  private static boolean jdField_c_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new BounceScrollView.1(this));
  private BounceScrollView.DrawFinishedListener jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$DrawFinishedListener;
  private BounceScrollView.MotionEventInterceptor jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor;
  protected BounceScrollView.OnScrollChangedListener a;
  private OnInterceptTouchEventListener jdField_a_of_type_ComTencentMobileqqWidgetOnInterceptTouchEventListener;
  ScrollListener jdField_a_of_type_ComTencentMobileqqWidgetScrollListener = null;
  OnSizeChangeListener jdField_a_of_type_ComTencentWidgetOnSizeChangeListener;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 1.0F };
  private int[] jdField_a_of_type_ArrayOfInt = { -654311425, -654311425 };
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int e;
  
  public BounceScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(9)
  public BounceScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOverScrollMode(0);
    setFadingEdgeLength(0);
  }
  
  private void a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_Float, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
      this.jdField_d_of_type_Int = getWidth();
      this.e = getHeight();
    }
  }
  
  public static void setEnableTalkBack(boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void computeScroll()
  {
    super.computeScroll();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$DrawFinishedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$DrawFinishedListener.a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor != null)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (localMotionEvent != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor.a(this, localMotionEvent);
        localMotionEvent.recycle();
      }
    }
    for (;;)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener.a(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.onFingerUpOrCancel(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      for (;;)
      {
        if (!bool1) {}
        try
        {
          boolean bool3 = super.dispatchTouchEvent(paramMotionEvent);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
          return bool1;
        }
        catch (Exception paramMotionEvent)
        {
          return bool1;
        }
        if (i == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.onFingerUpOrCancel(this, paramMotionEvent.getX(), paramMotionEvent.getY());
          }
        }
        else if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.onFingerDown(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      bool1 = false;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return super.drawChild(paramCanvas, paramView, paramLong);
    }
    int i = paramCanvas.saveLayer(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    int j = paramCanvas.save();
    paramCanvas.drawRect(0.0F, this.e + getScrollY() - this.jdField_a_of_type_Float, this.jdField_d_of_type_Int, this.e + getScrollY(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.fling(this, paramInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOnInterceptTouchEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetOnInterceptTouchEventListener.a(paramMotionEvent);
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        super.onInterceptTouchEvent(paramMotionEvent);
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.onScrollChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_d_of_type_Boolean) {
      getChildAt(0).invalidate();
    }
    invalidate();
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    if (this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4, false, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    int i;
    int j;
    int k;
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      View localView;
      do
      {
        return bool;
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Int >= 0) || (this.jdField_c_of_type_Int <= 0)) {
          break;
        }
        localView = getChildAt(0);
        if (localView == null) {
          break;
        }
        i = getScrollY();
      } while (i < this.jdField_b_of_type_Int);
      j = localView.getMeasuredHeight();
      k = getHeight();
    } while ((i <= 0) || (k <= 0) || (j <= 0) || (j + this.jdField_c_of_type_Int > i + k));
    return true;
  }
  
  public void setDrawFinishedListener(BounceScrollView.DrawFinishedListener paramDrawFinishedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$DrawFinishedListener = paramDrawFinishedListener;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMotionEventInterceptor(BounceScrollView.MotionEventInterceptor paramMotionEventInterceptor)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor = paramMotionEventInterceptor;
  }
  
  public void setNeedHorizontalGesture(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOnInterceptTouchEventListener = paramOnInterceptTouchEventListener;
  }
  
  public void setOnScrollChangedListener(BounceScrollView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
  
  public void setOnSizeChangeListener(OnSizeChangeListener paramOnSizeChangeListener)
  {
    this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener = paramOnSizeChangeListener;
  }
  
  public void setScrollListener(ScrollListener paramScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener = paramScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView
 * JD-Core Version:    0.7.0.1
 */