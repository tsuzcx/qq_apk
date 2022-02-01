package com.tencent.richmediabrowser.animation;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class AnimationUtils
{
  private static final float HEIGHER_IMGE_FACTOR = 1.5F;
  
  public static float getAIOImageScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 1.0F;
    }
    int i = paramInt2 * paramInt3 / paramInt1;
    float f1;
    if ((isLongPhoto(paramInt1, paramInt2)) && (paramInt1 <= paramInt3))
    {
      f1 = f2;
      if (paramInt2 <= paramInt4) {}
    }
    else
    {
      if ((paramInt1 >= 135) || (paramInt2 >= 135)) {
        break label69;
      }
      f1 = f2;
    }
    for (;;)
    {
      return Math.min(f1, 2.0F);
      label69:
      if (paramInt4 >= i) {
        f1 = paramInt3 / paramInt1;
      } else {
        f1 = paramInt4 / paramInt2;
      }
    }
  }
  
  public static Rect getAnimationEndDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return getAnimationEndDstRect(paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public static Rect getAnimationEndDstRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    float f = getAIOImageScale(paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    label63:
    label75:
    Rect localRect;
    if (paramInt2 >= paramInt1 * 3)
    {
      i = 1;
      if ((i == 0) || ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4)) || ((paramInt1 < 135) && (paramInt2 < 135))) {
        break label115;
      }
      f = Math.min(paramInt3 / paramInt1, 2.0F);
      i = 49;
      if ((paramBoolean) || (f <= 1.0F)) {
        break label122;
      }
      localRect = new Rect(0, 0, paramInt1, paramInt2);
      if (i != 49) {
        break label139;
      }
      localRect.offset((paramInt3 - paramInt1) / 2, 0);
    }
    label115:
    label122:
    while (i != 17)
    {
      return localRect;
      i = 0;
      break;
      i = 17;
      break label63;
      paramInt1 = (int)(paramInt1 * f);
      paramInt2 = (int)(f * paramInt2);
      break label75;
    }
    label139:
    localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
    return localRect;
  }
  
  public static float getScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt3 <= 0) || (paramInt4 <= 0)) {}
    do
    {
      do
      {
        return 1.0F;
        if ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4 * paramInt1 / paramInt3)) {
          return paramInt3 / paramInt1;
        }
      } while ((paramInt1 < paramInt3) && (paramInt2 >= paramInt4));
      if ((paramInt1 >= paramInt3) && (paramInt2 < paramInt4 * paramInt1 / paramInt3)) {
        return paramInt3 / paramInt1;
      }
      if ((paramInt1 > paramInt3) || (paramInt2 > paramInt4)) {
        return Math.min(paramInt4 / paramInt2, paramInt3 / paramInt1);
      }
    } while ((paramInt1 >= paramInt3) || (paramInt1 <= paramInt3 / 2) || (paramInt4 <= paramInt3 / paramInt1 * paramInt2));
    return paramInt3 / paramInt1;
  }
  
  public static Rect getViewRect(View paramView)
  {
    Rect localRect = new Rect(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getWidth() - paramView.getPaddingRight(), paramView.getHeight() - paramView.getPaddingBottom());
    getViewRect(paramView, localRect);
    return localRect;
  }
  
  public static boolean getViewRect(View paramView, Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    Point localPoint = new Point();
    if ((i > 0) && (j > 0))
    {
      Rect localRect = paramRect;
      if (paramRect == null)
      {
        localRect = new Rect();
        localRect.set(0, 0, i, j);
      }
      localPoint.set(-paramView.getScrollX(), -paramView.getScrollY());
      localRect.offset((i - localRect.width()) / 2, (j - localRect.height()) / 2);
      return (localViewGroup == null) || (localViewGroup.getChildVisibleRect(paramView, localRect, localPoint));
    }
    return false;
  }
  
  public static boolean isLongPhoto(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 3L * paramLong2) || (paramLong2 >= 3L * paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */