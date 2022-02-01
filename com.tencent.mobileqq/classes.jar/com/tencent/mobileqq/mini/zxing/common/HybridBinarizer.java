package com.tencent.mobileqq.mini.zxing.common;

import com.tencent.mobileqq.mini.zxing.Binarizer;
import com.tencent.mobileqq.mini.zxing.LuminanceSource;
import java.lang.reflect.Array;

public final class HybridBinarizer
  extends GlobalHistogramBinarizer
{
  private static final int BLOCK_SIZE = 8;
  private static final int BLOCK_SIZE_MASK = 7;
  private static final int BLOCK_SIZE_POWER = 3;
  private static final int MINIMUM_DIMENSION = 40;
  private static final int MIN_DYNAMIC_RANGE = 24;
  private BitMatrix matrix;
  
  public HybridBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }
  
  private static int[][] calculateBlackPoints(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 8;
    int i6 = paramInt4 - 8;
    int i7 = paramInt3 - 8;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt2, paramInt1 });
    int m = 0;
    while (m < paramInt2)
    {
      paramInt4 = m << 3;
      int n = paramInt4;
      if (paramInt4 > i6) {
        n = i6;
      }
      int i1 = 0;
      while (i1 < paramInt1)
      {
        int i = i1 << 3;
        paramInt4 = i;
        if (i > i7) {
          paramInt4 = i7;
        }
        i = n * paramInt3 + paramInt4;
        int j = 0;
        paramInt4 = 0;
        int i2 = 0;
        int i3 = 255;
        while (j < k)
        {
          int i4 = 0;
          while (i4 < k)
          {
            k = paramArrayOfByte[(i + i4)] & 0xFF;
            i5 = paramInt4 + k;
            paramInt4 = i3;
            if (k < i3) {
              paramInt4 = k;
            }
            i3 = i2;
            if (k > i2) {
              i3 = k;
            }
            i4 += 1;
            k = 8;
            i2 = i3;
            i3 = paramInt4;
            paramInt4 = i5;
          }
          if (i2 - i3 > 24)
          {
            k = j + 1;
            i += paramInt3;
            j = paramInt4;
            paramInt4 = i;
            i = k;
            for (;;)
            {
              i5 = i;
              i4 = paramInt4;
              k = j;
              if (i >= 8) {
                break;
              }
              k = 0;
              while (k < 8)
              {
                j += (paramArrayOfByte[(paramInt4 + k)] & 0xFF);
                k += 1;
              }
              i += 1;
              paramInt4 += paramInt3;
            }
          }
          k = paramInt4;
          i4 = i;
          int i5 = j;
          j = 8;
          paramInt4 = k;
          i5 += 1;
          i = i4 + paramInt3;
          k = j;
          j = i5;
        }
        paramInt4 >>= 6;
        if (i2 - i3 <= 24)
        {
          i = i3 / 2;
          paramInt4 = i;
          if (m > 0)
          {
            paramInt4 = i;
            if (i1 > 0)
            {
              paramInt4 = m - 1;
              j = arrayOfInt[paramInt4][i1];
              int[] arrayOfInt1 = arrayOfInt[m];
              i2 = i1 - 1;
              j = (j + arrayOfInt1[i2] * 2 + arrayOfInt[paramInt4][i2]) / 4;
              paramInt4 = i;
              if (i3 < j) {
                paramInt4 = j;
              }
            }
          }
        }
        arrayOfInt[m][i1] = paramInt4;
        i1 += 1;
      }
      m += 1;
    }
    return arrayOfInt;
  }
  
  private static void calculateThresholdForBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i1 = paramInt4 - 8;
    int i2 = paramInt3 - 8;
    paramInt4 = 0;
    while (paramInt4 < paramInt2)
    {
      int i = paramInt4 << 3;
      if (i > i1) {
        i = i1;
      }
      int i3 = cap(paramInt4, 2, paramInt2 - 3);
      int j = 0;
      while (j < paramInt1)
      {
        int k = j << 3;
        if (k > i2) {
          k = i2;
        }
        int i4 = cap(j, 2, paramInt1 - 3);
        int m = -2;
        int n = 0;
        while (m <= 2)
        {
          int[] arrayOfInt = paramArrayOfInt[(i3 + m)];
          n += arrayOfInt[(i4 - 2)] + arrayOfInt[(i4 - 1)] + arrayOfInt[i4] + arrayOfInt[(i4 + 1)] + arrayOfInt[(i4 + 2)];
          m += 1;
        }
        thresholdBlock(paramArrayOfByte, k, i, n / 25, paramInt3, paramBitMatrix);
        j += 1;
      }
      paramInt4 += 1;
    }
  }
  
  private static int cap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > paramInt3) {
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  private static void thresholdBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix)
  {
    int i = paramInt2 * paramInt4 + paramInt1;
    int j = 0;
    while (j < 8)
    {
      int k = 0;
      while (k < 8)
      {
        if ((paramArrayOfByte[(i + k)] & 0xFF) <= paramInt3) {
          paramBitMatrix.set(paramInt1 + k, paramInt2 + j);
        }
        k += 1;
      }
      j += 1;
      i += paramInt4;
    }
  }
  
  public Binarizer createBinarizer(LuminanceSource paramLuminanceSource)
  {
    return new HybridBinarizer(paramLuminanceSource);
  }
  
  public BitMatrix getBlackMatrix()
  {
    Object localObject = this.matrix;
    if (localObject != null) {
      return localObject;
    }
    localObject = getLuminanceSource();
    int m = ((LuminanceSource)localObject).getWidth();
    int n = ((LuminanceSource)localObject).getHeight();
    if ((m >= 40) && (n >= 40))
    {
      localObject = ((LuminanceSource)localObject).getMatrix();
      int j = m >> 3;
      int i = j;
      if ((m & 0x7) != 0) {
        i = j + 1;
      }
      int k = n >> 3;
      j = k;
      if ((n & 0x7) != 0) {
        j = k + 1;
      }
      int[][] arrayOfInt = calculateBlackPoints((byte[])localObject, i, j, m, n);
      BitMatrix localBitMatrix = new BitMatrix(m, n);
      calculateThresholdForBlock((byte[])localObject, i, j, m, n, arrayOfInt, localBitMatrix);
      this.matrix = localBitMatrix;
    }
    else
    {
      this.matrix = super.getBlackMatrix();
    }
    return this.matrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.common.HybridBinarizer
 * JD-Core Version:    0.7.0.1
 */