package com.tencent.mobileqq.popanim.state;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import mqq.app.MobileQQ;

public class BaseState
{
  protected Context a;
  protected ViewGroup a;
  protected StateContext a;
  
  protected BaseState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    this.jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext = paramStateContext;
  }
  
  public void a(BaseState paramBaseState) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void b(BaseState paramBaseState) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.BaseState
 * JD-Core Version:    0.7.0.1
 */