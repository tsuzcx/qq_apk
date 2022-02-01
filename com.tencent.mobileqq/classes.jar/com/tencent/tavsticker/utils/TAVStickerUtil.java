package com.tencent.tavsticker.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;

public class TAVStickerUtil
{
  private static final String TAG = "TAVStickerUtil";
  
  public static PointF[] computeRectanglePoints(Matrix paramMatrix, float paramFloat1, float paramFloat2)
  {
    PointF[] arrayOfPointF = new PointF[4];
    arrayOfPointF[0] = new PointF();
    arrayOfPointF[1] = new PointF();
    arrayOfPointF[2] = new PointF();
    arrayOfPointF[3] = new PointF();
    if ((paramMatrix != null) && (paramFloat1 > 0.0F) && (paramFloat2 > 0.0F))
    {
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      float f1 = arrayOfFloat[2];
      float f2 = arrayOfFloat[5];
      arrayOfPointF[0].set(f1, f2);
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[2];
      float f3 = arrayOfFloat[3];
      float f4 = arrayOfFloat[5];
      arrayOfPointF[1].set(f1 * paramFloat1 + f2, f3 * paramFloat1 + f4);
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
      f3 = arrayOfFloat[2];
      f4 = arrayOfFloat[3];
      float f5 = arrayOfFloat[4];
      float f6 = arrayOfFloat[5];
      arrayOfPointF[2].set(f1 * paramFloat1 + f2 * paramFloat2 + f3, f4 * paramFloat1 + f5 * paramFloat2 + f6);
      paramFloat1 = arrayOfFloat[1];
      f1 = arrayOfFloat[2];
      f2 = arrayOfFloat[4];
      f3 = arrayOfFloat[5];
      arrayOfPointF[3].set(paramFloat1 * paramFloat2 + f1, f2 * paramFloat2 + f3);
    }
    return arrayOfPointF;
  }
  
  public static float covertCoordinate(float paramFloat, int paramInt1, int paramInt2)
  {
    float f = paramFloat;
    if (paramInt1 > 0)
    {
      f = paramFloat;
      if (paramInt2 > 0) {
        f = paramFloat / paramInt1 * paramInt2;
      }
    }
    return f;
  }
  
  public static float getDistance(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 != null) && (paramPointF2 != null))
    {
      float f1 = paramPointF1.x - paramPointF2.x;
      float f2 = paramPointF1.y - paramPointF2.y;
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    return 0.0F;
  }
  
  public static Matrix getMatrix(TAVSticker paramTAVSticker, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    if (paramTAVSticker != null)
    {
      RectF localRectF = getStickerRect(paramTAVSticker, paramInt1, paramInt2, paramTAVSticker.getScale());
      if (localRectF != null)
      {
        paramInt1 = paramTAVSticker.getWidth();
        paramInt2 = paramTAVSticker.getHeight();
        localMatrix.setTranslate(-paramInt1 * 0.5F, -paramInt2 * 0.5F);
        float f3 = localRectF.right - localRectF.left;
        float f2 = localRectF.bottom - localRectF.top;
        if ((paramInt1 != 0) && (paramInt2 != 0)) {
          localMatrix.postScale(f3 * 1.0F / paramInt1, 1.0F * f2 / paramInt2);
        }
        localMatrix.postRotate(paramTAVSticker.getRotate());
        float f1 = localRectF.left;
        f3 /= 2.0F;
        float f4 = localRectF.top;
        f2 /= 2.0F;
        localMatrix.postTranslate((float)Math.ceil(f1 + f3), (float)Math.ceil(f4 + f2));
      }
    }
    return localMatrix;
  }
  
  public static float getMaxXBy4Point(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    float f2 = paramPointF1.x;
    float f1 = f2;
    if (f2 < paramPointF2.x) {
      f1 = paramPointF2.x;
    }
    f2 = f1;
    if (f1 < paramPointF3.x) {
      f2 = paramPointF3.x;
    }
    f1 = f2;
    if (f2 < paramPointF4.x) {
      f1 = paramPointF4.x;
    }
    return f1;
  }
  
  public static float getMaxYBy4Point(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    float f2 = paramPointF1.y;
    float f1 = f2;
    if (f2 < paramPointF2.y) {
      f1 = paramPointF2.y;
    }
    f2 = f1;
    if (f1 < paramPointF3.y) {
      f2 = paramPointF3.y;
    }
    f1 = f2;
    if (f2 < paramPointF4.y) {
      f1 = paramPointF4.y;
    }
    return f1;
  }
  
  public static PointF getMiddlePoint(PointF paramPointF1, PointF paramPointF2)
  {
    PointF localPointF = new PointF();
    if ((paramPointF1 != null) && (paramPointF2 != null))
    {
      float f1 = paramPointF1.x;
      float f2 = paramPointF2.x;
      float f3 = paramPointF1.y;
      float f4 = paramPointF2.y;
      localPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    }
    return localPointF;
  }
  
  public static float getMinXBy4Point(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    float f2 = paramPointF1.x;
    float f1 = f2;
    if (f2 > paramPointF2.x) {
      f1 = paramPointF2.x;
    }
    f2 = f1;
    if (f1 > paramPointF3.x) {
      f2 = paramPointF3.x;
    }
    f1 = f2;
    if (f2 > paramPointF4.x) {
      f1 = paramPointF4.x;
    }
    return f1;
  }
  
  public static float getMinYBy4Point(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    float f2 = paramPointF1.y;
    float f1 = f2;
    if (f2 > paramPointF2.y) {
      f1 = paramPointF2.y;
    }
    f2 = f1;
    if (f1 > paramPointF3.y) {
      f2 = paramPointF3.y;
    }
    f1 = f2;
    if (f2 > paramPointF4.y) {
      f1 = paramPointF4.y;
    }
    return f1;
  }
  
  public static float getRotation(double paramDouble1, double paramDouble2)
  {
    return (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1));
  }
  
  public static float getRotation(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 != null) && (paramPointF2 != null)) {
      return getRotation(paramPointF1.x - paramPointF2.x, paramPointF1.y - paramPointF2.y);
    }
    return 0.0F;
  }
  
  public static float getRotation(MotionEvent paramMotionEvent)
  {
    return getRotation(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
  }
  
  public static RectF getStickerRect(TAVSticker paramTAVSticker, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramTAVSticker != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = paramInt1;
      if (paramInt1 % 2 != 0) {
        i = paramInt1 + 1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 % 2 != 0) {
        paramInt1 = paramInt2 + 1;
      }
      RectF localRectF = new RectF();
      paramInt2 = paramTAVSticker.getWidth();
      int j = paramTAVSticker.getHeight();
      float f4 = i;
      float f3 = paramFloat * f4;
      float f1 = 0.0F;
      paramFloat = f1;
      if (paramInt2 > 0)
      {
        paramFloat = f1;
        if (f3 > 0.0F) {
          paramFloat = j * 1.0F / paramInt2 * f3;
        }
      }
      float f2 = paramFloat;
      f1 = f3;
      if (paramTAVSticker.getScaleMode() == 1)
      {
        f2 = Math.max(f4 * 1.0F / f3, paramInt1 * 1.0F / paramFloat);
        f1 = f3 * f2;
        f2 = paramFloat * f2;
      }
      paramFloat = paramTAVSticker.getCenterX() * f4 - f1 / 2.0F;
      f3 = paramTAVSticker.getCenterY() * paramInt1 - f2 / 2.0F;
      localRectF.left = ((float)Math.floor(paramFloat));
      localRectF.top = ((float)Math.floor(f3));
      localRectF.bottom = ((float)Math.ceil(f3 + f2));
      localRectF.right = ((float)Math.ceil(paramFloat + f1));
      paramTAVSticker = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStickerRect -> parentWidth: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", parentHeight:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", StickerRect-left: ");
      localStringBuilder.append(localRectF.left);
      localStringBuilder.append(", top: ");
      localStringBuilder.append(localRectF.top);
      localStringBuilder.append(", bottom: ");
      localStringBuilder.append(localRectF.bottom);
      localStringBuilder.append(", right: ");
      localStringBuilder.append(localRectF.right);
      TLog.d(paramTAVSticker, localStringBuilder.toString());
      return localRectF;
    }
    return null;
  }
  
  public static boolean inQuadrangle(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5)
  {
    return Math.abs(triangleArea(paramPointF1, paramPointF2, paramPointF5) + triangleArea(paramPointF2, paramPointF3, paramPointF5) + triangleArea(paramPointF3, paramPointF4, paramPointF5) + triangleArea(paramPointF4, paramPointF1, paramPointF5) - (triangleArea(paramPointF1, paramPointF2, paramPointF3) + triangleArea(paramPointF3, paramPointF4, paramPointF1))) < 4.0D;
  }
  
  public static boolean isPresentationTimeInStickerTimeRange(long paramLong, TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      paramTAVSticker = paramTAVSticker.getTimeRange();
      if (paramTAVSticker == null) {
        return true;
      }
      return TimeRangeUtil.isInTimeRange(paramTAVSticker, paramLong);
    }
    return false;
  }
  
  public static boolean isSameTAVSticker(TAVSticker paramTAVSticker1, TAVSticker paramTAVSticker2)
  {
    if ((paramTAVSticker1 == null) && (paramTAVSticker2 == null)) {
      return true;
    }
    if ((paramTAVSticker1 != null) && (paramTAVSticker2 != null)) {
      return TextUtils.equals(paramTAVSticker1.getUniqueId(), paramTAVSticker2.getUniqueId());
    }
    return false;
  }
  
  public static boolean isValidCGSize(CGSize paramCGSize)
  {
    return (paramCGSize != null) && (paramCGSize.width > 0.0F) && (paramCGSize.height > 0.0F);
  }
  
  public static float microsecond2Seconds(long paramLong)
  {
    return (float)paramLong * 1.0F / 1000000.0F;
  }
  
  public static float millisecond2Seconds(long paramLong)
  {
    return (float)paramLong * 1.0F / 1000.0F;
  }
  
  private static double triangleArea(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    double d = paramPointF1.x * paramPointF2.y + paramPointF2.x * paramPointF3.y + paramPointF3.x * paramPointF1.y - paramPointF2.x * paramPointF1.y - paramPointF3.x * paramPointF2.y - paramPointF1.x * paramPointF3.y;
    Double.isNaN(d);
    return Math.abs(d / 2.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.utils.TAVStickerUtil
 * JD-Core Version:    0.7.0.1
 */