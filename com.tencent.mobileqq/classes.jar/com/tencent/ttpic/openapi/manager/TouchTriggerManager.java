package com.tencent.ttpic.openapi.manager;

import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import java.util.Set;

public enum TouchTriggerManager
{
  INSTANCE;
  
  public static final int ACTION_CLICK_AND_MOVE_SCREEN = 103;
  public static final int ACTION_DOUBLE_CLICK_SCREEN = 101;
  public static final int ACTION_LONG_CLICK_SCREEN = 102;
  public static final int ACTION_TAP_SCREEN = 100;
  private static final int ACTIVE_NOT_TOUCH = -1;
  private static final String TAG = TouchTriggerManager.class.getSimpleName();
  private static int mCurExpression = -1;
  
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
  }
  
  public void reset()
  {
    mCurExpression = -1;
  }
  
  public void setTouchState(int paramInt)
  {
    mCurExpression = getTouchState(paramInt);
  }
  
  public void updateTouchTriggerState(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo != null) && (paramPTDetectInfo.triggeredExpression != null) && (mCurExpression != -1)) {
      paramPTDetectInfo.triggeredExpression.add(Integer.valueOf(mCurExpression));
    }
    mCurExpression = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.TouchTriggerManager
 * JD-Core Version:    0.7.0.1
 */