package com.tencent.widget;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

class PullToZoomListView$ScalingRunnalable
  implements Runnable
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean = true;
  long b;
  
  PullToZoomListView$ScalingRunnalable(PullToZoomListView paramPullToZoomListView) {}
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    if (!this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    this.b = SystemClock.currentThreadTimeMillis();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = (this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() / this.this$0.b);
    this.jdField_a_of_type_Boolean = false;
    this.this$0.post(this);
  }
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Float > 1.0D))
    {
      float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.b) / (float)this.jdField_a_of_type_Long;
      float f2 = this.jdField_a_of_type_Float;
      f1 = f2 - (f2 - 1.0F) * PullToZoomListView.a().getInterpolation(f1);
      ViewGroup.LayoutParams localLayoutParams1 = this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams2 = this.this$0.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (f1 > 1.0F)
      {
        localLayoutParams1.height = this.this$0.b;
        localLayoutParams2.height = (this.this$0.b - this.this$0.c);
        localLayoutParams1.height = ((int)(f1 * this.this$0.b));
        localLayoutParams1.height -= this.this$0.c;
        this.this$0.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams1);
        this.this$0.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
        this.this$0.post(this);
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PullToZoomListView.ScalingRunnalable
 * JD-Core Version:    0.7.0.1
 */