package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.tianshu.api.ITianShuLifeCircleManager;
import cooperation.vip.tianshu.TianShuManager;

public class TianshuLifeCircleManagerImpl
  implements ITianShuLifeCircleManager
{
  public void onAccountChange()
  {
    TianShuManager.getInstance().clearNecessaryDataCacheForReport();
    TianShuManager.setLastClickAdTraceInfo("", "");
  }
  
  public void onEnterBackground() {}
  
  public void onEnterForeground()
  {
    TianShuManager.setLastClickAdTraceInfo("", "");
  }
  
  public void onLogout()
  {
    TianShuManager.getInstance().clearNecessaryDataCacheForReport();
    TianShuManager.setLastClickAdTraceInfo("", "");
  }
  
  public void onNetworkStateChange()
  {
    TianShuManager.setLastClickAdTraceInfo("", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.TianshuLifeCircleManagerImpl
 * JD-Core Version:    0.7.0.1
 */