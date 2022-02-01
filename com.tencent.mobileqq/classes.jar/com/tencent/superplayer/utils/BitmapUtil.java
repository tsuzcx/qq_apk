package com.tencent.superplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.IOException;

public class BitmapUtil
{
  public static Bitmap scaleBitmap(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    if (paramBitmap == null) {
      throw new IOException("invalid image");
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == 0) || (j == 0)) {
      throw new IOException("invalid image");
    }
    if ((i == paramFloat) && (j == paramFloat)) {
      return paramBitmap;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat / i, paramFloat / j);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.utils.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */