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
  private static final String TAG = "TAVImageFactory";
  
  @Nullable
  private static Bitmap checkBitmapConfig(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      try
      {
        if (paramBitmap.getConfig() != null)
        {
          if (Arrays.binarySearch(SUPPORT_CONFIGS, paramBitmap.getConfig()) < 0)
          {
            paramBitmap = transcodeBitmap(paramBitmap);
            return paramBitmap;
          }
          return paramBitmap;
        }
      }
      finally {}
    }
    return null;
  }
  
  /* Error */
  @Nullable
  public static Bitmap fixSupportImageConfig(@Nullable Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 58	com/tencent/tav/decoder/TAVImageFactory:checkBitmapConfig	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   7: astore_0
    //   8: ldc 2
    //   10: monitorexit
    //   11: aload_0
    //   12: areturn
    //   13: astore_0
    //   14: goto +17 -> 31
    //   17: astore_0
    //   18: ldc 10
    //   20: ldc 60
    //   22: aload_0
    //   23: invokestatic 66	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: aconst_null
    //   30: areturn
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   3	8	13	finally
    //   18	26	13	finally
    //   3	8	17	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.TAVImageFactory
 * JD-Core Version:    0.7.0.1
 */