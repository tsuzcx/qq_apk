package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.HashMap;
import java.util.Map;

public class TroopFileDataManager
{
  public static Map<Long, TroopFileDataManager> a = new HashMap();
  public Map<String, TroopFileData> b = new HashMap();
  public long c;
  
  public TroopFileDataManager(long paramLong)
  {
    this.c = paramLong;
  }
  
  public static TroopFileDataManager a(long paramLong)
  {
    try
    {
      TroopFileDataManager localTroopFileDataManager2 = (TroopFileDataManager)a.get(Long.valueOf(paramLong));
      TroopFileDataManager localTroopFileDataManager1 = localTroopFileDataManager2;
      if (localTroopFileDataManager2 == null)
      {
        localTroopFileDataManager1 = new TroopFileDataManager(paramLong);
        a.put(Long.valueOf(paramLong), localTroopFileDataManager1);
      }
      return localTroopFileDataManager1;
    }
    finally {}
  }
  
  public TroopFileData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopFileData localTroopFileData1 = null;
    try
    {
      if (this.b != null) {
        localTroopFileData1 = (TroopFileData)this.b.get(paramString);
      }
      TroopFileData localTroopFileData2 = localTroopFileData1;
      if (localTroopFileData1 == null)
      {
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        localTroopFileData2 = (TroopFileData)paramQQAppInterface.find(TroopFileData.class, paramString);
        paramQQAppInterface.close();
      }
      return localTroopFileData2;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, TroopFileData paramTroopFileData)
  {
    try
    {
      if (this.b != null) {
        this.b.put(paramTroopFileData.fileUrl, paramTroopFileData);
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramQQAppInterface.persist(paramTroopFileData);
      paramQQAppInterface.close();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileDataManager
 * JD-Core Version:    0.7.0.1
 */