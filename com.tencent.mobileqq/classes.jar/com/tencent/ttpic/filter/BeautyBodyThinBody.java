package com.tencent.ttpic.filter;

import android.graphics.PointF;

public class BeautyBodyThinBody
{
  private static final int[] leftIndexs = { 13, 14, 15, 16, 17 };
  private static final int[] rightIndexs = { 45, 44, 43, 42, 41 };
  private int currentIdx;
  private boolean hasSeenValid;
  private long lastValidTime;
  private BeautyBodyThinBody.ThinBodyParameters params;
  private BeautyBodyThinBody.ThinBodyParameters[] previousParams;
  private boolean[] previousValidFrames;
  private BeautyBodyThinBody.ThinBodyParameters previousValidParams;
  private BeautyBodyThinBody.ThinBodyParameters smoothedParams;
  private int smoothedWithinFrames = 2;
  private long validDuration;
  
  public BeautyBodyThinBody()
  {
    int k = 0;
    this.currentIdx = 0;
    this.validDuration = 2000L;
    this.hasSeenValid = false;
    if (this.previousValidFrames == null)
    {
      this.previousValidFrames = new boolean[this.smoothedWithinFrames];
      i = 0;
      while (i < this.smoothedWithinFrames)
      {
        this.previousValidFrames[i] = false;
        i += 1;
      }
    }
    if (this.params == null) {
      this.params = new BeautyBodyThinBody.ThinBodyParameters(this);
    }
    if (this.previousParams == null)
    {
      this.previousParams = new BeautyBodyThinBody.ThinBodyParameters[this.smoothedWithinFrames];
      i = 0;
      while (i < this.smoothedWithinFrames)
      {
        this.previousParams[i] = new BeautyBodyThinBody.ThinBodyParameters(this);
        i += 1;
      }
    }
    if (this.smoothedParams == null) {
      this.smoothedParams = new BeautyBodyThinBody.ThinBodyParameters(this);
    }
    this.smoothedParams.reset();
    int j = 0;
    int i = k;
    BeautyBodyThinBody.ThinBodyParameters localThinBodyParameters1;
    while (i < this.smoothedWithinFrames)
    {
      k = j;
      if (this.previousValidFrames[i] == 1)
      {
        k = j + 1;
        localThinBodyParameters1 = this.previousParams[i];
        BeautyBodyThinBody.ThinBodyParameters localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.y0 += localThinBodyParameters1.y0;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.y1 += localThinBodyParameters1.y1;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.y2 += localThinBodyParameters1.y2;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.middleLine += localThinBodyParameters1.middleLine;
        localThinBodyParameters2 = this.smoothedParams;
        localThinBodyParameters2.waistWidth += localThinBodyParameters1.waistWidth;
      }
      i += 1;
      j = k;
    }
    if (j > 0)
    {
      localThinBodyParameters1 = this.smoothedParams;
      float f1 = localThinBodyParameters1.y0;
      float f2 = j;
      localThinBodyParameters1.y0 = (f1 / f2);
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.y1 /= f2;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.y2 /= f2;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.middleLine /= f2;
      localThinBodyParameters1 = this.smoothedParams;
      localThinBodyParameters1.waistWidth /= f2;
    }
  }
  
  private void calculateMiddleLineWithNormalizedPoints(PointF[] paramArrayOfPointF)
  {
    int j = leftIndexs.length;
    int i = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      PointF localPointF1 = paramArrayOfPointF[leftIndexs[i]];
      PointF localPointF2 = paramArrayOfPointF[rightIndexs[i]];
      f3 += (localPointF1.x + localPointF2.x) / 2.0F;
      f2 += (localPointF1.y + localPointF2.y) / 2.0F;
      f1 += localPointF2.x - localPointF1.x;
      i += 1;
    }
    float f4 = (paramArrayOfPointF[0].y + paramArrayOfPointF[58].y) / 2.0F;
    float f5 = j;
    f3 /= f5;
    f2 /= f5;
    f1 /= f5;
    setMiddleLine(f3);
    setY0(f4);
    setY1(f2 - 0.0F * f1);
    setY2(f2 + 0.4F * f1);
    setWaistWidth(f1);
  }
  
  public BeautyBodyThinBody.ThinBodyParameters getThinBodyParameters()
  {
    return this.params;
  }
  
  public void setMiddleLine(float paramFloat)
  {
    if (paramFloat < 0.1F)
    {
      this.params.middleLine = 0.1F;
      return;
    }
    if (paramFloat > 0.9F)
    {
      this.params.middleLine = 0.9F;
      return;
    }
    this.params.middleLine = paramFloat;
  }
  
  public void setWaistWidth(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.params.waistWidth = 0.0F;
      return;
    }
    if (paramFloat > 1.0F)
    {
      this.params.waistWidth = 1.0F;
      return;
    }
    this.params.waistWidth = paramFloat;
  }
  
  public void setY0(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.params.y0 = 0.0F;
      return;
    }
    if (paramFloat > this.params.y1)
    {
      BeautyBodyThinBody.ThinBodyParameters localThinBodyParameters = this.params;
      localThinBodyParameters.y0 = localThinBodyParameters.y1;
      return;
    }
    this.params.y0 = paramFloat;
  }
  
  public void setY1(float paramFloat)
  {
    BeautyBodyThinBody.ThinBodyParameters localThinBodyParameters;
    if (paramFloat > this.params.y2)
    {
      localThinBodyParameters = this.params;
      localThinBodyParameters.y1 = localThinBodyParameters.y2;
      return;
    }
    if (paramFloat < this.params.y0)
    {
      localThinBodyParameters = this.params;
      localThinBodyParameters.y1 = localThinBodyParameters.y0;
      return;
    }
    this.params.y1 = paramFloat;
  }
  
  public void setY2(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      this.params.y2 = 1.0F;
      return;
    }
    if (paramFloat < this.params.y1)
    {
      BeautyBodyThinBody.ThinBodyParameters localThinBodyParameters = this.params;
      localThinBodyParameters.y2 = localThinBodyParameters.y1;
      return;
    }
    this.params.y2 = paramFloat;
  }
  
  public boolean setupBodyPoints(PointF[] paramArrayOfPointF)
  {
    this.currentIdx += 1;
    if (this.currentIdx >= this.smoothedWithinFrames) {
      this.currentIdx = 0;
    }
    if (paramArrayOfPointF != null)
    {
      this.hasSeenValid = true;
      calculateMiddleLineWithNormalizedPoints(paramArrayOfPointF);
      paramArrayOfPointF = this.previousValidFrames;
      int i = this.currentIdx;
      paramArrayOfPointF[i] = 1;
      this.previousParams[i] = this.params.copy();
      paramArrayOfPointF = this.smoothedParams;
      this.params = paramArrayOfPointF;
      this.previousValidParams = paramArrayOfPointF;
      this.lastValidTime = System.currentTimeMillis();
      return true;
    }
    this.previousValidFrames[this.currentIdx] = false;
    if ((this.hasSeenValid) && (System.currentTimeMillis() - this.lastValidTime < this.validDuration))
    {
      this.params = this.previousValidParams;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodyThinBody
 * JD-Core Version:    0.7.0.1
 */