package com.tencent.ttpic.filter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIActionCounter;
import com.tencent.aekit.plugin.core.AIActionCounter.AI_TYPE;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.model.TriggerTimeUpdater;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.openapi.model.StickerItem.ValueRange;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    boolean bool2 = true;
    if ((this.mCurrentTime <= 0L) || ((!this.mIsFreezeFrameMode) && (this.TRIGGERED_TIMES > 0) && (this.mHasTriggeredTimes >= this.TRIGGERED_TIMES))) {
      return;
    }
    if (this.mFreezeSnapshot != null) {
      this.mFreezeSnapshot.updateTimeStamp(paramLong);
    }
    paramLong = getCurentObjectLifeTime(paramLong);
    if ((paramLong >= this.mFreezeFrameStartTime) && (paramLong >= 0L))
    {
      bool1 = true;
      if ((!this.mIsFreezeFrameMode) && (bool1)) {
        this.mHasTriggeredTimes += 1;
      }
      this.mIsFreezeFrameMode = bool1;
      if (this.mIsFreezeFrameMode)
      {
        if (this.mFreezeFrameDuration <= 0L) {
          break label221;
        }
        if (paramLong >= this.mFreezeFrameStartTime + this.mFreezeFrameDuration) {
          break label216;
        }
        bool1 = true;
        label134:
        this.mIsFreezeFrameMode = bool1;
        if ((!this.mIsFreezeFrameMode) && (!this.mIsAlawayTriggedFreezeFrame)) {
          if (paramLong > this.mFreezeFrameStartTime + this.mPlayTime) {
            break label229;
          }
        }
      }
    }
    label216:
    label221:
    label229:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mIsFreezeFrameMode = bool1;
      if ((!this.mIsFreezeFrameMode) && (this.mFreezeSnapshot != null))
      {
        this.mFreezeSnapshot.clear();
        this.mFreezeSnapshot = null;
      }
      updateTriggerTimeUpdater(paramLong, this.mIsFreezeFrameMode);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label134;
      bool1 = this.mIsFreezeFrameMode;
      break label134;
    }
  }
  
  private void checkPlayOver()
  {
    if (!this.mIsAlawayTriggedFreezeFrame) {
      this.mIsFreezeFrameMode = isPlaying();
    }
    if ((!this.mIsFreezeFrameMode) && (this.mFreezeSnapshot != null))
    {
      this.mFreezeSnapshot.clear();
      this.mFreezeSnapshot = null;
    }
  }
  
  private boolean checkTriggerActiveCount(Map<Integer, FaceActionCounter> paramMap)
  {
    if (this.mTotalTriggerCount <= 1) {
      return true;
    }
    int j = -1;
    int i;
    if (VideoMaterialUtil.isFaceTriggerType(this.mFreezeFrameTriggleType))
    {
      paramMap = (FaceActionCounter)paramMap.get(Integer.valueOf(this.mFreezeFrameTriggleType));
      if (paramMap != null)
      {
        i = paramMap.count;
        if (i % this.mTotalTriggerCount != this.mActiveTriggerCount) {
          break label126;
        }
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i = -1;
      break;
      paramMap = AIActionCounter.getActions(AIActionCounter.AI_TYPE.HAND);
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (paramMap.get(Integer.valueOf(this.mFreezeFrameTriggleType)) != null) {
          i = ((Integer)paramMap.get(Integer.valueOf(this.mFreezeFrameTriggleType))).intValue();
        }
      }
      break;
    }
  }
  
  private int checkTriggered(int paramInt, Map<Integer, FaceActionCounter> paramMap)
  {
    int i = 1;
    if (paramInt == this.mFreezeFrameTriggleType)
    {
      if (this.mTotalTriggerCount > 1) {
        if (checkTriggerActiveCount(paramMap)) {
          triggeredWork();
        }
      }
      for (;;)
      {
        paramInt = 2;
        do
        {
          return paramInt;
          paramInt = i;
        } while (!this.mIsFreezeFrameMode);
        this.mIsFreezeFrameMode = false;
        checkPlayOver();
        continue;
        triggeredWork();
      }
    }
    return 0;
  }
  
  private long getCurentObjectLifeTime(long paramLong)
  {
    long l = paramLong;
    if (this.mInitTime >= 0L) {
      l = paramLong - this.mInitTime;
    }
    return l;
  }
  
  private boolean isPlaying()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.mFreezeSnapshot != null)
    {
      PTFaceAttr localPTFaceAttr = this.mFreezeSnapshot.getPTFaceSnapshot();
      l1 = l2;
      if (localPTFaceAttr != null) {
        l1 = getCurentObjectLifeTime(localPTFaceAttr.getTimeStamp());
      }
    }
    return this.mPlayTime + this.mFreezeFrameStartTime > l1;
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
    if (this.mTriggerTimeUpdater != null) {
      this.mFreezeFrameStartTime = this.mTriggerTimeUpdater.updateCurTriggerTimeAddDelayTime(paramLong, this.mFreezeFrameStartTime, paramBoolean);
    }
  }
  
  public void checkFreezeFrameValiedByStateTrigger(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet)
  {
    if ((this.mCurrentTime <= 0L) || ((!this.mIsFreezeFrameMode) && (this.TRIGGERED_TIMES > 0) && (this.mHasTriggeredTimes >= this.TRIGGERED_TIMES))) {}
    label167:
    label173:
    label177:
    for (;;)
    {
      return;
      if (this.mFreezeSnapshot != null) {
        this.mFreezeSnapshot.updateCameraTriggerAction(paramSet);
      }
      boolean bool1;
      if (this.mIsStateTrigger)
      {
        paramSet = TriggerStateManager.getInstance().getTriggerStateItem(this.mItemRenderId);
        if (paramSet == null) {
          break label173;
        }
        boolean bool2 = paramSet.isTriggerState(this.mTriggerState);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (this.mTriggerStateRangeMin < this.mTriggerStateRangeMax)
          {
            double d = paramSet.getRandomValue();
            if ((d < this.mTriggerStateRangeMin) || (d >= this.mTriggerStateRangeMax)) {
              break label167;
            }
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        if ((bool1) && (checkTriggered(this.mFreezeFrameTriggleType, paramMap) != 0)) {
          break label177;
        }
        if (!this.mIsFreezeFrameMode) {
          break;
        }
        this.mIsFreezeFrameMode = false;
        checkPlayOver();
        return;
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public void checkFreezeFrameValiedByTriggers(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, AIAttr paramAIAttr)
  {
    label34:
    int i;
    if ((this.mCurrentTime <= 0L) || ((!this.mIsFreezeFrameMode) && (this.TRIGGERED_TIMES > 0) && (this.mHasTriggeredTimes >= this.TRIGGERED_TIMES)))
    {
      return;
    }
    else
    {
      if (this.mFreezeSnapshot != null) {
        this.mFreezeSnapshot.updateCameraTriggerAction(paramSet);
      }
      paramAIAttr = (PTHandAttr)paramAIAttr.getAvailableData(AEDetectorType.HAND.value);
      if (paramAIAttr == null) {
        break label163;
      }
      if (paramAIAttr.getHandType() != this.mFreezeFrameTriggleType) {
        break label116;
      }
      i = 1;
    }
    for (;;)
    {
      label82:
      if (i != 0) {
        if (checkTriggered(this.mFreezeFrameTriggleType, paramMap) != 0) {
          break label34;
        }
      }
      label116:
      do
      {
        break label133;
        if (!this.mIsFreezeFrameMode) {
          break label34;
        }
        this.mIsFreezeFrameMode = false;
        checkPlayOver();
        return;
        i = 0;
        break label82;
        if (paramSet == null) {
          break;
        }
        paramSet = paramSet.iterator();
        if (!paramSet.hasNext()) {
          break;
        }
      } while (checkTriggered(((Integer)paramSet.next()).intValue(), paramMap) == 0);
      label133:
      return;
      label163:
      i = 0;
    }
  }
  
  public void clear()
  {
    if (this.mFreezeSnapshot != null)
    {
      this.mFreezeSnapshot.clear();
      this.mFreezeSnapshot = null;
    }
    this.mIsFreezeFrameMode = false;
    this.mHasTriggeredTimes = 0;
    this.mIsDelaying = false;
    if (this.mPostHandler != null)
    {
      this.mPostHandler.getLooper().quit();
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
    if (this.mFreezeSnapshot != null) {
      paramPTFaceAttr = this.mFreezeSnapshot.getPTFaceSnapshot();
    }
    return paramPTFaceAttr;
  }
  
  public PTSegAttr getPTSegSnapshot(PTSegAttr paramPTSegAttr)
  {
    if (this.mFreezeSnapshot != null) {
      paramPTSegAttr = this.mFreezeSnapshot.getPTSegSnapshot();
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
    if (this.mFreezeSnapshot != null)
    {
      this.mFreezeSnapshot.clear();
      this.mFreezeSnapshot = null;
    }
    this.mHasTriggeredTimes = 0;
    this.mIsDelaying = false;
    if (this.mInitTime > 0L)
    {
      this.mInitTime += this.mCurrentTime;
      this.mCurrentTime = 0L;
    }
    if (this.mPostHandler != null) {
      this.mPostHandler.removeCallbacks(this.mDelayRunnable);
    }
    updateTriggerTimeUpdater(-1L, false);
  }
  
  public void setDelayTriggerTime(long paramLong)
  {
    this.DELAY_TRIGGER_TIME = paramLong;
    if ((this.mIsTimeTrigged) && (this.mFreezeFrameStartTime >= 0L)) {
      this.mFreezeFrameStartTime += this.DELAY_TRIGGER_TIME;
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
    if (this.DELAY_TRIGGER_TIME >= 0L) {
      this.mFreezeFrameStartTime += this.DELAY_TRIGGER_TIME;
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
    if (paramInt1 == PTFaceAttr.PTExpression.ALWAYS.value)
    {
      if ((!this.mIsFreezeFrameMode) && (this.DELAY_TRIGGER_TIME > 0L) && (this.mPostHandler != null)) {
        postDelayTimesTriggered();
      }
    }
    else
    {
      this.mFreezeFrameTriggleType = paramInt1;
      this.mIsAlawayTriggedFreezeFrame = paramBoolean;
      if (paramInt2 <= 0) {
        break label92;
      }
      label56:
      this.mActiveTriggerCount = paramInt2;
      if (paramInt3 <= 1) {
        break label97;
      }
    }
    for (;;)
    {
      this.mTotalTriggerCount = paramInt3;
      return;
      this.mFreezeFrameStartTime = 0L;
      this.mIsFreezeFrameMode = true;
      this.mHasTriggeredTimes = 1;
      break;
      label92:
      paramInt2 = 0;
      break label56;
      label97:
      paramInt3 = 1;
    }
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
    if (this.mFreezeSnapshot != null) {
      this.mFreezeSnapshot.updateTimeStamp(paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoFilterInputFreeze
 * JD-Core Version:    0.7.0.1
 */