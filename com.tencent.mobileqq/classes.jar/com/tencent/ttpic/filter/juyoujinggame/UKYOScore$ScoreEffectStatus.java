package com.tencent.ttpic.filter.juyoujinggame;

import com.tencent.ttpic.openapi.model.StickerItem;

public class UKYOScore$ScoreEffectStatus
  extends UKYOScore.ScoreStatus
{
  private int FRAMES;
  private int mFrameDuration;
  private boolean mIsAppear = false;
  protected int mLastScore = 0;
  private long mStartTime = -1L;
  
  public UKYOScore$ScoreEffectStatus(UKYOScore paramUKYOScore, StickerItem paramStickerItem)
  {
    super(paramUKYOScore, paramStickerItem);
    if (paramStickerItem == null) {
      return;
    }
    this.mFrameDuration = ((int)paramStickerItem.frameDuration);
    this.FRAMES = paramStickerItem.frames;
    this.mImageID = paramStickerItem.id;
  }
  
  public boolean isAppear()
  {
    return this.mIsAppear;
  }
  
  public void needAppear()
  {
    if (this.mImageID != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsAppear = bool;
      return;
    }
  }
  
  public void reset()
  {
    this.mStartTime = -1L;
    this.mCurIndex = -1;
    this.mIsAppear = false;
  }
  
  public void updateFrameIndex(long paramLong)
  {
    if (this.mFrameDuration == 0) {}
    for (this.mCurIndex += 1;; this.mCurIndex += 1)
    {
      int i;
      do
      {
        if (this.mCurIndex >= this.FRAMES) {
          reset();
        }
        return;
        if (this.mStartTime == -1L)
        {
          this.mStartTime = paramLong;
          this.mCurIndex = 0;
          return;
        }
        i = (int)(paramLong - this.mStartTime);
      } while ((i <= 0) || (i / this.mFrameDuration - this.mCurIndex <= 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScore.ScoreEffectStatus
 * JD-Core Version:    0.7.0.1
 */