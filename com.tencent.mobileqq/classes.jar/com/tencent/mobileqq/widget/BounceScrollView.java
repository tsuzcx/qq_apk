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
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$DrawFinishedListener;
    if (paramCanvas != null) {
      paramCanvas.a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor;
    boolean bool2 = false;
    if (localObject != null)
    {
      localObject = MotionEvent.obtain(paramMotionEvent);
      if (localObject != null)
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor.a(this, (MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
        break label48;
      }
    }
    boolean bool1 = false;
    label48:
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener;
      if (localObject != null) {
        ((BounceScrollView.OnScrollChangedListener)localObject).a(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener;
      if (localObject != null) {
        ((ScrollListener)localObject).onFingerUpOrCancel(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    else if (i == 3)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener;
      if (localObject != null) {
        ((ScrollListener)localObject).onFingerUpOrCancel(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
    else if (i == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener;
      if (localObject != null) {
        ((ScrollListener)localObject).onFingerDown(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
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
    catch (Exception paramMotionEvent) {}
    return bool1;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
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
    ScrollListener localScrollListener = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener;
    if (localScrollListener != null) {
      localScrollListener.fling(this, paramInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    OnInterceptTouchEventListener localOnInterceptTouchEventListener = this.jdField_a_of_type_ComTencentMobileqqWidgetOnInterceptTouchEventListener;
    if (localOnInterceptTouchEventListener != null) {
      localOnInterceptTouchEventListener.onInterceptTouchEvent(paramMotionEvent);
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
    catch (Exception paramMotionEvent)
    {
      label47:
      break label47;
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_Int;
    if (i > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener;
    if (localObject != null) {
      ((BounceScrollView.OnScrollChangedListener)localObject).a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener;
    if (localObject != null) {
      ((ScrollListener)localObject).onScrollChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_d_of_type_Boolean) {
      getChildAt(0).invalidate();
    }
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    OnSizeChangeListener localOnSizeChangeListener = this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener;
    if (localOnSizeChangeListener != null) {
      localOnSizeChangeListener.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4, false, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() & 0xFF) == 2) && (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int < 0) && (this.jdField_c_of_type_Int > 0))
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        int i = getScrollY();
        if (i < this.jdField_b_of_type_Int) {
          return true;
        }
        int j = localView.getMeasuredHeight();
        int k = getHeight();
        if ((i > 0) && (k > 0) && (j > 0) && (j + this.jdField_c_of_type_Int <= i + k)) {
          return true;
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView
 * JD-Core Version:    0.7.0.1
 */