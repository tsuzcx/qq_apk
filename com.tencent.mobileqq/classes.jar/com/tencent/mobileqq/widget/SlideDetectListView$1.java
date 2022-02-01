package com.tencent.mobileqq.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class SlideDetectListView$1
  extends GestureDetector.SimpleOnGestureListener
{
  SlideDetectListView$1(SlideDetectListView paramSlideDetectListView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.jdField_c_of_type_Boolean) {
      return false;
    }
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) && ((this.a.jdField_c_of_type_Int == 0) || (this.a.d)) && (!this.a.jdField_a_of_type_Boolean) && (Math.abs(paramFloat1) > this.a.f))
    {
      paramMotionEvent1 = this.a;
      paramMotionEvent1.jdField_b_of_type_Int = paramMotionEvent1.a(paramMotionEvent1.jdField_a_of_type_Int);
      paramMotionEvent1 = this.a;
      paramMotionEvent1.jdField_a_of_type_AndroidViewView = paramMotionEvent1.a(paramMotionEvent1.jdField_b_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        paramMotionEvent1 = this.a;
        paramMotionEvent1.jdField_a_of_type_Boolean = true;
        paramMotionEvent1.setPressed(false);
        this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
        if (SlideDetectListView.a(this.a) != null)
        {
          int i = this.a.jdField_b_of_type_Int;
          int j = this.a.getHeaderViewsCount();
          paramMotionEvent1 = SlideDetectListView.a(this.a);
          paramMotionEvent2 = this.a;
          paramMotionEvent1.a(paramMotionEvent2, paramMotionEvent2.jdField_a_of_type_AndroidViewView, i - j);
        }
        this.a.jdField_a_of_type_Int = 0;
        return true;
      }
      this.a.jdField_b_of_type_Boolean = true;
      return true;
    }
    if (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) {
      this.a.jdField_b_of_type_Boolean = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView.1
 * JD-Core Version:    0.7.0.1
 */