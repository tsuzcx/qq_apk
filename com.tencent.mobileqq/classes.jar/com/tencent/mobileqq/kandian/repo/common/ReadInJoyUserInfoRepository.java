package com.tencent.mobileqq.kandian.repo.common;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.glue.baseconfig.RIJUserInfoAladdinConfig;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class ReadInJoyUserInfoRepository
{
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap<String, ReadInJoyUserInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  public ReadInJoyUserInfoRepository(ExecutorService paramExecutorService, ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule = paramReadInJoyUserInfoModule;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  private static Boolean a(ReadInJoyUserInfo paramReadInJoyUserInfo, long paramLong)
  {
    boolean bool;
    if ((System.currentTimeMillis() - paramReadInJoyUserInfo.lastUpdateTimeMilliSecond) / 1000L >= paramLong) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.i("ReadInJoyUserInfoRepository", 1, "[isUserInfoExpired] isExpired = $isExpired, uin = ${userInfo.uin}, nickName = ${userInfo.nick}, updateIntervalSecond = $updateIntervalSecond, expiredTimeSecond = $expiredTimeSecond");
    return Boolean.valueOf(bool);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "saveReadInJoyUserInfoToDB, \n  userInfo = ", paramReadInJoyUserInfo });
    }
    if (paramReadInJoyUserInfo != null) {
      RIJThreadHandler.a("saveReadInJoyUserInfoToDB", new ReadInJoyUserInfoRepository.1(this, paramReadInJoyUserInfo), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    }
  }
  
  public ReadInJoyUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localReadInJoyUserInfo != null) && (!localReadInJoyUserInfo.requestFlag))
    {
      localReadInJoyUserInfo.requestFlag = true;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule;
      if (paramString != null) {
        paramString.a(localArrayList, 1, 1, 0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "getReadInJoyUserInfoByUin, \n ", "userInfo = ", localReadInJoyUserInfo });
    }
    return localReadInJoyUserInfo;
  }
  
  public List<ReadInJoyUserInfo> a(String paramString)
  {
    return a(paramString, true);
  }
  
  public List<ReadInJoyUserInfo> a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ReadInJoyUserInfo.class, true, "uin = ?", new String[] { paramString }, null, null, null, "1");
    if ((localList != null) && (localList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadSingleReadInJoyUserInfoFromDB, userInfo = ", localList.get(0) });
      }
      if ((localList.get(0) != null) && (a((ReadInJoyUserInfo)localList.get(0), RIJUserInfoAladdinConfig.a.a()).booleanValue())) {
        return null;
      }
      a(paramString, (ReadInJoyUserInfo)localList.get(0), false, paramBoolean);
      return localList;
    }
    return null;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, "resetRequestFlag.");
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ReadInJoyUserInfo)((Map.Entry)((Iterator)localObject).next()).getValue()).requestFlag = false;
      }
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback.");
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule;
    if (localObject1 != null)
    {
      Object localObject2 = ((ReadInJoyUserInfoModule)localObject1).a();
      if ((localObject2 != null) && (((ConcurrentHashMap)localObject2).get(paramString) != null))
      {
        localObject1 = new ArrayList();
        localObject2 = (List)((ConcurrentHashMap)localObject2).get(paramString);
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          IReadInJoyUserInfoModule.RefreshUserInfoCallBack localRefreshUserInfoCallBack = (IReadInJoyUserInfoModule.RefreshUserInfoCallBack)localIterator.next();
          if (localRefreshUserInfoCallBack != null)
          {
            localRefreshUserInfoCallBack.onLoadUserInfoSucceed(paramString, paramReadInJoyUserInfo);
            ((List)localObject1).add(localRefreshUserInfoCallBack);
          }
        }
        if (((List)localObject1).size() > 0) {
          ((List)localObject2).removeAll((Collection)localObject1);
        } else {
          QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback tempList is null.");
        }
      }
      else
      {
        QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback callbackList is null.");
      }
      paramReadInJoyUserInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoModule.b();
      if (paramReadInJoyUserInfo != null) {
        paramReadInJoyUserInfo.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramReadInJoyUserInfo != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramReadInJoyUserInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "updateReadInJoyUserInfo, \n uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo, Character.valueOf('\n'), "saveToDB = ", Boolean.valueOf(paramBoolean1), Character.valueOf('\n'), "notifyCallback = ", Boolean.valueOf(paramBoolean2) });
      }
      if (paramBoolean2) {
        a(paramString, paramReadInJoyUserInfo);
      }
      if (paramBoolean1) {
        a(paramReadInJoyUserInfo);
      }
      return;
    }
    QLog.d("ReadInJoyUserInfoRepository", 2, "updateReadInJoyUserInfo failed, uin is null or empty, or userInfo is null");
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoRepository
 * JD-Core Version:    0.7.0.1
 */