package com.tencent.mobileqq.vas;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VasPalette
{
  private static int a = 57600;
  private static int b = -1;
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    double d2 = -1.0D;
    int i;
    double d1;
    if (a > 0)
    {
      i = paramBitmap.getWidth() * paramBitmap.getHeight();
      d1 = d2;
      if (i > a) {
        d1 = Math.sqrt(a / i);
      }
    }
    while (d1 <= 0.0D)
    {
      return paramBitmap;
      d1 = d2;
      if (b > 0)
      {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        d1 = d2;
        if (i > b) {
          d1 = b / i;
        }
      }
    }
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(d1 * paramBitmap.getHeight()), false);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("VasPalette", 1, "scaleBitmapDown failed.", paramBitmap);
    }
    return null;
  }
  
  public static List a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = a(paramBitmap);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        VasPalette.OcTreeQuantizer localOcTreeQuantizer = new VasPalette.OcTreeQuantizer();
        try
        {
          localOcTreeQuantizer.a(a(paramBitmap), 16);
          paramBitmap.recycle();
          return localOcTreeQuantizer.a();
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            QLog.e("VasPalette", 1, localOutOfMemoryError.getMessage());
          }
        }
      }
    }
    return null;
  }
  
  private static int[] a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int[] arrayOfInt = new int[i * j];
    paramBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette
 * JD-Core Version:    0.7.0.1
 */