package com.tencent.mobileqq.dinifly.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.content.TrimPathContent;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class Utils
{
  private static final float INV_SQRT_2 = (float)(Math.sqrt(2.0D) / 2.0D);
  public static final int SECOND_IN_NANOS = 1000000000;
  private static DisplayMetrics displayMetrics;
  private static float dpScale = -1.0F;
  private static final ThreadLocal<PathMeasure> threadLocalPathMeasure = new Utils.1();
  private static final ThreadLocal<float[]> threadLocalPoints;
  private static final ThreadLocal<Path> threadLocalTempPath = new Utils.2();
  private static final ThreadLocal<Path> threadLocalTempPath2 = new Utils.3();
  
  static
  {
    threadLocalPoints = new Utils.4();
  }
  
  public static void applyTrimPathIfNeeded(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    L.beginSection("applyTrimPathIfNeeded");
    PathMeasure localPathMeasure = (PathMeasure)threadLocalPathMeasure.get();
    Path localPath1 = (Path)threadLocalTempPath.get();
    Path localPath2 = (Path)threadLocalTempPath2.get();
    localPathMeasure.setPath(paramPath, false);
    float f2 = localPathMeasure.getLength();
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 0.0F))
    {
      L.endSection("applyTrimPathIfNeeded");
      return;
    }
    if ((f2 >= 1.0F) && (Math.abs(paramFloat2 - paramFloat1 - 1.0F) >= 0.01D))
    {
      float f1 = paramFloat1 * f2;
      paramFloat2 *= f2;
      paramFloat1 = Math.min(f1, paramFloat2);
      f1 = Math.max(f1, paramFloat2);
      paramFloat3 *= f2;
      paramFloat2 = paramFloat1 + paramFloat3;
      f1 += paramFloat3;
      paramFloat3 = paramFloat2;
      paramFloat1 = f1;
      if (paramFloat2 >= f2)
      {
        paramFloat3 = paramFloat2;
        paramFloat1 = f1;
        if (f1 >= f2)
        {
          paramFloat3 = MiscUtils.floorMod(paramFloat2, f2);
          paramFloat1 = MiscUtils.floorMod(f1, f2);
        }
      }
      paramFloat2 = paramFloat3;
      if (paramFloat3 < 0.0F) {
        paramFloat2 = MiscUtils.floorMod(paramFloat3, f2);
      }
      paramFloat3 = paramFloat1;
      if (paramFloat1 < 0.0F) {
        paramFloat3 = MiscUtils.floorMod(paramFloat1, f2);
      }
      if (paramFloat2 == paramFloat3)
      {
        paramPath.reset();
        L.endSection("applyTrimPathIfNeeded");
        return;
      }
      paramFloat1 = paramFloat2;
      if (paramFloat2 >= paramFloat3) {
        paramFloat1 = paramFloat2 - f2;
      }
      localPath1.reset();
      localPathMeasure.getSegment(paramFloat1, paramFloat3, localPath1, true);
      if (paramFloat3 > f2)
      {
        localPath2.reset();
        localPathMeasure.getSegment(0.0F, paramFloat3 % f2, localPath2, true);
        localPath1.addPath(localPath2);
      }
      else if (paramFloat1 < 0.0F)
      {
        localPath2.reset();
        localPathMeasure.getSegment(paramFloat1 + f2, f2, localPath2, true);
        localPath1.addPath(localPath2);
      }
      paramPath.set(localPath1);
      L.endSection("applyTrimPathIfNeeded");
      return;
    }
    L.endSection("applyTrimPathIfNeeded");
  }
  
  public static void applyTrimPathIfNeeded(Path paramPath, @Nullable TrimPathContent paramTrimPathContent)
  {
    if (paramTrimPathContent != null)
    {
      if (paramTrimPathContent.isHidden()) {
        return;
      }
      float f1 = ((FloatKeyframeAnimation)paramTrimPathContent.getStart()).getFloatValue();
      float f2 = ((FloatKeyframeAnimation)paramTrimPathContent.getEnd()).getFloatValue();
      float f3 = ((FloatKeyframeAnimation)paramTrimPathContent.getOffset()).getFloatValue();
      applyTrimPathIfNeeded(paramPath, f1 / 100.0F, f2 / 100.0F, f3 / 360.0F);
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static Path createPath(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramPointF1.x, paramPointF1.y);
    if ((paramPointF3 != null) && (paramPointF4 != null) && ((paramPointF3.length() != 0.0F) || (paramPointF4.length() != 0.0F)))
    {
      float f = paramPointF1.x;
      localPath.cubicTo(paramPointF3.x + f, paramPointF1.y + paramPointF3.y, paramPointF2.x + paramPointF4.x, paramPointF2.y + paramPointF4.y, paramPointF2.x, paramPointF2.y);
      return localPath;
    }
    localPath.lineTo(paramPointF2.x, paramPointF2.y);
    return localPath;
  }
  
  public static float dpScale()
  {
    if (dpScale == -1.0F) {
      dpScale = Resources.getSystem().getDisplayMetrics().density;
    }
    return dpScale;
  }
  
  public static float getAnimationScale(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Settings.Global.getFloat(paramContext.getContentResolver(), "animator_duration_scale", 1.0F);
    }
    return Settings.System.getFloat(paramContext.getContentResolver(), "animator_duration_scale", 1.0F);
  }
  
  public static float getScale(Matrix paramMatrix)
  {
    float[] arrayOfFloat = (float[])threadLocalPoints.get();
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    float f1 = INV_SQRT_2;
    arrayOfFloat[2] = f1;
    arrayOfFloat[3] = f1;
    paramMatrix.mapPoints(arrayOfFloat);
    f1 = arrayOfFloat[2];
    float f2 = arrayOfFloat[0];
    float f3 = arrayOfFloat[3];
    float f4 = arrayOfFloat[1];
    return (float)Math.hypot(f1 - f2, f3 - f4);
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (displayMetrics == null) {
      displayMetrics = new DisplayMetrics();
    }
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics.heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (displayMetrics == null) {
      displayMetrics = new DisplayMetrics();
    }
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics.widthPixels;
  }
  
  public static boolean hasZeroScaleAxis(Matrix paramMatrix)
  {
    float[] arrayOfFloat = (float[])threadLocalPoints.get();
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 37394.73F;
    arrayOfFloat[3] = 39575.234F;
    paramMatrix.mapPoints(arrayOfFloat);
    if (arrayOfFloat[0] != arrayOfFloat[2]) {
      return arrayOfFloat[1] == arrayOfFloat[3];
    }
    return true;
  }
  
  public static int hashFor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 != 0.0F) {
      j = (int)(527 * paramFloat1);
    } else {
      j = 17;
    }
    int i = j;
    if (paramFloat2 != 0.0F) {
      i = (int)(j * 31 * paramFloat2);
    }
    int j = i;
    if (paramFloat3 != 0.0F) {
      j = (int)(i * 31 * paramFloat3);
    }
    i = j;
    if (paramFloat4 != 0.0F) {
      i = (int)(j * 31 * paramFloat4);
    }
    return i;
  }
  
  public static boolean isAtLeastVersion(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    boolean bool = false;
    if (paramInt1 < paramInt4) {
      return false;
    }
    if (paramInt1 > paramInt4) {
      return true;
    }
    if (paramInt2 < paramInt5) {
      return false;
    }
    if (paramInt2 > paramInt5) {
      return true;
    }
    if (paramInt3 >= paramInt6) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isNetworkException(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof SocketException)) || ((paramThrowable instanceof ClosedChannelException)) || ((paramThrowable instanceof InterruptedIOException)) || ((paramThrowable instanceof ProtocolException)) || ((paramThrowable instanceof SSLException)) || ((paramThrowable instanceof UnknownHostException)) || ((paramThrowable instanceof UnknownServiceException));
  }
  
  public static String printMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = "";
    int i = 0;
    while (i < 9)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMatrix);
      localStringBuilder.append(String.valueOf(arrayOfFloat[i]));
      localStringBuilder.append(" ");
      paramMatrix = localStringBuilder.toString();
      i += 1;
    }
    return paramMatrix;
  }
  
  public static Bitmap renderPath(Path paramPath)
  {
    Object localObject = new RectF();
    paramPath.computeBounds((RectF)localObject, false);
    localObject = Bitmap.createBitmap((int)((RectF)localObject).right, (int)((RectF)localObject).bottom, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    LPaint localLPaint = new LPaint();
    localLPaint.setAntiAlias(true);
    localLPaint.setColor(-16776961);
    localCanvas.drawPath(paramPath, localLPaint);
    return localObject;
  }
  
  public static Bitmap resizeBitmapIfNeeded(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2)) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static void saveLayerCompat(Canvas paramCanvas, RectF paramRectF, Paint paramPaint)
  {
    saveLayerCompat(paramCanvas, paramRectF, paramPaint, 31);
  }
  
  public static void saveLayerCompat(Canvas paramCanvas, RectF paramRectF, Paint paramPaint, int paramInt)
  {
    L.beginSection("Utils#saveLayer");
    if (Build.VERSION.SDK_INT < 23) {
      paramCanvas.saveLayer(paramRectF, paramPaint, paramInt);
    } else {
      paramCanvas.saveLayer(paramRectF, paramPaint);
    }
    L.endSection("Utils#saveLayer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.Utils
 * JD-Core Version:    0.7.0.1
 */