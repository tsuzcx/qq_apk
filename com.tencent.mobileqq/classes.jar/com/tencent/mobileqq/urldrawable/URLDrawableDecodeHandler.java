package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams.DecodeHandler;

public abstract class URLDrawableDecodeHandler
  implements DownloadParams.DecodeHandler
{
  private static String a = "URLDrawableDecodeHandler";
  public static final DownloadParams.DecodeHandler b = new URLDrawableDecodeHandler.1();
  public static final DownloadParams.DecodeHandler c = new URLDrawableDecodeHandler.2();
  public static final DownloadParams.DecodeHandler d = new URLDrawableDecodeHandler.3();
  public static final DownloadParams.DecodeHandler e = new URLDrawableDecodeHandler.4();
  public static final DownloadParams.DecodeHandler f = new URLDrawableDecodeHandler.5();
  public static final DownloadParams.DecodeHandler g = new URLDrawableDecodeHandler.6();
  public static final DownloadParams.DecodeHandler h = new URLDrawableDecodeHandler.7();
  public static final DownloadParams.DecodeHandler i = new URLDrawableDecodeHandler.8();
  public static final DownloadParams.DecodeHandler j = new URLDrawableDecodeHandler.9();
  public static final DownloadParams.DecodeHandler k = new URLDrawableDecodeHandler.10();
  public static final DownloadParams.DecodeHandler l = new URLDrawableDecodeHandler.11();
  public static final DownloadParams.DecodeHandler m = new URLDrawableDecodeHandler.12();
  public static final DownloadParams.DecodeHandler n = new URLDrawableDecodeHandler.13();
  public static final DownloadParams.DecodeHandler o = new URLDrawableDecodeHandler.14();
  public static final DownloadParams.DecodeHandler p = new URLDrawableDecodeHandler.15();
  public static final DownloadParams.DecodeHandler q = new URLDrawableDecodeHandler.16();
  public static final DownloadParams.DecodeHandler r = new URLDrawableDecodeHandler.17();
  public static final DownloadParams.DecodeHandler s = new URLDrawableDecodeHandler.FastBlurDecoder(10);
  public static final DownloadParams.DecodeHandler t = new URLDrawableDecodeHandler.FastBlurDecoder(20);
  public static final DownloadParams.DecodeHandler u = new URLDrawableDecodeHandler.18();
  public static final DownloadParams.DecodeHandler v = new URLDrawableDecodeHandler.19();
  public static final DownloadParams.DecodeHandler w = new URLDrawableDecodeHandler.ReadInJoyVideoFeedsFastBlurDecoder();
  public static final DownloadParams.DecodeHandler x = new URLDrawableDecodeHandler.20();
  public static final DownloadParams.DecodeHandler y = new URLDrawableDecodeHandler.21();
  public static final DownloadParams.DecodeHandler z = new URLDrawableDecodeHandler.22();
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i3 = i1 * 15 / 16;
    int i4 = i2 * 16 / 15;
    Bitmap localBitmap;
    if (i2 > i3)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, (i2 - i3) / 2, i1, i3, null, false);
      paramBitmap.recycle();
      return localBitmap;
    }
    if (i1 > i4)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, (i1 - i4) / 2, 0, i4, i2, null, false);
      paramBitmap.recycle();
      return localBitmap;
    }
    return paramBitmap;
  }
  
  public static void a(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2)
    {
      f1 = paramInt4;
      f2 = paramInt2;
    }
    else
    {
      f1 = paramInt3;
      f2 = paramInt1;
    }
    float f2 = f1 / f2;
    float f5 = paramInt3 * 0.5F;
    float f3 = paramInt4 * 0.5F;
    paramInt1 = (int)(paramInt1 * f2);
    paramInt2 = (int)(paramInt2 * f2);
    paramFloat1 *= paramInt1;
    float f4 = paramFloat2 * paramInt2;
    float f1 = 0.0F;
    if ((paramInt1 > paramInt3) && (paramFloat1 > f5)) {
      paramFloat1 = Math.min(paramInt1 - paramInt3, paramFloat1 - f5);
    } else {
      paramFloat1 = 0.0F;
    }
    paramFloat2 = f1;
    if (paramInt2 > paramInt4)
    {
      paramFloat2 = f1;
      if (f4 > f3) {
        paramFloat2 = Math.min(paramInt2 - paramInt4, f4 - f3);
      }
    }
    localMatrix.setScale(f2, f2);
    localMatrix.postTranslate((int)(paramFloat1 + 0.5F) * -1, (int)(paramFloat2 + 0.5F) * -1);
  }
  
  public static final int[] a(int paramInt1, int paramInt2)
  {
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new int[] { paramInt1, paramInt2, paramInt3 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return new int[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6 };
  }
  
  public static final int[] b(int paramInt1, int paramInt2, int paramInt3)
  {
    return new int[] { paramInt1, paramInt2, paramInt3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler
 * JD-Core Version:    0.7.0.1
 */