package com.tencent.mobileqq.widget;

import com.tencent.biz.common.util.HttpUtil;

class WebViewProgressBarController$DurationGenerator
{
  private static DurationGenerator b;
  private static DurationGenerator c;
  private int[] a = null;
  private int d = 0;
  private int e = 0;
  private int f = 9000;
  private int g = 1800;
  private long h;
  private int i;
  
  public WebViewProgressBarController$DurationGenerator(int paramInt)
  {
    this.d = paramInt;
    this.e = 0;
    if (this.d == 0)
    {
      this.f = 9000;
      this.g = 1800;
    }
    else
    {
      this.f = 6000;
      this.g = 1200;
    }
    this.h = 0L;
    this.i = 0;
    this.a = new int[3];
    paramInt = 0;
    while (paramInt < 3)
    {
      this.a[paramInt] = 0;
      paramInt += 1;
    }
  }
  
  public static DurationGenerator a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (b == null) {
        b = new DurationGenerator(0);
      }
      return b;
    }
    if (c == null) {
      c = new DurationGenerator(1);
    }
    return c;
  }
  
  private int d()
  {
    int i2 = 0;
    int k = 0;
    int m = 0;
    int n;
    for (int j = 0; k < 3; j = n)
    {
      int[] arrayOfInt = this.a;
      int i1 = m;
      n = j;
      if (arrayOfInt[k] > 0)
      {
        i1 = m + 1;
        n = j + arrayOfInt[k];
      }
      k += 1;
      m = i1;
    }
    k = i2;
    if (m > 0) {
      k = j / m;
    }
    return k;
  }
  
  private void e()
  {
    int j = 0;
    while (j < 3)
    {
      this.a[j] = 0;
      j += 1;
    }
    this.i = 0;
  }
  
  public int a()
  {
    if (2 == this.e) {
      return this.f;
    }
    return this.g;
  }
  
  public int b()
  {
    this.h = System.currentTimeMillis();
    int m = HttpUtil.getNetWorkType();
    int j = this.e;
    int k = 0;
    if (j != m) {
      j = 1;
    } else {
      j = 0;
    }
    this.e = m;
    if (j != 0)
    {
      if (this.e == 2) {
        j = this.f;
      } else {
        j = this.g;
      }
      e();
      return j;
    }
    m = d();
    j = k;
    if (m > 0) {
      j = m;
    }
    return j;
  }
  
  public void c()
  {
    int k = (int)(System.currentTimeMillis() - this.h);
    int m = d();
    int j;
    if (this.e == 2) {
      j = this.f;
    } else {
      j = this.g;
    }
    if (m == 0) {
      j *= 3;
    } else {
      j = m * 3;
    }
    if (k > 100)
    {
      if (k <= j) {
        j = k;
      }
      int[] arrayOfInt = this.a;
      k = this.i;
      arrayOfInt[k] = ((int)(j * 1.2F));
      j = k + 1;
      this.i = j;
      this.i = (j % 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController.DurationGenerator
 * JD-Core Version:    0.7.0.1
 */