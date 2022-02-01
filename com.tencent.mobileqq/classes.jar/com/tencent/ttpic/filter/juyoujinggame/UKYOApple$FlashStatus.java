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
    int i = this.frameIndex;
    boolean bool = true;
    this.frameIndex = (i + 1);
    if (this.frameIndex < this.mSetting.mFrames - 1) {
      bool = false;
    }
    this.mIsDisappear = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOApple.FlashStatus
 * JD-Core Version:    0.7.0.1
 */