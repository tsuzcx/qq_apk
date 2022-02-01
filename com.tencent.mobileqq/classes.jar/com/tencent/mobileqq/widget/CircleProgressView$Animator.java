package com.tencent.mobileqq.widget;

import android.os.Handler;

class CircleProgressView$Animator
  implements Runnable
{
  private CircleProgressView$Animator(CircleProgressView paramCircleProgressView) {}
  
  public void run()
  {
    if (CircleProgressView.a(this.this$0)) {
      CircleProgressView.a(this.this$0, CircleProgressView.a(this.this$0) + CircleProgressView.b(this.this$0));
    }
    for (;;)
    {
      CircleProgressView.a(this.this$0, CircleProgressView.a(this.this$0) % 360);
      CircleProgressView.a(this.this$0).postDelayed(this, 16L);
      this.this$0.invalidate();
      return;
      CircleProgressView.a(this.this$0, CircleProgressView.a(this.this$0) + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressView.Animator
 * JD-Core Version:    0.7.0.1
 */