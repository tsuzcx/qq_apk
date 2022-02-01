package com.tencent.mobileqq.friend.cache;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ExtensionInfoCache
  implements ICache<String, ExtensionInfo>
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, ExtensionInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public ExtensionInfoCache(AppRuntime paramAppRuntime, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public ExtensionInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ExtensionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List<ExtensionInfo> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = null;
    long l1;
    Object localObject5;
    Object localObject3;
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("IMCore.friend.ExtensionInfoCache", 1, "init extension info| had init!");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      l1 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.ExtensionInfoCache", 2, "initExtensionCache begin");
      }
      localObject5 = FriendDataServiceImpl.getService(this.jdField_a_of_type_MqqAppAppRuntime).getAllFriends();
      if (localObject5 == null) {
        break label402;
      }
      if (((List)localObject5).size() >= 100) {
        break label251;
      }
      localStringBuilder = new StringBuilder(((List)localObject5).size() * 20);
      localObject3 = new ArrayList(((List)localObject5).size());
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject5).next();
        if (localFriends.isFriend())
        {
          localStringBuilder.append("uin=? or ");
          ((List)localObject3).add(localFriends.uin);
        }
      }
      if (localObject1.length() <= 4) {
        break label457;
      }
    }
    finally {}
    ??? = localObject1.delete(localObject1.length() - 4, localObject1.length());
    label402:
    label457:
    for (;;)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ExtensionInfo.class, true, ((StringBuilder)???).toString(), (String[])((List)localObject3).toArray(new String[((List)localObject3).size()]), null, null, null, null);
      label251:
      localObject3 = ???;
      if (??? == null) {}
      try
      {
        localObject3 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ExtensionInfo.class);
        if (localObject3 != null) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (ExtensionInfo)((Iterator)localObject3).next();
              if (!TextUtils.isEmpty(((ExtensionInfo)localObject5).uin)) {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ExtensionInfo)localObject5).uin, localObject5);
              }
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          ArrayList localArrayList = new ArrayList(0);
          QLog.e("IMCore.friend.ExtensionInfoCache", 1, "initExtensionInfoCache error OOM", localOutOfMemoryError);
          continue;
          QLog.e("IMCore.friend.ExtensionInfoCache", 1, "initExtensionCache| uin is null");
        }
      }
      long l2 = SystemClock.elapsedRealtime();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("IMCore.friend.ExtensionInfoCache", 2, "initExtensionCache, size: " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ", cost: " + (l2 - l1));
      break;
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramExtensionInfo.uin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramExtensionInfo.uin, paramExtensionInfo);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ExtensionInfo paramExtensionInfo)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramExtensionInfo == null) {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.ExtensionInfoCache", 2, "saveToDB begin| friendUin: " + paramExtensionInfo.uin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {
      if (paramExtensionInfo.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramExtensionInfo);
        if (paramExtensionInfo.getStatus() != 1001) {}
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      long l2 = System.currentTimeMillis();
      QLog.d("IMCore.friend.ExtensionInfoCache", 2, "saveToDB begin| friendUin: " + paramExtensionInfo.uin + ", isSuccess: " + bool1 + ", cost: " + (l2 - l1));
      return bool1;
      bool1 = false;
      continue;
      if (paramExtensionInfo.getStatus() != 1001)
      {
        bool1 = bool3;
        if (paramExtensionInfo.getStatus() != 1002) {}
      }
      else
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramExtensionInfo);
        continue;
        QLog.d("IMCore.friend.ExtensionInfoCache", 1, "saveToDB| em closed uin = " + paramExtensionInfo.uin);
        bool1 = bool3;
      }
    }
  }
  
  public boolean a(List<ExtensionInfo> paramList)
  {
    bool1 = true;
    boolean bool2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("IMCore.friend.ExtensionInfoCache", 1, "saveToDB| friendList is empty!");
      bool2 = false;
    }
    long l1;
    do
    {
      return bool2;
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.ExtensionInfoCache", 2, "saveToDB extensionInfoList begin| extensionInfoList begin");
      }
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localEntityTransaction.begin();
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          bool1 &= a((ExtensionInfo)localIterator.next());
        }
        localEntityTransaction.commit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          QLog.e("IMCore.friend.ExtensionInfoCache", 1, "saveToDB", localException);
          localEntityTransaction.end();
          bool1 = false;
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    l2 = System.currentTimeMillis();
    QLog.d("IMCore.friend.ExtensionInfoCache", 2, "saveToDB extensionInfoList begin| " + paramList.size() + ", isSuccess: " + bool1 + " , cost: " + (l2 - l1));
    return bool1;
  }
  
  public ExtensionInfo b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    long l1;
    ExtensionInfo localExtensionInfo;
    do
    {
      return localObject;
      l1 = System.currentTimeMillis();
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ExtensionInfo.class, paramString);
      a(localExtensionInfo);
      localObject = localExtensionInfo;
    } while (!QLog.isColorLevel());
    long l2 = System.currentTimeMillis();
    QLog.d("IMCore.friend.ExtensionInfoCache", 2, "queryFromDB end | friendUin: " + paramString + ", cost: " + (l2 - l1));
    return localExtensionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.ExtensionInfoCache
 * JD-Core Version:    0.7.0.1
 */