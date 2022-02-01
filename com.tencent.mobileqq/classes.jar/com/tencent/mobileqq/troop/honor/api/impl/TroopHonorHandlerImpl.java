package com.tencent.mobileqq.troop.honor.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler;
import com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler;
import mqq.app.AppRuntime;

public class TroopHonorHandlerImpl
  implements ITroopHonorHandler
{
  private AppRuntime mApp;
  private TroopHonorHandler troopHonorHandler;
  
  private TroopHonorHandler getTroopHonorHandler()
  {
    Object localObject = (AppInterface)this.mApp;
    if (localObject != null)
    {
      localObject = (TroopHonorHandler)((AppInterface)localObject).getBusinessHandler(TroopHonorHandler.class.getName());
      this.troopHonorHandler = ((TroopHonorHandler)localObject);
      return localObject;
    }
    return null;
  }
  
  public void getHostTroopHonorList()
  {
    getHostTroopHonorList(false);
  }
  
  public void getHostTroopHonorList(boolean paramBoolean)
  {
    this.troopHonorHandler.a(paramBoolean);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.troopHonorHandler = getTroopHonorHandler();
  }
  
  public void onDestroy()
  {
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.api.impl.TroopHonorHandlerImpl
 * JD-Core Version:    0.7.0.1
 */