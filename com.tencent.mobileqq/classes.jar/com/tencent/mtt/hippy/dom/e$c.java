package com.tencent.mtt.hippy.dom;

import android.os.Handler;

final class e$c
  implements Runnable
{
  private boolean b;
  private long c;
  private int d;
  private final Handler e;
  
  public void a()
  {
    this.e.postDelayed(this, 16L);
  }
  
  public void run()
  {
    this.b = false;
    this.a.a(this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.e.c
 * JD-Core Version:    0.7.0.1
 */