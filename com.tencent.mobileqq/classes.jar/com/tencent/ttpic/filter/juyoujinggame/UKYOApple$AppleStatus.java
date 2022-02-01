package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.RectF;
import android.util.Log;
import com.tencent.ttpic.util.AlgoUtils;

public class UKYOApple$AppleStatus
  implements IHittingStatus
{
  private final int STATUS_START_TIME_FROM_INITED;
  protected int frameIndex = -1;
  private boolean isNeedUpdatePosition = true;
  protected float[] mAdjustPoints;
  protected RectF mCurAPPRec;
  private UKYOApple.APPLE_STATUS mCurrentStatus = UKYOApple.APPLE_STATUS.DROPPING;
  private boolean mIsAppear = false;
  private int mIsDisappear = -1;
  private double mLeftScaleFactor = UKYOApple.access$400(this.this$0, Math.random() * 0.9D);
  private int mPlayCount = 0;
  private long[] mPlayingStarTime = { -1L, -1L };
  private long mPreTime = -1L;
  private AppleItemSetting mSetting;
  
  public UKYOApple$AppleStatus(UKYOApple paramUKYOApple, AppleItemSetting paramAppleItemSetting, int paramInt)
  {
    reset();
    this.mSetting = paramAppleItemSetting;
    this.mCurAPPRec = new RectF((float)(this.mLeftScaleFactor * paramAppleItemSetting.mWidth), 0.0F, 0.0F, 0.0F);
    this.STATUS_START_TIME_FROM_INITED = paramInt;
  }
  
  private int getFrameIndex()
  {
    return this.frameIndex;
  }
  
  private String getImageID()
  {
    return this.mSetting.getImageID(this.mCurrentStatus);
  }
  
  private void updateFrameIndex(long paramLong)
  {
    int i = this.frameIndex + 1;
    this.mPlayCount = (i / Math.max(this.mSetting.mFrames[this.mCurrentStatus.getValue()], 1));
    this.frameIndex = (i % Math.max(this.mSetting.mFrames[this.mCurrentStatus.getValue()], 1));
    if ((this.mCurrentStatus == UKYOApple.APPLE_STATUS.HITTING) && (i >= this.mSetting.mFrames[UKYOApple.APPLE_STATUS.HITTING.getValue()])) {
      this.mIsDisappear = 1;
    }
    while ((this.mCurrentStatus != UKYOApple.APPLE_STATUS.DROPPING) || (this.mCurAPPRec.bottom <= UKYOApple.access$500(this.this$0))) {
      return;
    }
    this.mIsDisappear = 0;
  }
  
  private void updateStartTime(long paramLong)
  {
    if (this.mPlayingStarTime[this.mCurrentStatus.getValue()] == -1L)
    {
      this.mPlayingStarTime[this.mCurrentStatus.getValue()] = paramLong;
      this.mPlayingStarTime[((this.mCurrentStatus.getValue() + 1) % 2)] = -1L;
      this.frameIndex = -1;
    }
  }
  
  public RectF getRectF()
  {
    return this.mCurAPPRec;
  }
  
  public boolean isAppear()
  {
    return this.mIsAppear;
  }
  
  public boolean isHitting()
  {
    return this.mCurrentStatus == UKYOApple.APPLE_STATUS.HITTING;
  }
  
  public void reset()
  {
    this.mCurrentStatus = UKYOApple.APPLE_STATUS.DROPPING;
    this.mLeftScaleFactor = UKYOApple.access$400(this.this$0, Math.random() * 0.9D);
    int i = 0;
    while (i < this.mPlayingStarTime.length)
    {
      this.mPlayingStarTime[i] = -1L;
      i += 1;
    }
    this.mPlayCount = 0;
    this.mIsDisappear = -1;
    this.mIsAppear = false;
    this.mAdjustPoints = null;
    this.mCurAPPRec = null;
    if (this.mSetting != null) {
      this.mCurAPPRec = new RectF((float)(this.mLeftScaleFactor * this.mSetting.mWidth), 0.0F, 0.0F, 0.0F);
    }
    this.mPreTime = -1L;
    this.frameIndex = -1;
    this.isNeedUpdatePosition = true;
  }
  
  public boolean updateAppearStatus(long paramLong)
  {
    if ((this.STATUS_START_TIME_FROM_INITED >= 0) && (this.mIsDisappear < 0) && (paramLong >= this.STATUS_START_TIME_FROM_INITED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsAppear = bool;
      Log.i("greatgao", this.STATUS_START_TIME_FROM_INITED + "-> Appear:" + this.mIsAppear);
      return this.mIsAppear;
    }
  }
  
  public void updateHitting(boolean paramBoolean)
  {
    if ((this.mIsAppear) && (paramBoolean) && (UKYOApple.APPLE_STATUS.HITTING != this.mCurrentStatus))
    {
      this.this$0.updatePlayerAAttack(true);
      UKYOApple.access$608(this.this$0);
      UKYOApple.access$702(this.this$0, UKYOApple.access$700(this.this$0) + 1);
      Log.i("greatgao03", "Score:" + UKYOApple.access$600(this.this$0));
      this.isNeedUpdatePosition = false;
      this.mCurrentStatus = UKYOApple.APPLE_STATUS.HITTING;
      updateStartTime(UKYOApple.access$800(this.this$0));
      Log.i("greatgao020", "APPLE HITTING");
    }
  }
  
  public float[] updatePosition(long paramLong)
  {
    if ((!this.mIsAppear) || (paramLong < 0L)) {
      return null;
    }
    if ((this.mPreTime == paramLong) && (this.mAdjustPoints != null)) {
      return this.mAdjustPoints;
    }
    if (this.mPreTime <= 0L) {
      this.mPreTime = paramLong;
    }
    this.mCurAPPRec.left = ((float)(this.mLeftScaleFactor * this.mSetting.mWidth));
    if ((this.isNeedUpdatePosition) && (paramLong - this.mPreTime > 3L))
    {
      RectF localRectF = this.mCurAPPRec;
      localRectF.top += this.mSetting.mDropSpeed * this.mSetting.mHeight;
    }
    float f1 = this.mCurAPPRec.left + this.mSetting.mItemWidth;
    float f2 = this.mCurAPPRec.top;
    f2 = this.mSetting.mItemHeight + f2;
    float f3 = this.mCurAPPRec.top;
    this.mAdjustPoints = AlgoUtils.adjustPosition(AlgoUtils.calPositions(this.mCurAPPRec.left, f2, f1, f3, this.mSetting.mWidth, this.mSetting.mHeight), this.mSetting.audioScaleFactor);
    this.mCurAPPRec.right = f1;
    this.mCurAPPRec.bottom = f2;
    this.mPreTime = paramLong;
    updateStartTime(paramLong);
    updateFrameIndex(paramLong);
    Log.i("greatgao", this.STATUS_START_TIME_FROM_INITED + "-> rect:" + this.mCurAPPRec.toString());
    return this.mAdjustPoints;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOApple.AppleStatus
 * JD-Core Version:    0.7.0.1
 */