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
    if (this.this$0.h())
    {
      int i = GestureController.a(this.this$0).getCurrX();
      int j = GestureController.a(this.this$0).getCurrY();
      boolean bool1;
      if (GestureController.a(this.this$0).computeScrollOffset())
      {
        int k = GestureController.a(this.this$0).getCurrX();
        int m = GestureController.a(this.this$0).getCurrY();
        if (!this.this$0.a(k - i, m - j)) {
          this.this$0.k();
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      bool2 = bool1;
      if (!this.this$0.h())
      {
        this.this$0.b(false);
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    if (this.this$0.g())
    {
      GestureController.b(this.this$0).b();
      float f = GestureController.b(this.this$0).d();
      if ((!Float.isNaN(this.this$0.d)) && (!Float.isNaN(this.this$0.e)) && (!Float.isNaN(GestureController.c(this.this$0))) && (!Float.isNaN(GestureController.d(this.this$0)))) {
        MathUtils.a(this.this$0.j, this.this$0.f, this.this$0.d, this.this$0.e, this.this$0.g, GestureController.c(this.this$0), GestureController.d(this.this$0), f);
      } else {
        MathUtils.a(this.this$0.j, this.this$0.f, this.this$0.g, f);
      }
      if (!this.this$0.g()) {
        this.this$0.a(false);
      }
      bool2 = true;
    }
    if (bool2) {
      this.this$0.m();
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.control.GestureController.LocalAnimationEngine
 * JD-Core Version:    0.7.0.1
 */