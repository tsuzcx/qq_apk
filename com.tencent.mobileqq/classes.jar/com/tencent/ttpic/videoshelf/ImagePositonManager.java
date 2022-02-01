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
    float f1 = paramDrawable.width();
    float f2 = paramDrawable.height();
    if ((f1 > paramInt1) && (paramDrawable.left + paramFloat1 <= 0.0F) && (paramDrawable.right + paramFloat1 >= paramInt1)) {
      paramMatrix.postTranslate(paramFloat1, 0.0F);
    }
    if ((f2 > paramInt2) && (paramDrawable.top + paramFloat2 <= 0.0F) && (paramDrawable.bottom + paramFloat2 >= paramInt2)) {
      paramMatrix.postTranslate(0.0F, paramFloat2);
    }
  }
  
  public static void setShowPosition(Drawable paramDrawable, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    paramDrawable = new RectF(0.0F, 0.0F, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramMatrix.mapRect(paramDrawable);
    float f6 = paramDrawable.width();
    float f5 = paramDrawable.height();
    if (f6 <= paramInt1) {}
    for (float f2 = paramInt1 / 2 - f6 / 2.0F - paramDrawable.left;; f2 = 0.0F)
    {
      if (f5 <= paramInt2) {}
      for (float f1 = paramInt2 / 2 - f5 / 2.0F - paramDrawable.top;; f1 = 0.0F)
      {
        float f3 = f2;
        if (f6 > paramInt1)
        {
          f3 = f2;
          if (paramDrawable.left > 0.0F) {
            f3 = -paramDrawable.left;
          }
        }
        float f4 = f3;
        if (f6 > paramInt1)
        {
          f4 = f3;
          if (paramDrawable.right < paramInt1) {
            f4 = paramInt1 - paramDrawable.right;
          }
        }
        f2 = f1;
        if (f5 > paramInt2)
        {
          f2 = f1;
          if (paramDrawable.top > 0.0F) {
            f2 = -paramDrawable.top;
          }
        }
        f1 = f2;
        if (f5 > paramInt2)
        {
          f1 = f2;
          if (paramDrawable.bottom < paramInt2) {
            f1 = paramInt2 - paramDrawable.bottom;
          }
        }
        paramMatrix.postTranslate(f4, f1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ImagePositonManager
 * JD-Core Version:    0.7.0.1
 */