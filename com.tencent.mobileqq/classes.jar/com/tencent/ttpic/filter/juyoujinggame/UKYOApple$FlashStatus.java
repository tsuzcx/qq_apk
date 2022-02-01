package com.tencent.ttpic.filter.juyoujinggame;

class UKYOApple$FlashStatus
{
  protected int frameIndex = 0;
  protected float[] mAdjustPoints;
  private boolean mIsDisappear = false;
  private int mPlayCount = 0;
  private FlashItemSetting mSetting;
  private long mStartPlayTime;
  
  public UKYOApple$FlashStatus(UKYOApple paramUKYOApple, FlashItemSetting paramFlashItemSetting, long paramLong)
  {
    this.mSetting = paramFlashItemSetting;
    this.mStartPlayTime = paramLong;
    this.frameIndex = 1;
  }
  
  public void updateIndex(long paramLong)
  {
    this.frameIndex += 1;
    if (this.frameIndex >= this.mSetting.mFrames - 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsDisappear = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOApple.FlashStatus
 * JD-Core Version:    0.7.0.1
 */