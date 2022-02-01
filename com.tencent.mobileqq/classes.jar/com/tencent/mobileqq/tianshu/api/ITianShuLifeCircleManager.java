package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITianShuLifeCircleManager
  extends QRouteApi
{
  public abstract void onAccountChange();
  
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
  
  public abstract void onLogout();
  
  public abstract void onNetworkStateChange();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager
 * JD-Core Version:    0.7.0.1
 */