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
    boolean bool;
    if (this.mImageID != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsAppear = bool;
  }
  
  public void reset()
  {
    this.mStartTime = -1L;
    this.mCurIndex = -1;
    this.mIsAppear = false;
  }
  
  public void updateFrameIndex(long paramLong)
  {
    int i = this.mFrameDuration;
    if (i == 0)
    {
      this.mCurIndex += 1;
    }
    else
    {
      long l = this.mStartTime;
      if (l == -1L)
      {
        this.mStartTime = paramLong;
        this.mCurIndex = 0;
        return;
      }
      int j = (int)(paramLong - l);
      if ((j > 0) && (j / i - this.mCurIndex > 1)) {
        this.mCurIndex += 1;
      }
    }
    if (this.mCurIndex >= this.FRAMES) {
      reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOScore.ScoreEffectStatus
 * JD-Core Version:    0.7.0.1
 */