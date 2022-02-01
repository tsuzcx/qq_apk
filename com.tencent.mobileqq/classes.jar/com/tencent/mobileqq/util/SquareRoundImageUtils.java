package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;

public final class SquareRoundImageUtils
{
  public static final DownloadParams.DecodeHandler a = new SquareRoundImageUtils.1();
  
  public static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (Exception|OutOfMemoryError paramConfig) {}
    return null;
  }
  
  public static Bitmap a(@NonNull Bitmap paramBitmap)
  {
    return a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static Bitmap a(@NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap1 = paramBitmap;
    if (paramBitmap.getWidth() > 0)
    {
      localBitmap1 = paramBitmap;
      if (paramBitmap.getHeight() > 0)
      {
        if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
          return paramBitmap;
        }
        Bitmap localBitmap2 = a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        localBitmap1 = paramBitmap;
        if (localBitmap2 != null) {
          localBitmap1 = a(paramBitmap, localBitmap2, paramInt1, paramInt2);
        }
      }
    }
    return localBitmap1;
  }
  
  public static Bitmap a(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return paramBitmap1;
      }
      paramBitmap2.setDensity((int)ViewUtils.c());
      Canvas localCanvas = new Canvas(paramBitmap2);
      Path localPath = a(paramInt1, paramInt2);
      BitmapShader localBitmapShader = new BitmapShader(paramBitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      localBitmapShader.setLocalMatrix(a(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramInt1, paramInt2));
      paramBitmap1 = new Paint();
      paramBitmap1.setShader(localBitmapShader);
      paramBitmap1.setAntiAlias(true);
      localCanvas.drawPath(localPath, paramBitmap1);
      return paramBitmap2;
    }
    return paramBitmap1;
  }
  
  @NonNull
  private static Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix localMatrix = new Matrix();
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return localMatrix;
    }
    float f1 = 0.0F;
    float f2;
    float f3;
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2)
    {
      f2 = paramInt4 / paramInt2;
      f1 = (paramInt3 - paramInt1 * f2) * 0.5F;
      f3 = 0.0F;
    }
    else
    {
      f2 = paramInt3 / paramInt1;
      f3 = (paramInt4 - paramInt2 * f2) * 0.5F;
    }
    localMatrix.setScale(f2, f2);
    localMatrix.postTranslate(Math.round(f1), Math.round(f3));
    return localMatrix;
  }
  
  @NonNull
  public static Path a(int paramInt1, int paramInt2)
  {
    Path localPath = new Path();
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return localPath;
      }
      float f1 = paramInt1;
      float f2 = paramInt2;
      float f3 = Math.min(f1 * 0.0618F, 0.0618F * f2);
      float f4 = f1 / 2.0F;
      float f5 = f2 / 2.0F;
      localPath.moveTo(0.0F, f5);
      localPath.cubicTo(0.0F, f3, f3, 0.0F, f4, 0.0F);
      float f6 = f1 - f3;
      localPath.cubicTo(f6, 0.0F, f1, f3, f1, f5);
      float f7 = f2 - f3;
      localPath.cubicTo(f1, f7, f6, f2, f4, f2);
      localPath.cubicTo(f3, f2, 0.0F, f7, 0.0F, f5);
    }
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SquareRoundImageUtils
 * JD-Core Version:    0.7.0.1
 */