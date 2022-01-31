package com.tencent.mobileqq.trooponline.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopOnlineMemberManager
  implements Manager
{
  protected long a;
  protected QQAppInterface a;
  private Map a;
  
  public TroopOnlineMemberManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.b;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public String a(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (paramString = paramString.jdField_a_of_type_JavaLangString;; paramString = null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
    }
  }
  
  public List a(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopDetailOnlineData localTroopDetailOnlineData2 = (TroopDetailOnlineData)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    TroopDetailOnlineData localTroopDetailOnlineData1 = localTroopDetailOnlineData2;
    if (localTroopDetailOnlineData2 == null)
    {
      localTroopDetailOnlineData1 = new TroopDetailOnlineData();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, localTroopDetailOnlineData1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localTroopDetailOnlineData1.jdField_a_of_type_JavaLangString = paramString2;
    }
    localTroopDetailOnlineData1.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public void a(String paramString, List paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData = new TroopAllOnlineData();
    localTroopAllOnlineData.troopUin = paramString;
    localTroopAllOnlineData.memberUinList = paramList;
    localTroopAllOnlineData.nextReqTime = i;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString.b(localTroopAllOnlineData);
    paramString.a();
  }
  
  public void a(String paramString1, List paramList, int paramInt, String paramString2)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopDetailOnlineData localTroopDetailOnlineData2 = (TroopDetailOnlineData)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    TroopDetailOnlineData localTroopDetailOnlineData1 = localTroopDetailOnlineData2;
    if (localTroopDetailOnlineData2 == null)
    {
      localTroopDetailOnlineData1 = new TroopDetailOnlineData();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, localTroopDetailOnlineData1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localTroopDetailOnlineData1.jdField_a_of_type_JavaLangString = paramString2;
      localTroopDetailOnlineData1.jdField_a_of_type_JavaUtilList = paramList;
    }
    localTroopDetailOnlineData1.b = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public long b(String paramString)
  {
    paramString = (TroopDetailOnlineData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.jdField_a_of_type_Long;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public List b(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.a(TroopAllOnlineData.class, paramString);
    localEntityManager.a();
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public long c(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.a(TroopAllOnlineData.class, paramString);
    localEntityManager.a();
    if (paramString != null) {}
    for (long l1 = paramString.nextReqTime;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager
 * JD-Core Version:    0.7.0.1
 */