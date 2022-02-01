package com.tencent.mobileqq.onlinestatus.auto.location;

import android.support.annotation.NonNull;

class SampleModeController
{
  private int a;
  private int b;
  private SampleModeController.OnSampleModeChangedListener c;
  private int d = 0;
  private boolean e = true;
  
  SampleModeController(int paramInt1, int paramInt2, @NonNull SampleModeController.OnSampleModeChangedListener paramOnSampleModeChangedListener)
  {
    this.b = paramInt1;
    this.a = paramInt2;
    this.c = paramOnSampleModeChangedListener;
  }
  
  void a()
  {
    int i;
    if (this.e) {
      i = this.a;
    } else {
      i = this.b;
    }
    int j = this.d;
    this.d = (j + 1);
    if (j >= i - 1)
    {
      this.d = 0;
      this.e ^= true;
      this.c.a(this.e);
    }
  }
  
  void b()
  {
    this.d = 0;
    this.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.SampleModeController
 * JD-Core Version:    0.7.0.1
 */