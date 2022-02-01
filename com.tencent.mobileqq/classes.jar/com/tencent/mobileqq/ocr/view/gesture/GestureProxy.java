package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import com.tencent.mobileqq.ocr.view.gesture.control.OnGestureListener;
import com.tencent.mobileqq.ocr.view.gesture.state.State;
import com.tencent.mobileqq.ocr.view.gesture.state.StateController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public Settings a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  }
  
  public OnGestureListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureControlOnGestureListener;
  }
  
  public State a()
  {
    return this.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateStateController.a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateStateController.a(this.d);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateStateController.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateState);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateStateController.a(this.b);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateStateController.b(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public void a(GestureProxy.OnStateChangeListener paramOnStateChangeListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnStateChangeListener);
  }
  
  public void a(OnGestureListener paramOnGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureControlOnGestureListener = paramOnGestureListener;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateStateController.a(this.c))
    {
      g();
      return;
    }
    f();
  }
  
  public boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    return super.b(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureProxy
 * JD-Core Version:    0.7.0.1
 */