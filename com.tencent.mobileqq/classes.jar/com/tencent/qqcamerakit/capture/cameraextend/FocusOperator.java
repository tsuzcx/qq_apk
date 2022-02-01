package com.tencent.qqcamerakit.capture.cameraextend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.qqcamerakit.capture.CameraProxy;

public class FocusOperator
{
  private static int b;
  private int a = 90;
  private Matrix c = new Matrix();
  private Matrix d = new Matrix();
  
  private static int a()
  {
    int j = b;
    int i = j;
    if (j == 0)
    {
      b = (int)CameraProxy.a().getResources().getDimension(2131296990);
      i = b;
    }
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public static Rect a(Matrix paramMatrix, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    int i = Float.valueOf(a() * paramFloat3).intValue();
    int k = (int)paramFloat1;
    int j = i / 2;
    paramInt1 = a(k - j, 0, paramInt1 - i);
    paramInt2 = a((int)paramFloat2 - j, 0, paramInt2 - i);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + i, paramInt2 + i);
    paramMatrix.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramMatrix.reset();
    int i;
    if (paramInt2 < paramInt3) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt2;
    if (i != 0)
    {
      j = paramInt2;
      if (paramInt4 != 0) {
        j = paramInt5 * paramInt3 / paramInt4;
      }
    }
    if (paramBoolean) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    }
    paramMatrix.setScale(f1, 1.0F);
    paramMatrix.postRotate(paramInt1);
    float f1 = j;
    float f2 = f1 / 2000.0F;
    float f3 = paramInt3;
    paramMatrix.postScale(f2, f3 / 2000.0F);
    paramMatrix.postTranslate(f1 / 2.0F, f3 / 2.0F);
  }
  
  public Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.d = new Matrix();
    boolean bool;
    if (paramInt5 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    a(this.d, bool, this.a, paramInt3, paramInt4, paramInt1, paramInt2);
    this.d.invert(this.c);
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.cameraextend.FocusOperator
 * JD-Core Version:    0.7.0.1
 */