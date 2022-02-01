package com.tencent.mobileqq.friend.cache;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.utils.FriendSorter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FriendCache
  implements ICache<String, Friends>
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap<String, Friends> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public FriendCache(EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public int a(boolean paramBoolean)
  {
    c();
    int k = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    int j;
    if (!paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      int i = 0;
      j = i;
      if (!localIterator.hasNext()) {
        break label71;
      }
      if (((Friends)localIterator.next()).gathtertype != 1) {
        break label126;
      }
      i += 1;
    }
    label71:
    label126:
    for (;;)
    {
      break;
      j = 0;
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendCache", 2, "getFriendCount| includeGather: " + paramBoolean + " friendCount: " + k + ", gatherCount: " + j);
      }
      return k - j;
    }
  }
  
  public Friends a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (Friends)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public List<Friends> a()
  {
    return new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
  }
  
  public List<Friends> a(Integer paramInteger)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      if (localFriends.groupid == paramInteger.intValue()) {
        localArrayList.add(localFriends);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendCache", 2, "getGroupFriendList| groupId: " + paramInteger + ", size: " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List<Friends> a(List<String> paramList)
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendCache", 2, "preload begin");
    }
    int i;
    if (paramList != null) {
      i = paramList.size();
    }
    while (i > 0)
    {
      localObject1 = new StringBuilder("uin=? ");
      int j = 1;
      for (;;)
      {
        if (j < paramList.size())
        {
          ((StringBuilder)localObject1).append("or uin=? ");
          j += 1;
          continue;
          i = 0;
          break;
        }
      }
      Object localObject2 = (String[])paramList.toArray(new String[i]);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Friends.class, true, ((StringBuilder)localObject1).toString(), (String[])localObject2, null, null, null, null);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          a((Friends)localIterator.next());
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendCache", 2, "preload: " + paramList + ", cost: " + (l2 - l1));
    }
    return localObject1;
  }
  
  public void a()
  {
    for (;;)
    {
      long l1;
      int i;
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache| had init!");
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        l1 = SystemClock.elapsedRealtime();
        QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache begin");
        Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
        if (localObject != null)
        {
          i = ((List)localObject).size();
          ArrayList localArrayList = new ArrayList();
          if (i <= 0) {
            break label179;
          }
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label179;
          }
          Friends localFriends = (Friends)((Iterator)localObject).next();
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
          {
            FriendSorter.a(localFriends);
            localArrayList.add(localFriends);
          }
          a(localFriends);
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label179:
      this.jdField_a_of_type_Boolean = true;
      long l2 = SystemClock.elapsedRealtime();
      QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache finish| friendCount: " + i + ", cost: " + (l2 - l1));
      if (localList.size() > 0) {
        this.jdField_a_of_type_AndroidOsHandler.post(new FriendCache.1(this, localList));
      }
    }
  }
  
  public void a(Friends paramFriends)
  {
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.uin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Friends paramFriends)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramFriends == null) {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramFriends);
        if (paramFriends.getStatus() != 1001) {}
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      long l2 = System.currentTimeMillis();
      QLog.d("IMCore.friend.FriendCache", 2, "saveToDB| friend: " + paramFriends.uin + ", isSuccess: " + bool1 + ", cost: " + (l2 - l1));
      return bool1;
      bool1 = false;
      continue;
      if (paramFriends.getStatus() != 1001)
      {
        bool1 = bool3;
        if (paramFriends.getStatus() != 1002) {}
      }
      else
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramFriends);
        continue;
        QLog.d("IMCore.friend.FriendCache", 1, "saveToDB| em closed uin = " + paramFriends.uin);
        bool1 = bool3;
      }
    }
  }
  
  public boolean a(List<Friends> paramList)
  {
    bool1 = true;
    boolean bool2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("IMCore.friend.FriendCache", 1, "saveToDB| friendList is empty!");
      bool2 = false;
    }
    long l1;
    do
    {
      return bool2;
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendCache", 2, "saveToDB friendList | begin");
      }
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
      localEntityTransaction.begin();
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          bool1 &= a((Friends)localIterator.next());
        }
        localEntityTransaction.commit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          QLog.e("IMCore.friend.FriendCache", 1, "saveToDB", localException);
          localEntityTransaction.end();
          bool1 = false;
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      l2 = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("IMCore.friend.FriendCache", 2, "saveToDB friendList| end, size: " + paramList.size() + ", cost: " + (l2 - l1) + ", isSuccess: " + bool1);
    return bool1;
  }
  
  public Friends b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (Friends)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    QLog.d("IMCore.friend.FriendCache", 1, "destroy");
  }
  
  public Friends c(String paramString)
  {
    Friends localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Friends.class, paramString);
    if (localFriends != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localFriends);
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendCache", 2, "removeFromDB| friendUin: " + paramString);
    }
    return localFriends;
  }
  
  public Friends d(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Friends localFriends;
    do
    {
      return localObject;
      localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Friends.class, paramString);
      a(localFriends);
      localObject = localFriends;
    } while (!QLog.isColorLevel());
    QLog.d("IMCore.friend.FriendCache", 2, "queryFromDB end | friendUin: " + paramString + ", friend: " + localFriends);
    return localFriends;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.FriendCache
 * JD-Core Version:    0.7.0.1
 */