package com.tencent.mobileqq.shortvideo.bighead;

public class BigHeadAnimation
  implements BigIAnimation
{
  private boolean mForward = true;
  public float mMaxScale;
  public float mMinScale;
  private long mStartTime = -1L;
  public float mTimeCycle;
  private float scaleNumber = 0.0F;
  
  public BigHeadAnimation()
  {
    setAnimationAttr(1.15F, 1.4F, 800.0F);
  }
  
  private void setAnimationAttr(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mMinScale = paramFloat1;
    this.mMaxScale = paramFloat2;
    this.mTimeCycle = paramFloat3;
    this.scaleNumber = (this.mMaxScale - this.mMinScale);
  }
  
  public float getCurrentScale(long paramLong)
  {
    if (this.mStartTime == -1L) {
      this.mStartTime = paramLong;
    }
    float f2 = Math.min((float)(paramLong - this.mStartTime) * 1.0F / this.mTimeCycle, 1.0F);
    float f1;
    if (this.mForward)
    {
      f1 = this.mMinScale + this.scaleNumber * f2;
      if (f2 >= 1.0F)
      {
        this.mStartTime = -1L;
        if (this.mForward) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.mForward = bool;
      return f1;
      f1 = this.mMaxScale - this.scaleNumber * f2;
      break;
    }
  }
  
  public float getMaxScale()
  {
    return this.mMaxScale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadAnimation
 * JD-Core Version:    0.7.0.1
 */