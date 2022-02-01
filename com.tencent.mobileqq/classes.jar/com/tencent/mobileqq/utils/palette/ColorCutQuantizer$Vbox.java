package com.tencent.mobileqq.utils.palette;

import java.util.Arrays;

class ColorCutQuantizer$Vbox
{
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  ColorCutQuantizer$Vbox(ColorCutQuantizer paramColorCutQuantizer, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    d();
  }
  
  final int a()
  {
    return (this.f - this.e + 1) * (this.h - this.g + 1) * (this.j - this.i + 1);
  }
  
  final boolean b()
  {
    return c() > 1;
  }
  
  final int c()
  {
    return this.c + 1 - this.b;
  }
  
  final void d()
  {
    int[] arrayOfInt1 = this.a.a;
    int[] arrayOfInt2 = this.a.b;
    int n = this.b;
    int i5 = 2147483647;
    int i6 = -2147483648;
    int i1 = 2147483647;
    int i2 = -2147483648;
    int k = 2147483647;
    int m = -2147483648;
    int i9;
    for (int i3 = 0; n <= this.c; i3 = i9)
    {
      int i4 = arrayOfInt1[n];
      i9 = i3 + arrayOfInt2[i4];
      int i7 = ColorCutQuantizer.a(i4);
      int i8 = ColorCutQuantizer.b(i4);
      i4 = ColorCutQuantizer.c(i4);
      i3 = i6;
      if (i7 > i6) {
        i3 = i7;
      }
      i6 = i5;
      if (i7 < i5) {
        i6 = i7;
      }
      i7 = i2;
      if (i8 > i2) {
        i7 = i8;
      }
      i2 = i1;
      if (i8 < i1) {
        i2 = i8;
      }
      i8 = m;
      if (i4 > m) {
        i8 = i4;
      }
      m = k;
      if (i4 < k) {
        m = i4;
      }
      n += 1;
      i5 = i6;
      i6 = i3;
      i1 = i2;
      i2 = i7;
      k = m;
      m = i8;
    }
    this.e = i5;
    this.f = i6;
    this.g = i1;
    this.h = i2;
    this.i = k;
    this.j = m;
    this.d = i3;
  }
  
  final Vbox e()
  {
    if (b())
    {
      int k = g();
      Vbox localVbox = new Vbox(this.a, k + 1, this.c);
      this.c = k;
      d();
      return localVbox;
    }
    throw new IllegalStateException("Can not split a box with only 1 color");
  }
  
  final int f()
  {
    int k = this.f - this.e;
    int m = this.h - this.g;
    int n = this.j - this.i;
    if ((k >= m) && (k >= n)) {
      return -3;
    }
    if ((m >= k) && (m >= n)) {
      return -2;
    }
    return -1;
  }
  
  final int g()
  {
    int k = f();
    int[] arrayOfInt1 = this.a.a;
    int[] arrayOfInt2 = this.a.b;
    ColorCutQuantizer.a(arrayOfInt1, k, this.b, this.c);
    Arrays.sort(arrayOfInt1, this.b, this.c + 1);
    ColorCutQuantizer.a(arrayOfInt1, k, this.b, this.c);
    int n = this.d / 2;
    k = this.b;
    int m = 0;
    for (;;)
    {
      int i1 = this.c;
      if (k > i1) {
        break;
      }
      m += arrayOfInt2[arrayOfInt1[k]];
      if (m >= n) {
        return Math.min(i1 - 1, k);
      }
      k += 1;
    }
    return this.b;
  }
  
  final Palette.Swatch h()
  {
    int[] arrayOfInt1 = this.a.a;
    int[] arrayOfInt2 = this.a.b;
    int n = this.b;
    int i1 = 0;
    int i2 = 0;
    int m = 0;
    int k = 0;
    while (n <= this.c)
    {
      int i3 = arrayOfInt1[n];
      int i4 = arrayOfInt2[i3];
      i2 += i4;
      i1 += ColorCutQuantizer.a(i3) * i4;
      m += ColorCutQuantizer.b(i3) * i4;
      k += i4 * ColorCutQuantizer.c(i3);
      n += 1;
    }
    float f1 = i1;
    float f2 = i2;
    return new Palette.Swatch(ColorCutQuantizer.a(Math.round(f1 / f2), Math.round(m / f2), Math.round(k / f2)), i2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ColorCutQuantizer.Vbox
 * JD-Core Version:    0.7.0.1
 */