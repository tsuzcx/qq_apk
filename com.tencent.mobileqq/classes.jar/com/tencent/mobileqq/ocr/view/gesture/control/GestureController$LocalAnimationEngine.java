package com.tencent.mobileqq.ocr.view.gesture.control;

import android.view.View;
import android.widget.OverScroller;
import axpk;
import axpy;
import com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine;

class GestureController$LocalAnimationEngine
  extends AnimationEngine
{
  GestureController$LocalAnimationEngine(GestureController paramGestureController, View paramView)
  {
    super(paramView);
  }
  
  public boolean a()
  {
    boolean bool3 = true;
    boolean bool1;
    if (this.this$0.c())
    {
      int i = GestureController.a(this.this$0).getCurrX();
      int j = GestureController.a(this.this$0).getCurrY();
      if (GestureController.a(this.this$0).computeScrollOffset())
      {
        int k = GestureController.a(this.this$0).getCurrX();
        int m = GestureController.a(this.this$0).getCurrY();
        if (!this.this$0.a(k - i, m - j)) {
          this.this$0.d();
        }
        bool1 = true;
        bool2 = bool1;
        if (!this.this$0.c()) {
          this.this$0.b(false);
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      float f;
      if (this.this$0.b())
      {
        GestureController.a(this.this$0).a();
        f = GestureController.a(this.this$0).a();
        if ((Float.isNaN(this.this$0.jdField_a_of_type_Float)) || (Float.isNaN(this.this$0.jdField_b_of_type_Float)) || (Float.isNaN(GestureController.a(this.this$0))) || (Float.isNaN(GestureController.b(this.this$0))))
        {
          axpy.a(this.this$0.c, this.this$0.jdField_a_of_type_Axpv, this.this$0.jdField_b_of_type_Axpv, f);
          bool1 = bool3;
          if (!this.this$0.b()) {
            this.this$0.a(false);
          }
        }
      }
      for (bool1 = bool3;; bool1 = bool2)
      {
        if (bool1) {
          this.this$0.f();
        }
        return bool1;
        axpy.a(this.this$0.c, this.this$0.jdField_a_of_type_Axpv, this.this$0.jdField_a_of_type_Float, this.this$0.jdField_b_of_type_Float, this.this$0.jdField_b_of_type_Axpv, GestureController.a(this.this$0), GestureController.b(this.this$0), f);
        break;
      }
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController.LocalAnimationEngine
 * JD-Core Version:    0.7.0.1
 */