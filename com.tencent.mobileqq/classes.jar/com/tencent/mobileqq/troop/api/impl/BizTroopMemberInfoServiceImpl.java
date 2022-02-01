package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class BizTroopMemberInfoServiceImpl
  implements IBizTroopMemberInfoService
{
  public static final String TAG = "BizTroopMemberInfoServiceImpl";
  protected AppRuntime mApp;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public boolean saveTroopMemberGlamourLevel(String paramString1, String paramString2, int paramInt)
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.mApp.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo = localITroopMemberInfoService.getTroopMember(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (paramInt > 0)
      {
        j = i;
        if (paramInt != localTroopMemberInfo.mGlamourLevel)
        {
          localTroopMemberInfo.mGlamourLevel = paramInt;
          j = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BizTroopMemberInfoServiceImpl", 2, "saveTroopMemberEx ," + localTroopMemberInfo.toString());
      }
      if (j != 0)
      {
        EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          localITroopMemberInfoService.saveTroopMemberInfoInLruCache(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.persistOrReplace(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.close();
          localITroopMemberInfoService.notifyChangeMember(paramString1, paramString2);
          return true;
          localEntityManager.update(localTroopMemberInfo);
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.BizTroopMemberInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */