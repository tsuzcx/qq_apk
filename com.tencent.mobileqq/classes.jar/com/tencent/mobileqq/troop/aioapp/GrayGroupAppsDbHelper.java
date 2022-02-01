package com.tencent.mobileqq.troop.aioapp;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class GrayGroupAppsDbHelper
{
  private final QQAppInterface a;
  
  GrayGroupAppsDbHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    AioGroupAppsManager localAioGroupAppsManager = AioGroupAppsManager.a(this.a);
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
        localAioGroupAppsManager.a.put(Long.valueOf(localGrayGroupAppEntity.groupUin), localGrayGroupAppEntity);
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
  
  void a()
  {
    a(false);
  }
  
  void a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ThreadManagerV2.excute(new GrayGroupAppsDbHelper.1(this, paramGrayGroupAppEntity), 32, null, false);
  }
  
  void b()
  {
    a(true);
  }
  
  void c()
  {
    this.a.getEntityManagerFactory().createEntityManager().delete(GrayGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.GrayGroupAppsDbHelper
 * JD-Core Version:    0.7.0.1
 */