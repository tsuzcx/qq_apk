package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class TroopAioNavigateBarManager
  extends Observable
  implements Manager
{
  protected AppInterface a;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected final ConcurrentHashMap<String, List<TroopMessageNavigateInfo>> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  
  public TroopAioNavigateBarManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public TroopAioNavigateBarManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    b();
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mapTroopNavigateInfo: size = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    localStringBuilder.append(" {");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    int i = 0;
    int j;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (Map.Entry)localIterator.next();
      List localList = (List)((Map.Entry)localObject).getValue();
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append(": size = ");
      if (localList == null) {
        j = 0;
      } else {
        j = localList.size();
      }
      localStringBuilder.append(j);
      localStringBuilder.append("->{ ");
      if (localList != null)
      {
        localObject = localList.iterator();
        j = 0;
        int k;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localStringBuilder.append(((TroopMessageNavigateInfo)((Iterator)localObject).next()).toString());
          localStringBuilder.append(" ");
          k = j + 1;
          j = k;
        } while (k < 10);
      }
      localStringBuilder.append(" } ");
      j = i + 1;
      i = j;
    } while (j < 20);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  protected static String a(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramInt == 3000)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(3000);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void a(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)))
      {
        Collections.sort((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString), new TroopAioNavigateBarManager.NavigationMsgComparator(null));
        return;
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    ThreadManager.excute(new TroopAioNavigateBarManager.1(this), 32, null, false);
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        a();
        i = 0;
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (!localIterator1.hasNext()) {
          continue;
        }
        localEntry = (Map.Entry)localIterator1.next();
        localList = (List)localEntry.getValue();
        localIterator2 = localList.iterator();
        j = i;
      }
      finally
      {
        int i;
        Map.Entry localEntry;
        List localList;
        Iterator localIterator2;
        TroopMessageNavigateInfo localTroopMessageNavigateInfo;
        continue;
        throw localObject;
        continue;
        int j = 1;
        continue;
      }
      if (localIterator2.hasNext())
      {
        localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator2.next();
        if (localTroopMessageNavigateInfo != null)
        {
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD)
          {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProxyManagerInner().doAddMsgQueue(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
            continue;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_MODIFY)
          {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProxyManagerInner().doAddMsgQueue(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
            continue;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
          {
            localIterator2.remove();
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProxyManagerInner().doAddMsgQueue(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
          }
        }
      }
      else
      {
        i = j;
        if (localList.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localEntry.getKey());
          i = j;
        }
      }
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProxyManagerInner().saveNotify();
    }
  }
  
  public int a(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (paramString != null)
      {
        int i = paramString.type;
        return i;
      }
      return -1;
    }
    finally {}
  }
  
  public int a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = a(paramInt);
      if (!bool) {
        return -1;
      }
      paramInt = a(a(paramString, paramInt));
      return paramInt;
    }
    finally {}
  }
  
  public long a(int paramInt, String paramString)
  {
    try
    {
      boolean bool = a(paramInt);
      if (!bool) {
        return -1L;
      }
      long l = a(a(paramString, paramInt));
      return l;
    }
    finally {}
  }
  
  public long a(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (paramString != null)
      {
        long l = paramString.msgseq;
        return l;
      }
      return 0L;
    }
    finally {}
  }
  
  public long a(String paramString, long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramString = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        boolean bool = ListUtils.a(paramString);
        if (bool) {
          return 0L;
        }
        int i = paramString.size() - 1;
        while (i >= 0)
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i);
          if (localTroopMessageNavigateInfo.msgseq == paramLong)
          {
            paramLong = localTroopMessageNavigateInfo.shmsgseq;
            return paramLong;
          }
          i -= 1;
        }
      }
      return 0L;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  @Nullable
  TroopMessageNavigateInfo a(String paramString)
  {
    a();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      paramString = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (ListUtils.a(paramString)) {
        return null;
      }
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i);
        if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE) {
          i += 1;
        } else {
          return localTroopMessageNavigateInfo;
        }
      }
    }
    return null;
  }
  
  public Object a(String paramString)
  {
    try
    {
      paramString = a(paramString);
      if (paramString != null)
      {
        paramString = paramString.extObj;
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  public List<Long> a(String paramString, int paramInt)
  {
    try
    {
      localObject = new TroopAioNavigateBarManager.2(this);
      i = 0;
      ThreadManager.excute((Runnable)localObject, 32, null, false);
      localObject = new ArrayList();
      localStringBuilder = new StringBuilder("getMultiNavigateSeqList, troopUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", seqList = ");
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label222;
      }
      paramString = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (ListUtils.a(paramString))
      {
        localStringBuilder.append("null");
        if (QLog.isColorLevel()) {
          QLog.d("Navigate.Manager", 2, localStringBuilder.toString());
        }
        return localObject;
      }
      j = paramString.size();
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i;
        StringBuilder localStringBuilder;
        int j;
        TroopMessageNavigateInfo localTroopMessageNavigateInfo;
        for (;;)
        {
          label222:
          throw paramString;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i);
      if ((localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_DELETE) && (localTroopMessageNavigateInfo.type == paramInt))
      {
        ((List)localObject).add(Long.valueOf(localTroopMessageNavigateInfo.msgseq));
        localStringBuilder.append(localTroopMessageNavigateInfo.msgseq);
        localStringBuilder.append(",");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.Manager", 2, localStringBuilder.toString());
      }
      return localObject;
    }
  }
  
  public void a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initTroopMessageNavigateInfo before, ");
        ((StringBuilder)localObject1).append(a());
        QLog.d("Navigate.Manager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager().query(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (TroopMessageNavigateInfo)((Iterator)localObject1).next();
          if ((localObject3 != null) && (!TextUtils.isEmpty(((TroopMessageNavigateInfo)localObject3).troopCode)))
          {
            Object localObject4 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((TroopMessageNavigateInfo)localObject3).troopCode);
            if (localObject4 != null)
            {
              localObject3 = ((List)localObject4).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (TroopMessageNavigateInfo)((Iterator)localObject3).next();
                if ((localObject4 != null) && (((TroopMessageNavigateInfo)localObject4).status == TroopMessageNavigateInfo.STATUS_ADD)) {
                  ((TroopMessageNavigateInfo)localObject4).status = TroopMessageNavigateInfo.STATUS_MODIFY;
                }
              }
            }
            else
            {
              ((TroopMessageNavigateInfo)localObject3).status = TroopMessageNavigateInfo.STATUS_NORMAL;
              localObject4 = new ArrayList();
              ((List)localObject4).add(localObject3);
              a(((TroopMessageNavigateInfo)localObject3).troopCode);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((TroopMessageNavigateInfo)localObject3).troopCode, localObject4);
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initTroopMessageNavigateInfo after, ");
        ((StringBuilder)localObject1).append(a());
        QLog.d("Navigate.Manager", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void a(@Nullable TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2, int paramInt)
  {
    if (TroopAioNavigateUtil.a(paramInt))
    {
      paramTroopMessageNavigateInfo2.status = TroopMessageNavigateInfo.STATUS_ADD;
      return;
    }
    if ((paramTroopMessageNavigateInfo1 != null) && (paramTroopMessageNavigateInfo1.status != TroopMessageNavigateInfo.STATUS_DELETE))
    {
      paramTroopMessageNavigateInfo2.status = TroopMessageNavigateInfo.STATUS_MODIFY;
      return;
    }
    paramTroopMessageNavigateInfo2.status = TroopMessageNavigateInfo.STATUS_ADD;
  }
  
  void a(@Nullable TroopMessageNavigateInfo paramTroopMessageNavigateInfo1, TroopMessageNavigateInfo paramTroopMessageNavigateInfo2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 26) {
      return;
    }
    if ((paramTroopMessageNavigateInfo1 != null) && (paramTroopMessageNavigateInfo1.status != TroopMessageNavigateInfo.STATUS_DELETE))
    {
      paramTroopMessageNavigateInfo1.receivedFlowserCount += paramInt2;
      return;
    }
    paramTroopMessageNavigateInfo2.receivedFlowserCount = paramInt2;
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearTroopMsgNavigateInfo: troopCode = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", type = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("Navigate.Manager", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label206;
      }
      localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      bool = ListUtils.a((Collection)localObject);
      if (bool) {
        return;
      }
      i = ((List)localObject).size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i;
        TroopMessageNavigateInfo localTroopMessageNavigateInfo;
        for (;;)
        {
          label206:
          throw paramString;
        }
        i -= 1;
      }
    }
    if (i >= 0)
    {
      localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)((List)localObject).get(i);
      if ((paramInt == localTroopMessageNavigateInfo.type) || (paramInt == 0)) {
        if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
          ((List)localObject).remove(i);
        } else {
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
        }
      }
    }
    else
    {
      if (((List)localObject).isEmpty()) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      boolean bool = a(paramInt1);
      if (!bool) {
        return;
      }
      a(a(paramString, paramInt1), paramInt2);
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString2, int paramInt3, Object paramObject)
  {
    try
    {
      boolean bool = a(paramInt1);
      if (!bool) {
        return;
      }
      a(a(paramString1, paramInt1), paramInt2, paramLong1, paramLong2, paramString2, paramInt3, paramObject);
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2, Object paramObject)
  {
    if (paramInt1 <= 0) {
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addTroopMsgNavigateInfo, troopCode = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", navType = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", shMsgSeq = ");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(" ,uinseq = ");
        ((StringBuilder)localObject).append(paramLong2);
        ((StringBuilder)localObject).append(" ,summary = ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", flowersCount = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("Navigate.Manager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new TroopMessageNavigateInfo();
      ((TroopMessageNavigateInfo)localObject).type = paramInt1;
      ((TroopMessageNavigateInfo)localObject).troopCode = paramString1;
      ((TroopMessageNavigateInfo)localObject).shmsgseq = paramLong1;
      ((TroopMessageNavigateInfo)localObject).msgseq = paramLong2;
      ((TroopMessageNavigateInfo)localObject).summary = paramString2;
      ((TroopMessageNavigateInfo)localObject).extObj = paramObject;
      localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (ListUtils.a(localList)) {
        break label461;
      }
      if (TroopAioNavigateUtil.a(paramInt1))
      {
        ((TroopMessageNavigateInfo)localObject).status = TroopMessageNavigateInfo.STATUS_ADD;
        localList.add(localObject);
        a(paramString1);
        break label512;
      }
      paramObject = null;
      i = localList.size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        List localList;
        int i;
        int j;
        for (;;)
        {
          throw paramString1;
        }
        i -= 1;
        continue;
      }
    }
    paramString2 = paramObject;
    if (i >= 0)
    {
      if (paramInt1 != ((TroopMessageNavigateInfo)localList.get(i)).type) {
        break label526;
      }
      paramString2 = (TroopMessageNavigateInfo)localList.get(i);
    }
    j = NavConstants.a(paramInt1);
    if ((paramInt1 != 1) && (paramString2 != null) && (paramString2.status != TroopMessageNavigateInfo.STATUS_DELETE)) {
      if (!MessageNavInfo.a(NavConstants.a(paramString2.type), paramString2.shmsgseq, j, paramLong1))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("addTroopMsgNavigateInfo, but do not need update, shMsgSeq = ");
          paramString1.append(paramLong1);
          QLog.d("Navigate.Manager", 2, paramString1.toString());
        }
        ((TroopMessageNavigateInfo)localObject).receivedFlowserCount = paramInt2;
        a((TroopMessageNavigateInfo)localObject, paramString2, paramInt1, paramString2.receivedFlowserCount);
        break label512;
        if (i >= 0) {
          localList.remove(i);
        }
        a(paramString2, (TroopMessageNavigateInfo)localObject, paramInt1);
        a(paramString2, (TroopMessageNavigateInfo)localObject, paramInt1, paramInt2);
        localList.add(localObject);
        a(paramString1);
        break label512;
        label461:
        ((TroopMessageNavigateInfo)localObject).status = TroopMessageNavigateInfo.STATUS_ADD;
        if (paramInt1 == 26) {
          ((TroopMessageNavigateInfo)localObject).receivedFlowserCount = paramInt2;
        }
        paramString2 = new ArrayList();
        paramString2.add(localObject);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
        label512:
        return;
      }
    }
  }
  
  boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 3000) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public long b(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      long l = -1L;
      if (bool)
      {
        paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (paramString != null) {
          l = paramString.longValue();
        }
        return l;
      }
      return -1L;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager
 * JD-Core Version:    0.7.0.1
 */