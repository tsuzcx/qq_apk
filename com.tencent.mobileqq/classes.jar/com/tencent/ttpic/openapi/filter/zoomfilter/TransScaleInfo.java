package com.tencent.ttpic.openapi.filter.zoomfilter;

import android.graphics.PointF;

public class TransScaleInfo
{
  PointF anchorPoint = new PointF(0.0F, 0.0F);
  float scaleValue = 1.0F;
  
  public void checkVaild(float paramFloat1, float paramFloat2)
  {
    float f7 = 1.0F;
    float f8 = 0.0F;
    float f1 = this.anchorPoint.x - paramFloat1 / 2.0F;
    float f4 = this.anchorPoint.y - paramFloat2 / 2.0F;
    float f2 = this.anchorPoint.x + paramFloat1 / 2.0F;
    float f3 = this.anchorPoint.y;
    float f5 = paramFloat2 / 2.0F + f3;
    f3 = f1;
    if (f1 < 0.0F) {
      f3 = 0.0F;
    }
    f1 = f4;
    if (f4 < 0.0F) {
      f1 = 0.0F;
    }
    f4 = f2;
    if (f2 > 1.0F) {
      f4 = 1.0F;
    }
    f2 = f5;
    if (f5 > 1.0F) {
      f2 = 1.0F;
    }
    f5 = f4;
    float f6 = f3;
    if (f4 - f3 < paramFloat1)
    {
      if (f3 + paramFloat1 > 1.0D)
      {
        f3 = f4 - paramFloat1;
        paramFloat1 = f3;
        if (f3 < 0.0F) {
          paramFloat1 = 0.0F;
        }
        f6 = paramFloat1;
        f5 = f4;
      }
    }
    else
    {
      if (f2 - f1 >= paramFloat2) {
        break label280;
      }
      if (f1 + paramFloat2 <= 1.0D) {
        break label259;
      }
      paramFloat1 = f2 - paramFloat2;
      if (paramFloat1 >= 0.0F) {
        break label256;
      }
      paramFloat1 = f8;
      label198:
      paramFloat2 = f2;
    }
    for (;;)
    {
      this.anchorPoint.x = ((f6 + f5) / 2.0F);
      this.anchorPoint.y = ((paramFloat1 + paramFloat2) / 2.0F);
      return;
      f4 = f3 + paramFloat1;
      paramFloat1 = f4;
      if (f4 > 1.0F) {
        paramFloat1 = 1.0F;
      }
      f5 = paramFloat1;
      f6 = f3;
      break;
      label256:
      break label198;
      label259:
      paramFloat2 = f1 + paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat2 = f7;
      }
      for (;;)
      {
        paramFloat1 = f1;
        break;
      }
      label280:
      paramFloat2 = f2;
      paramFloat1 = f1;
    }
  }
  
  public void reset()
  {
    this.anchorPoint.y = 0.0F;
    this.anchorPoint.x = 0.0F;
    this.scaleValue = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.zoomfilter.TransScaleInfo
 * JD-Core Version:    0.7.0.1
 */