package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class SerializableManager
{
  public static boolean a(QQAppInterface paramQQAppInterface, Map<UUID, ? extends Entity> paramMap, long paramLong)
  {
    if (paramMap == null)
    {
      QLog.e("SerializableManager", 4, "bad Entity Param");
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
    if (!paramQQAppInterface.drop(((TroopFileTansferItemEntity)localObject).getTableName())) {
      return false;
    }
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Entity)paramMap.next();
      ((TroopFileTansferItemEntity)localObject).troopuin = paramLong;
      ((Entity)localObject).setStatus(1000);
      paramQQAppInterface.persist((Entity)localObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SerializableManager
 * JD-Core Version:    0.7.0.1
 */