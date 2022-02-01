package com.tencent.statemachine.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStateManager
  extends QRouteApi
{
  public abstract void addMainStateObserver(StateObserver paramStateObserver);
  
  public abstract void onMainDrawerChange(boolean paramBoolean);
  
  public abstract void onMainFragmentChange(boolean paramBoolean);
  
  public abstract void onMainTabChange(int paramInt);
  
  public abstract void removeMainStateObserver(StateObserver paramStateObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.statemachine.api.IStateManager
 * JD-Core Version:    0.7.0.1
 */