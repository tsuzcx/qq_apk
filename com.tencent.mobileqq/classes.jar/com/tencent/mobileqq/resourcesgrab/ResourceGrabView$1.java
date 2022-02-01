package com.tencent.mobileqq.resourcesgrab;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class ResourceGrabView$1
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 0;
  float b = 0.0F;
  
  ResourceGrabView$1(ResourceGrabView paramResourceGrabView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView, System.currentTimeMillis());
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView).y;
      continue;
      float f1 = paramMotionEvent.getY();
      paramView = ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView);
      float f2 = paramView.y;
      paramView.y = ((int)((f1 - this.b) / 3.0F + f2));
      ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView).updateViewLayout(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView, ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView));
      continue;
      int i = ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView).y;
      int j = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      if ((Math.abs(i - this.jdField_a_of_type_Int) <= j) && (System.currentTimeMillis() - ResourceGrabView.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView) >= 500L)) {
        this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabView.1
 * JD-Core Version:    0.7.0.1
 */