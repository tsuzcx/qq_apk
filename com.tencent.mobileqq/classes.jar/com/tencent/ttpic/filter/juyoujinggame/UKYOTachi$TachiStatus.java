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
    if (this.mCurrentStatus == UKYOTachi.UKYOTACHISTATUS.MOVING) {
      return;
    }
    if (this.mCurFrameIndex + 1 >= this.mTachiSetting.mFrames[UKYOTachi.UKYOTACHISTATUS.HITTING.getValue()])
    {
      this.mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.MOVING;
      Log.i("greatgao020", "TACHI  HITTING over");
    }
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
    if ((!paramBoolean) && (this.mCurrentStatus == UKYOTachi.UKYOTACHISTATUS.MOVING)) {
      return;
    }
    if ((paramBoolean) && (this.mCurrentStatus == UKYOTachi.UKYOTACHISTATUS.MOVING))
    {
      this.mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.HITTING;
      updateStartTime(UKYOTachi.access$000(this.this$0));
      Log.i("greatgao020", "TACHI  HITTING start");
    }
  }
  
  protected String getImageId()
  {
    TachiSetting localTachiSetting = this.mTachiSetting;
    if (localTachiSetting != null) {
      return localTachiSetting.getImageID(this.mCurrentStatus);
    }
    return null;
  }
  
  public void reset()
  {
    this.mCurrentStatus = UKYOTachi.UKYOTACHISTATUS.MOVING;
    int i = 0;
    this.mCurFrameIndex = 0;
    for (;;)
    {
      long[] arrayOfLong = this.mPlayingStarTime;
      if (i >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[i] = -1L;
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
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (this.mTachiPositionRect == null) {
        return;
      }
      int i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IHittingStatus localIHittingStatus = (IHittingStatus)paramList.next();
        RectF localRectF = localIHittingStatus.getRectF();
        if ((!localIHittingStatus.isHitting()) && (localIHittingStatus.isAppear()) && (localRectF != null))
        {
          Object localObject = new RectF();
          ((RectF)localObject).set(this.mTachiPositionRect);
          ((RectF)localObject).left *= 1.1F;
          ((RectF)localObject).right *= 0.9F;
          boolean bool = RectF.intersects(localRectF, (RectF)localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("apple:");
          ((StringBuilder)localObject).append(localRectF.toString());
          ((StringBuilder)localObject).append("<->");
          ((StringBuilder)localObject).append(this.mTachiPositionRect.toString());
          ((StringBuilder)localObject).append(",isIntersects:");
          ((StringBuilder)localObject).append(bool);
          Log.i("greatgao01", ((StringBuilder)localObject).toString());
          localIHittingStatus.updateHitting(bool);
          if ((bool) && (i == 0))
          {
            updateStatus(true);
            i = 1;
          }
        }
      }
    }
  }
  
  protected float[] updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    boolean bool = CollectionUtils.isEmpty(paramList);
    int j = 0;
    if ((!bool) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mIsAppear = bool;
    if (this.mIsAppear)
    {
      this.mTachiPositionRect = null;
      return null;
    }
    paramArrayOfFloat = (PointF)paramList.get(this.mTachiSetting.alignFacePoints[0]);
    if (this.mTachiSetting.alignFacePoints.length == 1) {
      i = this.mTachiSetting.alignFacePoints[0];
    } else {
      i = this.mTachiSetting.alignFacePoints[1];
    }
    paramList = (PointF)paramList.get(i);
    paramList = new PointF((paramArrayOfFloat.x + paramList.x) / 2.0F, (paramArrayOfFloat.y + paramList.y) / 2.0F);
    double d1 = paramList.x;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    paramList.x = ((float)(d1 / d2));
    paramList.y = (this.mTachiSetting.mRoleSizeYFactor * this.mTachiSetting.mHeight);
    paramFloat = paramList.x;
    if (this.mTachiSetting.anchorPoint != null) {
      i = this.mTachiSetting.anchorPoint[0];
    } else {
      i = 0;
    }
    paramFloat -= i;
    float f1 = paramList.y;
    int i = j;
    if (this.mTachiSetting.anchorPoint != null) {
      i = this.mTachiSetting.anchorPoint[1];
    }
    f1 -= i;
    float f2 = this.mTachiSetting.mItemWidth + paramFloat;
    float f3 = this.mTachiSetting.mItemHeight + f1;
    paramList = AlgoUtils.calPositions(paramFloat, f3, f2, f1, this.mTachiSetting.mWidth, this.mTachiSetting.mHeight);
    this.mTachiPositionRect = new RectF(paramFloat, f1 + this.mTachiSetting.mItemHeight / 4, f2, f3 - this.mTachiSetting.mItemHeight / 4);
    return AlgoUtils.adjustPosition(paramList, this.mTachiSetting.audioScaleFactor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.UKYOTachi.TachiStatus
 * JD-Core Version:    0.7.0.1
 */