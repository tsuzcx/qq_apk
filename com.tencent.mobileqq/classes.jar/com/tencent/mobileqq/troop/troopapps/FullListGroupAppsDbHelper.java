package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FullListGroupAppsDbHelper
{
  private final AppRuntime a;
  
  public FullListGroupAppsDbHelper(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity != null) && (!GroupUtil.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
      paramFullListGroupAppEntity.setStatus(1000);
      localEntityManager.delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
      localEntityManager.persistOrReplace(paramFullListGroupAppEntity);
      localEntityManager.close();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
    }
  }
  
  public void a()
  {
    Object localObject1 = this.a.getEntityManagerFactory().createEntityManager();
    ITroopAioAppService localITroopAioAppService = (ITroopAioAppService)this.a.getRuntimeService(ITroopAioAppService.class, "");
    Object localObject2 = ((EntityManager)localObject1).query(FullListGroupAppEntity.class);
    if (!GroupUtil.a((Collection)localObject2))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject2).next();
        if (!GroupUtil.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localITroopAioAppService.setFullAppsListInfos(localFullListGroupAppEntity.troopAIOAppInfos);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("buildFullListFromDb: invoked. ");
          ((StringBuilder)localObject2).append(localITroopAioAppService.getFullAppsListInfos());
          QLog.i("FullListGroupAppsDbHelper", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    ((EntityManager)localObject1).close();
    localObject1 = localITroopAioAppService.getFullAppsListInfos();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      localITroopAioAppService.setFullAppListHash("");
      localITroopAioAppService.saveFullAppListHashInSp();
    }
  }
  
  public void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
  
  public void b()
  {
    this.a.getEntityManagerFactory().createEntityManager().delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper
 * JD-Core Version:    0.7.0.1
 */