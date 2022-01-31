package com.tencent.mobileqq.managers;

import aefa;
import aefb;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ShieldMsgManger
  implements Manager
{
  private QQConcurrentHashMap jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public ShieldMsgManger(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      throw new IllegalArgumentException("ShieldMsgManger this.app = null");
    }
    ThreadManager.post(new aefa(this), 2, null, false);
  }
  
  private ShieldListInfo a(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap == null) {
          b();
        }
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap != null) && (paramString != null) && (paramString.length() > 0))
        {
          if (paramInt == 2)
          {
            str = a(paramString);
            paramString = (ShieldListInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(str);
            return paramString;
          }
        }
        else {
          return null;
        }
      }
      String str = paramString;
      if (paramInt == 1) {
        str = paramString;
      }
    }
  }
  
  private String a(String paramString)
  {
    String str2 = paramString.trim();
    String str1 = str2;
    if (!str2.startsWith("+"))
    {
      str1 = str2;
      if (str2.length() == 11) {
        str1 = "+86" + paramString;
      }
    }
    return str1;
  }
  
  private void a() {}
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool = false;
    paramString = a(paramInt, paramString);
    if (paramString != null) {
      bool = paramString.isShieldMsg();
    }
    return bool;
  }
  
  private boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      paramEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return paramEntityManager.a(paramEntity);
  }
  
  private void b()
  {
    for (;;)
    {
      EntityManager localEntityManager;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        try
        {
          QQConcurrentHashMap localQQConcurrentHashMap = new QQConcurrentHashMap(1006, 0, 36);
          List localList = localEntityManager.a(ShieldListInfo.class);
          int i;
          if (localList == null)
          {
            i = 0;
            break label169;
            if (j < i)
            {
              ShieldListInfo localShieldListInfo = (ShieldListInfo)localList.get(j);
              if ((localShieldListInfo == null) || (localShieldListInfo.uin == null)) {
                break label174;
              }
              localQQConcurrentHashMap.put(localShieldListInfo.uin, localShieldListInfo);
              break label174;
            }
          }
          else
          {
            i = localList.size();
            break label169;
          }
          this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap = localQQConcurrentHashMap;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label144;
          }
          QLog.d("ShieldMsgManger", 2, localException.toString());
          localEntityManager.a();
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        finally
        {
          localObject2.a();
        }
        return;
      }
      label144:
      label169:
      int j = 0;
      continue;
      label174:
      j += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap == null) {
          b();
        }
        if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap != null) && (paramString != null) && (paramString.length() > 0))
        {
          if (paramInt2 != 2) {
            break label114;
          }
          localObject1 = a(paramString);
          paramString = (ShieldListInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localObject1);
          if (paramString != null)
          {
            paramString.flags = paramInt1;
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramString);
            ThreadManager.post(new aefb(this, (ArrayList)localObject1), 5, null, false);
          }
        }
        return;
      }
      label114:
      Object localObject1 = paramString;
      if (paramInt2 == 1) {
        localObject1 = paramString;
      }
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    a(paramInt, paramList, 0);
  }
  
  public void a(int paramInt1, List paramList, int paramInt2)
  {
    ShieldListHandler localShieldListHandler = (ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(18);
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    localShieldListHandler.a(paramInt1, arrayOfLong, paramInt2);
  }
  
  public boolean a(String paramString)
  {
    a();
    boolean bool = a(1, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShieldMsgManger", 2, "isUinInShieldList:" + paramString + ",result:" + bool);
    }
    return bool;
  }
  
  public boolean a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return true;
    }
    for (;;)
    {
      EntityManager localEntityManager;
      EntityTransaction localEntityTransaction;
      int i;
      ShieldListInfo localShieldListInfo1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap == null) {
          b();
        }
        localEntityTransaction = localEntityManager.a();
        try
        {
          localEntityTransaction.a();
          int j = paramList.size();
          i = 0;
          if (i >= j) {
            break label333;
          }
          localShieldListInfo1 = (ShieldListInfo)paramList.get(i);
          localShieldListInfo2 = (ShieldListInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.get(localShieldListInfo1.uin);
          if ((localShieldListInfo1.flags == 0) && (localShieldListInfo2 == null)) {
            break label349;
          }
          if ((localShieldListInfo2 != null) && ((localShieldListInfo2.getStatus() == 1001) || (localShieldListInfo2.getStatus() == 1002))) {
            if (localShieldListInfo1.flags != localShieldListInfo2.flags)
            {
              localShieldListInfo2.flags = localShieldListInfo1.flags;
              localShieldListInfo2.source_id = localShieldListInfo1.source_id;
              localShieldListInfo2.source_sub_id = localShieldListInfo1.source_sub_id;
              a(localEntityManager, localShieldListInfo2);
            }
          }
        }
        catch (Exception paramList)
        {
          ShieldListInfo localShieldListInfo2;
          paramList.printStackTrace();
          localEntityTransaction.b();
          bool = false;
          localEntityManager.a();
          a();
          return bool;
          if ((localShieldListInfo1.flags != 1) || (localShieldListInfo2.source_id == localShieldListInfo1.source_id)) {
            break label349;
          }
          localShieldListInfo2.flags = localShieldListInfo1.flags;
          localShieldListInfo2.source_id = localShieldListInfo1.source_id;
          localShieldListInfo2.source_sub_id = localShieldListInfo1.source_sub_id;
          a(localEntityManager, localShieldListInfo2);
        }
        finally
        {
          localEntityTransaction.b();
        }
      }
      a(localEntityManager, localShieldListInfo1);
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.put(localShieldListInfo1.uin, localShieldListInfo1);
      break label349;
      label333:
      localEntityTransaction.c();
      localEntityTransaction.b();
      boolean bool = true;
      continue;
      label349:
      i += 1;
    }
  }
  
  public boolean a(ConcurrentHashMap paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldMsgManger", 2, "<---saveShieldListTotal : begin....");
    }
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject2 != null)
      {
        localObject3 = new ShieldListInfo().getTableName();
        ((SQLiteDatabase)localObject2).a("delete from " + (String)localObject3);
      }
      if ((this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap != null) && (this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.size() > 0)) {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQConcurrentHashMap.clear();
      }
      localObject2 = new ArrayList();
      Object localObject3 = paramConcurrentHashMap.keySet().iterator();
      if (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject2).add(paramConcurrentHashMap.get((String)((Iterator)localObject3).next()));
      }
    }
    boolean bool = a((List)localObject2);
    return bool;
  }
  
  public void b(int paramInt, List paramList)
  {
    b(paramInt, paramList, 0);
  }
  
  public void b(int paramInt1, List paramList, int paramInt2)
  {
    ShieldListHandler localShieldListHandler = (ShieldListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(18);
    int j = paramList.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    localShieldListHandler.b(paramInt1, arrayOfLong, paramInt2);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.managers.ShieldMsgManger
 * JD-Core Version:    0.7.0.1
 */