package com.tencent.taveffect.utils;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVSize;

public class TAVMatrixUtils
{
  public static void applyMirror(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramMatrix == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramMatrix.postConcat(localMatrix);
      return;
      localMatrix.postScale(-1.0F, 1.0F);
      localMatrix.postTranslate(paramInt2, 0.0F);
      continue;
      localMatrix.postScale(1.0F, -1.0F);
      localMatrix.postTranslate(0.0F, paramInt3);
      continue;
      localMatrix.postScale(-1.0F, -1.0F);
      localMatrix.postTranslate(paramInt2, paramInt3);
    }
  }
  
  public static TAVRectangle getMatrixAndCropRect(TAVSize paramTAVSize, int paramInt, float paramFloat1, float paramFloat2, Point paramPoint, Matrix paramMatrix)
  {
    while (paramInt < 0) {
      paramInt += 4;
    }
    paramInt %= 4;
    getRotationMatrix(paramMatrix, paramInt, paramTAVSize.width, paramTAVSize.height);
    Object localObject = getTransformedSize(paramTAVSize, paramInt, paramFloat2);
    if ((paramFloat2 > 0.0F) || (paramFloat1 > 1.0F))
    {
      TAVSize localTAVSize = new TAVSize();
      float f2;
      float f1;
      if (paramInt % 2 == 1)
      {
        localTAVSize.width = paramTAVSize.height;
        localTAVSize.height = paramTAVSize.width;
        f2 = 0.0F;
        paramFloat2 = 0.0F;
        if (((TAVSize)localObject).width == localTAVSize.width) {
          break label507;
        }
        f1 = (localTAVSize.width - ((TAVSize)localObject).width) * 0.5F;
      }
      for (;;)
      {
        Matrix localMatrix = new Matrix();
        localMatrix.setTranslate(-f1, -paramFloat2);
        f2 = ((TAVSize)localObject).width;
        float f3 = ((TAVSize)localObject).height;
        f2 /= paramFloat1;
        f3 /= paramFloat1;
        float f5 = (paramFloat1 - 1.0F) / paramFloat1;
        float f4 = -((TAVSize)localObject).width * 0.5F * f5 - paramPoint.x;
        f5 = -((TAVSize)localObject).height * 0.5F * f5 - paramPoint.y;
        paramPoint = new Matrix();
        paramPoint.setTranslate(f4, f5);
        f1 -= f4;
        paramFloat2 -= f5;
        localMatrix.postConcat(paramPoint);
        localMatrix.postScale(paramFloat1, paramFloat1);
        paramPoint = new Matrix();
        paramMatrix.invert(paramPoint);
        localObject = new RectF(f1, paramFloat2, f2 + f1, f3 + paramFloat2);
        paramPoint.mapRect((RectF)localObject);
        paramPoint = new TAVRectangle(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).width(), ((RectF)localObject).height());
        if (paramPoint.x < 0.0F)
        {
          paramPoint.width += paramPoint.x;
          paramPoint.x = 0.0F;
        }
        if (paramPoint.y < 0.0F)
        {
          paramPoint.height += paramPoint.y;
          paramPoint.y = 0.0F;
        }
        if (paramPoint.x + paramPoint.width > paramTAVSize.width) {
          paramPoint.width = (localTAVSize.width - paramPoint.x);
        }
        if (paramPoint.y + paramPoint.height > paramTAVSize.height) {
          paramPoint.height = (localTAVSize.height - paramPoint.y);
        }
        paramMatrix.postConcat(localMatrix);
        return paramPoint;
        localTAVSize.width = paramTAVSize.width;
        localTAVSize.height = paramTAVSize.height;
        break;
        label507:
        f1 = f2;
        if (((TAVSize)localObject).height != localTAVSize.height)
        {
          paramFloat2 = (localTAVSize.height - ((TAVSize)localObject).height) * 0.5F;
          f1 = f2;
        }
      }
    }
    return null;
  }
  
  public static void getRotationMatrix(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    float f3 = -1.0F;
    int i = paramInt1 % 4;
    paramInt1 = i;
    if (i < 0) {
      paramInt1 = i + 4;
    }
    float f1;
    float f2;
    float f4;
    float f5;
    float f6;
    switch (paramInt1)
    {
    default: 
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 1.0F;
      f4 = 0.0F;
      f5 = 0.0F;
      f6 = 1.0F;
    }
    for (;;)
    {
      paramMatrix.setValues(new float[] { f6, f4, f2, f5, f3, f1, 0.0F, 0.0F, 1.0F });
      return;
      f2 = paramInt3;
      f4 = -1.0F;
      f5 = 1.0F;
      f6 = 0.0F;
      f3 = 0.0F;
      f1 = 0.0F;
      continue;
      f2 = paramInt2;
      f1 = paramInt3;
      f4 = 0.0F;
      f5 = 0.0F;
      f6 = -1.0F;
      continue;
      f1 = paramInt2;
      f2 = 0.0F;
      f4 = 1.0F;
      f5 = -1.0F;
      f6 = 0.0F;
      f3 = 0.0F;
    }
  }
  
  public static TAVSize getTransformedSize(TAVSize paramTAVSize, int paramInt, float paramFloat)
  {
    paramTAVSize = paramTAVSize.clone();
    if (Math.abs(paramInt) % 2 == 1)
    {
      paramInt = paramTAVSize.width;
      paramTAVSize.width = paramTAVSize.height;
      paramTAVSize.height = paramInt;
    }
    if (paramFloat > 0.0F)
    {
      if (paramTAVSize.width * 1.0F / paramTAVSize.height > paramFloat) {
        paramTAVSize.width = ((int)Math.ceil(paramTAVSize.height * paramFloat));
      }
    }
    else {
      return paramTAVSize;
    }
    paramTAVSize.height = ((int)Math.ceil(paramTAVSize.width * 1.0F / paramFloat));
    return paramTAVSize;
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public static float[] toOpenGL2DMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    if (paramMatrix == null)
    {
      int i = 0;
      if (i < 9)
      {
        if (i % 4 == 0) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          arrayOfFloat[i] = f;
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramMatrix.getValues(arrayOfFloat);
      swap(arrayOfFloat, 1, 3);
      swap(arrayOfFloat, 2, 6);
      swap(arrayOfFloat, 5, 7);
    }
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.taveffect.utils.TAVMatrixUtils
 * JD-Core Version:    0.7.0.1
 */