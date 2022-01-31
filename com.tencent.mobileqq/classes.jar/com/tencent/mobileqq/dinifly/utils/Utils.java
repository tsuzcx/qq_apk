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
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.dinifly.L;
import com.tencent.mobileqq.dinifly.animation.LPaint;
import com.tencent.mobileqq.dinifly.animation.content.TrimPathContent;
import com.tencent.mobileqq.dinifly.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;

public final class Utils
{
  public static final int SECOND_IN_NANOS = 1000000000;
  private static final float SQRT_2 = (float)Math.sqrt(2.0D);
  private static DisplayMetrics displayMetrics;
  private static float dpScale = -1.0F;
  private static final PathMeasure pathMeasure = new PathMeasure();
  private static final float[] points;
  private static final Path tempPath = new Path();
  private static final Path tempPath2 = new Path();
  
  static
  {
    points = new float[4];
  }
  
  public static void applyTrimPathIfNeeded(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    L.beginSection("applyTrimPathIfNeeded");
    pathMeasure.setPath(paramPath, false);
    float f2 = pathMeasure.getLength();
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 0.0F))
    {
      L.endSection("applyTrimPathIfNeeded");
      return;
    }
    if ((f2 < 1.0F) || (Math.abs(paramFloat2 - paramFloat1 - 1.0F) < 0.01D))
    {
      L.endSection("applyTrimPathIfNeeded");
      return;
    }
    float f1 = f2 * paramFloat1;
    paramFloat2 = f2 * paramFloat2;
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
    tempPath.reset();
    pathMeasure.getSegment(paramFloat1, paramFloat3, tempPath, true);
    if (paramFloat3 > f2)
    {
      tempPath2.reset();
      pathMeasure.getSegment(0.0F, paramFloat3 % f2, tempPath2, true);
      tempPath.addPath(tempPath2);
    }
    for (;;)
    {
      paramPath.set(tempPath);
      L.endSection("applyTrimPathIfNeeded");
      return;
      if (paramFloat1 < 0.0F)
      {
        tempPath2.reset();
        pathMeasure.getSegment(paramFloat1 + f2, f2, tempPath2, true);
        tempPath.addPath(tempPath2);
      }
    }
  }
  
  public static void applyTrimPathIfNeeded(Path paramPath, @Nullable TrimPathContent paramTrimPathContent)
  {
    if ((paramTrimPathContent == null) || (paramTrimPathContent.isHidden())) {
      return;
    }
    float f1 = ((FloatKeyframeAnimation)paramTrimPathContent.getStart()).getFloatValue();
    float f2 = ((FloatKeyframeAnimation)paramTrimPathContent.getEnd()).getFloatValue();
    float f3 = ((FloatKeyframeAnimation)paramTrimPathContent.getOffset()).getFloatValue();
    applyTrimPathIfNeeded(paramPath, f1 / 100.0F, f2 / 100.0F, f3 / 360.0F);
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
    }
    catch (Exception paramCloseable) {}
  }
  
  public static Path createPath(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramPointF1.x, paramPointF1.y);
    if ((paramPointF3 != null) && (paramPointF4 != null) && ((paramPointF3.length() != 0.0F) || (paramPointF4.length() != 0.0F)))
    {
      localPath.cubicTo(paramPointF1.x + paramPointF3.x, paramPointF1.y + paramPointF3.y, paramPointF2.x + paramPointF4.x, paramPointF2.y + paramPointF4.y, paramPointF2.x, paramPointF2.y);
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
  
  public static float getScale(Matrix paramMatrix)
  {
    points[0] = 0.0F;
    points[1] = 0.0F;
    points[2] = SQRT_2;
    points[3] = SQRT_2;
    paramMatrix.mapPoints(points);
    float f1 = points[2];
    float f2 = points[0];
    float f3 = points[3];
    float f4 = points[1];
    return (float)Math.hypot(f1 - f2, f3 - f4) / 2.0F;
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
    boolean bool = false;
    points[0] = 0.0F;
    points[1] = 0.0F;
    points[2] = 37394.73F;
    points[3] = 39575.234F;
    paramMatrix.mapPoints(points);
    if ((points[0] == points[2]) || (points[1] == points[3])) {
      bool = true;
    }
    return bool;
  }
  
  public static int hashFor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 17;
    if (paramFloat1 != 0.0F) {
      j = (int)(527 * paramFloat1);
    }
    int i = j;
    if (paramFloat2 != 0.0F) {
      i = (int)(j * 31 * paramFloat2);
    }
    j = i;
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
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 < paramInt4) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramInt1 > paramInt4);
        if (paramInt2 < paramInt5) {
          return false;
        }
        bool1 = bool2;
      } while (paramInt2 > paramInt5);
      bool1 = bool2;
    } while (paramInt3 >= paramInt6);
    return false;
  }
  
  public static String printMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = "";
    int i = 0;
    while (i < 9)
    {
      paramMatrix = paramMatrix + String.valueOf(arrayOfFloat[i]) + " ";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.Utils
 * JD-Core Version:    0.7.0.1
 */