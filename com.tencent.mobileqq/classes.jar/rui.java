import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import java.io.IOException;
import java.lang.reflect.Array;

public class rui
{
  private static int a(int paramInt)
  {
    return Color.red(paramInt) * 38 + Color.green(paramInt) * 75 + Color.blue(paramInt) * 15 >> 7;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    paramLong1 ^= paramLong2;
    paramLong1 -= (paramLong1 >> 1 & 0x55555555);
    paramLong1 = (paramLong1 >> 2 & 0x33333333) + (paramLong1 & 0x33333333);
    return (int)((paramLong1 + (paramLong1 >> 4) & 0xF0F0F0F) * 72340172838076673L >> 56);
  }
  
  public static long a(Bitmap paramBitmap, boolean paramBoolean)
  {
    return a(a(a(a(paramBitmap, paramBoolean, 32), 32), 32));
  }
  
  private static long a(double[] paramArrayOfDouble)
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
  
  private static Bitmap a(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    if (paramBitmap == null) {
      throw new IOException("invalid image");
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == 0) || (j == 0)) {
      throw new IOException("invalid image");
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat / i, paramFloat / j);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  private static double[] a(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = a(paramArrayOfInt, paramInt);
    double[] arrayOfDouble = new double[64];
    paramInt = 0;
    while (paramInt < 8)
    {
      System.arraycopy(paramArrayOfInt[paramInt], 0, arrayOfDouble, paramInt * 8, 8);
      paramInt += 1;
    }
    return arrayOfDouble;
  }
  
  private static int[] a(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = new int[paramInt * paramInt];
    paramBitmap.getPixels(arrayOfInt, 0, paramInt, 0, 0, paramInt, paramInt);
    paramBitmap.recycle();
    paramInt = i;
    while (paramInt < arrayOfInt.length)
    {
      i = a(arrayOfInt[paramInt]);
      arrayOfInt[paramInt] = Color.rgb(i, i, i);
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  private static double[][] a(int paramInt)
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
  
  private static double[][] a(int[] paramArrayOfInt, int paramInt)
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
    paramArrayOfInt = a(paramInt);
    double[][] arrayOfDouble2 = a(paramArrayOfInt, paramInt);
    return a(a(paramArrayOfInt, arrayOfDouble1, paramInt), arrayOfDouble2, paramInt);
  }
  
  private static double[][] a(double[][] paramArrayOfDouble, int paramInt)
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
  
  private static double[][] a(double[][] paramArrayOfDouble1, double[][] paramArrayOfDouble2, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rui
 * JD-Core Version:    0.7.0.1
 */