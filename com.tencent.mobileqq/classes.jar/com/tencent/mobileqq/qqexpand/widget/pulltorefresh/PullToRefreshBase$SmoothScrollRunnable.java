package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

import android.view.animation.Interpolator;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.ViewCompat;

final class PullToRefreshBase$SmoothScrollRunnable
  implements Runnable
{
  private final Interpolator a;
  private final int b;
  private final int c;
  private final long d;
  private final PullToRefreshBase.OnSmoothScrollFinishedListener e;
  private boolean f = true;
  private long g = -1L;
  private int h = -1;
  
  public PullToRefreshBase$SmoothScrollRunnable(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, long paramLong, PullToRefreshBase.OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener)
  {
    this.c = paramInt1;
    this.b = paramInt2;
    this.a = PullToRefreshBase.b(paramPullToRefreshBase);
    this.d = paramLong;
    this.e = paramOnSmoothScrollFinishedListener;
  }
  
  public void a()
  {
    this.f = false;
    this.this$0.removeCallbacks(this);
  }
  
  public void run()
  {
    if (this.g == -1L)
    {
      this.g = System.currentTimeMillis();
    }
    else
    {
      long l = Math.max(Math.min((System.currentTimeMillis() - this.g) * 1000L / this.d, 1000L), 0L);
      int i = Math.round((this.c - this.b) * this.a.getInterpolation((float)l / 1000.0F));
      this.h = (this.c - i);
      this.this$0.setHeaderScroll(this.h);
    }
    if ((this.f) && (this.b != this.h))
    {
      ViewCompat.a(this.this$0, this);
      return;
    }
    PullToRefreshBase.OnSmoothScrollFinishedListener localOnSmoothScrollFinishedListener = this.e;
    if (localOnSmoothScrollFinishedListener != null) {
      localOnSmoothScrollFinishedListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.SmoothScrollRunnable
 * JD-Core Version:    0.7.0.1
 */