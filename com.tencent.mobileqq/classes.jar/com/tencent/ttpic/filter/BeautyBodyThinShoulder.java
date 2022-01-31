package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;

public class BeautyBodyThinShoulder
{
  private static final int[] leftIndexs = { 13, 14, 15, 16, 17 };
  private static final int[] rightIndexs = { 45, 44, 43, 42, 41 };
  private PointF center;
  private int currentIdx;
  private boolean hasSeenValid;
  private float height;
  private long lastValidTime;
  private BeautyBodyThinShoulder.ThinShoulderParameters params;
  private BeautyBodyThinShoulder.ThinShoulderParameters[] previousParams;
  private boolean[] previousValidFrames;
  private BeautyBodyThinShoulder.ThinShoulderParameters previousValidParams;
  private float prop;
  private BeautyBodyThinShoulder.ThinShoulderParameters smoothedParams;
  private int smoothedWithinFrames;
  private BeautyBodyThinShoulder.ThinShoulderParameters thinShoulderParameters;
  private long validDuration;
  private float width;
  
  public BeautyBodyThinShoulder()
  {
    initParams();
    this.smoothedWithinFrames = 2;
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
      this.params = new BeautyBodyThinShoulder.ThinShoulderParameters(this);
    }
    if (this.thinShoulderParameters == null) {
      this.thinShoulderParameters = new BeautyBodyThinShoulder.ThinShoulderParameters(this);
    }
    if (this.previousParams == null)
    {
      this.previousParams = new BeautyBodyThinShoulder.ThinShoulderParameters[this.smoothedWithinFrames];
      i = 0;
      while (i < this.smoothedWithinFrames)
      {
        this.previousParams[i] = new BeautyBodyThinShoulder.ThinShoulderParameters(this);
        i += 1;
      }
    }
    if (this.previousValidParams == null) {
      this.previousValidParams = new BeautyBodyThinShoulder.ThinShoulderParameters(this);
    }
    if (this.smoothedParams == null) {
      this.smoothedParams = new BeautyBodyThinShoulder.ThinShoulderParameters(this);
    }
    this.smoothedParams.reset();
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    int j = 0;
    int i = k;
    float f4;
    while (i < this.smoothedWithinFrames)
    {
      float f6 = f1;
      float f5 = f2;
      f4 = f3;
      k = j;
      if (this.previousValidFrames[i] != 0)
      {
        k = j + 1;
        BeautyBodyThinShoulder.ThinShoulderParameters localThinShoulderParameters = this.previousParams[i];
        f4 = f3 + localThinShoulderParameters.rect.left;
        f5 = f2 + localThinShoulderParameters.rect.top;
        f6 = f1 + localThinShoulderParameters.rect.right + localThinShoulderParameters.rect.bottom;
      }
      i += 1;
      f1 = f6;
      f2 = f5;
      f3 = f4;
      j = k;
    }
    if (j > 0)
    {
      f3 /= j;
      f2 /= j;
      f1 /= j;
      f4 = 0.0F / j;
      this.smoothedParams.rect = new RectF(f3, f2, f1, f4);
    }
  }
  
  public void calculateMiddleLineWithNormalizedPoints(PointF[] paramArrayOfPointF)
  {
    int i = 0;
    float f1 = 0.0F;
    int j = leftIndexs.length;
    PointF localPointF1 = paramArrayOfPointF[0];
    PointF localPointF2 = paramArrayOfPointF[58];
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < j)
    {
      PointF localPointF3 = paramArrayOfPointF[leftIndexs[i]];
      PointF localPointF4 = paramArrayOfPointF[rightIndexs[i]];
      f4 += (localPointF3.x + localPointF4.x) / 2.0F;
      f3 += (localPointF3.y + localPointF4.y) / 2.0F;
      f2 += localPointF4.x - localPointF3.x;
      f1 += localPointF3.y + localPointF4.y - localPointF1.y - localPointF2.y;
      i += 1;
    }
    setParams(new BeautyBodyThinShoulder.ThinShoulderParameters(this, new RectF(f4 / j, f3 / j - 0.05F * f1, f2 / j * 2.0F, f1 * 0.18F)));
  }
  
  public BeautyBodyThinShoulder.ThinShoulderParameters getThinShoulderParameters()
  {
    return this.thinShoulderParameters;
  }
  
  public void initParams()
  {
    this.center = new PointF();
    this.prop = 0.5625F;
  }
  
  public void resetState()
  {
    this.hasSeenValid = false;
    this.previousParams = null;
  }
  
  public void setCenter(PointF paramPointF)
  {
    if (paramPointF.x < 0.0F) {
      this.center.x = 0.0F;
    }
    while (paramPointF.y < 0.0F)
    {
      this.center.y = 0.0F;
      return;
      if (paramPointF.x > 1.0F) {
        this.center.x = 1.0F;
      } else {
        this.center.x = paramPointF.x;
      }
    }
    if (paramPointF.y > 1.0F)
    {
      this.center.y = 1.0F;
      return;
    }
    this.center.y = paramPointF.y;
  }
  
  public void setHeight(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      this.height = 1.0F;
      return;
    }
    if (paramFloat < 0.0F)
    {
      this.height = 0.0F;
      return;
    }
    this.height = paramFloat;
  }
  
  public void setParams(BeautyBodyThinShoulder.ThinShoulderParameters paramThinShoulderParameters)
  {
    setCenter(new PointF(paramThinShoulderParameters.rect.left, paramThinShoulderParameters.rect.top));
    setWidth(paramThinShoulderParameters.rect.right);
    setHeight(paramThinShoulderParameters.rect.bottom);
    this.thinShoulderParameters = paramThinShoulderParameters;
  }
  
  public void setProp(float paramFloat)
  {
    if (paramFloat > 2.0F)
    {
      this.prop = 2.0F;
      return;
    }
    if (paramFloat < 0.5F)
    {
      this.prop = 0.5F;
      return;
    }
    this.prop = paramFloat;
  }
  
  public void setWidth(float paramFloat)
  {
    if (paramFloat > 1.0F)
    {
      this.width = 1.0F;
      return;
    }
    if (paramFloat < 0.0F)
    {
      this.width = 0.0F;
      return;
    }
    this.width = paramFloat;
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
      this.previousValidFrames[this.currentIdx] = true;
      this.previousParams[this.currentIdx] = this.params.copy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodyThinShoulder
 * JD-Core Version:    0.7.0.1
 */