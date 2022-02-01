package com.tencent.ttpic.videoshelf;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class ImagePositonManager
{
  public static void setMovePosition(Drawable paramDrawable, Matrix paramMatrix, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramDrawable = new RectF(0.0F, 0.0F, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramMatrix.mapRect(paramDrawable);
    float f2 = paramDrawable.width();
    float f1 = paramDrawable.height();
    float f3 = paramInt1;
    if ((f2 > f3) && (paramDrawable.left + paramFloat1 <= 0.0F) && (paramDrawable.right + paramFloat1 >= f3)) {
      paramMatrix.postTranslate(paramFloat1, 0.0F);
    }
    paramFloat1 = paramInt2;
    if ((f1 > paramFloat1) && (paramDrawable.top + paramFloat2 <= 0.0F) && (paramDrawable.bottom + paramFloat2 >= paramFloat1)) {
      paramMatrix.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public static void setShowPosition(Drawable paramDrawable, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    paramDrawable = new RectF(0.0F, 0.0F, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramMatrix.mapRect(paramDrawable);
    float f7 = paramDrawable.width();
    float f5 = paramDrawable.height();
    float f8 = paramInt1;
    if (f7 <= f8) {
      f2 = paramInt1 / 2 - f7 / 2.0F - paramDrawable.left;
    } else {
      f2 = 0.0F;
    }
    float f6 = paramInt2;
    if (f5 <= f6) {
      f1 = paramInt2 / 2 - f5 / 2.0F - paramDrawable.top;
    } else {
      f1 = 0.0F;
    }
    float f3 = f2;
    if (f7 > f8)
    {
      f3 = f2;
      if (paramDrawable.left > 0.0F) {
        f3 = -paramDrawable.left;
      }
    }
    float f4 = f3;
    if (f7 > f8)
    {
      f4 = f3;
      if (paramDrawable.right < f8) {
        f4 = f8 - paramDrawable.right;
      }
    }
    float f2 = f1;
    if (f5 > f6)
    {
      f2 = f1;
      if (paramDrawable.top > 0.0F) {
        f2 = -paramDrawable.top;
      }
    }
    float f1 = f2;
    if (f5 > f6)
    {
      f1 = f2;
      if (paramDrawable.bottom < f6) {
        f1 = f6 - paramDrawable.bottom;
      }
    }
    paramMatrix.postTranslate(f4, f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ImagePositonManager
 * JD-Core Version:    0.7.0.1
 */