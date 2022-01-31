package com.tencent.tav.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class CGMathFunctions
{
  public static CGRect initGLViewportDefault(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    return new CGRect(new PointF((paramCGSize1.width - paramCGSize2.width) / 2.0F, (paramCGSize1.height - paramCGSize2.height) / 2.0F), paramCGSize2);
  }
  
  public static CGRect initGLViewportFill(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    float f4 = 0.0F;
    float f3 = paramCGSize2.height;
    float f5 = paramCGSize2.width;
    float f1 = paramCGSize1.height;
    float f2 = paramCGSize1.width;
    if (f2 / f1 > f5 / f3)
    {
      f5 = f3 * f2 / f5;
      f3 = (f1 - f5) / 2.0F;
      f1 = f5;
    }
    for (;;)
    {
      return new CGRect(new PointF(f4, f3), new CGSize(f2, f1));
      f3 = f5 * f1 / f3;
      f4 = (f2 - f3) / 2.0F;
      f2 = f3;
      f3 = 0.0F;
    }
  }
  
  public static CGRect initGLViewportFit(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    float f4 = 0.0F;
    float f3 = paramCGSize2.height;
    float f5 = paramCGSize2.width;
    float f1 = paramCGSize1.height;
    float f2 = paramCGSize1.width;
    if (f2 / f1 > f5 / f3)
    {
      f5 = f5 * f1 / f3;
      f4 = (f2 - f5) / 2.0F;
      f3 = 0.0F;
      f2 = f5;
    }
    for (;;)
    {
      return new CGRect(new PointF(f4, f3), new CGSize(f2, f1));
      f5 = f3 * f2 / f5;
      f3 = (f1 - f5) / 2.0F;
      f1 = f5;
    }
  }
  
  private static CGRect rectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    paramCGRect1 = sizeFill(paramCGRect1.size, paramCGRect2.size);
    return new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
  }
  
  private static CGRect rectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    paramCGRect1 = sizeFit(paramCGRect1.size, paramCGRect2.size);
    return new CGRect(paramCGRect2.origin.x + (paramCGRect2.size.width - paramCGRect1.width) / 2.0F, paramCGRect2.origin.y + (paramCGRect2.size.height - paramCGRect1.height) / 2.0F, paramCGRect1.width, paramCGRect1.height);
  }
  
  private static CGSize sizeFill(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 > f1) {
      paramCGSize1.width *= f2;
    }
    while (f1 <= f2) {
      return localCGSize;
    }
    localCGSize.height = (f1 * paramCGSize1.height);
    return localCGSize;
  }
  
  static CGSize sizeFit(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    CGSize localCGSize = paramCGSize2.clone();
    float f1 = paramCGSize2.width / paramCGSize1.width;
    float f2 = paramCGSize2.height / paramCGSize1.height;
    if (f2 < f1) {
      localCGSize.width = Math.round(paramCGSize1.width * f2);
    }
    while (f1 >= f2) {
      return localCGSize;
    }
    localCGSize.height = Math.round(f1 * paramCGSize1.height);
    return localCGSize;
  }
  
  public static Matrix transformByScaleFitRect(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramCGRect2.size.width / paramCGRect1.size.width, paramCGRect2.size.height / paramCGRect1.size.height);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFill(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    paramCGRect2 = rectFill(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(paramCGRect2.origin.x - f1 * paramCGRect1.origin.x, paramCGRect2.origin.y - f2 * paramCGRect1.origin.y);
    return localMatrix;
  }
  
  public static Matrix transformBySourceRectFit(CGRect paramCGRect1, CGRect paramCGRect2)
  {
    paramCGRect2 = rectFit(paramCGRect1, paramCGRect2);
    float f1 = paramCGRect2.size.width / paramCGRect1.size.width;
    float f2 = paramCGRect2.size.height / paramCGRect1.size.height;
    Matrix localMatrix = new Matrix();
    float f3 = paramCGRect2.origin.x;
    float f4 = paramCGRect1.origin.x;
    float f5 = paramCGRect2.origin.y;
    float f6 = paramCGRect1.origin.y;
    localMatrix.postScale(f1, f2);
    localMatrix.postTranslate(f3 - f4 * f1, f5 - f6 * f2);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.CGMathFunctions
 * JD-Core Version:    0.7.0.1
 */