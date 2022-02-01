package com.tencent.statemachine.api.impl;

import com.tencent.statemachine.MainStateManager;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.statemachine.api.StateObserver;

public class StateManagerImpl
  implements IStateManager
{
  public void addMainStateObserver(StateObserver paramStateObserver)
  {
    MainStateManager.getInstance().addMainStateObserver(paramStateObserver);
  }
  
  public void onMainDrawerChange(boolean paramBoolean)
  {
    MainStateManager.getInstance().onMainDrawerChange(paramBoolean);
  }
  
  public void onMainFragmentChange(boolean paramBoolean)
  {
    MainStateManager.getInstance().onMainFragmentChange(paramBoolean);
  }
  
  public void onMainTabChange(int paramInt)
  {
    MainStateManager.getInstance().onMainTabChange(paramInt);
  }
  
  public void removeMainStateObserver(StateObserver paramStateObserver)
  {
    MainStateManager.getInstance().removeMainStateObserver(paramStateObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.statemachine.api.impl.StateManagerImpl
 * JD-Core Version:    0.7.0.1
 */