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
  private static float bgmClockTime = 0.0F;
  private static long bgmTriggerTime;
  private static int mCurExpression;
  private static PointF mCurPosition;
  private static PointF mNextPosition;
  
  static
  {
    $VALUES = new TouchTriggerManager[] { INSTANCE };
    TAG = TouchTriggerManager.class.getSimpleName();
    mCurExpression = -1;
    mCurPosition = new PointF();
    mNextPosition = new PointF();
    bgmTriggerTime = 0L;
  }
  
  private TouchTriggerManager() {}
  
  public static TouchTriggerManager getInstance()
  {
    return INSTANCE;
  }
  
  private int getTouchState(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (mCurExpression = -1;; mCurExpression = PTFaceAttr.PTExpression.TAP_SCREEN.value) {
      return mCurExpression;
    }
  }
  
  public void clear()
  {
    mCurExpression = -1;
    mCurPosition.x = 0.0F;
    mCurPosition.y = 0.0F;
    mNextPosition.x = 0.0F;
    mNextPosition.y = 0.0F;
    bgmClockTime = 0.0F;
    bgmTriggerTime = 0L;
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
  
  public void reset()
  {
    mCurExpression = -1;
    mCurPosition.x = 0.0F;
    mCurPosition.y = 0.0F;
    mNextPosition.x = 0.0F;
    mNextPosition.y = 0.0F;
    bgmClockTime = 0.0F;
    bgmTriggerTime = 0L;
  }
  
  public void setBgmClockTime(float paramFloat)
  {
    bgmClockTime = paramFloat;
  }
  
  public void setBgmTriggerTime(long paramLong)
  {
    bgmTriggerTime = paramLong;
  }
  
  public void setTouchState(int paramInt)
  {
    mCurExpression = getTouchState(paramInt);
  }
  
  public void setTouchState(int paramInt, float paramFloat1, float paramFloat2)
  {
    mCurExpression = getTouchState(paramInt);
    mNextPosition.x = paramFloat1;
    mNextPosition.y = paramFloat2;
  }
  
  public void updateTouchTriggerState(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo != null) && (paramPTDetectInfo.triggeredExpression != null) && (mCurExpression != -1))
    {
      paramPTDetectInfo.triggeredExpression.add(Integer.valueOf(mCurExpression));
      mCurPosition.x = mNextPosition.x;
    }
    for (mCurPosition.y = mNextPosition.y;; mCurPosition.y = 0.0F)
    {
      mCurExpression = -1;
      mNextPosition.x = 0.0F;
      mNextPosition.y = 0.0F;
      return;
      mCurPosition.x = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.TouchTriggerManager
 * JD-Core Version:    0.7.0.1
 */