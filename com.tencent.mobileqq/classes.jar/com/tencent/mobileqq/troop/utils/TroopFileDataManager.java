package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class TroopFileDataManager
{
  public static Map a;
  public long a;
  public Map b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public TroopFileDataManager(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static TroopFileDataManager a(long paramLong)
  {
    try
    {
      TroopFileDataManager localTroopFileDataManager2 = (TroopFileDataManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      TroopFileDataManager localTroopFileDataManager1 = localTroopFileDataManager2;
      if (localTroopFileDataManager2 == null)
      {
        localTroopFileDataManager1 = new TroopFileDataManager(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopFileDataManager1);
      }
      return localTroopFileDataManager1;
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
      paramQQAppInterface.a(paramTroopFileData);
      paramQQAppInterface.a();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileDataManager
 * JD-Core Version:    0.7.0.1
 */