package com.tencent.tavsticker.utils;

import android.graphics.Rect;
import android.graphics.RectF;

public class RectUtil
{
  private static final String TAG = "RectUtil";
  
  public static float getRectHeight(RectF paramRectF)
  {
    float f;
    if (paramRectF != null) {
      f = paramRectF.bottom - paramRectF.top;
    } else {
      f = 0.0F;
    }
    if (f > 0.0F) {
      return f;
    }
    return 0.0F;
  }
  
  public static int getRectHeight(Rect paramRect)
  {
    int i;
    if (paramRect != null) {
      i = paramRect.bottom - paramRect.top;
    } else {
      i = 0;
    }
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  public static float getRectWidth(RectF paramRectF)
  {
    float f;
    if (paramRectF != null) {
      f = paramRectF.right - paramRectF.left;
    } else {
      f = 0.0F;
    }
    if (f > 0.0F) {
      return f;
    }
    return 0.0F;
  }
  
  public static int getRectWidth(Rect paramRect)
  {
    int i;
    if (paramRect != null) {
      i = paramRect.right - paramRect.left;
    } else {
      i = 0;
    }
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  public static Rect getStickerMoveLimitRect(RectF paramRectF, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramRectF != null)
    {
      Rect localRect = new Rect();
      float f2 = paramRectF.left;
      float f1 = paramInt1;
      localRect.left = ((int)(f2 * f1));
      f2 = paramRectF.top;
      float f3 = paramInt2;
      localRect.top = ((int)(f2 * f3));
      localRect.right = ((int)(paramRectF.right * f1));
      localRect.bottom = ((int)(paramRectF.bottom * f3));
      localObject1 = localObject2;
      if (rectIsValid(localRect)) {
        localObject1 = localRect;
      }
    }
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.utils.RectUtil
 * JD-Core Version:    0.7.0.1
 */