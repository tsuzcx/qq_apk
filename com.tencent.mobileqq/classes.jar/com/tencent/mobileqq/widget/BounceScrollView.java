package com.tencent.mobileqq.widget;

import alal;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ScrollView;

public class BounceScrollView
  extends ScrollView
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new alal(this));
  private BounceScrollView.DrawFinishedListener jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$DrawFinishedListener;
  private BounceScrollView.MotionEventInterceptor jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$MotionEventInterceptor;
  protected BounceScrollView.OnScrollChangedListener a;
  ScrollListener jdField_a_of_type_ComTencentMobileqqWidgetScrollListener = null;
  OnSizeChangeListener jdField_a_of_type_ComTencentWidgetOnSizeChangeListener;
  private boolean jdField_a_of_type_Boolean;
  
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
    if (AppSetting.b) {
      AccessibilityUtil.a(this, false);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
          }
        }
        else if ((i == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.b(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      bool1 = false;
    }
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramInt);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).a(true);
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
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollListener.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOnSizeChangeListener.a(paramInt1, paramInt2, paramInt3, paramInt4, false, 0);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BounceScrollView
 * JD-Core Version:    0.7.0.1
 */