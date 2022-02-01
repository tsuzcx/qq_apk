package com.tencent.widget;

import android.os.SystemClock;

public class FastScroller$ScrollFade
  implements Runnable
{
  static final int ALPHA_MAX = 208;
  static final long FADE_DURATION = 200L;
  long mFadeDuration;
  long mStartTime;
  
  public FastScroller$ScrollFade(FastScroller paramFastScroller) {}
  
  int getAlpha()
  {
    if (this.this$0.getState() != 4) {
      return 208;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mStartTime;
    long l3 = this.mFadeDuration;
    if (l1 > l2 + l3) {
      return 0;
    }
    return (int)(208L - (l1 - l2) * 208L / l3);
  }
  
  public void run()
  {
    if (this.this$0.getState() != 4)
    {
      startFade();
      return;
    }
    if (getAlpha() > 0)
    {
      this.this$0.mList.invalidate();
      return;
    }
    this.this$0.setState(0);
  }
  
  void startFade()
  {
    this.mFadeDuration = 200L;
    this.mStartTime = SystemClock.uptimeMillis();
    this.this$0.setState(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.FastScroller.ScrollFade
 * JD-Core Version:    0.7.0.1
 */