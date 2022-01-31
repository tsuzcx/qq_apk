package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;

@TTNativeModule(name="NativeImageDecoder")
public class NativeImageDecoder
{
  private static int MAX_IMAGE_HEIGHT = 1024;
  private static int MAX_IMAGE_WIDTH = 1024;
  private static final String TAG = "NativeImageDecoder";
  
  @TTNativeCall
  public static Bitmap decodeGifBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    Bitmap localBitmap2 = decodeJpgBuffer(paramArrayOfByte, paramInt);
    if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
    {
      if (localBitmap2.getConfig() != Bitmap.Config.ARGB_8888)
      {
        Bitmap localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
        paramArrayOfByte = localBitmap1;
        if (localBitmap1 == null)
        {
          paramArrayOfByte = Bitmap.createBitmap(localBitmap2.getWidth(), localBitmap2.getHeight(), Bitmap.Config.ARGB_8888);
          new Canvas(paramArrayOfByte).drawBitmap(localBitmap2, 0.0F, 0.0F, null);
        }
        return paramArrayOfByte;
      }
      return localBitmap2;
    }
    return null;
  }
  
  @TTNativeCall
  public static Bitmap decodeJpgBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    return decodeJpgBuffer(paramArrayOfByte, paramInt, MAX_IMAGE_WIDTH * 2, MAX_IMAGE_HEIGHT * 2);
  }
  
  public static Bitmap decodeJpgBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
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
    catch (OutOfMemoryError paramArrayOfByte)
    {
      TTLog.e("NativeImageDecoder", "decodeJpgBuffer oom:" + paramArrayOfByte.getMessage());
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      TTLog.e("NativeImageDecoder", "decodeJpgBuffer failed:" + paramArrayOfByte.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.NativeImageDecoder
 * JD-Core Version:    0.7.0.1
 */