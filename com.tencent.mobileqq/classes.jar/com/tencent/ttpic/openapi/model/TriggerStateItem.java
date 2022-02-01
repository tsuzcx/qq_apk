package com.tencent.ttpic.openapi.model;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TriggerStateItem
{
  public static final int NEW_VERSION = 2;
  public static final int OLD_VERSION = 1;
  private static final String STATE_IDLE = "idle";
  private static final long STATE_TIME = 1000L;
  private static final String TAG = TriggerStateItem.class.getSimpleName();
  private int mCurrentState = 0;
  private long mDelayTime;
  private boolean mIsStateValid = false;
  private long mLastUpdateStateTime = 0L;
  private boolean mNeedToUpdate = true;
  private int mNextState;
  private int mNextTriggerType = 1;
  private int mRandomValue;
  private long mStartChangeTime = 0L;
  private Map<Integer, List<TriggerStateEdge>> mStateItemGraph = new HashMap();
  private Map<String, Integer> mStateMap = new HashMap();
  private int mStateVersion = 1;
  private int mTriggerType = 1;
  private Random rand = new Random();
  
  public TriggerStateItem(List<MaterialStateEdgeItem> paramList, List<TriggerActionItem> paramList1)
  {
    init(paramList, paramList1);
  }
  
  private void addItemToStateGraph(MaterialStateEdgeItem paramMaterialStateEdgeItem, List<TriggerActionItem> paramList)
  {
    int j;
    int i;
    Object localObject;
    if ((paramList != null) && (paramMaterialStateEdgeItem != null)) {
      if (this.mStateMap.containsKey(paramMaterialStateEdgeItem.startState))
      {
        j = ((Integer)this.mStateMap.get(paramMaterialStateEdgeItem.startState)).intValue();
        i = 0;
        localObject = null;
        if (i >= paramList.size()) {
          break label145;
        }
        TriggerActionItem localTriggerActionItem = (TriggerActionItem)paramList.get(i);
        if ((paramMaterialStateEdgeItem.action == null) || (!paramMaterialStateEdgeItem.action.equals(localTriggerActionItem.id))) {
          break label254;
        }
        localObject = localTriggerActionItem;
      }
    }
    label145:
    label219:
    label254:
    for (;;)
    {
      i += 1;
      break;
      Log.e(TAG, "startState = " + paramMaterialStateEdgeItem.startState + " is wrong!");
      this.mIsStateValid = false;
      return;
      if (localObject != null)
      {
        paramList = new TriggerStateEdge();
        paramList.state = paramMaterialStateEdgeItem.endState;
        paramList.value = localObject;
        if (!this.mStateItemGraph.containsKey(Integer.valueOf(j))) {
          break label219;
        }
        ((List)this.mStateItemGraph.get(Integer.valueOf(j))).add(paramList);
      }
      for (;;)
      {
        this.mIsStateValid = true;
        return;
        paramMaterialStateEdgeItem = new ArrayList();
        paramMaterialStateEdgeItem.add(paramList);
        this.mStateItemGraph.put(Integer.valueOf(j), paramMaterialStateEdgeItem);
      }
    }
  }
  
  private int getTriggerTypeFromAction(TriggerActionItem paramTriggerActionItem)
  {
    if (paramTriggerActionItem != null) {
      return paramTriggerActionItem.getTriggerType();
    }
    return -1;
  }
  
  private void initStateGraph(List<MaterialStateEdgeItem> paramList, List<TriggerActionItem> paramList1)
  {
    if ((paramList != null) && (paramList1 != null))
    {
      int i = 0;
      while (i < paramList.size())
      {
        addItemToStateGraph((MaterialStateEdgeItem)paramList.get(i), paramList1);
        i += 1;
      }
    }
  }
  
  private void initStateMap(List<MaterialStateEdgeItem> paramList)
  {
    if (paramList != null)
    {
      int k = 0;
      int i = 0;
      while (k < paramList.size())
      {
        MaterialStateEdgeItem localMaterialStateEdgeItem = (MaterialStateEdgeItem)paramList.get(k);
        int j = i;
        if (!this.mStateMap.containsKey(localMaterialStateEdgeItem.startState))
        {
          Log.i(TAG, localMaterialStateEdgeItem.startState + " = " + i);
          this.mStateMap.put(localMaterialStateEdgeItem.startState, Integer.valueOf(i));
          j = i + 1;
        }
        i = j;
        if (!this.mStateMap.containsKey(localMaterialStateEdgeItem.endState))
        {
          Log.i(TAG, localMaterialStateEdgeItem.endState + " = " + j);
          this.mStateMap.put(localMaterialStateEdgeItem.endState, Integer.valueOf(j));
          i = j + 1;
        }
        k += 1;
      }
    }
  }
  
  private boolean isInDelayTime()
  {
    return System.currentTimeMillis() - this.mStartChangeTime < this.mDelayTime;
  }
  
  private boolean isMatch(TriggerActionItem paramTriggerActionItem)
  {
    if (paramTriggerActionItem != null) {
      return paramTriggerActionItem.isTriggered();
    }
    return false;
  }
  
  private boolean isTooShortToChangeState()
  {
    if (this.mStateVersion == 1) {
      return System.currentTimeMillis() - this.mLastUpdateStateTime < 1000L;
    }
    return false;
  }
  
  private void resetAllDelayTime()
  {
    this.mStartChangeTime = 0L;
    this.mLastUpdateStateTime = 0L;
  }
  
  private void update()
  {
    this.mCurrentState = this.mNextState;
    this.mTriggerType = this.mNextTriggerType;
    this.mStartChangeTime = 0L;
    this.mDelayTime = 0L;
    this.mLastUpdateStateTime = System.currentTimeMillis();
    updateRamdonValue();
    this.mNeedToUpdate = false;
    Log.i(TAG, "after delay CurState = " + this.mCurrentState + " mRandomValue = " + this.mRandomValue);
  }
  
  private void updateRamdonValue()
  {
    this.mRandomValue = this.rand.nextInt(100);
  }
  
  private void updateTriggerExpressionDelay(TriggerActionItem paramTriggerActionItem)
  {
    this.mStartChangeTime = System.currentTimeMillis();
    this.mDelayTime = paramTriggerActionItem.mActionDelay;
  }
  
  public void clear()
  {
    if (this.mStateMap != null) {
      this.mStateMap.clear();
    }
    if (this.mStateItemGraph != null) {
      this.mStateItemGraph.clear();
    }
    resetAllDelayTime();
    this.mIsStateValid = false;
    this.mNeedToUpdate = true;
  }
  
  public void forceUpdateState(String paramString)
  {
    if ((this.mStateMap != null) && (this.mStateMap.containsKey(paramString)))
    {
      this.mCurrentState = ((Integer)this.mStateMap.get(paramString)).intValue();
      if (this.mStateItemGraph != null)
      {
        paramString = (List)this.mStateItemGraph.get(Integer.valueOf(this.mCurrentState));
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            TriggerStateEdge localTriggerStateEdge = (TriggerStateEdge)paramString.next();
            if (isMatch(localTriggerStateEdge.value))
            {
              this.mNextTriggerType = getTriggerTypeFromAction(localTriggerStateEdge.value);
              this.mNextState = ((Integer)this.mStateMap.get(localTriggerStateEdge.state)).intValue();
              updateTriggerExpressionDelay(localTriggerStateEdge.value);
              this.mNeedToUpdate = true;
              Log.i(TAG, " begin change delay isInDelayTime() = " + isInDelayTime() + " DelayTime = " + this.mDelayTime + " CurState = " + this.mCurrentState + " -> " + this.mNextState);
            }
          }
        }
      }
    }
  }
  
  public double getRandomValue()
  {
    return this.mRandomValue / 100.0D;
  }
  
  public int getTriggetType()
  {
    return this.mTriggerType;
  }
  
  public void init(List<MaterialStateEdgeItem> paramList, List<TriggerActionItem> paramList1)
  {
    initStateMap(paramList);
    initStateGraph(paramList, paramList1);
    if ((this.mStateMap != null) && (this.mStateMap.containsKey("idle")) && (this.mIsStateValid))
    {
      int i = ((Integer)this.mStateMap.get("idle")).intValue();
      this.mNextState = i;
      this.mCurrentState = i;
      return;
    }
    this.mIsStateValid = false;
  }
  
  public boolean isTriggerState(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if ((this.mStateMap != null) && (this.mStateMap.containsKey(str)) && (((Integer)this.mStateMap.get(str)).intValue() == this.mCurrentState)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isValid()
  {
    return this.mIsStateValid;
  }
  
  public void reset()
  {
    if ((this.mStateMap != null) && (this.mStateMap.containsKey("idle")) && (this.mIsStateValid))
    {
      int i = ((Integer)this.mStateMap.get("idle")).intValue();
      this.mNextState = i;
      this.mCurrentState = i;
      resetAllDelayTime();
      this.mNeedToUpdate = true;
      return;
    }
    this.mIsStateValid = false;
  }
  
  public void setStateVersion(int paramInt)
  {
    this.mStateVersion = paramInt;
  }
  
  public void updateState()
  {
    if ((isInDelayTime()) || (isTooShortToChangeState())) {}
    for (;;)
    {
      return;
      if (this.mNeedToUpdate)
      {
        update();
        return;
      }
      if (this.mStateItemGraph != null)
      {
        Object localObject = (List)this.mStateItemGraph.get(Integer.valueOf(this.mCurrentState));
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TriggerStateEdge localTriggerStateEdge = (TriggerStateEdge)((Iterator)localObject).next();
            if (isMatch(localTriggerStateEdge.value))
            {
              this.mNextTriggerType = getTriggerTypeFromAction(localTriggerStateEdge.value);
              this.mNextState = ((Integer)this.mStateMap.get(localTriggerStateEdge.state)).intValue();
              updateTriggerExpressionDelay(localTriggerStateEdge.value);
              this.mNeedToUpdate = true;
              Log.i(TAG, " begin change delay isInDelayTime() = " + isInDelayTime() + " DelayTime = " + this.mDelayTime + " CurState = " + this.mCurrentState + " -> " + this.mNextState);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerStateItem
 * JD-Core Version:    0.7.0.1
 */