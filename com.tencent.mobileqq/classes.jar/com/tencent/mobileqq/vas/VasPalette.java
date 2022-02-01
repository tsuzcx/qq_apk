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
    int i = a;
    double d2 = -1.0D;
    int j;
    double d1;
    if (i > 0)
    {
      i = paramBitmap.getWidth() * paramBitmap.getHeight();
      j = a;
      d1 = d2;
      if (i > j)
      {
        d1 = j;
        d2 = i;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 = Math.sqrt(d1 / d2);
      }
    }
    else
    {
      d1 = d2;
      if (b > 0)
      {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        j = b;
        d1 = d2;
        if (i > j)
        {
          d1 = j;
          d2 = i;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
        }
      }
    }
    if (d1 <= 0.0D) {
      return paramBitmap;
    }
    try
    {
      i = paramBitmap.getWidth();
      d2 = i;
      Double.isNaN(d2);
      i = (int)Math.ceil(d2 * d1);
      j = paramBitmap.getHeight();
      d2 = j;
      Double.isNaN(d2);
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, (int)Math.ceil(d2 * d1), false);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("VasPalette", 1, "scaleBitmapDown failed.", paramBitmap);
    }
    return null;
  }
  
  public static List<VasPalette.OcNode> a(Bitmap paramBitmap)
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
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("VasPalette", 1, localOutOfMemoryError.getMessage());
        }
        paramBitmap.recycle();
        return localOcTreeQuantizer.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasPalette
 * JD-Core Version:    0.7.0.1
 */