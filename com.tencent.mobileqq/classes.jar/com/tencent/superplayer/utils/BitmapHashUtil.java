package com.tencent.superplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.lang.reflect.Array;

public class BitmapHashUtil
{
  private static double[][] coefficient(int paramInt)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt, paramInt });
    double d1 = paramInt;
    Double.isNaN(d1);
    double d3 = Math.sqrt(1.0D / d1);
    Double.isNaN(d1);
    double d2 = Math.sqrt(2.0D / d1);
    int i = 0;
    while (i < paramInt)
    {
      arrayOfDouble[0][i] = d3;
      i += 1;
    }
    i = 1;
    while (i < paramInt)
    {
      int j = 0;
      while (j < paramInt)
      {
        double[] arrayOfDouble1 = arrayOfDouble[i];
        d3 = i;
        Double.isNaN(d3);
        double d4 = j;
        Double.isNaN(d4);
        Double.isNaN(d1);
        arrayOfDouble1[j] = (Math.cos(d3 * 3.141592653589793D * (d4 + 0.5D) / d1) * d2);
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
    int k = paramArrayOfDouble.length;
    int j = 0;
    double d1 = 0.0D;
    int i = 0;
    while (i < k)
    {
      d1 += paramArrayOfDouble[i];
      i += 1;
    }
    double d2 = paramArrayOfDouble.length;
    Double.isNaN(d2);
    d1 /= d2;
    long l1 = 1L;
    long l2 = 0L;
    k = paramArrayOfDouble.length;
    i = j;
    while (i < k)
    {
      long l3 = l2;
      if (paramArrayOfDouble[i] > d1) {
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
    int[] arrayOfInt = new int[paramInt * paramInt];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt, 0, 0, paramInt, paramInt);
    paramBitmap.recycle();
    paramInt = 0;
    while (paramInt < arrayOfInt.length)
    {
      int i = computeGray(arrayOfInt[paramInt]);
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
    paramLong1 = (paramLong1 & 0x33333333) + (paramLong1 >> 2 & 0x33333333);
    return (int)((0xF0F0F0F & paramLong1 + (paramLong1 >> 4)) * 72340172838076673L >> 56);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.utils.BitmapHashUtil
 * JD-Core Version:    0.7.0.1
 */