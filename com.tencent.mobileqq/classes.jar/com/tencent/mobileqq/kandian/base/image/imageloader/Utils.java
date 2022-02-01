package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class Utils
{
  public static int a(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  @TargetApi(19)
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (a()) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RuntimeException localRuntimeException = new RuntimeException("getStack");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(localRuntimeException.getStackTrace()[2].getMethodName());
      a(paramString1, localStringBuilder.toString());
      return;
    }
    a(paramString1, paramString2);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  @TargetApi(19)
  public static boolean a(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramBitmap != null)
    {
      bool1 = bool3;
      if (!paramBitmap.isRecycled())
      {
        if (!paramBitmap.isMutable()) {
          return false;
        }
        if ((b()) && (!a(paramOptions)))
        {
          double d1 = paramOptions.outWidth;
          Double.isNaN(d1);
          double d2 = paramOptions.inSampleSize;
          Double.isNaN(d2);
          int i = (int)Math.ceil(d1 * 1.0D / d2);
          d1 = paramOptions.outHeight;
          Double.isNaN(d1);
          d2 = paramOptions.inSampleSize;
          Double.isNaN(d2);
          bool1 = bool2;
          if (i * (int)Math.ceil(d1 * 1.0D / d2) * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool3;
        if (paramBitmap.getWidth() == paramOptions.outWidth)
        {
          bool1 = bool3;
          if (paramBitmap.getHeight() == paramOptions.outHeight)
          {
            bool1 = bool3;
            if (paramOptions.inSampleSize == 1) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.outWidth > 2048) || (paramOptions.outHeight > 2048);
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.Utils
 * JD-Core Version:    0.7.0.1
 */