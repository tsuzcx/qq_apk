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
  private static final String TAG = "TriggerStateItem";
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
    if ((paramList != null) && (paramMaterialStateEdgeItem != null))
    {
      boolean bool = this.mStateMap.containsKey(paramMaterialStateEdgeItem.startState);
      int i = 0;
      if (bool)
      {
        int j = ((Integer)this.mStateMap.get(paramMaterialStateEdgeItem.startState)).intValue();
        Object localObject2;
        for (localObject1 = null; i < paramList.size(); localObject1 = localObject2)
        {
          TriggerActionItem localTriggerActionItem = (TriggerActionItem)paramList.get(i);
          localObject2 = localObject1;
          if (paramMaterialStateEdgeItem.action != null)
          {
            localObject2 = localObject1;
            if (paramMaterialStateEdgeItem.action.equals(localTriggerActionItem.id)) {
              localObject2 = localTriggerActionItem;
            }
          }
          i += 1;
        }
        if (localObject1 != null)
        {
          paramList = new TriggerStateEdge();
          paramList.state = paramMaterialStateEdgeItem.endState;
          paramList.value = ((TriggerActionItem)localObject1);
          if (this.mStateItemGraph.containsKey(Integer.valueOf(j)))
          {
            ((List)this.mStateItemGraph.get(Integer.valueOf(j))).add(paramList);
          }
          else
          {
            paramMaterialStateEdgeItem = new ArrayList();
            paramMaterialStateEdgeItem.add(paramList);
            this.mStateItemGraph.put(Integer.valueOf(j), paramMaterialStateEdgeItem);
          }
        }
        this.mIsStateValid = true;
        return;
      }
      paramList = TAG;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startState = ");
      ((StringBuilder)localObject1).append(paramMaterialStateEdgeItem.startState);
      ((StringBuilder)localObject1).append(" is wrong!");
      Log.e(paramList, ((StringBuilder)localObject1).toString());
      this.mIsStateValid = false;
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
        String str;
        StringBuilder localStringBuilder;
        if (!this.mStateMap.containsKey(localMaterialStateEdgeItem.startState))
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localMaterialStateEdgeItem.startState);
          localStringBuilder.append(" = ");
          localStringBuilder.append(i);
          Log.i(str, localStringBuilder.toString());
          this.mStateMap.put(localMaterialStateEdgeItem.startState, Integer.valueOf(i));
          j = i + 1;
        }
        i = j;
        if (!this.mStateMap.containsKey(localMaterialStateEdgeItem.endState))
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localMaterialStateEdgeItem.endState);
          localStringBuilder.append(" = ");
          localStringBuilder.append(j);
          Log.i(str, localStringBuilder.toString());
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
    int i = this.mStateVersion;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - this.mLastUpdateStateTime < 1000L) {
        bool1 = true;
      }
    }
    return bool1;
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("after delay CurState = ");
    localStringBuilder.append(this.mCurrentState);
    localStringBuilder.append(" mRandomValue = ");
    localStringBuilder.append(this.mRandomValue);
    Log.i(str, localStringBuilder.toString());
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
    Map localMap = this.mStateMap;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.mStateItemGraph;
    if (localMap != null) {
      localMap.clear();
    }
    resetAllDelayTime();
    this.mIsStateValid = false;
    this.mNeedToUpdate = true;
  }
  
  public void forceUpdateState(String paramString)
  {
    Object localObject = this.mStateMap;
    if ((localObject != null) && (((Map)localObject).containsKey(paramString)))
    {
      this.mCurrentState = ((Integer)this.mStateMap.get(paramString)).intValue();
      paramString = this.mStateItemGraph;
      if (paramString != null)
      {
        paramString = (List)paramString.get(Integer.valueOf(this.mCurrentState));
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject = (TriggerStateEdge)paramString.next();
            if (isMatch(((TriggerStateEdge)localObject).value))
            {
              this.mNextTriggerType = getTriggerTypeFromAction(((TriggerStateEdge)localObject).value);
              this.mNextState = ((Integer)this.mStateMap.get(((TriggerStateEdge)localObject).state)).intValue();
              updateTriggerExpressionDelay(((TriggerStateEdge)localObject).value);
              this.mNeedToUpdate = true;
              localObject = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(" begin change delay isInDelayTime() = ");
              localStringBuilder.append(isInDelayTime());
              localStringBuilder.append(" DelayTime = ");
              localStringBuilder.append(this.mDelayTime);
              localStringBuilder.append(" CurState = ");
              localStringBuilder.append(this.mCurrentState);
              localStringBuilder.append(" -> ");
              localStringBuilder.append(this.mNextState);
              Log.i((String)localObject, localStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public double getRandomValue()
  {
    double d = this.mRandomValue;
    Double.isNaN(d);
    return d / 100.0D;
  }
  
  public int getTriggetType()
  {
    return this.mTriggerType;
  }
  
  public void init(List<MaterialStateEdgeItem> paramList, List<TriggerActionItem> paramList1)
  {
    initStateMap(paramList);
    initStateGraph(paramList, paramList1);
    paramList = this.mStateMap;
    if ((paramList != null) && (paramList.containsKey("idle")) && (this.mIsStateValid))
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
        Map localMap = this.mStateMap;
        if ((localMap != null) && (localMap.containsKey(str)) && (((Integer)this.mStateMap.get(str)).intValue() == this.mCurrentState)) {
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
    Map localMap = this.mStateMap;
    if ((localMap != null) && (localMap.containsKey("idle")) && (this.mIsStateValid))
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
    if (!isInDelayTime())
    {
      if (isTooShortToChangeState()) {
        return;
      }
      if (this.mNeedToUpdate)
      {
        update();
        return;
      }
      Object localObject1 = this.mStateItemGraph;
      if (localObject1 != null)
      {
        localObject1 = (List)((Map)localObject1).get(Integer.valueOf(this.mCurrentState));
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (TriggerStateEdge)((Iterator)localObject1).next();
            if (isMatch(((TriggerStateEdge)localObject2).value))
            {
              this.mNextTriggerType = getTriggerTypeFromAction(((TriggerStateEdge)localObject2).value);
              this.mNextState = ((Integer)this.mStateMap.get(((TriggerStateEdge)localObject2).state)).intValue();
              updateTriggerExpressionDelay(((TriggerStateEdge)localObject2).value);
              this.mNeedToUpdate = true;
              localObject2 = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(" begin change delay isInDelayTime() = ");
              localStringBuilder.append(isInDelayTime());
              localStringBuilder.append(" DelayTime = ");
              localStringBuilder.append(this.mDelayTime);
              localStringBuilder.append(" CurState = ");
              localStringBuilder.append(this.mCurrentState);
              localStringBuilder.append(" -> ");
              localStringBuilder.append(this.mNextState);
              Log.i((String)localObject2, localStringBuilder.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerStateItem
 * JD-Core Version:    0.7.0.1
 */