package com.tencent.mobileqq.shortvideo.bighead;

import com.tencent.ttpic.openapi.model.BigAnimationParam;
import com.tencent.ttpic.openapi.model.BigItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Iterator;

public class BigHeadAnimationConfig
  implements BigIAnimation
{
  private BigAnimationParam mBigHeadParam;
  private int mCurrentIndex = 0;
  private float mLastScaleRatio;
  private int mPlayCount = 0;
  private long mStartTime = -1L;
  
  BigHeadAnimationConfig(VideoMaterial paramVideoMaterial)
  {
    this.mBigHeadParam = paramVideoMaterial.mBigHeadParam;
    this.mPlayCount = 0;
  }
  
  public float getCurrentScale(long paramLong)
  {
    float f1 = 1.0F;
    float f2 = f1;
    if (this.mBigHeadParam != null)
    {
      f2 = f1;
      if (this.mBigHeadParam.animation != null)
      {
        if (this.mBigHeadParam.animation.size() > 0) {
          break label44;
        }
        f2 = f1;
      }
    }
    label44:
    do
    {
      return f2;
      f2 = f1;
    } while (this.mBigHeadParam.repeatCount == 0);
    if ((this.mBigHeadParam.repeatCount == -1) || (this.mPlayCount < this.mBigHeadParam.repeatCount))
    {
      if (this.mStartTime == -1L)
      {
        this.mStartTime = paramLong;
        this.mCurrentIndex = 0;
        this.mLastScaleRatio = 1.0F;
      }
      paramLong -= this.mStartTime;
      BigItem localBigItem = (BigItem)this.mBigHeadParam.animation.get(this.mCurrentIndex);
      if ((paramLong < localBigItem.beginTime) || (localBigItem.beginTime >= localBigItem.endTime)) {
        f1 = this.mLastScaleRatio;
      }
      for (;;)
      {
        this.mLastScaleRatio = f1;
        f2 = f1;
        if (localBigItem.endTime == -1L) {
          break;
        }
        if (paramLong > localBigItem.endTime) {
          this.mCurrentIndex += 1;
        }
        if (this.mCurrentIndex < this.mBigHeadParam.animation.size()) {
          break label321;
        }
        this.mStartTime = -1L;
        this.mPlayCount += 1;
        return f1;
        if (localBigItem.endTime > 0L)
        {
          f1 = Math.min((float)(paramLong - localBigItem.beginTime) * 1.0F / (float)(localBigItem.endTime - localBigItem.beginTime), 1.0F);
          f2 = localBigItem.beginScale;
          f1 = f1 * (localBigItem.endScale - localBigItem.beginScale) + f2;
        }
        else
        {
          f1 = (localBigItem.endScale + localBigItem.beginScale) / 2.0F;
        }
      }
      label321:
      int i = this.mCurrentIndex;
      for (;;)
      {
        if (i < this.mBigHeadParam.animation.size())
        {
          localBigItem = (BigItem)this.mBigHeadParam.animation.get(i);
          if ((paramLong >= localBigItem.endTime) && (localBigItem.endTime != -1L)) {}
        }
        else
        {
          this.mCurrentIndex = i;
          f2 = f1;
          if (this.mCurrentIndex < this.mBigHeadParam.animation.size()) {
            break;
          }
          this.mStartTime = -1L;
          this.mPlayCount += 1;
          return f1;
        }
        i += 1;
      }
    }
    return this.mLastScaleRatio;
  }
  
  public float getMaxScale()
  {
    if (this.mBigHeadParam == null) {}
    while ((this.mBigHeadParam.animation == null) || (this.mBigHeadParam.animation.size() <= 0)) {
      return 1.0F;
    }
    Iterator localIterator = this.mBigHeadParam.animation.iterator();
    BigItem localBigItem;
    for (float f = 1.0F; localIterator.hasNext(); f = Math.max(f, Math.max(localBigItem.endScale, localBigItem.beginScale))) {
      localBigItem = (BigItem)localIterator.next();
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadAnimationConfig
 * JD-Core Version:    0.7.0.1
 */