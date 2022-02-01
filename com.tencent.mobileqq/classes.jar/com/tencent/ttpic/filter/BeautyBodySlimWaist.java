package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

public class BeautyBodySlimWaist
{
  private static int[] leftIndex = { 13, 14, 15, 16, 17 };
  private static int[] rightIndex = { 41, 42, 43, 44, 45 };
  private int currentIdx = 0;
  private RectF mCurrentRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private boolean mHasSeenValid = false;
  private long mPreviousLostTime = System.currentTimeMillis();
  private RectF mPreviousValidRect = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private long mTimesForLostProtect = 2000L;
  private final float maxX0 = 0.68F;
  private RectF[] previousRects = { new RectF(0.0F, 0.0F, 0.0F, 0.0F), new RectF(0.0F, 0.0F, 0.0F, 0.0F), new RectF(0.0F, 0.0F, 0.0F, 0.0F), new RectF(0.0F, 0.0F, 0.0F, 0.0F) };
  private boolean[] previousValid = { 0, 0, 0, 0 };
  private BeautyBodySlimWaist.SlimWaistParameters slimWaistParameters = new BeautyBodySlimWaist.SlimWaistParameters(this);
  private int smoothedWithinFrames = 2;
  private final float t0 = 0.6F;
  
  private RectF calculateRectPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    int j = leftIndex.length;
    float f1 = 0.0F;
    PointF localPointF = new PointF(0.0F, 0.0F);
    int i = 0;
    while (i < j)
    {
      localPointF.x += (((PointF)paramList.get(rightIndex[i])).x + ((PointF)paramList.get(leftIndex[i])).x) / 2.0F;
      localPointF.y += (((PointF)paramList.get(rightIndex[i])).y + ((PointF)paramList.get(leftIndex[i])).y) / 2.0F;
      f1 += ((PointF)paramList.get(rightIndex[i])).x - ((PointF)paramList.get(leftIndex[i])).x;
      i += 1;
    }
    float f2 = localPointF.x;
    float f3 = j;
    localPointF.x = (f2 / f3);
    localPointF.y /= f3;
    double d = f1 / f3;
    Double.isNaN(d);
    f1 = (float)(d * 1.9D);
    d = f1;
    Double.isNaN(d);
    f3 = (float)(d * 0.7D);
    float f4 = localPointF.x;
    f1 /= 2.0F;
    f2 = paramInt1;
    f4 = (f4 - f1) / f2;
    float f5 = localPointF.y;
    f3 /= 2.0F;
    float f6 = paramInt2;
    return new RectF(f4, (f5 - f3) / f6, (localPointF.x + f1) / f2, (localPointF.y + f3) / f6);
  }
  
  private RectF getSmoothedRect()
  {
    RectF localRectF1 = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    int i = 0;
    int k;
    float f1;
    float f2;
    float f3;
    for (int j = 0; i < this.smoothedWithinFrames; j = k)
    {
      k = j;
      if (this.previousValid[i] != 0)
      {
        k = j + 1;
        RectF localRectF2 = this.previousRects[i];
        f1 = localRectF2.left;
        f2 = localRectF1.left;
        f3 = localRectF2.right;
        float f4 = localRectF1.right;
        localRectF1.set(f1 + f2, localRectF2.top + localRectF1.top, f3 + f4, localRectF2.bottom + localRectF1.bottom);
      }
      i += 1;
    }
    if (j > 0)
    {
      f2 = localRectF1.left;
      f1 = j;
      f2 /= f1;
      f3 = localRectF1.right / f1;
      localRectF1.set(f2, localRectF1.top / f1, f3, localRectF1.bottom / f1);
    }
    return localRectF1;
  }
  
  public BeautyBodySlimWaist.SlimWaistParameters getSlimWaistParameters()
  {
    return this.slimWaistParameters;
  }
  
  public void setSlimWaistParameters(BeautyBodySlimWaist.SlimWaistParameters paramSlimWaistParameters)
  {
    this.slimWaistParameters = paramSlimWaistParameters;
  }
  
  public void setStatusReset()
  {
    this.mHasSeenValid = false;
    this.mPreviousValidRect = null;
    this.currentIdx = 0;
    int i = 0;
    while (i < this.smoothedWithinFrames)
    {
      this.previousValid[i] = false;
      this.previousRects[i].set(0.0F, 0.0F, 0.0F, 0.0F);
      i += 1;
    }
  }
  
  public void setStrength(float paramFloat) {}
  
  public boolean setWaistRectangle(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    int i = this.currentIdx;
    boolean bool = true;
    this.currentIdx = ((i + 1) % this.smoothedWithinFrames);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.mHasSeenValid = true;
      paramList = calculateRectPoints(paramList, paramInt1, paramInt2);
      boolean[] arrayOfBoolean = this.previousValid;
      paramInt1 = this.currentIdx;
      arrayOfBoolean[paramInt1] = true;
      this.previousRects[paramInt1] = paramList;
      this.mCurrentRect = getSmoothedRect();
      this.mPreviousValidRect = getSmoothedRect();
      this.mPreviousLostTime = System.currentTimeMillis();
    }
    else
    {
      this.previousValid[this.currentIdx] = false;
      if ((this.mHasSeenValid) && (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect)) {
        this.mCurrentRect = this.mPreviousValidRect;
      } else {
        bool = false;
      }
    }
    if (bool) {
      this.slimWaistParameters = new BeautyBodySlimWaist.SlimWaistParameters(this, new RectF(this.mCurrentRect));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodySlimWaist
 * JD-Core Version:    0.7.0.1
 */