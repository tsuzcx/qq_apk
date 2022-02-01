package com.tencent.ttpic.filter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.trigger.TriggerTimeUpdater;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Deprecated
public class VideoFilterInputFreeze
{
  private long DELAY_TRIGGER_TIME = 0L;
  private final int INIT_DELAY_TRIGGERTIME = 0;
  private int TRIGGERED_TIMES = 0;
  private int mActiveTriggerCount = 0;
  private long mCurrentTime = -1L;
  private VideoFilterInputFreeze.DelayRunnable mDelayRunnable;
  private long mFreezeFrameDuration = -1L;
  private long mFreezeFrameStartTime = -1L;
  private int mFreezeFrameTriggleType = -1;
  private VideoFilterListSnapshot mFreezeSnapshot;
  private int mHasTriggeredTimes = 0;
  private long mInitTime = -1L;
  private boolean mIsAlawayTriggedFreezeFrame = false;
  private boolean mIsDelaying = false;
  private boolean mIsFreezeFrameMode = false;
  private boolean mIsStateTrigger = false;
  private boolean mIsTimeTrigged = false;
  private int mItemRenderId;
  private long mPlayTime = 0L;
  private Handler mPostHandler;
  private int mTotalTriggerCount = 1;
  private ArrayList<String> mTriggerState;
  private double mTriggerStateRangeMax;
  private double mTriggerStateRangeMin;
  private TriggerTimeUpdater mTriggerTimeUpdater;
  
  private void checkFreezeFrameValiedByTime(long paramLong)
  {
    if (this.mCurrentTime > 0L)
    {
      if (!this.mIsFreezeFrameMode)
      {
        int i = this.TRIGGERED_TIMES;
        if ((i > 0) && (this.mHasTriggeredTimes >= i)) {
          return;
        }
      }
      VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
      if (localVideoFilterListSnapshot != null) {
        localVideoFilterListSnapshot.updateTimeStamp(paramLong);
      }
      paramLong = getCurentObjectLifeTime(paramLong);
      long l = this.mFreezeFrameStartTime;
      boolean bool2 = false;
      if ((paramLong >= l) && (paramLong >= 0L)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((!this.mIsFreezeFrameMode) && (bool1)) {
        this.mHasTriggeredTimes += 1;
      }
      this.mIsFreezeFrameMode = bool1;
      boolean bool1 = this.mIsFreezeFrameMode;
      if (bool1)
      {
        l = this.mFreezeFrameDuration;
        if (l > 0L) {
          if (paramLong < this.mFreezeFrameStartTime + l) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        this.mIsFreezeFrameMode = bool1;
        if ((!this.mIsFreezeFrameMode) && (!this.mIsAlawayTriggedFreezeFrame))
        {
          bool1 = bool2;
          if (paramLong <= this.mFreezeFrameStartTime + this.mPlayTime) {
            bool1 = true;
          }
          this.mIsFreezeFrameMode = bool1;
        }
        if (!this.mIsFreezeFrameMode)
        {
          localVideoFilterListSnapshot = this.mFreezeSnapshot;
          if (localVideoFilterListSnapshot != null)
          {
            localVideoFilterListSnapshot.clear();
            this.mFreezeSnapshot = null;
          }
        }
      }
      updateTriggerTimeUpdater(paramLong, this.mIsFreezeFrameMode);
    }
  }
  
  private void checkPlayOver()
  {
    if (!this.mIsAlawayTriggedFreezeFrame) {
      this.mIsFreezeFrameMode = isPlaying();
    }
    if (!this.mIsFreezeFrameMode)
    {
      VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
      if (localVideoFilterListSnapshot != null)
      {
        localVideoFilterListSnapshot.clear();
        this.mFreezeSnapshot = null;
      }
    }
  }
  
  private boolean checkTriggerActiveCount(Map<Integer, FaceActionCounter> paramMap)
  {
    if (this.mTotalTriggerCount <= 1) {
      return true;
    }
    int j = -1;
    int i;
    if (VideoMaterial.isFaceTriggerType(this.mFreezeFrameTriggleType))
    {
      paramMap = (FaceActionCounter)paramMap.get(Integer.valueOf(this.mFreezeFrameTriggleType));
      i = j;
      if (paramMap != null) {
        i = paramMap.count;
      }
    }
    else
    {
      paramMap = AIActionCounter.getActions(AEDetectorType.HAND);
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (paramMap.get(Integer.valueOf(this.mFreezeFrameTriggleType)) != null) {
          i = ((Integer)paramMap.get(Integer.valueOf(this.mFreezeFrameTriggleType))).intValue();
        }
      }
    }
    return i % this.mTotalTriggerCount == this.mActiveTriggerCount;
  }
  
  private int checkTriggered(int paramInt, Map<Integer, FaceActionCounter> paramMap)
  {
    if (paramInt == this.mFreezeFrameTriggleType)
    {
      if (this.mTotalTriggerCount > 1)
      {
        if (checkTriggerActiveCount(paramMap))
        {
          triggeredWork();
        }
        else
        {
          if (!this.mIsFreezeFrameMode) {
            return 1;
          }
          this.mIsFreezeFrameMode = false;
          checkPlayOver();
        }
      }
      else {
        triggeredWork();
      }
      return 2;
    }
    return 0;
  }
  
  private long getCurentObjectLifeTime(long paramLong)
  {
    long l2 = this.mInitTime;
    long l1 = paramLong;
    if (l2 >= 0L) {
      l1 = paramLong - l2;
    }
    return l1;
  }
  
  private boolean isPlaying()
  {
    Object localObject = this.mFreezeSnapshot;
    if (localObject != null)
    {
      localObject = ((VideoFilterListSnapshot)localObject).getPTFaceSnapshot();
      if (localObject != null)
      {
        l = getCurentObjectLifeTime(((PTFaceAttr)localObject).getTimeStamp());
        break label32;
      }
    }
    long l = 0L;
    label32:
    return this.mPlayTime + this.mFreezeFrameStartTime > l;
  }
  
  private void postDelayTimesTriggered()
  {
    if (this.mIsDelaying) {
      return;
    }
    this.mIsDelaying = true;
    this.mPostHandler.postDelayed(this.mDelayRunnable, this.DELAY_TRIGGER_TIME);
  }
  
  private void triggeredWork()
  {
    if (this.mCurrentTime <= 0L) {
      return;
    }
    if (!this.mIsFreezeFrameMode)
    {
      if ((this.DELAY_TRIGGER_TIME > 0L) && (this.mPostHandler != null))
      {
        postDelayTimesTriggered();
        return;
      }
      updateTriggedFirstFrameTime();
      this.mHasTriggeredTimes += 1;
      this.mIsFreezeFrameMode = true;
      return;
    }
    this.mIsFreezeFrameMode = true;
  }
  
  private void updateTriggedFirstFrameTime()
  {
    this.mFreezeFrameStartTime = this.mCurrentTime;
  }
  
  private void updateTriggerTimeUpdater(long paramLong, boolean paramBoolean)
  {
    TriggerTimeUpdater localTriggerTimeUpdater = this.mTriggerTimeUpdater;
    if (localTriggerTimeUpdater != null) {
      this.mFreezeFrameStartTime = localTriggerTimeUpdater.updateCurTriggerTimeAddDelayTime(paramLong, this.mFreezeFrameStartTime, paramBoolean);
    }
  }
  
  public void checkFreezeFrameValiedByStateTrigger(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet)
  {
    if (this.mCurrentTime > 0L)
    {
      if (!this.mIsFreezeFrameMode)
      {
        int i = this.TRIGGERED_TIMES;
        if ((i > 0) && (this.mHasTriggeredTimes >= i)) {
          return;
        }
      }
      VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
      if (localVideoFilterListSnapshot != null) {
        localVideoFilterListSnapshot.updateCameraTriggerAction(paramSet);
      }
      if (this.mIsStateTrigger)
      {
        paramSet = TriggerStateManager.getInstance().getTriggerStateItem(this.mItemRenderId);
        if (paramSet != null)
        {
          bool = paramSet.isTriggerState(this.mTriggerState);
          if ((bool) && (this.mTriggerStateRangeMin < this.mTriggerStateRangeMax))
          {
            double d = paramSet.getRandomValue();
            if ((d >= this.mTriggerStateRangeMin) && (d < this.mTriggerStateRangeMax))
            {
              bool = true;
              break label138;
            }
          }
          else
          {
            break label138;
          }
        }
        boolean bool = false;
        label138:
        if ((bool) && (checkTriggered(this.mFreezeFrameTriggleType, paramMap) != 0)) {
          return;
        }
      }
      if (this.mIsFreezeFrameMode)
      {
        this.mIsFreezeFrameMode = false;
        checkPlayOver();
      }
    }
  }
  
  public void checkFreezeFrameValiedByTriggers(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr)
  {
    if (this.mCurrentTime > 0L)
    {
      int i;
      if (!this.mIsFreezeFrameMode)
      {
        i = this.TRIGGERED_TIMES;
        if ((i > 0) && (this.mHasTriggeredTimes >= i)) {
          return;
        }
      }
      VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
      if (localVideoFilterListSnapshot != null) {
        localVideoFilterListSnapshot.updateCameraTriggerAction(paramSet);
      }
      paramAIAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if ((paramAIAttr != null) && (paramAIAttr.getHandType() == this.mFreezeFrameTriggleType)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (checkTriggered(this.mFreezeFrameTriggleType, paramMap) == 0) {}
      }
      else if (paramSet != null)
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          if (checkTriggered(((Integer)paramSet.next()).intValue(), paramMap) != 0) {
            return;
          }
        }
      }
      if (this.mIsFreezeFrameMode)
      {
        this.mIsFreezeFrameMode = false;
        checkPlayOver();
      }
    }
  }
  
  public void clear()
  {
    Object localObject = this.mFreezeSnapshot;
    if (localObject != null)
    {
      ((VideoFilterListSnapshot)localObject).clear();
      this.mFreezeSnapshot = null;
    }
    this.mIsFreezeFrameMode = false;
    this.mHasTriggeredTimes = 0;
    this.mIsDelaying = false;
    localObject = this.mPostHandler;
    if (localObject != null)
    {
      ((Handler)localObject).getLooper().quit();
      this.mPostHandler = null;
    }
    if (this.mTriggerTimeUpdater != null) {
      this.mTriggerTimeUpdater = null;
    }
  }
  
  public VideoFilterListSnapshot getFrameInfoSnapShot()
  {
    return this.mFreezeSnapshot;
  }
  
  public PTFaceAttr getPTFaceSnapshot(PTFaceAttr paramPTFaceAttr)
  {
    VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
    if (localVideoFilterListSnapshot != null) {
      paramPTFaceAttr = localVideoFilterListSnapshot.getPTFaceSnapshot();
    }
    return paramPTFaceAttr;
  }
  
  public PTSegAttr getPTSegSnapshot(PTSegAttr paramPTSegAttr)
  {
    VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
    if (localVideoFilterListSnapshot != null) {
      paramPTSegAttr = localVideoFilterListSnapshot.getPTSegSnapshot();
    }
    return paramPTSegAttr;
  }
  
  public boolean isFreezeFrame()
  {
    return this.mIsFreezeFrameMode;
  }
  
  public boolean isStateTrigger()
  {
    return this.mIsStateTrigger;
  }
  
  public boolean isTimeTrigger()
  {
    return this.mIsTimeTrigged;
  }
  
  public void reset()
  {
    this.mIsFreezeFrameMode = false;
    Object localObject = this.mFreezeSnapshot;
    if (localObject != null)
    {
      ((VideoFilterListSnapshot)localObject).clear();
      this.mFreezeSnapshot = null;
    }
    this.mHasTriggeredTimes = 0;
    this.mIsDelaying = false;
    long l = this.mInitTime;
    if (l > 0L)
    {
      this.mInitTime = (l + this.mCurrentTime);
      this.mCurrentTime = 0L;
    }
    localObject = this.mPostHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.mDelayRunnable);
    }
    updateTriggerTimeUpdater(-1L, false);
  }
  
  public void setDelayTriggerTime(long paramLong)
  {
    this.DELAY_TRIGGER_TIME = paramLong;
    if (this.mIsTimeTrigged)
    {
      paramLong = this.mFreezeFrameStartTime;
      if (paramLong >= 0L) {
        this.mFreezeFrameStartTime = (paramLong + this.DELAY_TRIGGER_TIME);
      }
    }
    HandlerThread localHandlerThread = new HandlerThread("ExpressionDetectThread");
    localHandlerThread.start();
    this.mPostHandler = new Handler(localHandlerThread.getLooper());
    this.mDelayRunnable = new VideoFilterInputFreeze.DelayRunnable(this, null);
  }
  
  public void setFrameInfoSnapShot(VideoFilterListSnapshot paramVideoFilterListSnapshot)
  {
    this.mFreezeSnapshot = paramVideoFilterListSnapshot;
  }
  
  public void setFramesAndCount(long paramLong)
  {
    this.mPlayTime = paramLong;
  }
  
  public void setFreezeFrameStartTime(long paramLong)
  {
    setFreezeFrameStartTime(paramLong, -1L);
  }
  
  public void setFreezeFrameStartTime(long paramLong1, long paramLong2)
  {
    setFreezeFrameStartTime(paramLong1, paramLong2, true);
  }
  
  public void setFreezeFrameStartTime(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.mIsTimeTrigged = true;
    this.mFreezeFrameStartTime = paramLong1;
    this.mFreezeFrameDuration = paramLong2;
    this.mIsAlawayTriggedFreezeFrame = paramBoolean;
    paramLong1 = this.DELAY_TRIGGER_TIME;
    if (paramLong1 >= 0L) {
      this.mFreezeFrameStartTime += paramLong1;
    }
    checkFreezeFrameValiedByTime(0L);
  }
  
  public void setFreezeFrameTriggleType(int paramInt)
  {
    setFreezeFrameTriggleType(paramInt, true, 0, 1);
  }
  
  public void setFreezeFrameTriggleType(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this.mIsTimeTrigged = false;
    if (paramInt1 == PTFaceAttr.PTExpression.ALWAYS.value) {
      if ((!this.mIsFreezeFrameMode) && (this.DELAY_TRIGGER_TIME > 0L) && (this.mPostHandler != null))
      {
        postDelayTimesTriggered();
      }
      else
      {
        this.mFreezeFrameStartTime = 0L;
        this.mIsFreezeFrameMode = true;
        this.mHasTriggeredTimes = 1;
      }
    }
    this.mFreezeFrameTriggleType = paramInt1;
    this.mIsAlawayTriggedFreezeFrame = paramBoolean;
    if (paramInt2 <= 0) {
      paramInt2 = 0;
    }
    this.mActiveTriggerCount = paramInt2;
    if (paramInt3 <= 1) {
      paramInt3 = 1;
    }
    this.mTotalTriggerCount = paramInt3;
  }
  
  public void setIsStateTrigger(boolean paramBoolean)
  {
    this.mIsStateTrigger = paramBoolean;
  }
  
  public void setPlayTimes(int paramInt)
  {
    this.TRIGGERED_TIMES = paramInt;
  }
  
  public void setStateTriggerParam(int paramInt, ArrayList<String> paramArrayList, StickerItem.ValueRange paramValueRange)
  {
    this.mItemRenderId = paramInt;
    this.mTriggerState = paramArrayList;
    if (paramValueRange != null)
    {
      this.mTriggerStateRangeMin = paramValueRange.min;
      this.mTriggerStateRangeMax = paramValueRange.max;
    }
  }
  
  public void setTriggerTimeUpdater(TriggerTimeUpdater paramTriggerTimeUpdater)
  {
    this.mTriggerTimeUpdater = paramTriggerTimeUpdater;
  }
  
  public void updateTimeStamp(long paramLong)
  {
    VideoFilterListSnapshot localVideoFilterListSnapshot = this.mFreezeSnapshot;
    if (localVideoFilterListSnapshot != null) {
      localVideoFilterListSnapshot.updateTimeStamp(paramLong);
    }
    if (this.mInitTime < 0L) {
      this.mInitTime = paramLong;
    }
    this.mCurrentTime = getCurentObjectLifeTime(paramLong);
    if ((this.mIsTimeTrigged) && (!this.mIsStateTrigger)) {
      checkFreezeFrameValiedByTime(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterInputFreeze
 * JD-Core Version:    0.7.0.1
 */