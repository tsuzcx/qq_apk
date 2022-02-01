package com.tencent.mobileqq.utils.palette;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

public final class ColorUtils
{
  private static final ThreadLocal<double[]> a = new ThreadLocal();
  
  @FloatRange(from=0.0D, to=1.0D)
  public static double a(@ColorInt int paramInt)
  {
    double[] arrayOfDouble = a();
    a(paramInt, arrayOfDouble);
    return arrayOfDouble[1] / 100.0D;
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 > paramFloat3) {
      paramFloat2 = paramFloat3;
    }
    return paramFloat2;
  }
  
  public static int a(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = d(j, i);
    return Color.argb(k, a(Color.red(paramInt1), j, Color.red(paramInt2), i, k), a(Color.green(paramInt1), j, Color.green(paramInt2), i, k), a(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  public static int a(@ColorInt int paramInt1, @ColorInt int paramInt2, float paramFloat)
  {
    int i = Color.alpha(paramInt2);
    int j = 255;
    if (i == 255)
    {
      double d1 = b(c(paramInt1, 255), paramInt2);
      double d2 = paramFloat;
      if (d1 < d2) {
        return -1;
      }
      i = 0;
      int k = 0;
      while ((i <= 10) && (j - k > 1))
      {
        int m = (k + j) / 2;
        if (b(c(paramInt1, m), paramInt2) < d2) {
          k = m;
        } else {
          j = m;
        }
        i += 1;
      }
      return j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("background can not be translucent: #");
    ((StringBuilder)localObject).append(Integer.toHexString(paramInt2));
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  public static void a(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3, @NonNull double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 3)
    {
      double d1 = paramInt1;
      Double.isNaN(d1);
      d1 /= 255.0D;
      if (d1 < 0.04045D) {
        d1 /= 12.92D;
      } else {
        d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      }
      double d2 = paramInt2;
      Double.isNaN(d2);
      d2 /= 255.0D;
      if (d2 < 0.04045D) {
        d2 /= 12.92D;
      } else {
        d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      }
      double d3 = paramInt3;
      Double.isNaN(d3);
      d3 /= 255.0D;
      if (d3 < 0.04045D) {
        d3 /= 12.92D;
      } else {
        d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D);
      }
      paramArrayOfDouble[0] = ((0.4124D * d1 + 0.3576D * d2 + 0.1805D * d3) * 100.0D);
      paramArrayOfDouble[1] = ((0.2126D * d1 + 0.7152D * d2 + 0.0722D * d3) * 100.0D);
      paramArrayOfDouble[2] = ((d1 * 0.0193D + d2 * 0.1192D + d3 * 0.9505D) * 100.0D);
      return;
    }
    throw new IllegalArgumentException("outXyz must have a length of 3.");
  }
  
  public static void a(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3, @NonNull float[] paramArrayOfFloat)
  {
    float f1 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f5 = paramInt3 / 255.0F;
    float f6 = Math.max(f1, Math.max(f3, f5));
    float f7 = Math.min(f1, Math.min(f3, f5));
    float f2 = f6 - f7;
    float f4 = (f6 + f7) / 2.0F;
    if (f6 == f7)
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    else
    {
      if (f6 == f1) {
        f1 = (f3 - f5) / f2 % 6.0F;
      } else if (f6 == f3) {
        f1 = (f5 - f1) / f2 + 2.0F;
      } else {
        f1 = (f1 - f3) / f2 + 4.0F;
      }
      f2 /= (1.0F - Math.abs(2.0F * f4 - 1.0F));
    }
    f3 = f1 * 60.0F % 360.0F;
    f1 = f3;
    if (f3 < 0.0F) {
      f1 = f3 + 360.0F;
    }
    paramArrayOfFloat[0] = a(f1, 0.0F, 360.0F);
    paramArrayOfFloat[1] = a(f2, 0.0F, 1.0F);
    paramArrayOfFloat[2] = a(f4, 0.0F, 1.0F);
  }
  
  public static void a(@ColorInt int paramInt, @NonNull double[] paramArrayOfDouble)
  {
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfDouble);
  }
  
  public static void a(@ColorInt int paramInt, @NonNull float[] paramArrayOfFloat)
  {
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
  }
  
  private static double[] a()
  {
    double[] arrayOfDouble2 = (double[])a.get();
    double[] arrayOfDouble1 = arrayOfDouble2;
    if (arrayOfDouble2 == null)
    {
      arrayOfDouble1 = new double[3];
      a.set(arrayOfDouble1);
    }
    return arrayOfDouble1;
  }
  
  public static double b(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    if (Color.alpha(paramInt2) == 255)
    {
      int i = paramInt1;
      if (Color.alpha(paramInt1) < 255) {
        i = a(paramInt1, paramInt2);
      }
      double d1 = a(i) + 0.05D;
      double d2 = a(paramInt2) + 0.05D;
      return Math.max(d1, d2) / Math.min(d1, d2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("background can not be translucent: #");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @ColorInt
  public static int c(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 255)) {
      return paramInt1 & 0xFFFFFF | paramInt2 << 24;
    }
    throw new IllegalArgumentException("alpha must be between 0 and 255.");
  }
  
  private static int d(int paramInt1, int paramInt2)
  {
    return 255 - (255 - paramInt2) * (255 - paramInt1) / 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ColorUtils
 * JD-Core Version:    0.7.0.1
 */