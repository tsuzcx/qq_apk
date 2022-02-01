package com.tencent.mobileqq.shortvideo.util;

public class ImageUtil
{
  public static void a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i8 = paramInt1 * paramInt2;
    int m = 0;
    int i = 0;
    int j = 0;
    int n = 0;
    while (m < paramInt2)
    {
      int k = (m >> 1) * paramInt1 / 2;
      int i6 = i8 + k;
      k = i8 * 5 / 4 + k;
      int i1 = j;
      j = i;
      int i2 = 0;
      i = i1;
      i1 = i2;
      while (i1 < paramInt1)
      {
        i2 = (paramArrayOfByte[n] & 0xFF) - 16;
        int i7 = i2;
        if (i2 < 0) {
          i7 = 0;
        }
        int i5 = j;
        int i4 = i;
        int i3 = i6;
        i2 = k;
        if ((i1 & 0x1) == 0)
        {
          j = paramArrayOfByte[i6];
          i = paramArrayOfByte[k];
          i3 = i6 + 1;
          i5 = (j & 0xFF) - 128;
          i4 = (i & 0xFF) - 128;
          i2 = k + 1;
        }
        i = i7 * 1192;
        j = i4 * 1634 + i;
        i7 = i - i4 * 833 - i5 * 400;
        k = i + i5 * 2066;
        i6 = 262143;
        if (j < 0)
        {
          i = 0;
        }
        else
        {
          i = j;
          if (j > 262143) {
            i = 262143;
          }
        }
        if (i7 < 0)
        {
          j = 0;
        }
        else
        {
          j = i7;
          if (i7 > 262143) {
            j = 262143;
          }
        }
        if (k < 0) {
          k = 0;
        } else if (k > 262143) {
          k = i6;
        }
        paramArrayOfInt[n] = (0xFF000000 | i << 6 & 0xFF0000 | j >> 2 & 0xFF00 | k >> 10 & 0xFF);
        i1 += 1;
        n += 1;
        j = i5;
        i = i4;
        i6 = i3;
        k = i2;
      }
      m += 1;
      k = i;
      i = j;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */