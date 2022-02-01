package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import mqq.app.AppRuntime;

public class TroopManagerServiceImpl
  implements ITroopManagerService
{
  private AppRuntime mAppRuntime;
  
  public void deleteTroop(String paramString)
  {
    ((TroopManager)this.mAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).d(paramString);
  }
  
  public byte[] getTroopAppListData(String paramString)
  {
    return ((TroopInfoManager)this.mAppRuntime.getManager(QQManagerFactory.TROOPINFO_MANAGER)).c(paramString);
  }
  
  public int getTroopMask(String paramString)
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getTroopMask(paramString);
    }
    return 1;
  }
  
  public void getTroopsMemberList()
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((ITroopMemberInfoService)localAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopsMemberList();
    }
  }
  
  public void handleTroopMemberNewLevelChange(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    ((TroopManager)this.mAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString, paramArrayOfByte, paramInt);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void setTroopAppListData(String paramString, byte[] paramArrayOfByte)
  {
    ((ITroopAppService)this.mAppRuntime.getRuntimeService(ITroopAppService.class, "all")).setTroopAppListData(paramString, paramArrayOfByte);
    ((TroopInfoManager)this.mAppRuntime.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */