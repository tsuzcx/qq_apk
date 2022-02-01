package com.tencent.tkd.topicsdk.common;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

public class StackBlur
{
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    int i7 = paramInt;
    if (i7 < 1) {
      return;
    }
    int i19 = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int i = i19 * j;
    int[] arrayOfInt2 = new int[i];
    paramBitmap.getPixels(arrayOfInt2, 0, i19, 0, 0, i19, j);
    int i20 = i19 - 1;
    int k = j - 1;
    int i17 = i7 + i7 + 1;
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[i];
    int[] arrayOfInt1 = new int[Math.max(i19, j)];
    i = i17 + 1 >> 1;
    int m = i * i;
    int n = m * 256;
    int[] arrayOfInt6 = new int[n];
    int i11 = arrayOfInt6.length;
    i = 0;
    while (i < n)
    {
      arrayOfInt6[i] = (i / m);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
    int i8 = i7 + 1;
    int i10 = 0;
    int i12 = 0;
    int i9 = 0;
    i = k;
    int i13;
    int i6;
    int i5;
    int i4;
    int i1;
    int i2;
    int i3;
    int i14;
    int[] arrayOfInt7;
    int i15;
    int i16;
    while (i10 < j)
    {
      i13 = -i7;
      i6 = 0;
      i5 = 0;
      i4 = 0;
      n = 0;
      m = 0;
      k = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      while (i13 <= i7)
      {
        i14 = arrayOfInt2[(i12 + Math.min(i20, Math.max(i13, 0)))];
        arrayOfInt7 = arrayOfInt[(i13 + i7)];
        arrayOfInt7[0] = ((i14 & 0xFF0000) >> 16);
        arrayOfInt7[1] = ((i14 & 0xFF00) >> 8);
        arrayOfInt7[2] = (i14 & 0xFF);
        i14 = i8 - Math.abs(i13);
        i6 += arrayOfInt7[0] * i14;
        i5 += arrayOfInt7[1] * i14;
        i4 += arrayOfInt7[2] * i14;
        if (i13 > 0)
        {
          i1 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          i3 += arrayOfInt7[2];
        }
        else
        {
          n += arrayOfInt7[0];
          m += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
        i13 += 1;
      }
      i15 = i6;
      int i18 = 0;
      i16 = i7;
      i6 = i3;
      i13 = i2;
      i14 = i1;
      i1 = i16;
      i3 = i5;
      i2 = i4;
      i5 = i15;
      i4 = i18;
      while (i4 < i19) {
        if ((i5 < i11) && (i3 < i11))
        {
          if (i2 >= i11) {
            return;
          }
          arrayOfInt3[i12] = arrayOfInt6[i5];
          arrayOfInt4[i12] = arrayOfInt6[i3];
          arrayOfInt5[i12] = arrayOfInt6[i2];
          arrayOfInt7 = arrayOfInt[((i1 - i7 + i17) % i17)];
          i18 = arrayOfInt7[0];
          i16 = arrayOfInt7[1];
          i15 = arrayOfInt7[2];
          if (i10 == 0) {
            arrayOfInt1[i4] = Math.min(i4 + i7 + 1, i20);
          }
          int i21 = arrayOfInt2[(i9 + arrayOfInt1[i4])];
          arrayOfInt7[0] = ((i21 & 0xFF0000) >> 16);
          arrayOfInt7[1] = ((i21 & 0xFF00) >> 8);
          arrayOfInt7[2] = (i21 & 0xFF);
          i14 += arrayOfInt7[0];
          i13 += arrayOfInt7[1];
          i6 += arrayOfInt7[2];
          i5 = i5 - n + i14;
          i3 = i3 - m + i13;
          i2 = i2 - k + i6;
          i1 = (i1 + 1) % i17;
          arrayOfInt7 = arrayOfInt[(i1 % i17)];
          n = n - i18 + arrayOfInt7[0];
          m = m - i16 + arrayOfInt7[1];
          k = k - i15 + arrayOfInt7[2];
          i14 -= arrayOfInt7[0];
          i13 -= arrayOfInt7[1];
          i6 -= arrayOfInt7[2];
          i12 += 1;
          i4 += 1;
        }
        else
        {
          return;
        }
      }
      i9 += i19;
      i10 += 1;
    }
    i9 = j;
    m = 0;
    j = i;
    k = i17;
    i = m;
    for (;;)
    {
      i10 = paramInt;
      if (i >= i19) {
        break;
      }
      i11 = -i10;
      i12 = i11 * i19;
      i7 = 0;
      i2 = 0;
      i3 = 0;
      i1 = 0;
      n = 0;
      m = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      while (i11 <= i10)
      {
        i14 = Math.max(0, i12) + i;
        arrayOfInt7 = arrayOfInt[(i11 + i10)];
        arrayOfInt7[0] = arrayOfInt3[i14];
        arrayOfInt7[1] = arrayOfInt4[i14];
        arrayOfInt7[2] = arrayOfInt5[i14];
        i15 = i8 - Math.abs(i11);
        i7 += arrayOfInt3[i14] * i15;
        i13 = i2 + arrayOfInt4[i14] * i15;
        i3 += arrayOfInt5[i14] * i15;
        if (i11 > 0)
        {
          i4 += arrayOfInt7[0];
          i5 += arrayOfInt7[1];
          i6 += arrayOfInt7[2];
        }
        else
        {
          i1 += arrayOfInt7[0];
          n += arrayOfInt7[1];
          m += arrayOfInt7[2];
        }
        i2 = i12;
        if (i11 < j) {
          i2 = i12 + i19;
        }
        i11 += 1;
        i12 = i2;
        i2 = i13;
      }
      i11 = i;
      i12 = i6;
      i15 = 0;
      i13 = i10;
      i6 = i7;
      i14 = i2;
      i7 = i12;
      i10 = i5;
      i12 = i4;
      i2 = i13;
      i4 = i14;
      i5 = i15;
      while (i5 < i9)
      {
        arrayOfInt2[i11] = (arrayOfInt6[i6] << 16 | 0xFF000000 | arrayOfInt6[i4] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i2 - paramInt + k) % k)];
        i15 = arrayOfInt7[0];
        i14 = arrayOfInt7[1];
        i13 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt1[i5] = (Math.min(i5 + i8, j) * i19);
        }
        i16 = arrayOfInt1[i5] + i;
        arrayOfInt7[0] = arrayOfInt3[i16];
        arrayOfInt7[1] = arrayOfInt4[i16];
        arrayOfInt7[2] = arrayOfInt5[i16];
        i12 += arrayOfInt7[0];
        i10 += arrayOfInt7[1];
        i7 += arrayOfInt7[2];
        i6 = i6 - i1 + i12;
        i4 = i4 - n + i10;
        i3 = i3 - m + i7;
        i2 = (i2 + 1) % k;
        arrayOfInt7 = arrayOfInt[i2];
        i1 = i1 - i15 + arrayOfInt7[0];
        n = n - i14 + arrayOfInt7[1];
        m = m - i13 + arrayOfInt7[2];
        i12 -= arrayOfInt7[0];
        i10 -= arrayOfInt7[1];
        i7 -= arrayOfInt7[2];
        i11 += i19;
        i5 += 1;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt2, 0, i19, 0, 0, i19, i9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.StackBlur
 * JD-Core Version:    0.7.0.1
 */