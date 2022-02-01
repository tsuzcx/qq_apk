package com.tencent.qq.effect.engine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.FrameLayout.LayoutParams;

public class Layout
{
  public static final int ABSOLUTE_LAYOUT = 0;
  public static final int SCALE_LAYOUT = 1;
  
  public static Rect absoluteLayout(Context paramContext, QEffectData paramQEffectData, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    if (paramQEffectData.w == -1.0F) {
      i = paramInt1;
    } else {
      i = 0;
    }
    if (paramQEffectData.h != -1.0F) {
      paramInt2 = 0;
    }
    if (paramQEffectData.w > 0.0F)
    {
      i = getLayoutPx(paramContext, (int)paramQEffectData.w);
      if (paramQEffectData.h > 0.0F)
      {
        paramInt2 = getLayoutPx(paramContext, (int)paramQEffectData.h);
        paramInt1 = i;
      }
      else
      {
        paramInt1 = i;
        if (paramQEffectData.aspectRatio > 0.0F)
        {
          paramInt2 = (int)(i * paramQEffectData.aspectRatio);
          paramInt1 = i;
        }
      }
    }
    else
    {
      paramInt1 = i;
      if (paramQEffectData.h > 0.0F)
      {
        j = getLayoutPx(paramContext, (int)paramQEffectData.h);
        if (paramQEffectData.w > 0.0F)
        {
          paramInt1 = getLayoutPx(paramContext, (int)paramQEffectData.w);
          paramInt2 = j;
        }
        else
        {
          paramInt1 = i;
          paramInt2 = j;
          if (paramQEffectData.aspectRatio > 0.0F)
          {
            paramInt1 = (int)(j * paramQEffectData.aspectRatio);
            paramInt2 = j;
          }
        }
      }
    }
    int i = getLayoutPx(paramContext, (int)paramQEffectData.x);
    int j = getLayoutPx(paramContext, (int)paramQEffectData.y);
    localRect.set(i, j, paramInt1 + i, paramInt2 + j);
    return localRect;
  }
  
  public static FrameLayout.LayoutParams getLayoutParams(Context paramContext, QEffectData paramQEffectData, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    int i = paramQEffectData.layoutType;
    if (i != 0)
    {
      if (i != 1) {
        paramContext = new Rect();
      } else {
        paramContext = scaleLayout(paramQEffectData, paramInt1, paramInt2);
      }
    }
    else {
      paramContext = absoluteLayout(paramContext, paramQEffectData, paramInt1, paramInt2);
    }
    if (paramQEffectData.w >= 0.0F) {
      localLayoutParams.width = paramContext.width();
    }
    if (paramQEffectData.h >= 0.0F) {
      localLayoutParams.height = paramContext.height();
    }
    localLayoutParams.leftMargin = paramContext.left;
    localLayoutParams.topMargin = paramContext.top;
    return localLayoutParams;
  }
  
  public static int getLayoutPx(Context paramContext, int paramInt)
  {
    return (int)(paramInt / layoutScale(paramContext));
  }
  
  public static float layoutScale(Context paramContext)
  {
    return 750.0F / paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static Rect scaleLayout(QEffectData paramQEffectData, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    float f1 = paramQEffectData.w;
    int k = 0;
    int j;
    if (f1 == -1.0F) {
      j = paramInt1;
    } else {
      j = 0;
    }
    if (paramQEffectData.h == -1.0F) {
      k = paramInt2;
    }
    float f2;
    if (paramQEffectData.w > 0.0F)
    {
      j = (int)(paramInt1 * paramQEffectData.w);
      if (paramQEffectData.h > 0.0F) {
        f1 = paramInt2;
      }
      for (f2 = paramQEffectData.h;; f2 = paramQEffectData.aspectRatio)
      {
        k = (int)(f1 * f2);
        i = j;
        break;
        i = j;
        if (paramQEffectData.aspectRatio <= 0.0F) {
          break;
        }
        f1 = j;
      }
    }
    int i = j;
    if (paramQEffectData.h > 0.0F)
    {
      int m = (int)(paramInt2 * paramQEffectData.h);
      if (paramQEffectData.w > 0.0F) {
        f1 = paramInt1;
      }
      for (f2 = paramQEffectData.w;; f2 = paramQEffectData.aspectRatio)
      {
        i = (int)(f1 * f2);
        k = m;
        break;
        i = j;
        k = m;
        if (paramQEffectData.aspectRatio <= 0.0F) {
          break;
        }
        f1 = m;
      }
    }
    paramInt1 = (int)(paramInt1 * paramQEffectData.x);
    paramInt2 = (int)(paramInt2 * paramQEffectData.y);
    localRect.set(paramInt1, paramInt2, i + paramInt1, k + paramInt2);
    return localRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.engine.Layout
 * JD-Core Version:    0.7.0.1
 */