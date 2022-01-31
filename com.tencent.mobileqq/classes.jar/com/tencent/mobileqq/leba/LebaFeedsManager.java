package com.tencent.mobileqq.leba;

import aeha;
import aehb;
import aehc;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.ark.LebaArkReporter;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import org.json.JSONObject;

public class LebaFeedsManager
  implements Manager
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  aehc jdField_a_of_type_Aehc = new aehc(this, null);
  ArrayMap jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  LebaFeedsHandler jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public Object a;
  public String a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  public int b = 1800;
  public int c = 250;
  
  public LebaFeedsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Int = 15;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler = ((LebaFeedsHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(129));
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        int j = (paramInt1 - paramInt2) / 86400;
        if ((j < 0) || (j > this.jdField_a_of_type_Int - 1)) {
          break label196;
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        i = 0;
        if (i > j) {
          break label196;
        }
        Object localObject1 = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(Integer.valueOf(paramInt1 - i * 86400));
        if (localObject1 == null) {
          break label251;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label251;
        }
        localObject1 = (LebaFeedInfo)localIterator.next();
        if ((localObject1 != null) && (((LebaFeedInfo)localObject1).showFlag == 1)) {
          break label181;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("feed not show, feedid=");
        if (localObject1 != null)
        {
          localObject1 = ((LebaFeedInfo)localObject1).toString();
          QLog.d("new_leba", 1, (String)localObject1);
        }
      }
      String str = "";
      continue;
      label181:
      this.jdField_a_of_type_JavaUtilList.add(str);
      continue;
      label196:
      QLog.d("new_leba", 1, "fillUiData, startTime=" + paramInt1 + ",finalTime=" + paramInt2 + ",uiSize=" + this.jdField_a_of_type_JavaUtilList.size());
      return;
      label251:
      i += 1;
    }
  }
  
  private void a(int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.d("new_leba", 1, "setFeedsPullCompleteTime, return null");
      return;
    }
    long l1 = ((Long)LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_ulfinishdaybitmap", Long.valueOf(0L))).longValue();
    int i = 0;
    if (i < paramList.size())
    {
      int j = (paramInt - ((Integer)paramList.get(i)).intValue()) / 86400;
      long l2 = l1;
      if (j > 0) {
        if (j < this.jdField_a_of_type_Int) {
          break label108;
        }
      }
      label108:
      for (l2 = l1;; l2 = l1 | 1L << j)
      {
        i += 1;
        l1 = l2;
        break;
      }
    }
    LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_ulfinishdaybitmap", Long.valueOf(l1));
    QLog.d("new_leba", 1, "setFeedsPullCompleteTime, uiFinishdayBitmap=" + l1 + ",updatedTimeList=" + paramList);
  }
  
  private void a(boolean paramBoolean, List paramList1, List paramList2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {}
    do
    {
      return;
      if (paramList1 != null)
      {
        try
        {
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            LebaFeedInfo localLebaFeedInfo = (LebaFeedInfo)paramList1.next();
            if ((localLebaFeedInfo != null) && (!a(localLebaFeedInfo))) {
              QLog.e("new_leba", 1, "handleGetFeedsForDB incUpdate fail，feedId = " + localLebaFeedInfo.feedID);
            }
          }
          if (paramList2 == null) {
            continue;
          }
        }
        catch (Exception paramList1)
        {
          paramList1.printStackTrace();
          return;
        }
      }
      else
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (LebaFeedInfo)paramList1.next();
          if ((paramList2 != null) && (!a(paramList2))) {
            QLog.e("new_leba", 1, "handleGetFeedsForDB delfeedep fail, feedId = " + paramList2.feedID);
          }
        }
      }
    } while (!paramBoolean);
    int i = b();
    i = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(LebaFeedInfo.class.getSimpleName(), "uiLoadDayTimestamp < " + i, null);
    QLog.d("new_leba", 1, "handleGetFeedsForDB delete exceed MaxDayCNT, ret = " + i);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramInt1 - paramInt3) / 86400 >= this.jdField_a_of_type_Int)
    {
      paramBoolean = false;
      QLog.d("new_leba", 1, "hasMoreData, hasMoreData=" + paramBoolean);
      return paramBoolean;
    }
    if ((paramInt2 == paramInt3) && (!paramBoolean)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        List localList = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(Integer.valueOf(paramInt3));
        if (localList == null) {
          break label124;
        }
        if (localList.isEmpty()) {
          break label124;
        }
      }
      paramBoolean = true;
      continue;
      paramBoolean = true;
      break;
      label124:
      paramBoolean = false;
    }
  }
  
  private boolean a(Entity paramEntity)
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
  
  private int b()
  {
    return LebaUtils.a(this.jdField_a_of_type_Int - 1);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      String str = "update  " + LebaFeedInfo.class.getSimpleName() + " set showFlag = ?  where templateId = ? ";
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(str, new Integer[] { Integer.valueOf(-1), Integer.valueOf(3) });
      localEntityTransaction.c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) {}
    for (int i = 1;; i = 0)
    {
      if (paramInt == 1) {
        if (Math.abs(l - this.jdField_a_of_type_Long) >= this.b * 1000) {
          i = j;
        }
      }
      for (;;)
      {
        QLog.d("new_leba", 1, "reqGetFeeds, state=" + i + ",reqTime=" + l + ",lastReqTime=" + this.jdField_a_of_type_Long + ",eventType=" + paramInt + ",isFirst=" + paramBoolean);
        if (i == 0) {
          a(paramInt, l);
        }
        return i;
        i = 2;
      }
    }
  }
  
  public List a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
  }
  
  public void a()
  {
    JSONObject localJSONObject = ((LebaGridManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211)).a();
    if (localJSONObject != null)
    {
      this.jdField_a_of_type_Int = localJSONObject.optInt("maxShowFeedsDays", 15);
      this.b = localJSONObject.optInt("pullFeedsInternal", 1800);
      this.c = localJSONObject.optInt("maxLoadFeedsCnt", 250);
      if (localJSONObject.optInt("isShowArk", 0) == 0) {
        break label220;
      }
    }
    label220:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      LebaArkReporter.jdField_a_of_type_Int = localJSONObject.optInt("arkCrashMaxCount", 5);
      LebaArkReporter.jdField_a_of_type_Long = localJSONObject.optInt("arkCheckDelay", 3000);
      if (QLog.isColorLevel()) {
        QLog.i("new_leba", 2, "initConfig " + LebaArkReporter.jdField_a_of_type_Int + ", " + LebaArkReporter.jdField_a_of_type_Long);
      }
      QLog.d("new_leba", 1, "initConfig, max_feeds_show_days = " + this.jdField_a_of_type_Int + ",max_get_feeds_interval=" + this.b + ",max_cache_load_cnt=" + this.c + ",isShowArk=" + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, List paramList1, String paramString1, List paramList2, String paramString2, int paramInt3)
  {
    QLog.d("new_leba", 1, "handleGetFeeds start, startTime=" + paramInt1 + ",uiNextDayTime=" + paramInt2 + ",eventType=" + paramInt3 + ",uiDelFeeds=" + paramList2);
    if (QLog.isColorLevel()) {
      QLog.d("new_leba", 2, "handleGetFeeds, lebaFeedInfos=" + paramList1);
    }
    int n = LebaUtils.a(0);
    int i;
    if (paramInt1 == 0) {
      i = n;
    }
    int i1;
    boolean bool2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int j;
    Object localObject4;
    int k;
    int m;
    for (;;)
    {
      i1 = LebaUtils.b(paramInt2);
      if ((paramList1 != null) && (!paramList1.isEmpty())) {
        break label916;
      }
      bool2 = false;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localObject2 = this.jdField_a_of_type_JavaLangObject;
      paramInt1 = 2147483647;
      localObject1 = null;
      if (!bool2) {
        break;
      }
      try
      {
        localObject3 = paramList1.iterator();
        j = -1;
        paramInt1 = 2147483647;
        paramList1 = (List)localObject1;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (LebaFeedInfo)((Iterator)localObject3).next();
          if (localObject4 != null)
          {
            localObject1 = paramList1;
            k = paramInt1;
            m = j;
            if (j != ((LebaFeedInfo)localObject4).uiLoadDayTimestamp)
            {
              j = ((LebaFeedInfo)localObject4).uiLoadDayTimestamp;
              localObject1 = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(Integer.valueOf(j));
              paramList1 = (List)localObject1;
              if (localObject1 != null) {
                break label922;
              }
              paramList1 = new ArrayList();
              this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(Integer.valueOf(j), paramList1);
              break label922;
            }
            label296:
            paramList1 = (List)localObject1;
            paramInt1 = k;
            j = m;
            if (localObject1 != null)
            {
              paramList1 = (List)localObject1;
              paramInt1 = k;
              j = m;
              if (!((List)localObject1).contains(localObject4))
              {
                ((List)localObject1).add(localObject4);
                localArrayList2.add(localObject4);
                paramList1 = (List)localObject1;
                paramInt1 = k;
                j = m;
              }
            }
          }
        }
        i = LebaUtils.b(paramInt1);
      }
      finally {}
    }
    if (paramInt1 != i1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool2) {
        bool1 = true;
      }
      for (;;)
      {
        paramInt1 = i1;
        if (bool1) {
          paramInt1 = 86400 + i1;
        }
        k = (i - paramInt1) / 86400;
        if ((k >= 0) && (k <= this.jdField_a_of_type_Int - 1))
        {
          j = 0;
          while (j <= k)
          {
            localArrayList1.add(Integer.valueOf(i - 86400 * j));
            j += 1;
          }
        }
        if ((paramList2 != null) && (!paramList2.isEmpty()))
        {
          localObject1 = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.keySet();
          paramList1 = new LebaFeedInfo();
          localObject1 = ((Set)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Integer)((Iterator)localObject1).next();
            localObject3 = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject3);
            if (localObject3 != null)
            {
              localObject4 = paramList2.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                paramList1.feedID = ((Long)((Iterator)localObject4).next()).longValue();
                j = ((List)localObject3).indexOf(paramList1);
                if (j >= 0)
                {
                  LebaFeedInfo localLebaFeedInfo = (LebaFeedInfo)((List)localObject3).get(j);
                  localLebaFeedInfo.showFlag = -2;
                  localArrayList3.add(localLebaFeedInfo);
                }
              }
            }
          }
        }
        paramList1 = localArrayList1.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (Integer)paramList1.next();
          paramList2 = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramList2);
          if (paramList2 != null) {
            Collections.sort(paramList2, this.jdField_a_of_type_Aehc);
          }
        }
        a(n, paramInt1);
        boolean bool3 = a(n, i, paramInt1, bool2);
        if (!TextUtils.isEmpty(paramString1)) {
          this.jdField_a_of_type_JavaLangString = paramString1;
        }
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler;
        if (bool3)
        {
          paramInt1 = 1;
          paramList1.a(1, true, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt1) });
          QLog.d("new_leba", 1, "handleGetFeeds end, curTime=" + n + ",isComplete=" + bool1 + ",hasDataFromServer=" + bool2 + ",updatedTimeList=" + localArrayList1);
          if (paramInt3 != 1) {
            break label907;
          }
        }
        label907:
        for (bool1 = true;; bool1 = false)
        {
          a(bool1, localArrayList2, localArrayList3);
          a(n, localArrayList1);
          LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_today_title", this.jdField_a_of_type_JavaLangString);
          LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_uinext_daytimestamp", Integer.valueOf(paramInt2));
          LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_strreqcookie", paramString2);
          return;
          paramInt1 = 2;
          break;
        }
      }
      label916:
      bool2 = true;
      break;
      label922:
      localObject1 = paramList1;
      k = paramInt1;
      m = j;
      if (paramInt1 <= j) {
        break label296;
      }
      k = j;
      localObject1 = paramList1;
      m = j;
      break label296;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    List localList = LebaGridShowManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = (String)LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_strreqcookie", "");
    int i;
    long l;
    int k;
    int j;
    label88:
    int m;
    if (paramInt == 1)
    {
      i = 1;
      l = ((Long)LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_ulfinishdaybitmap", Long.valueOf(0L))).longValue();
      k = ((Integer)LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sp_key_uinext_daytimestamp", Integer.valueOf(0))).intValue();
      if (i == 0) {
        break label168;
      }
      j = 0;
      m = LebaUtils.a(0);
      if (i == 0) {
        break label175;
      }
    }
    ArrayList localArrayList;
    for (;;)
    {
      localArrayList = new ArrayList();
      Object localObject = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.values();
      if (localObject == null) {
        break label184;
      }
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.addAll((List)((Iterator)localObject).next());
      }
      i = 0;
      break;
      label168:
      j = k;
      break label88;
      label175:
      LebaUtils.b(k);
    }
    label184:
    if (i != 0) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    QLog.d("new_leba", 1, "realGetFeeds, uiDayTimestamp=" + j + ",ulfinishdaybitmap=" + l + ",curDayTimestampForZero=" + m + ",reqTime=" + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler.a(j, paramInt, localList, localArrayList, str, l, paramLong);
  }
  
  public void a(LebaFeedInfo paramLebaFeedInfo)
  {
    if (paramLebaFeedInfo == null)
    {
      QLog.d("new_leba", 1, "setFeedsPullCompleteTime, feedInfo is null");
      return;
    }
    paramLebaFeedInfo.showFlag = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramLebaFeedInfo);
      a(paramLebaFeedInfo);
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler.a(paramLebaFeedInfo.feedID, paramLebaFeedInfo.strFeedCookie);
      QLog.d("new_leba", 1, "reportDislike, feedInfo=" + paramLebaFeedInfo);
      return;
    }
  }
  
  public void a(LebaFeedInfo paramLebaFeedInfo, int paramInt)
  {
    if (paramLebaFeedInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler.a(paramLebaFeedInfo.feedID, paramLebaFeedInfo.strFeedCookie, paramInt);
    QLog.d("new_leba", 1, "reportLike, feedInfo=" + paramLebaFeedInfo);
  }
  
  public void b()
  {
    QLog.d("new_leba", 1, "loadLocalData start， isLoadLocalFinish = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    long l = System.currentTimeMillis();
    a();
    int k = b();
    Object localObject1 = "uiLoadDayTimestamp >= " + k;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    label471:
    label740:
    Object localObject3;
    for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(LebaFeedInfo.class, false, (String)localObject1, null, null, null, "serverUpdateTime desc", String.valueOf(this.c));; localObject3 = null)
    {
      Object localObject10 = this.jdField_a_of_type_JavaLangObject;
      int i;
      Object localObject4;
      boolean bool1;
      int j;
      if (localObject1 != null)
      {
        HashMap localHashMap;
        ArrayList localArrayList2;
        Object localObject7;
        try
        {
          if (((List)localObject1).isEmpty()) {
            break label740;
          }
          i = ((List)localObject1).size();
          ArrayList localArrayList1 = new ArrayList();
          localHashMap = new HashMap();
          localArrayList2 = new ArrayList();
          Iterator localIterator = ((List)localObject1).iterator();
          localObject4 = null;
          Object localObject5 = null;
          localObject7 = Integer.valueOf(-1);
          bool1 = false;
          while (localIterator.hasNext())
          {
            LebaFeedInfo localLebaFeedInfo = (LebaFeedInfo)localIterator.next();
            if (localLebaFeedInfo != null)
            {
              localLebaFeedInfo.doParseUIInfo();
              j = localLebaFeedInfo.uiLoadDayTimestamp;
              Object localObject9 = localObject7;
              Object localObject8 = localObject4;
              Object localObject6 = localObject5;
              if (!localArrayList1.contains(Integer.valueOf(j)))
              {
                localArrayList1.add(Integer.valueOf(j));
                localObject6 = new ArrayList();
                if (((Integer)localObject7).intValue() != -1) {
                  localHashMap.put(localObject7, localObject4);
                }
                localObject9 = Integer.valueOf(j);
                localObject8 = localObject6;
              }
              ((List)localObject6).add(localLebaFeedInfo);
              boolean bool2 = bool1;
              if (!this.jdField_a_of_type_Boolean)
              {
                bool2 = bool1;
                if (LebaFeedInfo.isArkFeed(localLebaFeedInfo))
                {
                  bool2 = bool1;
                  if (localLebaFeedInfo.showFlag != -1)
                  {
                    bool2 = true;
                    localLebaFeedInfo.showFlag = -1;
                  }
                }
              }
              bool1 = bool2;
              localObject7 = localObject9;
              localObject4 = localObject8;
              localObject5 = localObject6;
              if (localLebaFeedInfo.showFlag == 1)
              {
                localArrayList2.add(localLebaFeedInfo);
                bool1 = bool2;
                localObject7 = localObject9;
                localObject4 = localObject8;
                localObject5 = localObject6;
              }
            }
          }
          if (((Integer)localObject7).intValue() == -1) {
            break label471;
          }
        }
        finally {}
        if (localObject4 != null) {
          localHashMap.put(localObject7, localObject4);
        }
        this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.putAll(localHashMap);
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
        j = this.jdField_a_of_type_JavaUtilList.size();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        l = Math.abs(System.currentTimeMillis() - l);
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsHandler.a(2, true, null);
        if (bool1) {
          ThreadManager.post(new aeha(this), 5, null, true);
        }
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("load_time", String.valueOf(l));
        ((HashMap)localObject4).put("info_size", Integer.toString(i));
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "newleba_loadfeeds", true, l, i, (HashMap)localObject4, "");
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("new_leba", 2, "loadLocalData, localInfos=" + localObject2);
          }
          label650:
          QLog.d("new_leba", 1, "loadLocalData end, isLoadLocalFinish = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxEarlyTime=" + k + ",localInfoSize=" + i + ",uiInfoSize=" + j + ",needUdateArkFlagForDB=" + bool1 + ",costTime=" + l);
          return;
        }
        catch (Exception localException)
        {
          break label650;
        }
        bool1 = false;
        j = 0;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    a();
    if (!this.jdField_a_of_type_Boolean)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        LebaFeedInfo localLebaFeedInfo;
        do
        {
          Iterator localIterator = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.keySet().iterator();
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (Integer)localIterator.next();
              localObject3 = (List)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localObject3);
            } while (localObject3 == null);
            localObject3 = ((List)localObject3).iterator();
          }
          localLebaFeedInfo = (LebaFeedInfo)((Iterator)localObject3).next();
        } while ((!LebaFeedInfo.isArkFeed(localLebaFeedInfo)) || (localLebaFeedInfo.showFlag == -1));
        localLebaFeedInfo.showFlag = -1;
      }
      ThreadManager.post(new aehb(this), 5, null, true);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsManager
 * JD-Core Version:    0.7.0.1
 */