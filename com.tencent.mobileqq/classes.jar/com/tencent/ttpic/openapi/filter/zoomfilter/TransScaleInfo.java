package com.tencent.ttpic.openapi.filter.zoomfilter;

import android.graphics.PointF;

public class TransScaleInfo
{
  PointF anchorPoint = new PointF(0.0F, 0.0F);
  float scaleValue = 1.0F;
  
  public void checkVaild(float paramFloat1, float paramFloat2)
  {
    float f1 = this.anchorPoint.x;
    float f2 = paramFloat1 / 2.0F;
    f1 -= f2;
    float f4 = this.anchorPoint.y;
    float f3 = paramFloat2 / 2.0F;
    float f5 = f4 - f3;
    f2 = this.anchorPoint.x + f2;
    f4 = this.anchorPoint.y + f3;
    f3 = f1;
    if (f1 < 0.0F) {
      f3 = 0.0F;
    }
    f1 = f5;
    if (f5 < 0.0F) {
      f1 = 0.0F;
    }
    float f6 = f2;
    if (f2 > 1.0F) {
      f6 = 1.0F;
    }
    f2 = f4;
    if (f4 > 1.0F) {
      f2 = 1.0F;
    }
    f4 = f3;
    f5 = f6;
    if (f6 - f3 < paramFloat1)
    {
      f5 = f3 + paramFloat1;
      if (f5 > 1.0D)
      {
        f4 = f6 - paramFloat1;
        if (f4 < 0.0F)
        {
          f4 = 0.0F;
          f5 = f6;
        }
        else
        {
          f5 = f6;
        }
      }
      else if (f5 > 1.0F)
      {
        f5 = 1.0F;
        f4 = f3;
      }
      else
      {
        f4 = f3;
      }
    }
    paramFloat1 = f2;
    f3 = f1;
    if (f2 - f1 < paramFloat2)
    {
      paramFloat1 = f1 + paramFloat2;
      if (paramFloat1 > 1.0D)
      {
        f3 = f2 - paramFloat2;
        if (f3 < 0.0F)
        {
          f3 = 0.0F;
          paramFloat1 = f2;
        }
        else
        {
          paramFloat1 = f2;
        }
      }
      else if (paramFloat1 > 1.0F)
      {
        paramFloat1 = 1.0F;
        f3 = f1;
      }
      else
      {
        f3 = f1;
      }
    }
    PointF localPointF = this.anchorPoint;
    localPointF.x = ((f4 + f5) / 2.0F);
    localPointF.y = ((f3 + paramFloat1) / 2.0F);
  }
  
  public void reset()
  {
    PointF localPointF = this.anchorPoint;
    localPointF.y = 0.0F;
    localPointF.x = 0.0F;
    this.scaleValue = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.zoomfilter.TransScaleInfo
 * JD-Core Version:    0.7.0.1
 */