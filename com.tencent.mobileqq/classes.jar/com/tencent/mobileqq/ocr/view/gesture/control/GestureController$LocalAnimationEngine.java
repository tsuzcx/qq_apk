package com.tencent.mobileqq.ocr.view.gesture.control;

import android.view.View;
import android.widget.OverScroller;
import com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine;
import com.tencent.mobileqq.ocr.view.gesture.animation.StateScroller;
import com.tencent.mobileqq.ocr.view.gesture.utils.MathUtils;

class GestureController$LocalAnimationEngine
  extends AnimationEngine
{
  GestureController$LocalAnimationEngine(GestureController paramGestureController, View paramView)
  {
    super(paramView);
  }
  
  public boolean a()
  {
    boolean bool2;
    if (this.this$0.c())
    {
      int i = GestureController.a(this.this$0).getCurrX();
      int j = GestureController.a(this.this$0).getCurrY();
      boolean bool1;
      if (GestureController.a(this.this$0).computeScrollOffset())
      {
        int k = GestureController.a(this.this$0).getCurrX();
        int m = GestureController.a(this.this$0).getCurrY();
        if (!this.this$0.a(k - i, m - j)) {
          this.this$0.d();
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      bool2 = bool1;
      if (!this.this$0.c())
      {
        this.this$0.b(false);
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    if (this.this$0.b())
    {
      GestureController.a(this.this$0).a();
      float f = GestureController.a(this.this$0).a();
      if ((!Float.isNaN(this.this$0.jdField_a_of_type_Float)) && (!Float.isNaN(this.this$0.jdField_b_of_type_Float)) && (!Float.isNaN(GestureController.a(this.this$0))) && (!Float.isNaN(GestureController.b(this.this$0)))) {
        MathUtils.a(this.this$0.c, this.this$0.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateState, this.this$0.jdField_a_of_type_Float, this.this$0.jdField_b_of_type_Float, this.this$0.jdField_b_of_type_ComTencentMobileqqOcrViewGestureStateState, GestureController.a(this.this$0), GestureController.b(this.this$0), f);
      } else {
        MathUtils.a(this.this$0.c, this.this$0.jdField_a_of_type_ComTencentMobileqqOcrViewGestureStateState, this.this$0.jdField_b_of_type_ComTencentMobileqqOcrViewGestureStateState, f);
      }
      if (!this.this$0.b()) {
        this.this$0.a(false);
      }
      bool2 = true;
    }
    if (bool2) {
      this.this$0.f();
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController.LocalAnimationEngine
 * JD-Core Version:    0.7.0.1
 */