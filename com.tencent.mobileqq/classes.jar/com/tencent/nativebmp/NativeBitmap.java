package com.tencent.nativebmp;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.nio.ByteBuffer;

public class NativeBitmap
{
  private static final String LIB_NAME = "qflutter-resource-loader";
  private static final String TAG = "NativeBitmap";
  
  public static long getBitmapPixelDataMemoryPtr(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return 0L;
    }
    try
    {
      long l = nativeGetBitmapPixelDataMemoryPtr(paramBitmap);
      return l;
    }
    catch (Throwable paramBitmap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapPixelDataMemoryPtr error:");
      localStringBuilder.append(paramBitmap.getMessage());
      Log.e("NativeBitmap", localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static long getByteBufferPtr(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return 0L;
    }
    try
    {
      long l = nativeGetByteBufferPtr(paramByteBuffer);
      return l;
    }
    catch (Throwable paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getByteBufferPtr error:");
      localStringBuilder.append(paramByteBuffer.getMessage());
      Log.e("NativeBitmap", localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static void init(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (new File(paramString).exists())
      {
        System.load(paramString);
        return;
      }
      System.loadLibrary("qflutter-resource-loader");
      return;
    }
    System.loadLibrary("qflutter-resource-loader");
  }
  
  public static native long nativeGetBitmapPixelDataMemoryPtr(Bitmap paramBitmap);
  
  public static native long nativeGetByteBufferPtr(ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.nativebmp.NativeBitmap
 * JD-Core Version:    0.7.0.1
 */