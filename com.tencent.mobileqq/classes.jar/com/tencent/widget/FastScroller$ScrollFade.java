package com.tencent.widget;

import android.os.SystemClock;

public class FastScroller$ScrollFade
  implements Runnable
{
  long a;
  long b;
  
  public FastScroller$ScrollFade(FastScroller paramFastScroller) {}
  
  int a()
  {
    if (this.this$0.b() != 4) {
      return 208;
    }
    long l = SystemClock.uptimeMillis();
    if (l > this.a + this.b) {
      return 0;
    }
    return (int)(208L - (l - this.a) * 208L / this.b);
  }
  
  void a()
  {
    this.b = 200L;
    this.a = SystemClock.uptimeMillis();
    this.this$0.b(4);
  }
  
  public void run()
  {
    if (this.this$0.b() != 4)
    {
      a();
      return;
    }
    if (a() > 0)
    {
      this.this$0.a.invalidate();
      return;
    }
    this.this$0.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller.ScrollFade
 * JD-Core Version:    0.7.0.1
 */