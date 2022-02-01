package com.tencent.mobileqq.mini.appbrand.fsm;

import com.tencent.qphone.base.util.QLog;
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
      label21:
      return;
    } else {
      localObject1 = ((List)localObject1).iterator();
    }
    label182:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label21;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 == null) {
        break;
      }
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label182;
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
    if ((paramStateMachine == null) || (StateMachine.StateTransfer.access$000(paramStateMachine) == null)) {
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
  
  public void appendEvent(E paramE)
  {
    if ((paramE == null) || (this.mCurrState == null)) {}
    label156:
    label157:
    for (;;)
    {
      return;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (StateMachine.State)((Map.Entry)localObject1).getKey();
        if (this.mCurrState != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StateMachine.StateTransfer)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(StateMachine.StateTransfer.access$100((StateMachine.StateTransfer)localObject2))))
          {
            setCurrState(StateMachine.StateTransfer.access$200((StateMachine.StateTransfer)localObject2));
            i = 1;
          }
        }
      }
      for (;;)
      {
        break;
        if (i != 0) {
          break label157;
        }
        this.mEvents.add(paramE);
        return;
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
    }
    finally {}
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
    if ((paramE == null) || (this.mCurrState == null)) {}
    label128:
    for (;;)
    {
      return;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
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
    if ((paramState == null) || (paramState == this.mCurrState)) {
      return;
    }
    StateMachine.State localState = getCurrState();
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.mCurrState != null) {}
    for (Object localObject = this.mCurrState.id;; localObject = "N/A")
    {
      QLog.i("StateMachine", 1, localObject + " to " + paramState.id);
      this.mCurrState = paramState;
      this.mCurrState.onStart();
      autoConsumeCacheEvents();
      if (paramState == localState) {
        break;
      }
      notifyStateChange(localState, paramState);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.fsm.StateMachine
 * JD-Core Version:    0.7.0.1
 */