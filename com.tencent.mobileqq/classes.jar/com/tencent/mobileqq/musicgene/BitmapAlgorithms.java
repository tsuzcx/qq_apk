package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.qphone.base.util.QLog;

public class BitmapAlgorithms
{
  private static int a(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = b(paramBitmap, paramInt1, paramInt2, paramInt3);
      if (localBitmap != null)
      {
        paramInt1 = (int)(localBitmap.getWidth() * 0.03F);
        paramInt2 = (int)(localBitmap.getHeight() * 0.03F);
        paramBitmap = localBitmap;
        if (paramInt2 > 0)
        {
          paramBitmap = Bitmap.createBitmap(localBitmap, paramInt1, paramInt2, localBitmap.getWidth() - (paramInt1 << 1), localBitmap.getHeight() - (paramInt2 << 1));
          if (!localBitmap.isRecycled()) {
            localBitmap.recycle();
          }
          return paramBitmap;
        }
      }
      else
      {
        paramBitmap = null;
      }
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      QLog.e("BitmapAlgorithms", 1, paramBitmap.toString());
    }
    return null;
  }
  
  private static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat)
  {
    paramFloat -= (int)paramFloat;
    float f = 1.0F / (2.0F * paramFloat + 1.0F);
    int i = 0;
    int j = 0;
    while (i < paramInt2)
    {
      paramArrayOfInt2[i] = paramArrayOfInt1[0];
      int m = i + paramInt2;
      int k = 1;
      int n;
      for (;;)
      {
        n = paramInt1 - 1;
        if (k >= n) {
          break;
        }
        int i1 = j + k;
        int i3 = paramArrayOfInt1[(i1 - 1)];
        n = paramArrayOfInt1[i1];
        int i5 = paramArrayOfInt1[(i1 + 1)];
        int i4 = (int)(((i3 >> 24 & 0xFF) + (i5 >> 24 & 0xFF)) * paramFloat);
        i1 = (int)(((i3 >> 16 & 0xFF) + (i5 >> 16 & 0xFF)) * paramFloat);
        int i2 = (int)(((i3 >> 8 & 0xFF) + (i5 >> 8 & 0xFF)) * paramFloat);
        i3 = (int)(((i3 & 0xFF) + (i5 & 0xFF)) * paramFloat);
        i4 = (int)(((n >> 24 & 0xFF) + i4) * f);
        paramArrayOfInt2[m] = ((int)(((n >> 16 & 0xFF) + i1) * f) << 16 | i4 << 24 | (int)(((n >> 8 & 0xFF) + i2) * f) << 8 | (int)(((n & 0xFF) + i3) * f));
        m += paramInt2;
        k += 1;
      }
      paramArrayOfInt2[m] = paramArrayOfInt1[n];
      j += paramInt1;
      i += 1;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Bitmap localBitmap1 = null;
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap2 = localBitmap1;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      int j = paramBitmap.getWidth();
      localBitmap2 = localBitmap1;
      localObject1 = localObject3;
      localObject2 = localObject4;
      int k = paramBitmap.getHeight();
      int i = j * k;
      localBitmap2 = localBitmap1;
      localObject1 = localObject3;
      localObject2 = localObject4;
      int[] arrayOfInt1 = new int[i];
      localBitmap2 = localBitmap1;
      localObject1 = localObject3;
      localObject2 = localObject4;
      int[] arrayOfInt2 = new int[i];
      localBitmap2 = localBitmap1;
      localObject1 = localObject3;
      localObject2 = localObject4;
      localBitmap1 = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      localBitmap2 = localBitmap1;
      localObject1 = localBitmap1;
      localObject2 = localBitmap1;
      paramBitmap.getPixels(arrayOfInt1, 0, j, 0, 0, j, k);
      i = 0;
      while (i < paramInt1)
      {
        localBitmap2 = localBitmap1;
        localObject1 = localBitmap1;
        localObject2 = localBitmap1;
        b(arrayOfInt1, arrayOfInt2, j, k, paramInt2);
        localBitmap2 = localBitmap1;
        localObject1 = localBitmap1;
        localObject2 = localBitmap1;
        b(arrayOfInt2, arrayOfInt1, k, j, paramInt3);
        i += 1;
      }
      localBitmap2 = localBitmap1;
      localObject1 = localBitmap1;
      localObject2 = localBitmap1;
      a(arrayOfInt1, arrayOfInt2, j, k, paramInt2);
      localBitmap2 = localBitmap1;
      localObject1 = localBitmap1;
      localObject2 = localBitmap1;
      a(arrayOfInt2, arrayOfInt1, k, j, paramInt3);
      localBitmap2 = localBitmap1;
      localObject1 = localBitmap1;
      localObject2 = localBitmap1;
      localBitmap1.setPixels(arrayOfInt1, 0, j, 0, 0, j, k);
      return localBitmap1;
    }
    catch (Error paramBitmap)
    {
      QLog.e("BitmapAlgorithms", 1, paramBitmap.toString());
      return localBitmap2;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("BitmapAlgorithms", 1, paramBitmap.toString());
      return localObject1;
    }
    catch (Exception paramBitmap)
    {
      QLog.e("BitmapAlgorithms", 1, paramBitmap.toString());
    }
    return localObject2;
  }
  
  private static void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, float paramFloat)
  {
    int i2 = paramInt1 - 1;
    int i8 = (int)paramFloat;
    int j = i8 * 2 + 1;
    int k = j * 256;
    int[] arrayOfInt = new int[k];
    int i = 0;
    while (i < k)
    {
      arrayOfInt[i] = (i / j);
      i += 1;
    }
    i = 0;
    int i1 = 0;
    while (i < paramInt2)
    {
      int i3 = -i8;
      j = 0;
      k = 0;
      int m = 0;
      int n = 0;
      while (i3 <= i8)
      {
        i4 = paramArrayOfInt1[(a(i3, 0, i2) + i1)];
        j += (i4 >> 24 & 0xFF);
        k += (i4 >> 16 & 0xFF);
        m += (i4 >> 8 & 0xFF);
        n += (i4 & 0xFF);
        i3 += 1;
      }
      int i6 = 0;
      i3 = k;
      int i4 = i;
      k = n;
      n = i3;
      int i5 = j;
      i3 = i6;
      j = i2;
      while (i3 < paramInt1)
      {
        paramArrayOfInt2[i4] = (arrayOfInt[i5] << 24 | arrayOfInt[n] << 16 | arrayOfInt[m] << 8 | arrayOfInt[k]);
        i6 = i3 + i8 + 1;
        i2 = i6;
        if (i6 > j) {
          i2 = j;
        }
        int i7 = i3 - i8;
        i6 = i7;
        if (i7 < 0) {
          i6 = 0;
        }
        i2 = paramArrayOfInt1[(i2 + i1)];
        i6 = paramArrayOfInt1[(i6 + i1)];
        i5 += (i2 >> 24 & 0xFF) - (i6 >> 24 & 0xFF);
        n += ((i2 & 0xFF0000) - (0xFF0000 & i6) >> 16);
        m += ((i2 & 0xFF00) - (0xFF00 & i6) >> 8);
        k += (i2 & 0xFF) - (i6 & 0xFF);
        i4 += paramInt2;
        i3 += 1;
      }
      i1 += paramInt1;
      i += 1;
      i2 = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.BitmapAlgorithms
 * JD-Core Version:    0.7.0.1
 */