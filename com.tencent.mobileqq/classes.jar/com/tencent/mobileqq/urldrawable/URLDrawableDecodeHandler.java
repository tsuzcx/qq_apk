package com.tencent.mobileqq.urldrawable;

import ajkg;
import ajkh;
import ajki;
import ajkj;
import ajkk;
import ajkl;
import ajkm;
import ajkn;
import ajko;
import ajkp;
import ajkq;
import ajkr;
import ajks;
import ajkt;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.image.DownloadParams.DecodeHandler;

public abstract class URLDrawableDecodeHandler
  implements DownloadParams.DecodeHandler
{
  public static final DownloadParams.DecodeHandler a;
  private static String a;
  public static final DownloadParams.DecodeHandler b = new ajkm();
  public static final DownloadParams.DecodeHandler c = new ajkn();
  public static final DownloadParams.DecodeHandler d = new ajko();
  public static final DownloadParams.DecodeHandler e = new ajkp();
  public static final DownloadParams.DecodeHandler f = new ajkq();
  public static final DownloadParams.DecodeHandler g = new ajkr();
  public static final DownloadParams.DecodeHandler h = new ajks();
  public static final DownloadParams.DecodeHandler i = new ajkt();
  public static final DownloadParams.DecodeHandler j = new ajkh();
  public static final DownloadParams.DecodeHandler k = new ajki();
  public static final DownloadParams.DecodeHandler l = new ajkj();
  public static final DownloadParams.DecodeHandler m = new ajkk();
  public static final DownloadParams.DecodeHandler n = new URLDrawableDecodeHandler.FastBlurDecoder(10);
  public static final DownloadParams.DecodeHandler o = new URLDrawableDecodeHandler.FastBlurDecoder(20);
  public static final DownloadParams.DecodeHandler p = new ajkl();
  
  static
  {
    jdField_a_of_type_JavaLangString = "URLDrawableDecodeHandler";
    jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new ajkg();
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i3 = i1 * 15 / 16;
    int i4 = i2 * 16 / 15;
    if (i2 > i3)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, (i2 - i3) / 2, i1, i3, null, false);
      paramBitmap.recycle();
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap;
    } while (i1 <= i4);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, (i1 - i4) / 2, 0, i4, i2, null, false);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    Object localObject = new int[i3 * i4];
    paramBitmap.getPixels((int[])localObject, 0, i3, 0, 0, i3, i4);
    int i5 = (int)Math.ceil(i4 / paramInt);
    int i6 = (int)Math.ceil(i3 / paramInt);
    int i1 = 0;
    while (i1 < i5)
    {
      int i2 = 0;
      while (i2 < i6)
      {
        a((int[])localObject, i2 * paramInt + 1, i1 * paramInt + 1, paramInt, i3, i4);
        i2 += 1;
      }
      i1 += 1;
    }
    paramBitmap.recycle();
    paramBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
    paramBitmap.setPixels((int[])localObject, 0, i3, 0, 0, i3, i4);
    localObject = new Canvas();
    ((Canvas)localObject).setBitmap(paramBitmap);
    ((Canvas)localObject).drawARGB(89, 0, 0, 0);
    return paramBitmap;
  }
  
  public static void a(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2) {}
    for (float f1 = paramInt4 / paramInt2;; f1 = paramInt3 / paramInt1)
    {
      float f5 = paramInt3 * 0.5F;
      float f4 = paramInt4 * 0.5F;
      float f3 = 0.0F;
      float f2 = 0.0F;
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(paramInt2 * f1);
      float f7 = paramInt1 * paramFloat1;
      float f6 = paramInt2 * paramFloat2;
      paramFloat1 = f3;
      if (paramInt1 > paramInt3)
      {
        paramFloat1 = f3;
        if (f7 > f5) {
          paramFloat1 = Math.min(paramInt1 - paramInt3, f7 - f5);
        }
      }
      paramFloat2 = f2;
      if (paramInt2 > paramInt4)
      {
        paramFloat2 = f2;
        if (f6 > f4) {
          paramFloat2 = Math.min(paramInt2 - paramInt4, f6 - f4);
        }
      }
      localMatrix.setScale(f1, f1);
      localMatrix.postTranslate((int)(paramFloat1 + 0.5F) * -1, (int)(paramFloat2 + 0.5F) * -1);
      return;
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i1 = paramInt1 + paramInt3 - 1;
    int i2 = paramInt2 + paramInt3 - 1;
    paramInt3 = i1;
    if (i1 > paramInt4) {
      paramInt3 = paramInt4;
    }
    if (i2 > paramInt5) {}
    for (;;)
    {
      i2 = paramArrayOfInt[((paramInt3 - paramInt1 + 1) / 2 + paramInt1 + ((paramInt5 - paramInt2 + 1) / 2 + paramInt2 - 1) * paramInt4 - 1)];
      while (paramInt2 <= paramInt5)
      {
        i1 = paramInt1;
        while (i1 <= paramInt3)
        {
          paramArrayOfInt[((paramInt2 - 1) * paramInt4 + i1 - 1)] = i2;
          i1 += 1;
        }
        paramInt2 += 1;
      }
      return;
      paramInt5 = i2;
    }
  }
  
  public static final int[] a(int paramInt1, int paramInt2)
  {
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static final int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new int[] { paramInt1, paramInt2, paramInt3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler
 * JD-Core Version:    0.7.0.1
 */