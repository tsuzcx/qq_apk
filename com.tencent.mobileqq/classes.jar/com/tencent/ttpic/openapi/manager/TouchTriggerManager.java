package com.tencent.ttpic.openapi.manager;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import java.util.Set;

public enum TouchTriggerManager
{
  public static final int ACTION_CLICK_AND_MOVE_SCREEN = 103;
  public static final int ACTION_DOUBLE_CLICK_SCREEN = 101;
  public static final int ACTION_LONG_CLICK_SCREEN = 102;
  public static final int ACTION_TAP_SCREEN = 100;
  private static final int ACTIVE_NOT_TOUCH = -1;
  private static final String TAG;
  private static float bgmClockTime;
  private static long bgmTriggerTime;
  private static boolean isLocked = false;
  private static int mCurExpression;
  private static PointF mCurPosition;
  private static PointF mNextPosition;
  private static int mTouchCount;
  private static int musicCurrentPosition;
  private static int musicDuration;
  private static long musicStartTime;
  
  static
  {
    $VALUES = new TouchTriggerManager[] { INSTANCE };
    TAG = TouchTriggerManager.class.getSimpleName();
    mCurExpression = -1;
    mCurPosition = new PointF();
    mNextPosition = new PointF();
    bgmTriggerTime = 0L;
    bgmClockTime = 0.0F;
    musicStartTime = 0L;
    musicDuration = 0;
    musicCurrentPosition = 0;
    mTouchCount = 0;
  }
  
  private TouchTriggerManager() {}
  
  public static TouchTriggerManager getInstance()
  {
    return INSTANCE;
  }
  
  private int getTouchState(int paramInt)
  {
    if (paramInt != 100) {
      mCurExpression = -1;
    } else {
      mCurExpression = PTFaceAttr.PTExpression.TAP_SCREEN.value;
    }
    return mCurExpression;
  }
  
  public void clear()
  {
    mCurExpression = -1;
    PointF localPointF = mCurPosition;
    localPointF.x = -1.0F;
    localPointF.y = -1.0F;
    localPointF = mNextPosition;
    localPointF.x = 0.0F;
    localPointF.y = 0.0F;
    bgmClockTime = 0.0F;
    bgmTriggerTime = 0L;
    musicDuration = 0;
    musicStartTime = 0L;
    musicCurrentPosition = 0;
    isLocked = false;
    mTouchCount = 0;
  }
  
  public void clearAction()
  {
    isLocked = false;
  }
  
  public float getBgmClockTime()
  {
    return bgmClockTime;
  }
  
  public long getBgmTriggerTime()
  {
    return bgmTriggerTime;
  }
  
  public PointF getCurTouchPosition()
  {
    return mCurPosition;
  }
  
  public int getMusicCurrentPosition()
  {
    return musicCurrentPosition;
  }
  
  public int getMusicDuration()
  {
    return musicDuration;
  }
  
  public long getMusicStartTime()
  {
    return musicStartTime;
  }
  
  public int getTouchCount()
  {
    return mTouchCount;
  }
  
  public void lockAction()
  {
    isLocked = true;
  }
  
  public void reset()
  {
    mCurExpression = -1;
    PointF localPointF = mCurPosition;
    localPointF.x = -1.0F;
    localPointF.y = -1.0F;
    localPointF = mNextPosition;
    localPointF.x = 0.0F;
    localPointF.y = 0.0F;
    bgmClockTime = 0.0F;
    bgmTriggerTime = 0L;
    musicDuration = 0;
    musicStartTime = 0L;
    musicCurrentPosition = 0;
    isLocked = false;
    mTouchCount = 0;
  }
  
  public void setBgmClockTime(float paramFloat)
  {
    bgmClockTime = paramFloat;
  }
  
  public void setBgmTriggerTime(long paramLong)
  {
    bgmTriggerTime = paramLong;
  }
  
  public void setMusicCurrentPosition(int paramInt)
  {
    musicCurrentPosition = paramInt;
  }
  
  public void setMusicDuration(int paramInt)
  {
    musicDuration = paramInt;
  }
  
  public void setMusicStartTime(long paramLong)
  {
    musicStartTime = paramLong;
  }
  
  public void setTouchState(int paramInt)
  {
    mCurExpression = getTouchState(paramInt);
    if (!isLocked) {
      mTouchCount += 1;
    }
  }
  
  public void setTouchState(int paramInt, float paramFloat1, float paramFloat2)
  {
    mCurExpression = getTouchState(paramInt);
    PointF localPointF = mNextPosition;
    localPointF.x = paramFloat1;
    localPointF.y = paramFloat2;
    if (!isLocked) {
      mTouchCount += 1;
    }
  }
  
  public void updateTouchTriggerState(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo != null) && (paramPTDetectInfo.triggeredExpression != null) && (mCurExpression != -1))
    {
      paramPTDetectInfo.triggeredExpression.add(Integer.valueOf(mCurExpression));
      mCurPosition.x = mNextPosition.x;
      mCurPosition.y = mNextPosition.y;
    }
    else
    {
      paramPTDetectInfo = mCurPosition;
      paramPTDetectInfo.x = -1.0F;
      paramPTDetectInfo.y = -1.0F;
    }
    mCurExpression = -1;
    paramPTDetectInfo = mNextPosition;
    paramPTDetectInfo.x = 0.0F;
    paramPTDetectInfo.y = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.TouchTriggerManager
 * JD-Core Version:    0.7.0.1
 */