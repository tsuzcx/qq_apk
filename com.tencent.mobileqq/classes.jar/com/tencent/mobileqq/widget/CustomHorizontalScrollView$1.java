package com.tencent.mobileqq.widget;

import android.os.Handler;

class CustomHorizontalScrollView$1
  implements Runnable
{
  CustomHorizontalScrollView$1(CustomHorizontalScrollView paramCustomHorizontalScrollView) {}
  
  public void run()
  {
    int i = this.this$0.getScrollX();
    if (i == this.this$0.k)
    {
      int j = i % (this.this$0.l + this.this$0.m);
      if (this.this$0.o + i >= this.this$0.n) {
        return;
      }
      if (j < this.this$0.l / 2)
      {
        this.this$0.smoothScrollBy(-j, 0);
      }
      else if (j >= this.this$0.l / 2)
      {
        int k = this.this$0.l;
        int m = this.this$0.m;
        this.this$0.smoothScrollBy(k + m - j, 0);
      }
      this.this$0.k = i;
      return;
    }
    CustomHorizontalScrollView localCustomHorizontalScrollView = this.this$0;
    localCustomHorizontalScrollView.k = i;
    localCustomHorizontalScrollView.i.postDelayed(this.this$0.p, 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomHorizontalScrollView.1
 * JD-Core Version:    0.7.0.1
 */