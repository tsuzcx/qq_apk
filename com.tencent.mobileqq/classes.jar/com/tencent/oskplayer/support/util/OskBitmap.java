package com.tencent.oskplayer.support.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.util.Log;

public class OskBitmap
{
  public static final String TAG = "OskBitmap";
  
  public static int calculateInSampleSizeHigh(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i < paramInt2) {
          break;
        }
        j = i;
        if (m / i < paramInt1) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static int calculateInSampleSizeLow(BitmapFactory.Options paramOptions)
  {
    return calculateInSampleSizeLow(paramOptions, 720, 1280);
  }
  
  public static int calculateInSampleSizeLow(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      k /= 2;
      m /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt2 / 2) {
          break;
        }
        j = i;
        if (m / i <= paramInt1 / 2) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static void printDebugPixelValue(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject1 = "";
      Object localObject2 = localObject1;
      Object localObject3 = localObject2;
      Object localObject4 = localObject3;
      int i = 0;
      while (i < paramBitmap.getHeight())
      {
        localObject5 = localObject2;
        Object localObject6 = localObject1;
        int j = 0;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject3 = localObject5;
        localObject4 = localObject6;
        while (j < paramBitmap.getWidth())
        {
          int i1 = paramBitmap.getPixel(j, i);
          int k = Color.red(i1);
          int m = Color.blue(i1);
          int n = Color.green(i1);
          i1 = Color.alpha(i1);
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject4);
          ((StringBuilder)localObject5).append(k);
          ((StringBuilder)localObject5).append(",");
          localObject4 = ((StringBuilder)localObject5).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject3);
          ((StringBuilder)localObject5).append(n);
          ((StringBuilder)localObject5).append(",");
          localObject3 = ((StringBuilder)localObject5).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject2);
          ((StringBuilder)localObject5).append(m);
          ((StringBuilder)localObject5).append(",");
          localObject2 = ((StringBuilder)localObject5).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject1);
          ((StringBuilder)localObject5).append(i1);
          ((StringBuilder)localObject5).append(",");
          localObject1 = ((StringBuilder)localObject5).toString();
          j += 1;
        }
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject4);
        ((StringBuilder)localObject5).append("\n");
        localObject5 = ((StringBuilder)localObject5).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("\n");
        localObject3 = ((StringBuilder)localObject4).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append("\n");
        localObject6 = ((StringBuilder)localObject4).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("\n");
        localObject4 = ((StringBuilder)localObject2).toString();
        i += 1;
        localObject2 = localObject3;
        localObject3 = localObject6;
        localObject1 = localObject5;
      }
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("S:\n");
      ((StringBuilder)localObject5).append(paramBitmap.getWidth());
      ((StringBuilder)localObject5).append("*");
      ((StringBuilder)localObject5).append(paramBitmap.getHeight());
      Log.v("OskBitmap", ((StringBuilder)localObject5).toString());
      paramBitmap = new StringBuilder();
      paramBitmap.append("R:\n");
      paramBitmap.append((String)localObject1);
      Log.v("OskBitmap", paramBitmap.toString());
      paramBitmap = new StringBuilder();
      paramBitmap.append("G:\n");
      paramBitmap.append((String)localObject2);
      Log.v("OskBitmap", paramBitmap.toString());
      paramBitmap = new StringBuilder();
      paramBitmap.append("B:\n");
      paramBitmap.append((String)localObject3);
      Log.v("OskBitmap", paramBitmap.toString());
      paramBitmap = new StringBuilder();
      paramBitmap.append("A:\n");
      paramBitmap.append((String)localObject4);
      Log.v("OskBitmap", paramBitmap.toString());
      return;
    }
    Log.v("OskBitmap", "invalid bitmap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.support.util.OskBitmap
 * JD-Core Version:    0.7.0.1
 */