package com.tencent.richmediabrowser.animation;

import android.graphics.Rect;

public class AnimationUtils
{
  private static final float HEIGHER_IMGE_FACTOR = 1.5F;
  
  public static float getAIOImageScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return 1.0F;
      }
      int i = paramInt2 * paramInt3 / paramInt1;
      float f1;
      if ((isLongPhoto(paramInt1, paramInt2)) && (paramInt1 <= paramInt3))
      {
        f1 = f2;
        if (paramInt2 <= paramInt4) {}
      }
      else if ((paramInt1 < 135) && (paramInt2 < 135))
      {
        f1 = f2;
      }
      else if (paramInt4 >= i)
      {
        f1 = paramInt3 / paramInt1;
      }
      else
      {
        f1 = paramInt4 / paramInt2;
      }
      return Math.min(f1, 2.0F);
    }
    return 1.0F;
  }
  
  public static Rect getAnimationEndDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return getAnimationEndDstRect(paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public static Rect getAnimationEndDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    float f = getAIOImageScale(paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    if (paramInt2 >= paramInt1 * 3) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) && ((paramInt1 >= 135) || (paramInt2 >= 135)))
    {
      f = Math.min(paramInt3 / paramInt1, 2.0F);
      i = 49;
    }
    else
    {
      i = 17;
    }
    if ((paramBoolean) || (f <= 1.0F))
    {
      paramInt1 = (int)(paramInt1 * f);
      paramInt2 = (int)(paramInt2 * f);
    }
    Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
    if (i == 49)
    {
      localRect.offset((paramInt3 - paramInt1) / 2, 0);
      return localRect;
    }
    if (i == 17) {
      localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
    }
    return localRect;
  }
  
  public static boolean isLongPhoto(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= paramLong2 * 3L) || (paramLong2 >= paramLong1 * 3L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */