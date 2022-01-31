package com.tencent.mobileqq.emosm.favroaming;

import abrz;
import absa;
import absb;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class EmoticonFromGroupDBManager
  implements Manager
{
  public volatile int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new abrz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public EntityManager a;
  public List a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(600);
  public volatile boolean a;
  public volatile int b;
  private List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  public boolean b;
  private boolean c;
  
  public EmoticonFromGroupDBManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 400;
  }
  
  private List d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_DBManager", 2, "sortAndSyncData start.");
    }
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values());
    Collections.sort(localArrayList1);
    if (this.jdField_b_of_type_Boolean)
    {
      ArrayList localArrayList2 = new ArrayList(100);
      int j = localArrayList1.size();
      if (j > 300)
      {
        int i = 300;
        while (i < j)
        {
          String str = ((EmoticonFromGroupEntity)localArrayList1.get(i)).md5;
          EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
          if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
          }
          if (localEmoticonFromGroupEntity != null) {
            localArrayList2.add(localEmoticonFromGroupEntity);
          }
          i += 1;
        }
        a(localArrayList2, 2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_DBManager", 2, "sortAndSyncData end.");
    }
    return localArrayList1;
  }
  
  private void d(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if ((paramEmoticonFromGroupEntity == null) || (paramEmoticonFromGroupEntity.md5 == null) || (paramEmoticonFromGroupEntity.md5.equals("")) || (paramEmoticonFromGroupEntity.thumbURL == null) || (paramEmoticonFromGroupEntity.thumbURL.equals("")) || (paramEmoticonFromGroupEntity.bigURL == null) || (paramEmoticonFromGroupEntity.bigURL.equals(""))) {}
    do
    {
      return;
      c(paramEmoticonFromGroupEntity);
      switch (this.jdField_a_of_type_Int)
      {
      case 1: 
      default: 
        return;
      case 0: 
        b();
        return;
      }
    } while ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() < 10));
    paramEmoticonFromGroupEntity = new ArrayList(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.values());
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a(paramEmoticonFromGroupEntity, 1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonFromGroupEntity.class);
  }
  
  public void a()
  {
    if (!this.c)
    {
      this.c = true;
      new Handler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback).sendEmptyMessageDelayed(1, 10000L);
    }
  }
  
  public void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramEmoticonFromGroupEntity.md5)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramEmoticonFromGroupEntity.md5);
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramEmoticonFromGroupEntity.md5)) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramEmoticonFromGroupEntity.md5);
      }
    }
  }
  
  public void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    paramEmoticonFromGroupEntity = new absa(this, paramInt, paramEmoticonFromGroupEntity);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramEmoticonFromGroupEntity.run();
      return;
    }
    ThreadManager.post(paramEmoticonFromGroupEntity, 5, null, true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if ((paramMessageRecord instanceof MessageForPic)) {
      d(((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a(paramMessageRecord));
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        if (a())
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_DBManager", 2, "clean data start.");
          }
          d();
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_DBManager", 2, "clean data end.");
          }
        }
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StressTesting.Emoticon.EmoticonFromGroup", 2, "EmoticonFromGroup deal with per msg=" + (Calendar.getInstance().getTimeInMillis() - l));
      }
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        Iterator localIterator = paramMessageRecord.msgElemList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          if ((localObject instanceof MessageForPic))
          {
            localObject = (MessageForPic)localObject;
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject, paramMessageRecord);
            d(((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a((MessageRecord)localObject));
          }
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localEmoticonFromGroupEntity.md5)) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonFromGroupEntity.md5);
        }
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localEmoticonFromGroupEntity.md5)) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEmoticonFromGroupEntity.md5);
        }
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = new absb(this, paramInt, paramList);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramList.run();
      return;
    }
    ThreadManager.post(paramList, 5, null, true);
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size();
  }
  
  public List b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db start.");
      }
      Object localObject = a();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db mid.");
      }
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          b((EmoticonFromGroupEntity)((Iterator)localObject).next());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db end.");
      }
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {}
    label149:
    for (;;)
    {
      return;
      if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramEmoticonFromGroupEntity.md5)))
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramEmoticonFromGroupEntity.md5);
        if (localEmoticonFromGroupEntity != null)
        {
          if (paramEmoticonFromGroupEntity.timestamp < localEmoticonFromGroupEntity.timestamp) {
            paramEmoticonFromGroupEntity.replaceEntity(localEmoticonFromGroupEntity);
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
        }
      }
      for (;;)
      {
        if (((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() < 600) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() < 300)) || (!QLog.isColorLevel())) {
          break label149;
        }
        QLog.e("EmoticonFromGroup_DBManager", 1, "replaceDBToCache over max limit.");
        return;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramEmoticonFromGroupEntity.md5);
        break;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((MessageForPic)paramMessageRecord).md5)) {
        a((EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((MessageForPic)paramMessageRecord).md5), 2);
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (!(paramMessageRecord instanceof MessageForMixedMsg));
      paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
      localArrayList = new ArrayList(20);
      Iterator localIterator = paramMessageRecord.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MessageRecord)localIterator.next();
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject, paramMessageRecord);
          localObject = ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a((MessageRecord)localObject);
          localObject = (EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((EmoticonFromGroupEntity)localObject).md5);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    } while (localArrayList.isEmpty());
    a(localArrayList, 2);
  }
  
  public List c()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = d();
    if (localList != null)
    {
      if (localList.size() <= 300) {
        break label57;
      }
      localList = localList.subList(0, 300);
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    for (;;)
    {
      return this.jdField_b_of_type_JavaUtilList;
      label57:
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
  }
  
  public void c(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {}
    for (;;)
    {
      return;
      if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramEmoticonFromGroupEntity.md5)))
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramEmoticonFromGroupEntity.md5);
        if (localEmoticonFromGroupEntity != null) {
          if (paramEmoticonFromGroupEntity.timestamp > localEmoticonFromGroupEntity.timestamp)
          {
            localEmoticonFromGroupEntity.replaceEntity(paramEmoticonFromGroupEntity);
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEmoticonFromGroupEntity.md5, localEmoticonFromGroupEntity);
          }
        }
      }
      while (((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 600) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 300)) && (QLog.isColorLevel()))
      {
        QLog.e("EmoticonFromGroup_DBManager", 1, "add2cache over max limit.");
        return;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramEmoticonFromGroupEntity.md5);
        continue;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
      }
    }
  }
  
  public void onDestroy()
  {
    if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      a(localArrayList, 1);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager
 * JD-Core Version:    0.7.0.1
 */