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
    double d1 = this.mLeftScaleFactor;
    double d2 = paramAppleItemSetting.mWidth;
    Double.isNaN(d2);
    this.mCurAPPRec = new RectF((float)(d1 * d2), 0.0F, 0.0F, 0.0F);
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
    if ((this.mCurrentStatus == UKYOApple.APPLE_STATUS.HITTING) && (i >= this.mSetting.mFrames[UKYOApple.APPLE_STATUS.HITTING.getValue()]))
    {
      this.mIsDisappear = 1;
      return;
    }
    if ((this.mCurrentStatus == UKYOApple.APPLE_STATUS.DROPPING) && (this.mCurAPPRec.bottom > UKYOApple.access$500(this.this$0))) {
      this.mIsDisappear = 0;
    }
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
    for (;;)
    {
      localObject = this.mPlayingStarTime;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = -1L;
      i += 1;
    }
    this.mPlayCount = 0;
    this.mIsDisappear = -1;
    this.mIsAppear = false;
    this.mAdjustPoints = null;
    this.mCurAPPRec = null;
    Object localObject = this.mSetting;
    if (localObject != null)
    {
      double d1 = this.mLeftScaleFactor;
      double d2 = ((AppleItemSetting)localObject).mWidth;
      Double.isNaN(d2);
      this.mCurAPPRec = new RectF((float)(d1 * d2), 0.0F, 0.0F, 0.0F);
    }
    this.mPreTime = -1L;
    this.frameIndex = -1;
    this.isNeedUpdatePosition = true;
  }
  
  public boolean updateAppearStatus(long paramLong)
  {
    int i = this.STATUS_START_TIME_FROM_INITED;
    boolean bool;
    if ((i >= 0) && (this.mIsDisappear < 0) && (paramLong >= i)) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsAppear = bool;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.STATUS_START_TIME_FROM_INITED);
    localStringBuilder.append("-> Appear:");
    localStringBuilder.append(this.mIsAppear);
    Log.i("greatgao", localStringBuilder.toString());
    return this.mIsAppear;
  }
  
  public void updateHitting(boolean paramBoolean)
  {
    if ((this.mIsAppear) && (paramBoolean) && (UKYOApple.APPLE_STATUS.HITTING != this.mCurrentStatus))
    {
      this.this$0.updatePlayerAAttack(true);
      UKYOApple.access$608(this.this$0);
      Object localObject = this.this$0;
      UKYOApple.access$702((UKYOApple)localObject, UKYOApple.access$700((UKYOApple)localObject) + 1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Score:");
      ((StringBuilder)localObject).append(UKYOApple.access$600(this.this$0));
      Log.i("greatgao03", ((StringBuilder)localObject).toString());
      this.isNeedUpdatePosition = false;
      this.mCurrentStatus = UKYOApple.APPLE_STATUS.HITTING;
      updateStartTime(UKYOApple.access$800(this.this$0));
      Log.i("greatgao020", "APPLE HITTING");
    }
  }
  
  public float[] updatePosition(long paramLong)
  {
    if ((this.mIsAppear) && (paramLong >= 0L))
    {
      if (this.mPreTime == paramLong)
      {
        localObject = this.mAdjustPoints;
        if (localObject != null) {
          return localObject;
        }
      }
      if (this.mPreTime <= 0L) {
        this.mPreTime = paramLong;
      }
      Object localObject = this.mCurAPPRec;
      double d1 = this.mLeftScaleFactor;
      double d2 = this.mSetting.mWidth;
      Double.isNaN(d2);
      ((RectF)localObject).left = ((float)(d1 * d2));
      if ((this.isNeedUpdatePosition) && (paramLong - this.mPreTime > 3L))
      {
        localObject = this.mCurAPPRec;
        ((RectF)localObject).top += this.mSetting.mDropSpeed * this.mSetting.mHeight;
      }
      float f1 = this.mCurAPPRec.left + this.mSetting.mItemWidth;
      float f2 = this.mCurAPPRec.top + this.mSetting.mItemHeight;
      float f3 = this.mCurAPPRec.top;
      this.mAdjustPoints = AlgoUtils.adjustPosition(AlgoUtils.calPositions(this.mCurAPPRec.left, f2, f1, f3, this.mSetting.mWidth, this.mSetting.mHeight), this.mSetting.audioScaleFactor);
      localObject = this.mCurAPPRec;
      ((RectF)localObject).right = f1;
      ((RectF)localObject).bottom = f2;
      this.mPreTime = paramLong;
      updateStartTime(paramLong);
      updateFrameIndex(paramLong);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.STATUS_START_TIME_FROM_INITED);
      ((StringBuilder)localObject).append("-> rect:");
      ((StringBuilder)localObject).append(this.mCurAPPRec.toString());
      Log.i("greatgao", ((StringBuilder)localObject).toString());
      return this.mAdjustPoints;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOApple.AppleStatus
 * JD-Core Version:    0.7.0.1
 */