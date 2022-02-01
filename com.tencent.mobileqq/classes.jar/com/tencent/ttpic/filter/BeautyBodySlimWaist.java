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
    PointF localPointF = new PointF(0.0F, 0.0F);
    float f1 = 0.0F;
    int i = 0;
    while (i < j)
    {
      f2 = localPointF.x;
      f3 = ((PointF)paramList.get(rightIndex[i])).x;
      localPointF.x = ((((PointF)paramList.get(leftIndex[i])).x + f3) / 2.0F + f2);
      f2 = localPointF.y;
      f3 = ((PointF)paramList.get(rightIndex[i])).y;
      localPointF.y = ((((PointF)paramList.get(leftIndex[i])).y + f3) / 2.0F + f2);
      f1 += ((PointF)paramList.get(rightIndex[i])).x - ((PointF)paramList.get(leftIndex[i])).x;
      i += 1;
    }
    localPointF.x /= j;
    localPointF.y /= j;
    float f4 = (float)(f1 / j * 1.9D);
    f1 = (float)(f4 * 0.7D);
    float f2 = (localPointF.x - f4 / 2.0F) / paramInt1;
    float f3 = (localPointF.y - f1 / 2.0F) / paramInt2;
    float f5 = localPointF.x;
    f4 = (f4 / 2.0F + f5) / paramInt1;
    f5 = localPointF.y;
    return new RectF(f2, f3, f4, (f1 / 2.0F + f5) / paramInt2);
  }
  
  private RectF getSmoothedRect()
  {
    int i = 0;
    RectF localRectF1 = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    int k;
    float f1;
    float f2;
    for (int j = 0; i < this.smoothedWithinFrames; j = k)
    {
      k = j;
      if (this.previousValid[i] != 0)
      {
        k = j + 1;
        RectF localRectF2 = this.previousRects[i];
        f1 = localRectF2.left;
        f2 = localRectF1.left;
        float f3 = localRectF2.right;
        float f4 = localRectF1.right;
        localRectF1.set(f1 + f2, localRectF2.top + localRectF1.top, f3 + f4, localRectF2.bottom + localRectF1.bottom);
      }
      i += 1;
    }
    if (j > 0)
    {
      f1 = localRectF1.left / j;
      f2 = localRectF1.right / j;
      localRectF1.set(f1, localRectF1.top / j, f2, localRectF1.bottom / j);
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
    boolean bool = true;
    this.currentIdx = ((this.currentIdx + 1) % this.smoothedWithinFrames);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.previousValid[this.currentIdx] = false;
      if ((!this.mHasSeenValid) || (System.currentTimeMillis() - this.mPreviousLostTime >= this.mTimesForLostProtect)) {
        break label162;
      }
      this.mCurrentRect = this.mPreviousValidRect;
    }
    for (;;)
    {
      if (bool) {
        this.slimWaistParameters = new BeautyBodySlimWaist.SlimWaistParameters(this, new RectF(this.mCurrentRect));
      }
      return bool;
      this.mHasSeenValid = true;
      paramList = calculateRectPoints(paramList, paramInt1, paramInt2);
      this.previousValid[this.currentIdx] = true;
      this.previousRects[this.currentIdx] = paramList;
      this.mCurrentRect = getSmoothedRect();
      this.mPreviousValidRect = getSmoothedRect();
      this.mPreviousLostTime = System.currentTimeMillis();
      continue;
      label162:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodySlimWaist
 * JD-Core Version:    0.7.0.1
 */