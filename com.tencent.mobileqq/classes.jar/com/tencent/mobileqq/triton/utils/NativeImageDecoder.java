package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;

public class NativeImageDecoder
{
  private static int a = 1024;
  private static int b = 1024;
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt1);
      int j = localOptions.outWidth;
      int k = localOptions.outHeight;
      if ((j > paramInt2) || (k > paramInt3)) {
        i = Math.min(Math.round(j / paramInt2), Math.round(k / paramInt3));
      }
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      TTLog.b("NativeImageDecoder", "decodeJpgBuffer failed:" + paramArrayOfByte.getMessage());
      return null;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      TTLog.b("NativeImageDecoder", "decodeJpgBuffer oom:" + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  @TTNativeCall
  public static Bitmap decodeGifBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    Bitmap localBitmap = decodeImageBuffer(paramArrayOfByte, paramInt);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramArrayOfByte = localBitmap.getConfig();
      Object localObject = Bitmap.Config.ARGB_8888;
      if (paramArrayOfByte != localObject)
      {
        localObject = localBitmap.copy((Bitmap.Config)localObject, true);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null)
        {
          paramArrayOfByte = Bitmap.createBitmap(localBitmap.getWidth(), localBitmap.getHeight(), Bitmap.Config.ARGB_8888);
          new Canvas(paramArrayOfByte).drawBitmap(localBitmap, 0.0F, 0.0F, null);
        }
        return paramArrayOfByte;
      }
      return localBitmap;
    }
    return null;
  }
  
  @TTNativeCall
  public static Bitmap decodeImageBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, paramInt, a * 2, b * 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.NativeImageDecoder
 * JD-Core Version:    0.7.0.1
 */