package com.tencent.mobileqq.widget;

import android.graphics.Color;
import android.view.View;

class ScrollerRunnable$3
  implements Runnable
{
  ScrollerRunnable$3(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void run()
  {
    if (ScrollerRunnable.a(this.this$0) != null) {
      ScrollerRunnable.a(this.this$0).setBackgroundColor(0);
    }
    this.a.setBackgroundColor(Color.parseColor("#7FFFFFFF"));
    ScrollerRunnable.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.3
 * JD-Core Version:    0.7.0.1
 */