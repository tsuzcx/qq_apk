package com.tencent.mobileqq.troop.troopgame.api.impl;

import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardManager;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.CallbackInMainThread;
import mqq.app.AppRuntime;

public class TroopGameCardServiceImpl
  implements ITroopGameCardService
{
  private AppRuntime mAppRuntime;
  
  private TroopGameCardManager getTroopGameCardManager()
  {
    IManagerFactoryService localIManagerFactoryService = (IManagerFactoryService)this.mAppRuntime.getRuntimeService(IManagerFactoryService.class, "");
    if (localIManagerFactoryService != null) {
      return (TroopGameCardManager)localIManagerFactoryService.getManager(TroopGameCardManager.class);
    }
    return null;
  }
  
  public void getMemberGradeLevelInfoAsync(String paramString, ITroopGameCardService.CallbackInMainThread paramCallbackInMainThread)
  {
    TroopGameCardManager localTroopGameCardManager = getTroopGameCardManager();
    if (localTroopGameCardManager != null) {
      localTroopGameCardManager.a(paramString, paramCallbackInMainThread);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mAppRuntime = null;
  }
  
  public void saveMemberGradeLevelInfo(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    TroopGameCardManager localTroopGameCardManager = getTroopGameCardManager();
    if (localTroopGameCardManager != null) {
      localTroopGameCardManager.a(paramMemberGradeLevelInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.api.impl.TroopGameCardServiceImpl
 * JD-Core Version:    0.7.0.1
 */