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
    if (paramQEffectData.w == -1.0F) {}
    for (int i = paramInt1;; i = 0)
    {
      if (paramQEffectData.h == -1.0F) {}
      for (;;)
      {
        if (paramQEffectData.w > 0.0F)
        {
          i = getLayoutPx(paramContext, (int)paramQEffectData.w);
          if (paramQEffectData.h > 0.0F)
          {
            paramInt2 = getLayoutPx(paramContext, (int)paramQEffectData.h);
            paramInt1 = i;
          }
        }
        for (;;)
        {
          i = getLayoutPx(paramContext, (int)paramQEffectData.x);
          int j = getLayoutPx(paramContext, (int)paramQEffectData.y);
          localRect.set(i, j, i + paramInt1, j + paramInt2);
          return localRect;
          paramInt1 = i;
          if (paramQEffectData.aspectRatio > 0.0F)
          {
            paramInt2 = (int)(i * paramQEffectData.aspectRatio);
            paramInt1 = i;
            continue;
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
        }
        paramInt2 = 0;
      }
    }
  }
  
  public static FrameLayout.LayoutParams getLayoutParams(Context paramContext, QEffectData paramQEffectData, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    switch (paramQEffectData.layoutType)
    {
    default: 
      paramContext = new Rect();
    }
    for (;;)
    {
      if (paramQEffectData.w >= 0.0F) {
        localLayoutParams.width = paramContext.width();
      }
      if (paramQEffectData.h >= 0.0F) {
        localLayoutParams.height = paramContext.height();
      }
      localLayoutParams.leftMargin = paramContext.left;
      localLayoutParams.topMargin = paramContext.top;
      return localLayoutParams;
      paramContext = scaleLayout(paramQEffectData, paramInt1, paramInt2);
      continue;
      paramContext = absoluteLayout(paramContext, paramQEffectData, paramInt1, paramInt2);
    }
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
    int j = 0;
    Rect localRect = new Rect();
    if (paramQEffectData.w == -1.0F) {}
    for (int k = paramInt1;; k = 0)
    {
      if (paramQEffectData.h == -1.0F) {
        j = paramInt2;
      }
      int i;
      if (paramQEffectData.w > 0.0F)
      {
        k = (int)(paramInt1 * paramQEffectData.w);
        if (paramQEffectData.h > 0.0F)
        {
          j = (int)(paramInt2 * paramQEffectData.h);
          i = k;
        }
      }
      for (;;)
      {
        paramInt1 = (int)(paramInt1 * paramQEffectData.x);
        paramInt2 = (int)(paramInt2 * paramQEffectData.y);
        localRect.set(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
        return localRect;
        i = k;
        if (paramQEffectData.aspectRatio > 0.0F)
        {
          j = (int)(k * paramQEffectData.aspectRatio);
          i = k;
          continue;
          i = k;
          if (paramQEffectData.h > 0.0F)
          {
            int m = (int)(paramInt2 * paramQEffectData.h);
            if (paramQEffectData.w > 0.0F)
            {
              i = (int)(paramInt1 * paramQEffectData.w);
              j = m;
            }
            else
            {
              i = k;
              j = m;
              if (paramQEffectData.aspectRatio > 0.0F)
              {
                i = (int)(m * paramQEffectData.aspectRatio);
                j = m;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.engine.Layout
 * JD-Core Version:    0.7.0.1
 */