package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class OverScrollRecyclerView$OverScrollingState
  implements OverScrollRecyclerView.IDecoratorState
{
  protected float a;
  protected int a;
  protected final OverScrollRecyclerView.MotionAttributes a;
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  protected float b;
  
  public OverScrollRecyclerView$OverScrollingState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager = paramOverScrollStateManager;
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes = new OverScrollRecyclerView.MotionAttributes();
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStartAttributes.jdField_a_of_type_Boolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStartAttributes;
    if (localOverScrollStartAttributes.jdField_a_of_type_Int != paramMotionEvent.getPointerId(0))
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager;
      paramMotionEvent.a(paramMotionEvent.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$BounceBackState);
      return true;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.a();
    OverScrollRecyclerView.IOverScrollDecor localIOverScrollDecor = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$IOverScrollDecor;
    if (!localIOverScrollDecor.a(localView, this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes, paramMotionEvent)) {
      return true;
    }
    float f2 = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes.b;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean == localOverScrollStartAttributes.jdField_a_of_type_Boolean) {
      f1 = this.jdField_a_of_type_Float;
    } else {
      f1 = this.b;
    }
    float f1 = f2 / f1;
    f2 = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Float + f1;
    if (((localOverScrollStartAttributes.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean) && (f2 <= localOverScrollStartAttributes.jdField_a_of_type_Float)) || ((!localOverScrollStartAttributes.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$MotionAttributes.jdField_a_of_type_Boolean) && (f2 >= localOverScrollStartAttributes.jdField_a_of_type_Float)))
    {
      localIOverScrollDecor.a(localView, localOverScrollStartAttributes.jdField_a_of_type_Float, paramMotionEvent);
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager;
      paramMotionEvent.a(paramMotionEvent.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$IdleState);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_Float = (f1 / (float)l);
    }
    localIOverScrollDecor.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager;
    paramMotionEvent.a(paramMotionEvent.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$BounceBackState);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.OverScrollingState
 * JD-Core Version:    0.7.0.1
 */