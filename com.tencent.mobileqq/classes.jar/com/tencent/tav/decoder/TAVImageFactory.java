package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import java.util.Arrays;

public class TAVImageFactory
{
  private static Bitmap.Config[] SUPPORT_CONFIGS = { Bitmap.Config.ALPHA_8, Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444, Bitmap.Config.ARGB_8888 };
  
  @Nullable
  private static Bitmap checkBitmapConfig(@Nullable Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap == null) {
      localBitmap = null;
    }
    for (;;)
    {
      return localBitmap;
      localBitmap = paramBitmap;
      try
      {
        if (Arrays.binarySearch(SUPPORT_CONFIGS, paramBitmap.getConfig()) >= 0) {
          continue;
        }
        localBitmap = transcodeBitmap(paramBitmap);
      }
      finally {}
    }
  }
  
  @Nullable
  public static Bitmap fixSupportImageConfig(@Nullable Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = checkBitmapConfig(paramBitmap);
      return paramBitmap;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  private static Bitmap transcodeBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.TAVImageFactory
 * JD-Core Version:    0.7.0.1
 */