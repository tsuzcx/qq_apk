package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.Iterator;
import java.util.List;

class UKYOTachi$TachiStatus
{
  protected int mCurFrameIndex = 0;
  private UKYOTachi.UKYOTACHISTATUS mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.MOVING;
  protected double mFaceDetScale = 1.0D;
  protected boolean mIsAppear = false;
  private long[] mPlayingStarTime = { -1L, -1L };
  private RectF mTachiPositionRect;
  private TachiSetting mTachiSetting;
  
  public UKYOTachi$TachiStatus(UKYOTachi paramUKYOTachi, TachiSetting paramTachiSetting)
  {
    this.mTachiSetting = paramTachiSetting;
  }
  
  private void updataHittingStatus(long paramLong)
  {
    if (this.mCurrentStatus == UKYOTachi.UKYOTACHISTATUS.MOVING) {}
    while (this.mCurFrameIndex + 1 < this.mTachiSetting.mFrames[UKYOTachi.UKYOTACHISTATUS.HITTING.getValue()]) {
      return;
    }
    this.mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.MOVING;
    Log.i("greatgao020", "TACHI  HITTING over");
  }
  
  private void updateFrameIndex(long paramLong)
  {
    this.mCurFrameIndex = ((this.mCurFrameIndex + 1) % Math.max(this.mTachiSetting.mFrames[this.mCurrentStatus.getValue()], 1));
  }
  
  private void updateStartTime(long paramLong)
  {
    if (this.mPlayingStarTime[this.mCurrentStatus.getValue()] == -1L)
    {
      this.mPlayingStarTime[this.mCurrentStatus.getValue()] = paramLong;
      this.mCurFrameIndex = -1;
      this.mPlayingStarTime[((this.mCurrentStatus.getValue() + 1) % 2)] = -1L;
    }
  }
  
  private void updateStatus(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mCurrentStatus == UKYOTachi.UKYOTACHISTATUS.MOVING)) {}
    while ((!paramBoolean) || (this.mCurrentStatus != UKYOTachi.UKYOTACHISTATUS.MOVING)) {
      return;
    }
    this.mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.HITTING;
    updateStartTime(UKYOTachi.access$000(this.this$0));
    Log.i("greatgao020", "TACHI  HITTING start");
  }
  
  protected String getImageId()
  {
    if (this.mTachiSetting != null) {
      return this.mTachiSetting.getImageID(this.mCurrentStatus);
    }
    return null;
  }
  
  public void reset()
  {
    int i = 0;
    this.mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.MOVING;
    this.mCurFrameIndex = 0;
    while (i < this.mPlayingStarTime.length)
    {
      this.mPlayingStarTime[i] = -1L;
      i += 1;
    }
  }
  
  public void updateCurTime(long paramLong)
  {
    if (this.mTachiSetting == null) {
      return;
    }
    updataHittingStatus(paramLong);
    updateStartTime(paramLong);
    updateFrameIndex(paramLong);
  }
  
  public void updateHittingStatus(List<IHittingStatus> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.mTachiPositionRect == null)) {
      return;
    }
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i = 1)
    {
      label30:
      IHittingStatus localIHittingStatus = (IHittingStatus)paramList.next();
      RectF localRectF1 = localIHittingStatus.getRectF();
      if ((localIHittingStatus.isHitting()) || (!localIHittingStatus.isAppear()) || (localRectF1 == null)) {
        break label30;
      }
      RectF localRectF2 = new RectF();
      localRectF2.set(this.mTachiPositionRect);
      localRectF2.left *= 1.1F;
      localRectF2.right *= 0.9F;
      boolean bool = RectF.intersects(localRectF1, localRectF2);
      Log.i("greatgao01", "apple:" + localRectF1.toString() + "<->" + this.mTachiPositionRect.toString() + ",isIntersects:" + bool);
      localIHittingStatus.updateHitting(bool);
      if ((!bool) || (i != 0)) {
        break label215;
      }
      updateStatus(true);
    }
    label215:
    for (;;)
    {
      break label30;
      break;
    }
  }
  
  protected float[] updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    int j = 0;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsAppear = bool;
      if (!this.mIsAppear) {
        break;
      }
      this.mTachiPositionRect = null;
      return null;
    }
    paramArrayOfFloat = (PointF)paramList.get(this.mTachiSetting.alignFacePoints[0]);
    if (this.mTachiSetting.alignFacePoints.length == 1)
    {
      i = this.mTachiSetting.alignFacePoints[0];
      paramList = (PointF)paramList.get(i);
      paramList = new PointF((paramArrayOfFloat.x + paramList.x) / 2.0F, (paramArrayOfFloat.y + paramList.y) / 2.0F);
      paramList.x = ((float)(paramList.x / this.mFaceDetScale));
      paramList.y = (this.mTachiSetting.mRoleSizeYFactor * this.mTachiSetting.mHeight);
      paramFloat = paramList.x;
      if (this.mTachiSetting.anchorPoint == null) {
        break label355;
      }
    }
    label355:
    for (int i = this.mTachiSetting.anchorPoint[0];; i = 0)
    {
      paramFloat -= i;
      float f1 = paramList.y;
      i = j;
      if (this.mTachiSetting.anchorPoint != null) {
        i = this.mTachiSetting.anchorPoint[1];
      }
      f1 -= i;
      float f2 = paramFloat + this.mTachiSetting.mItemWidth;
      float f3 = this.mTachiSetting.mItemHeight + f1;
      paramList = AlgoUtils.calPositions(paramFloat, f3, f2, f1, this.mTachiSetting.mWidth, this.mTachiSetting.mHeight);
      this.mTachiPositionRect = new RectF(paramFloat, f1 + this.mTachiSetting.mItemHeight / 4, f2, f3 - this.mTachiSetting.mItemHeight / 4);
      return AlgoUtils.adjustPosition(paramList, this.mTachiSetting.audioScaleFactor);
      i = this.mTachiSetting.alignFacePoints[1];
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOTachi.TachiStatus
 * JD-Core Version:    0.7.0.1
 */