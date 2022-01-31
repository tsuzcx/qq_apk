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
    String str4 = "";
    String str3 = "";
    String str2 = "";
    String str1 = "";
    if (paramBitmap != null)
    {
      int i = 0;
      while (i < paramBitmap.getHeight())
      {
        int j = 0;
        while (j < paramBitmap.getWidth())
        {
          int i1 = paramBitmap.getPixel(j, i);
          int k = Color.red(i1);
          int m = Color.blue(i1);
          int n = Color.green(i1);
          i1 = Color.alpha(i1);
          str4 = str4 + k + ",";
          str3 = str3 + n + ",";
          str2 = str2 + m + ",";
          str1 = str1 + i1 + ",";
          j += 1;
        }
        str4 = str4 + "\n";
        str3 = str3 + "\n";
        str2 = str2 + "\n";
        str1 = str1 + "\n";
        i += 1;
      }
      Log.v("OskBitmap", "S:\n" + paramBitmap.getWidth() + "*" + paramBitmap.getHeight());
      Log.v("OskBitmap", "R:\n" + str4);
      Log.v("OskBitmap", "G:\n" + str3);
      Log.v("OskBitmap", "B:\n" + str2);
      Log.v("OskBitmap", "A:\n" + str1);
      return;
    }
    Log.v("OskBitmap", "invalid bitmap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.support.util.OskBitmap
 * JD-Core Version:    0.7.0.1
 */