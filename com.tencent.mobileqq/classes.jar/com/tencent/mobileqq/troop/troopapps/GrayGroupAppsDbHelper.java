package com.tencent.mobileqq.troop.troopapps;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class GrayGroupAppsDbHelper
{
  private final AppRuntime a;
  
  public GrayGroupAppsDbHelper(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  private void a(boolean paramBoolean)
  {
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    ITroopAioAppService localITroopAioAppService = (ITroopAioAppService)this.a.getRuntimeService(ITroopAioAppService.class, "");
    Object localObject = localEntityManager.query(GrayGroupAppEntity.class);
    if (!GroupUtil.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)((Iterator)localObject).next();
        if (paramBoolean)
        {
          localGrayGroupAppEntity.updatedTimestamp = 0L;
          b(localGrayGroupAppEntity);
        }
        localITroopAioAppService.getGrayAppInfoMap().put(Long.valueOf(localGrayGroupAppEntity.groupUin), localGrayGroupAppEntity);
      }
    }
    localEntityManager.close();
  }
  
  private void b(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    paramGrayGroupAppEntity.setStatus(1000);
    localEntityManager.persistOrReplace(paramGrayGroupAppEntity);
    localEntityManager.close();
  }
  
  public void a()
  {
    a(false);
  }
  
  void a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ThreadManagerV2.excute(new GrayGroupAppsDbHelper.1(this, paramGrayGroupAppEntity), 32, null, false);
  }
  
  public void b()
  {
    a(true);
  }
  
  public void c()
  {
    this.a.getEntityManagerFactory().createEntityManager().delete(GrayGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper
 * JD-Core Version:    0.7.0.1
 */