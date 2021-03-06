package com.tencent.qqmini.miniapp.core.fsm;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StateMachine<T, E>
{
  private static final String TAG = "StateMachine";
  private StateMachine<T, E>.State<T> mCurrState;
  private List<E> mEvents = new ArrayList();
  private List<StateMachine.OnStateChangeListener> mStateListeners = new ArrayList();
  private Map<StateMachine.State, List<StateMachine.StateTransfer>> mStateTransferMap = new HashMap();
  
  private void autoConsumeCacheEvents()
  {
    Object localObject1 = new ArrayList(this.mEvents);
    if (((List)localObject1).size() <= 0) {
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    label185:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label185;
          }
          Object localObject3 = (Map.Entry)localIterator.next();
          Object localObject4 = (StateMachine.State)((Map.Entry)localObject3).getKey();
          if (this.mCurrState == localObject4)
          {
            localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (StateMachine.StateTransfer)((Iterator)localObject3).next();
              if ((localObject4 == null) || (!localObject2.equals(StateMachine.StateTransfer.access$100((StateMachine.StateTransfer)localObject4)))) {
                break;
              }
              setCurrState(StateMachine.StateTransfer.access$200((StateMachine.StateTransfer)localObject4));
              this.mEvents.remove(localObject2);
            }
          }
        }
      }
    }
  }
  
  public void addStateChangeListener(StateMachine.OnStateChangeListener paramOnStateChangeListener)
  {
    try
    {
      if (!this.mStateListeners.contains(paramOnStateChangeListener)) {
        this.mStateListeners.add(paramOnStateChangeListener);
      }
      return;
    }
    finally
    {
      paramOnStateChangeListener = finally;
      throw paramOnStateChangeListener;
    }
  }
  
  public void addStateTransfer(StateMachine<T, E>.StateTransfer<E> paramStateMachine)
  {
    if (paramStateMachine != null)
    {
      if (StateMachine.StateTransfer.access$000(paramStateMachine) == null) {
        return;
      }
      List localList = (List)this.mStateTransferMap.get(paramStateMachine.from());
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.mStateTransferMap.put(StateMachine.StateTransfer.access$000(paramStateMachine), localObject);
      }
      ((List)localObject).add(paramStateMachine);
    }
  }
  
  public void appendEvent(E paramE)
  {
    if (paramE != null)
    {
      if (this.mCurrState == null) {
        return;
      }
      int i = 0;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label140;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (StateMachine.State)((Map.Entry)localObject1).getKey();
        if (this.mCurrState == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StateMachine.StateTransfer)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(StateMachine.StateTransfer.access$100((StateMachine.StateTransfer)localObject2)))) {
              break;
            }
            setCurrState(StateMachine.StateTransfer.access$200((StateMachine.StateTransfer)localObject2));
            i = 1;
          }
        }
      }
      label140:
      if (i == 0) {
        this.mEvents.add(paramE);
      }
    }
  }
  
  public StateMachine.State getCurrState()
  {
    return this.mCurrState;
  }
  
  protected void notifyStateChange(StateMachine.State paramState1, StateMachine.State paramState2)
  {
    try
    {
      paramState1 = this.mStateListeners.iterator();
      while (paramState1.hasNext())
      {
        paramState2 = (StateMachine.OnStateChangeListener)paramState1.next();
        if (paramState2 != null) {
          paramState2.onStateChanged();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramState1;
    }
  }
  
  public boolean removeStateChangeListener(StateMachine.OnStateChangeListener paramOnStateChangeListener)
  {
    try
    {
      boolean bool = this.mStateListeners.remove(paramOnStateChangeListener);
      return bool;
    }
    finally
    {
      paramOnStateChangeListener = finally;
      throw paramOnStateChangeListener;
    }
  }
  
  public void sendEvent(E paramE)
  {
    if (paramE != null)
    {
      if (this.mCurrState == null) {
        return;
      }
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (StateMachine.State)((Map.Entry)localObject1).getKey();
        if (this.mCurrState == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StateMachine.StateTransfer)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(StateMachine.StateTransfer.access$100((StateMachine.StateTransfer)localObject2)))) {
              break;
            }
            setCurrState(StateMachine.StateTransfer.access$200((StateMachine.StateTransfer)localObject2));
          }
        }
      }
    }
  }
  
  public void setCurrState(StateMachine.State paramState)
  {
    StateMachine.State localState = getCurrState();
    if (paramState != null)
    {
      if (paramState == this.mCurrState) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append("(");
      localStringBuilder.append(this);
      localStringBuilder.append(") change state from ");
      Object localObject = this.mCurrState;
      if (localObject != null) {
        localObject = ((StateMachine.State)localObject).id;
      } else {
        localObject = "N/A";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramState.id);
      QMLog.i("StateMachine", localStringBuilder.toString());
      this.mCurrState = paramState;
      if (paramState != localState) {
        notifyStateChange(localState, paramState);
      }
      this.mCurrState.onStart();
      autoConsumeCacheEvents();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.fsm.StateMachine
 * JD-Core Version:    0.7.0.1
 */