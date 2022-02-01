package com.tencent.widget;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

class PullToZoomListView$ScalingRunnalable
  implements Runnable
{
  long a;
  boolean b = true;
  float c;
  long d;
  
  PullToZoomListView$ScalingRunnalable(PullToZoomListView paramPullToZoomListView) {}
  
  public void a()
  {
    this.b = true;
  }
  
  public void a(long paramLong)
  {
    if (!this.this$0.a) {
      return;
    }
    this.d = SystemClock.currentThreadTimeMillis();
    this.a = paramLong;
    this.c = (this.this$0.c.getBottom() / this.this$0.e);
    this.b = false;
    this.this$0.post(this);
  }
  
  public void run()
  {
    if (this.this$0.c == null) {
      return;
    }
    if ((!this.b) && (this.c > 1.0D))
    {
      float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.d) / (float)this.a;
      float f2 = this.c;
      f1 = f2 - (f2 - 1.0F) * PullToZoomListView.a().getInterpolation(f1);
      ViewGroup.LayoutParams localLayoutParams1 = this.this$0.c.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams2 = this.this$0.d.getLayoutParams();
      if (f1 > 1.0F)
      {
        localLayoutParams1.height = this.this$0.e;
        localLayoutParams2.height = (this.this$0.e - this.this$0.f);
        localLayoutParams1.height = ((int)(f1 * this.this$0.e));
        localLayoutParams1.height -= this.this$0.f;
        this.this$0.c.setLayoutParams(localLayoutParams1);
        this.this$0.d.setLayoutParams(localLayoutParams2);
        this.this$0.post(this);
        return;
      }
      this.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PullToZoomListView.ScalingRunnalable
 * JD-Core Version:    0.7.0.1
 */