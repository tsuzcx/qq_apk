package com.tencent.mobileqq.hotpic;

import android.os.SystemClock;

public class ScrollVelometer
{
  int a;
  int b;
  long c;
  boolean d = false;
  ScrollVelometer.SpeedListener e;
  int f = 100;
  
  public ScrollVelometer(int paramInt, ScrollVelometer.SpeedListener paramSpeedListener)
  {
    this.a = paramInt;
    this.e = paramSpeedListener;
  }
  
  public void a(int paramInt)
  {
    if (!this.d) {
      return;
    }
    this.b += paramInt;
    if (this.c == 0L)
    {
      this.c = SystemClock.uptimeMillis();
      return;
    }
    if (SystemClock.uptimeMillis() - this.c > this.f)
    {
      ScrollVelometer.SpeedListener localSpeedListener = this.e;
      boolean bool;
      if (this.b > this.a) {
        bool = true;
      } else {
        bool = false;
      }
      localSpeedListener.a(bool);
      this.c = 0L;
      this.b = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.ScrollVelometer
 * JD-Core Version:    0.7.0.1
 */