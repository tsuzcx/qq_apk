package com.tencent.tavsticker.utils;

import android.graphics.Rect;
import android.graphics.RectF;

public class RectUtil
{
  private static final String TAG = RectUtil.class.getSimpleName();
  
  public static float getRectHeight(RectF paramRectF)
  {
    if (paramRectF != null) {}
    for (float f = paramRectF.bottom - paramRectF.top;; f = 0.0F)
    {
      if (f > 0.0F) {
        return f;
      }
      return 0.0F;
    }
  }
  
  public static int getRectHeight(Rect paramRect)
  {
    if (paramRect != null) {}
    for (int i = paramRect.bottom - paramRect.top;; i = 0)
    {
      if (i > 0) {
        return i;
      }
      return 0;
    }
  }
  
  public static float getRectWidth(RectF paramRectF)
  {
    if (paramRectF != null) {}
    for (float f = paramRectF.right - paramRectF.left;; f = 0.0F)
    {
      if (f > 0.0F) {
        return f;
      }
      return 0.0F;
    }
  }
  
  public static int getRectWidth(Rect paramRect)
  {
    if (paramRect != null) {}
    for (int i = paramRect.right - paramRect.left;; i = 0)
    {
      if (i > 0) {
        return i;
      }
      return 0;
    }
  }
  
  public static Rect getStickerMoveLimitRect(RectF paramRectF, int paramInt1, int paramInt2)
  {
    if (paramRectF != null)
    {
      Rect localRect = new Rect();
      localRect.left = ((int)(paramRectF.left * paramInt1));
      localRect.top = ((int)(paramRectF.top * paramInt2));
      localRect.right = ((int)(paramRectF.right * paramInt1));
      localRect.bottom = ((int)(paramRectF.bottom * paramInt2));
      if (rectIsValid(localRect)) {
        return localRect;
      }
      return null;
    }
    return null;
  }
  
  public static Rect rectInset(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (paramRect != null)
    {
      int i = paramRect.left;
      int j = paramRect.right;
      int k = paramRect.top;
      int m = paramRect.bottom;
      paramRect.left = (i + paramInt1);
      paramRect.top = (k + paramInt2);
      paramRect.right = (j - paramInt1);
      paramRect.bottom = (m - paramInt2);
      return paramRect;
    }
    return null;
  }
  
  public static boolean rectIsEmpty(Rect paramRect)
  {
    return (paramRect == null) || (paramRect.right - paramRect.left <= 0) || (paramRect.bottom - paramRect.top <= 0);
  }
  
  public static boolean rectIsValid(Rect paramRect)
  {
    return (paramRect != null) && (paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.right > 0) && (paramRect.bottom > 0) && (paramRect.right - paramRect.left > 0) && (paramRect.bottom - paramRect.top > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.utils.RectUtil
 * JD-Core Version:    0.7.0.1
 */