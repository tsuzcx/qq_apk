package com.tencent.mtt.supportui.views.asyncimage;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public abstract class BaseDrawable
  extends Drawable
{
  protected RectF mRect = new RectF();
  protected float mShadowOffsetX;
  protected float mShadowOffsetY;
  protected float mShadowRadius;
  
  public void setShadowOffsetX(float paramFloat)
  {
    this.mShadowOffsetX = paramFloat;
    invalidateSelf();
  }
  
  public void setShadowOffsetY(float paramFloat)
  {
    this.mShadowOffsetY = paramFloat;
    invalidateSelf();
  }
  
  public void setShadowRadius(float paramFloat)
  {
    this.mShadowRadius = paramFloat;
    invalidateSelf();
  }
  
  public void updateContentRegion()
  {
    Rect localRect = getBounds();
    float f4 = localRect.top + this.mShadowRadius;
    float f1 = localRect.left + this.mShadowRadius;
    float f2 = localRect.right - this.mShadowRadius;
    float f3 = localRect.bottom;
    float f5 = this.mShadowRadius;
    f3 -= f5;
    float f6 = this.mShadowOffsetX;
    if (f6 > 0.0F)
    {
      if (f5 >= f6)
      {
        f1 -= f6;
        f2 -= f6;
      }
      else
      {
        f1 -= f5;
      }
    }
    else
    {
      f5 = Math.abs(f6);
      f6 = this.mShadowRadius;
      if (f6 >= f5)
      {
        f1 += f5;
        f2 += f5;
      }
      else
      {
        f2 += f6;
      }
    }
    f5 = this.mShadowOffsetY;
    if (f5 > 0.0F)
    {
      f6 = this.mShadowRadius;
      if (f6 >= f5)
      {
        f4 -= f5;
        f3 -= f5;
      }
      else
      {
        f4 -= f6;
      }
    }
    else
    {
      f5 = Math.abs(f5);
      f6 = this.mShadowRadius;
      if (f6 >= f5)
      {
        f5 = this.mShadowOffsetY;
        f4 += f5;
        f3 += f5;
      }
      else
      {
        f3 += f6;
      }
    }
    this.mRect.set(new RectF(f1, f4, f2, f3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.BaseDrawable
 * JD-Core Version:    0.7.0.1
 */