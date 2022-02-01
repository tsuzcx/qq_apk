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
    Object localObject = null;
    if (paramBitmap != null) {
      if (paramNinePatchParams == null) {
        return null;
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramNinePatchParams.a, paramNinePatchParams.b, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      NinePatch localNinePatch = a(paramBitmap, paramNinePatchParams);
      paramNinePatchParams = paramRect;
      if (paramRect == null) {
        paramNinePatchParams = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      localObject = localBitmap;
      if (localNinePatch != null)
      {
        localNinePatch.draw(localCanvas, paramNinePatchParams, new Paint(6));
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public static NinePatch a(Bitmap paramBitmap, NinePatchUtil.NinePatchParams paramNinePatchParams)
  {
    if (paramBitmap != null)
    {
      if (paramNinePatchParams == null) {
        return null;
      }
      paramNinePatchParams = a(paramBitmap, paramNinePatchParams);
      if ((paramNinePatchParams != null) && (NinePatch.isNinePatchChunk(paramNinePatchParams))) {
        return new NinePatch(paramBitmap, paramNinePatchParams, null);
      }
    }
    return null;
  }
  
  private static byte[] a(Bitmap paramBitmap, NinePatchUtil.NinePatchParams paramNinePatchParams)
  {
    if ((paramBitmap != null) && (paramNinePatchParams != null))
    {
      paramBitmap = new int[2];
      int j = paramNinePatchParams.c;
      int i = 0;
      paramBitmap[0] = j;
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.NinePatchUtil
 * JD-Core Version:    0.7.0.1
 */