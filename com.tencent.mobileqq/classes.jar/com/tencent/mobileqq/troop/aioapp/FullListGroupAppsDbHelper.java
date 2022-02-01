package com.tencent.mobileqq.troop.aioapp;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class FullListGroupAppsDbHelper
{
  private final QQAppInterface a;
  
  FullListGroupAppsDbHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void b(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    if ((paramFullListGroupAppEntity == null) || (GroupUtil.a(paramFullListGroupAppEntity.troopAIOAppInfos)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FullListGroupAppsDbHelper", 2, "saveToDb: invoked. empty full list, no need to persist");
      }
      return;
    }
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    paramFullListGroupAppEntity.setStatus(1000);
    localEntityManager.delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
    localEntityManager.persistOrReplace(paramFullListGroupAppEntity);
    localEntityManager.close();
  }
  
  void a()
  {
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    AioGroupAppsManager localAioGroupAppsManager = AioGroupAppsManager.a(this.a);
    Object localObject = localEntityManager.query(FullListGroupAppEntity.class);
    if (!GroupUtil.a((Collection)localObject))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FullListGroupAppEntity localFullListGroupAppEntity = (FullListGroupAppEntity)((Iterator)localObject).next();
        if (!GroupUtil.a(localFullListGroupAppEntity.troopAIOAppInfos))
        {
          localAioGroupAppsManager.a = localFullListGroupAppEntity.troopAIOAppInfos;
          QLog.i("FullListGroupAppsDbHelper", 1, "buildFullListFromDb: invoked. " + localAioGroupAppsManager.a);
          return;
        }
      }
    }
    localEntityManager.close();
  }
  
  void a(FullListGroupAppEntity paramFullListGroupAppEntity)
  {
    ThreadManagerV2.excute(new FullListGroupAppsDbHelper.1(this, paramFullListGroupAppEntity), 32, null, false);
  }
  
  void b()
  {
    this.a.getEntityManagerFactory().createEntityManager().delete(FullListGroupAppEntity.class.getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.FullListGroupAppsDbHelper
 * JD-Core Version:    0.7.0.1
 */