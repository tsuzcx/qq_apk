package com.tencent.mobileqq.friend.cache;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.callback.GetGroupListCallback;
import com.tencent.mobileqq.friend.utils.FriendSorter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class GroupCache
  implements ICache<Integer, Groups>
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList<Groups> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private ConcurrentHashMap<Integer, Groups> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public GroupCache(EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public Groups a(Integer paramInteger)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramInteger);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        if (((Groups)localIterator.next()).group_id == paramInteger.intValue()) {
          localIterator.remove();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.GroupCache", 2, "removeFromCache| groupId: " + paramInteger + ", group: " + localGroups);
      }
      return localGroups;
    }
  }
  
  public List<Groups> a()
  {
    c();
    return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
  }
  
  public List<Groups> a(GetGroupListCallback paramGetGroupListCallback)
  {
    if (this.jdField_a_of_type_Boolean) {
      return new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
    }
    ThreadManager.getSubThreadHandler().post(new GroupCache.1(this, paramGetGroupListCallback));
    return null;
  }
  
  public void a()
  {
    long l1;
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      l1 = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null);
      if ((localList == null) || (localList.isEmpty())) {
        break label226;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          Groups localGroups = (Groups)localIterator.next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localGroups.group_id), localGroups);
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
    finally {}
    this.jdField_a_of_type_JavaUtilLinkedList.addAll(localCollection);
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("IMCore.friend.GroupCache", 2, "init| group size: " + this.jdField_a_of_type_JavaUtilLinkedList.size() + ", cost: " + (l2 - l1));
      break;
      label226:
      QLog.d("IMCore.friend.GroupCache", 1, "init| groupList is empty!");
    }
  }
  
  public void a(Groups paramGroups)
  {
    if (paramGroups == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramGroups.group_id), paramGroups);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (localIterator.hasNext())
        {
          Groups localGroups = (Groups)localIterator.next();
          if (localGroups.group_id != paramGroups.group_id) {
            continue;
          }
          localGroups.group_name = paramGroups.group_name;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilLinkedList = FriendSorter.a(this.jdField_a_of_type_JavaUtilLinkedList, paramGroups);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("IMCore.friend.GroupCache", 2, "saveToCache| groupId: " + paramGroups.group_id);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void a(List<Groups> arg1)
  {
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new ArrayList();
      QLog.d("IMCore.friend.GroupCache", 1, "saveToCache| groupList == null");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        Groups localGroups = (Groups)localIterator.next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localGroups.group_id), localGroups);
        this.jdField_a_of_type_JavaUtilLinkedList.add(localGroups);
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilLinkedList, FriendSorter.a);
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.GroupCache", 2, "saveToCache| groupList size: " + localObject2.size());
    }
  }
  
  public boolean a(Groups paramGroups)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramGroups == null) {
      return bool2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {
      if (paramGroups.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramGroups);
        if (paramGroups.getStatus() != 1001) {}
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("IMCore.friend.GroupCache", 2, "saveToDB| saveGroup: " + paramGroups);
      return bool1;
      bool1 = false;
      continue;
      if (paramGroups.getStatus() != 1001)
      {
        bool1 = bool3;
        if (paramGroups.getStatus() != 1002) {}
      }
      else
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramGroups);
        continue;
        QLog.d("IMCore.friend.GroupCache", 1, "saveToDB| em closed groupId = " + paramGroups.group_id);
        bool1 = bool3;
      }
    }
  }
  
  public boolean a(List<Groups> paramList)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.d("IMCore.friend.GroupCache", 1, "saveToDB| groupList is empty!");
      bool2 = false;
      return bool2;
    }
    ArrayList localArrayList = new ArrayList();
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          localGroups = (Groups)localIterator.next();
          bool1 &= a(localGroups);
          localArrayList.add(Integer.valueOf(localGroups.group_id));
          continue;
        }
      }
      catch (Exception localException)
      {
        Groups localGroups;
        QLog.e("IMCore.friend.GroupCache", 1, "saveToDB", localException);
        localEntityTransaction.end();
        bool1 = false;
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IMCore.friend.GroupCache", 2, "saveToDB: " + paramList.size() + ", isSuccess: " + bool1);
        return bool1;
        Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values()).iterator();
        if (localIterator.hasNext())
        {
          localGroups = (Groups)localIterator.next();
          if (localException.contains(Integer.valueOf(localGroups.group_id))) {
            continue;
          }
          c(Integer.valueOf(localGroups.group_id));
          continue;
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
    }
  }
  
  public Groups b(Integer paramInteger)
  {
    c();
    return (Groups)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramInteger);
  }
  
  public void b() {}
  
  public Groups c(Integer paramInteger)
  {
    Groups localGroups = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Groups.class, String.valueOf(paramInteger));
    if (localGroups != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localGroups);
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.GroupCache", 2, "removeFromDB| groupId: " + paramInteger + ", group: " + localGroups);
    }
    return localGroups;
  }
  
  public Groups d(Integer paramInteger)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.GroupCache", 2, "queryFromDB: " + paramInteger);
    }
    paramInteger = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(Groups.class, String.valueOf(paramInteger));
    a(paramInteger);
    return paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.GroupCache
 * JD-Core Version:    0.7.0.1
 */