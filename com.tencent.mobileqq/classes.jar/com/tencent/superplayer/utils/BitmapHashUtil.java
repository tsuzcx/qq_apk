package com.tencent.superplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.lang.reflect.Array;

public class BitmapHashUtil
{
  private static double[][] coefficient(int paramInt)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt, paramInt });
    double d1 = Math.sqrt(1.0D / paramInt);
    double d2 = Math.sqrt(2.0D / paramInt);
    int i = 0;
    while (i < paramInt)
    {
      arrayOfDouble[0][i] = d1;
      i += 1;
    }
    i = 1;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        arrayOfDouble[i][j] = (Math.cos(i * 3.141592653589793D * (j + 0.5D) / paramInt) * d2);
        j += 1;
      }
      i += 1;
    }
    return arrayOfDouble;
  }
  
  private static int computeGray(int paramInt)
  {
    return Color.red(paramInt) * 38 + Color.green(paramInt) * 75 + Color.blue(paramInt) * 15 >> 7;
  }
  
  private static long computeHash(double[] paramArrayOfDouble)
  {
    double d = 0.0D;
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      d += paramArrayOfDouble[i];
      i += 1;
    }
    d /= paramArrayOfDouble.length;
    long l1 = 1L;
    j = paramArrayOfDouble.length;
    long l2 = 0L;
    i = 0;
    while (i < j)
    {
      long l3 = l2;
      if (paramArrayOfDouble[i] > d) {
        l3 = l2 | l1;
      }
      l1 <<= 1;
      i += 1;
      l2 = l3;
    }
    return l2;
  }
  
  private static int[] createGrayImage(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = new int[paramInt * paramInt];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt, 0, 0, paramInt, paramInt);
    paramBitmap.recycle();
    paramInt = i;
    while (paramInt < arrayOfInt.length)
    {
      i = computeGray(arrayOfInt[paramInt]);
      arrayOfInt[paramInt] = Color.rgb(i, i, i);
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  private static double[][] dct(int[] paramArrayOfInt, int paramInt)
  {
    double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt, paramInt });
    int i = 0;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        arrayOfDouble1[i][j] = paramArrayOfInt[(i * paramInt + j)];
        j += 1;
      }
      i += 1;
    }
    paramArrayOfInt = coefficient(paramInt);
    double[][] arrayOfDouble2 = transposingMatrix(paramArrayOfInt, paramInt);
    return matrixMultiply(matrixMultiply(paramArrayOfInt, arrayOfDouble1, paramInt), arrayOfDouble2, paramInt);
  }
  
  private static double[] dct8(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = dct(paramArrayOfInt, paramInt);
    double[] arrayOfDouble = new double[64];
    paramInt = 0;
    while (paramInt < 8)
    {
      System.arraycopy(paramArrayOfInt[paramInt], 0, arrayOfDouble, paramInt * 8, 8);
      paramInt += 1;
    }
    return arrayOfDouble;
  }
  
  public static long dctImageHash(Bitmap paramBitmap, boolean paramBoolean)
  {
    return computeHash(dct8(createGrayImage(BitmapUtil.scaleBitmap(paramBitmap, paramBoolean, 32), 32), 32));
  }
  
  public static int hammingDistance(long paramLong1, long paramLong2)
  {
    paramLong1 ^= paramLong2;
    paramLong1 -= (paramLong1 >> 1 & 0x55555555);
    paramLong1 = (paramLong1 >> 2 & 0x33333333) + (paramLong1 & 0x33333333);
    return (int)((paramLong1 + (paramLong1 >> 4) & 0xF0F0F0F) * 72340172838076673L >> 56);
  }
  
  private static double[][] matrixMultiply(double[][] paramArrayOfDouble1, double[][] paramArrayOfDouble2, int paramInt)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt, paramInt });
    int i = 0;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        double d = 0.0D;
        int k = 0;
        while (k < paramInt)
        {
          d += paramArrayOfDouble1[i][k] * paramArrayOfDouble2[k][j];
          k += 1;
        }
        arrayOfDouble[i][j] = d;
        j += 1;
      }
      i += 1;
    }
    return arrayOfDouble;
  }
  
  private static double[][] transposingMatrix(double[][] paramArrayOfDouble, int paramInt)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt, paramInt });
    int i = 0;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        arrayOfDouble[i][j] = paramArrayOfDouble[j][i];
        j += 1;
      }
      i += 1;
    }
    return arrayOfDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.utils.BitmapHashUtil
 * JD-Core Version:    0.7.0.1
 */