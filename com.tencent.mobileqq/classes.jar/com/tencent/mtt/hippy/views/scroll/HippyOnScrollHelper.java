package com.tencent.mtt.hippy.views.scroll;

import android.os.SystemClock;

public class HippyOnScrollHelper
{
  private static final int MIN_EVENT_SEPARATION_MS = 10;
  private long mLastScrollEventTimeMs = -11L;
  private int mPrevX = -2147483648;
  private int mPrevY = -2147483648;
  
  public boolean onScrollChanged(int paramInt1, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((l - this.mLastScrollEventTimeMs <= 10L) && (this.mPrevX == paramInt1) && (this.mPrevY == paramInt2)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mLastScrollEventTimeMs = l;
    this.mPrevX = paramInt1;
    this.mPrevY = paramInt2;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyOnScrollHelper
 * JD-Core Version:    0.7.0.1
 */