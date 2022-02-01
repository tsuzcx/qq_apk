package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class CustomedTabWidget$2
  implements View.OnTouchListener
{
  CustomedTabWidget$2(CustomedTabWidget paramCustomedTabWidget) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = 0;
      while (i < this.a.getChildCount())
      {
        if (this.a.getChildAt(i) == paramView)
        {
          paramView = this.a;
          paramView.jdField_a_of_type_Int = i;
          paramView.jdField_a_of_type_Boolean = true;
          paramView.invalidate();
          return false;
        }
        i += 1;
      }
    }
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = this.a;
      paramView.jdField_a_of_type_Boolean = false;
      paramView.invalidate();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget.2
 * JD-Core Version:    0.7.0.1
 */