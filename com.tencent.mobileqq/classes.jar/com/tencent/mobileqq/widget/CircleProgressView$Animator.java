package com.tencent.mobileqq.widget;

import android.os.Handler;

class CircleProgressView$Animator
  implements Runnable
{
  private CircleProgressView$Animator(CircleProgressView paramCircleProgressView) {}
  
  public void run()
  {
    if (CircleProgressView.a(this.this$0))
    {
      localCircleProgressView = this.this$0;
      CircleProgressView.a(localCircleProgressView, CircleProgressView.a(localCircleProgressView) + CircleProgressView.b(this.this$0));
    }
    else
    {
      localCircleProgressView = this.this$0;
      CircleProgressView.a(localCircleProgressView, CircleProgressView.a(localCircleProgressView) + 1);
    }
    CircleProgressView localCircleProgressView = this.this$0;
    CircleProgressView.a(localCircleProgressView, CircleProgressView.a(localCircleProgressView) % 360);
    CircleProgressView.a(this.this$0).postDelayed(this, 16L);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressView.Animator
 * JD-Core Version:    0.7.0.1
 */