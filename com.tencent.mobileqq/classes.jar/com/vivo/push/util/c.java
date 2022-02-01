package com.vivo.push.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public final class c
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    try
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
      return localObject;
    }
    catch (Exception localException) {}
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.c
 * JD-Core Version:    0.7.0.1
 */