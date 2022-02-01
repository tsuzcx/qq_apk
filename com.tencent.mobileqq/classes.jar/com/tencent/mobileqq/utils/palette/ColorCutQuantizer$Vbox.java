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
    if (!a()) {
      throw new IllegalStateException("Can not split a box with only 1 color");
    }
    int j = d();
    Vbox localVbox = new Vbox(this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer, j + 1, this.b);
    this.b = j;
    a();
    return localVbox;
  }
  
  final Palette.Swatch a()
  {
    int i1 = 0;
    int[] arrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.a;
    int[] arrayOfInt2 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.b;
    int n = this.jdField_a_of_type_Int;
    int j = 0;
    int k = 0;
    int m = 0;
    while (n <= this.b)
    {
      int i2 = arrayOfInt1[n];
      int i3 = arrayOfInt2[i2];
      i1 += i3;
      m += ColorCutQuantizer.a(i2) * i3;
      k += ColorCutQuantizer.b(i2) * i3;
      j += ColorCutQuantizer.c(i2) * i3;
      n += 1;
    }
    return new Palette.Swatch(ColorCutQuantizer.a(Math.round(m / i1), Math.round(k / i1), Math.round(j / i1)), i1);
  }
  
  final void a()
  {
    int[] arrayOfInt1 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.a;
    int[] arrayOfInt2 = this.jdField_a_of_type_ComTencentMobileqqUtilsPaletteColorCutQuantizer.b;
    int n = -2147483648;
    int i5 = 0;
    int m = this.jdField_a_of_type_Int;
    int i6 = -2147483648;
    int j = 2147483647;
    int k = 2147483647;
    int i3 = 2147483647;
    int i2 = -2147483648;
    while (m <= this.b)
    {
      int i1 = arrayOfInt1[m];
      int i9 = i5 + arrayOfInt2[i1];
      int i8 = ColorCutQuantizer.a(i1);
      int i7 = ColorCutQuantizer.b(i1);
      i5 = ColorCutQuantizer.c(i1);
      i1 = i6;
      if (i8 > i6) {
        i1 = i8;
      }
      int i4 = i3;
      if (i8 < i3) {
        i4 = i8;
      }
      i3 = i2;
      if (i7 > i2) {
        i3 = i7;
      }
      i8 = k;
      if (i7 < k) {
        i8 = i7;
      }
      i2 = n;
      if (i5 > n) {
        i2 = i5;
      }
      k = j;
      if (i5 < j) {
        k = i5;
      }
      m += 1;
      i5 = i9;
      n = i2;
      i2 = i3;
      i6 = i1;
      j = k;
      k = i8;
      i3 = i4;
    }
    this.d = i3;
    this.e = i6;
    this.f = k;
    this.g = i2;
    this.h = j;
    this.i = n;
    this.c = i5;
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
    while (j <= this.b)
    {
      k += arrayOfInt2[arrayOfInt1[j]];
      if (k >= m) {
        return Math.min(this.b - 1, j);
      }
      j += 1;
    }
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ColorCutQuantizer.Vbox
 * JD-Core Version:    0.7.0.1
 */