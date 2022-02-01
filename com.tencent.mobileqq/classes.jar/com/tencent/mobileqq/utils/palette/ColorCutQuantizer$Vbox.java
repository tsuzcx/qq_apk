package com.tencent.mobileqq.utils.palette;

import java.util.Arrays;

class ColorCutQuantizer$Vbox
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  ColorCutQuantizer$Vbox(ColorCutQuantizer paramColorCutQuantizer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    a();
  }
  
  final int a()
  {
    return (this.e - this.d + 1) * (this.g - this.f + 1) * (this.i - this.h + 1);
  }
  
  final Vbox a()
  {
    if (a())
    {
      int j = d();
      Vbox localVbox = new Vbox(this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer, j + 1, this.b);
      this.b = j;
      a();
      return localVbox;
    }
    throw new IllegalStateException("Can not split a box with only 1 color");
  }
  
  final Palette.Swatch a()
  {
    int[] arrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.a;
    int[] arrayOfInt2 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.b;
    int m = this.jdField_a_of_type_Int;
    int n = 0;
    int i1 = 0;
    int k = 0;
    int j = 0;
    while (m <= this.b)
    {
      int i2 = arrayOfInt1[m];
      int i3 = arrayOfInt2[i2];
      i1 += i3;
      n += ColorCutQuantizer.a(i2) * i3;
      k += ColorCutQuantizer.b(i2) * i3;
      j += i3 * ColorCutQuantizer.c(i2);
      m += 1;
    }
    float f1 = n;
    float f2 = i1;
    return new Palette.Swatch(ColorCutQuantizer.a(Math.round(f1 / f2), Math.round(k / f2), Math.round(j / f2)), i1);
  }
  
  final void a()
  {
    int[] arrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.a;
    int[] arrayOfInt2 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.b;
    int m = this.jdField_a_of_type_Int;
    int i4 = 2147483647;
    int i5 = -2147483648;
    int n = 2147483647;
    int i1 = -2147483648;
    int j = 2147483647;
    int k = -2147483648;
    int i8;
    for (int i2 = 0; m <= this.b; i2 = i8)
    {
      int i3 = arrayOfInt1[m];
      i8 = i2 + arrayOfInt2[i3];
      int i6 = ColorCutQuantizer.a(i3);
      int i7 = ColorCutQuantizer.b(i3);
      i3 = ColorCutQuantizer.c(i3);
      i2 = i5;
      if (i6 > i5) {
        i2 = i6;
      }
      i5 = i4;
      if (i6 < i4) {
        i5 = i6;
      }
      i6 = i1;
      if (i7 > i1) {
        i6 = i7;
      }
      i1 = n;
      if (i7 < n) {
        i1 = i7;
      }
      i7 = k;
      if (i3 > k) {
        i7 = i3;
      }
      k = j;
      if (i3 < j) {
        k = i3;
      }
      m += 1;
      i4 = i5;
      i5 = i2;
      n = i1;
      i1 = i6;
      j = k;
      k = i7;
    }
    this.d = i4;
    this.e = i5;
    this.f = n;
    this.g = i1;
    this.h = j;
    this.i = k;
    this.c = i2;
  }
  
  final boolean a()
  {
    return b() > 1;
  }
  
  final int b()
  {
    return this.b + 1 - this.jdField_a_of_type_Int;
  }
  
  final int c()
  {
    int j = this.e - this.d;
    int k = this.g - this.f;
    int m = this.i - this.h;
    if ((j >= k) && (j >= m)) {
      return -3;
    }
    if ((k >= j) && (k >= m)) {
      return -2;
    }
    return -1;
  }
  
  final int d()
  {
    int j = c();
    int[] arrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.a;
    int[] arrayOfInt2 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.b;
    ColorCutQuantizer.a(arrayOfInt1, j, this.jdField_a_of_type_Int, this.b);
    Arrays.sort(arrayOfInt1, this.jdField_a_of_type_Int, this.b + 1);
    ColorCutQuantizer.a(arrayOfInt1, j, this.jdField_a_of_type_Int, this.b);
    int m = this.c / 2;
    j = this.jdField_a_of_type_Int;
    int k = 0;
    for (;;)
    {
      int n = this.b;
      if (j > n) {
        break;
      }
      k += arrayOfInt2[arrayOfInt1[j]];
      if (k >= m) {
        return Math.min(n - 1, j);
      }
      j += 1;
    }
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ColorCutQuantizer.Vbox
 * JD-Core Version:    0.7.0.1
 */