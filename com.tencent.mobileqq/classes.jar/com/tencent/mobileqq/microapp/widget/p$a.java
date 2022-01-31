package com.tencent.mobileqq.microapp.widget;

import com.tencent.mobileqq.microapp.b.a;

final class p$a
{
  private static a b = null;
  private static a c = null;
  private int[] a = null;
  private int d = 0;
  private int e = 0;
  private int f = 9000;
  private int g = 1800;
  private long h;
  private int i;
  
  public p$a(int paramInt)
  {
    this.d = paramInt;
    this.e = 0;
    if (this.d == 0) {
      this.f = 9000;
    }
    for (this.g = 1800;; this.g = 1200)
    {
      this.h = 0L;
      this.i = 0;
      this.a = new int[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        this.a[paramInt] = 0;
        paramInt += 1;
      }
      this.f = 6000;
    }
  }
  
  public static a a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (b == null) {
        b = new a(0);
      }
      return b;
    }
    if (c == null) {
      c = new a(1);
    }
    return c;
  }
  
  private int d()
  {
    int j = 0;
    int k = 0;
    int n;
    for (int m = 0; j < 3; m = n)
    {
      int i1 = k;
      n = m;
      if (this.a[j] > 0)
      {
        n = m + 1;
        i1 = k + this.a[j];
      }
      j += 1;
      k = i1;
    }
    if (m > 0) {
      return k / m;
    }
    return 0;
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
    int k = a.b();
    int j;
    if (this.e != k)
    {
      j = 1;
      this.e = k;
      if (j == 0) {
        break label62;
      }
      if (this.e != 2) {
        break label54;
      }
      j = this.f;
      label43:
      e();
    }
    label54:
    label62:
    do
    {
      return j;
      j = 0;
      break;
      j = this.g;
      break label43;
      k = d();
      j = k;
    } while (k > 0);
    return 0;
  }
  
  public void c()
  {
    int k = (int)(System.currentTimeMillis() - this.h);
    int m = d();
    int j;
    if (this.e == 2)
    {
      j = this.f;
      if (m != 0) {
        break label90;
      }
      j *= 3;
      label36:
      if (k > 100) {
        if (k <= j) {
          break label97;
        }
      }
    }
    for (;;)
    {
      this.a[this.i] = ((int)(j * 1.2F));
      j = this.i + 1;
      this.i = j;
      this.i = (j % 3);
      return;
      j = this.g;
      break;
      label90:
      j = m * 3;
      break label36;
      label97:
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.p.a
 * JD-Core Version:    0.7.0.1
 */