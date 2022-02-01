package com.tencent.mobileqq.vas.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class NinePatchUtil
{
  public static Bitmap a(Bitmap paramBitmap, NinePatchUtil.NinePatchParams paramNinePatchParams, Rect paramRect)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    if (paramBitmap != null)
    {
      if (paramNinePatchParams != null) {
        break label19;
      }
      localBitmap1 = localBitmap2;
    }
    for (;;)
    {
      return localBitmap1;
      try
      {
        label19:
        localBitmap2 = Bitmap.createBitmap(paramNinePatchParams.a, paramNinePatchParams.b, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap2);
        NinePatch localNinePatch = a(paramBitmap, paramNinePatchParams);
        paramNinePatchParams = paramRect;
        if (paramRect == null) {
          paramNinePatchParams = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        }
        localBitmap1 = localBitmap2;
        if (localNinePatch != null)
        {
          localNinePatch.draw(localCanvas, paramNinePatchParams, new Paint(6));
          return localBitmap2;
        }
      }
      catch (OutOfMemoryError paramBitmap) {}
    }
    return null;
  }
  
  public static NinePatch a(Bitmap paramBitmap, NinePatchUtil.NinePatchParams paramNinePatchParams)
  {
    if ((paramBitmap == null) || (paramNinePatchParams == null)) {
      return null;
    }
    paramNinePatchParams = a(paramBitmap, paramNinePatchParams);
    if ((paramNinePatchParams != null) && (NinePatch.isNinePatchChunk(paramNinePatchParams))) {
      return new NinePatch(paramBitmap, paramNinePatchParams, null);
    }
    return null;
  }
  
  private static byte[] a(Bitmap paramBitmap, NinePatchUtil.NinePatchParams paramNinePatchParams)
  {
    int i = 0;
    if ((paramBitmap == null) || (paramNinePatchParams == null)) {
      return null;
    }
    paramBitmap = new int[2];
    paramBitmap[0] = paramNinePatchParams.c;
    paramBitmap[1] = (paramNinePatchParams.c + paramNinePatchParams.d);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramNinePatchParams.e;
    arrayOfInt[1] = (paramNinePatchParams.e + paramNinePatchParams.f);
    paramNinePatchParams = ByteBuffer.allocate(paramBitmap.length * 4 + arrayOfInt.length * 4 + 36 + 32).order(ByteOrder.nativeOrder());
    paramNinePatchParams.put((byte)1);
    paramNinePatchParams.put((byte)2);
    paramNinePatchParams.put((byte)2);
    paramNinePatchParams.put((byte)9);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(0);
    paramNinePatchParams.putInt(paramBitmap[0]);
    paramNinePatchParams.putInt(paramBitmap[1]);
    paramNinePatchParams.putInt(arrayOfInt[0]);
    paramNinePatchParams.putInt(arrayOfInt[1]);
    while (i < 9)
    {
      paramNinePatchParams.putInt(1);
      i += 1;
    }
    return paramNinePatchParams.array();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.NinePatchUtil
 * JD-Core Version:    0.7.0.1
 */