package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.interfaces.IFTSMsgInterface;
import com.tencent.mobileqq.fts.interfaces.IFTSOperator;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchGroupEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.CreateDiscussionSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GroupSearchEngine
  implements ISearchGroupEngine<ISearchResultGroupModel>, Observer
{
  private static final Comparator<GroupSearchEngine.SearchEngineEntity> jdField_a_of_type_JavaUtilComparator = new GroupSearchEngine.1();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new GroupSearchEngine.3(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new GroupSearchEngine.2());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GroupSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable;
  private GroupSearchEngine.TroopMemberSearchRunnable jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<GroupSearchEngine.SearchEngineEntity> jdField_a_of_type_JavaUtilArrayList;
  private Future jdField_a_of_type_JavaUtilConcurrentFuture;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = a();
    ((IFTSMsgInterface)((IFTSDBRuntimeService)paramQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(1)).a(this);
  }
  
  private ArrayList<GroupSearchEngine.SearchEngineEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Int;
    if (i == 12)
    {
      localArrayList.add(new GroupSearchEngine.4(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i), "public_account", 50));
      localArrayList.add(new GroupSearchEngine.5(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    if (i == 14)
    {
      localArrayList.add(new GroupSearchEngine.6(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i), "public_account", 50));
      localArrayList.add(new GroupSearchEngine.7(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    localArrayList.add(new GroupSearchEngine.8(this, new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 197437, null), "people", 20));
    if (StudyModeManager.a())
    {
      d(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    }
    else
    {
      a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      b(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      c(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      d(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
      a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      e(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    }
    Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
    return localArrayList;
  }
  
  private void a(ArrayList<GroupSearchEngine.SearchEngineEntity> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    paramArrayList.add(new GroupSearchEngine.15(this, new FavoriteSearchEngine(paramQQAppInterface), "favorite", 60));
  }
  
  private void a(ArrayList<GroupSearchEngine.SearchEngineEntity> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new GroupSearchEngine.9(this, new MiniProgramSearchEngine(paramQQAppInterface, paramInt), "", 0, paramInt));
  }
  
  private void b(ArrayList<GroupSearchEngine.SearchEngineEntity> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new GroupSearchEngine.10(this, new ApproximateSearchEngine(paramQQAppInterface, paramInt, 793, null), "people", 20, paramInt));
  }
  
  private void c(ArrayList<GroupSearchEngine.SearchEngineEntity> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new GroupSearchEngine.11(this, new FunctionSearchEngine(paramQQAppInterface, paramInt), "function", 130, paramInt));
  }
  
  private void d(ArrayList<GroupSearchEngine.SearchEngineEntity> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool1 = SearchConfigUtils.f();
    boolean bool2 = SearchConfigUtils.e();
    if (bool1)
    {
      paramArrayList.add(new GroupSearchEngine.12(this, new CreateDiscussionSearchEngine(paramQQAppInterface, paramInt), "create_discussion", 120, paramInt));
      IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)paramQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "");
      if ((bool2) && (localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(paramQQAppInterface)) && (localIFTSDBRuntimeService.hasInit()) && (SQLiteFTSUtils.c(paramQQAppInterface)))
      {
        paramArrayList.add(new GroupSearchEngine.13(this, new FTSMessageSearchEngine(paramQQAppInterface), "fts_message", 40, paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      }
      if ((bool2) && (localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(paramQQAppInterface)) && (localIFTSDBRuntimeService.hasInit()) && (SQLiteFTSUtils.a(paramQQAppInterface) != 1) && ((!SQLiteFTSUtils.a(paramQQAppInterface)) || (SQLiteFTSUtils.c(paramQQAppInterface))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add MessageSearchEngine");
        }
      }
      else
      {
        paramArrayList.add(new GroupSearchEngine.14(this, new MessageSearchEngine(paramQQAppInterface), "message", 40));
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
        }
      }
    }
    else
    {
      QLog.e("GroupSearchEngine", 2, "not show message search! ");
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("bShowMsgSearchResult : ");
    paramArrayList.append(bool1);
    paramArrayList.append("bEnableFtsSearch: ");
    paramArrayList.append(bool2);
    QLog.d("GroupSearchEngine", 2, paramArrayList.toString());
  }
  
  private void e(ArrayList<GroupSearchEngine.SearchEngineEntity> paramArrayList, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramArrayList.add(new GroupSearchEngine.16(this, new FileManagerSearchEngine(paramQQAppInterface, paramInt), "file", 100, paramInt));
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentFuture;
    if (localObject != null)
    {
      ((Future)localObject).cancel(true);
      localObject = this.jdField_a_of_type_JavaUtilConcurrentFuture;
      if ((localObject instanceof Runnable)) {
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.remove((Runnable)localObject);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable;
    if (localObject != null) {
      ((GroupSearchEngine.SearchRunnable)localObject).a();
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
    if (localObject != null)
    {
      ((ScheduledFuture)localObject).cancel(true);
      localObject = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
      if (localObject != null)
      {
        ScheduledFuture localScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
        if ((localScheduledFuture instanceof Runnable)) {
          ((ScheduledThreadPoolExecutor)localObject).remove((Runnable)localScheduledFuture);
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$TroopMemberSearchRunnable;
    if (localObject != null) {
      ((GroupSearchEngine.TroopMemberSearchRunnable)localObject).b();
    }
  }
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    return null;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    SearchConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, jdField_a_of_type_JavaUtilComparator);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.a();
        i += 1;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("GroupSearchEngine.init() cost time : ");
        ((StringBuilder)???).append(l2 - l1);
        QLog.d("GroupSearchEngine", 2, ((StringBuilder)???).toString());
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, SearchUtils.a(null), "", false);
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<ISearchResultGroupModel> paramISearchListener)
  {
    this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("bSearchNet", true);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putInt("iNumber", 11);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", false);
    h();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable = new GroupSearchEngine.SearchRunnable(this, paramSearchRequest, paramISearchListener);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine$SearchRunnable);
    SearchUtils.a("all_result", "active_local", new String[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    SearchStatisticsConstants.a();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.b();
        i += 1;
      }
      h();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.c();
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.d();
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void e()
  {
    Object localObject1 = ((IFTSDBRuntimeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(1);
    if (localObject1 != null) {
      ((IFTSOperator)localObject1).b(this);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    int j = 0;
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.e();
        i += 1;
      }
      if (this.jdField_a_of_type_Long != -1L)
      {
        HashMap localHashMap = new HashMap();
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
        i = j;
        try
        {
          while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            localHashMap.put(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, String.valueOf(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("_size");
            localHashMap.put(((StringBuilder)localObject2).toString(), String.valueOf(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b));
            i += 1;
          }
          Object localObject2 = this.jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localHashMap.put("keyword", localObject1);
          localObject1 = this.jdField_a_of_type_JavaLangString;
          if (localObject1 == null) {
            localObject1 = "0";
          } else {
            localObject1 = Integer.toString(((String)localObject1).trim().split("\\s+").length);
          }
          localHashMap.put("keyword_count", localObject1);
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "GroupSearchEngineSearch", true, this.jdField_a_of_type_Long, 0L, SearchUtils.a(localHashMap), "", false);
          return;
        }
        finally {}
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject4;
    }
  }
  
  public void f()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine instanceof FTSMessageSearchEngine)) {
            ((FTSMessageSearchEngine)localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).f();
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  public void g()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine instanceof FTSMessageSearchEngine)) {
            ((FTSMessageSearchEngine)localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).g();
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i;
    if (((IFTSDBRuntimeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getEnable())
    {
      paramObservable = this.jdField_a_of_type_JavaUtilArrayList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramObject = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((paramObject.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine instanceof FTSMessageSearchEngine))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if (!(paramObject.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine instanceof MessageSearchEngine)) {
            break label196;
          }
          paramObject = new FTSMessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramObject.a();
          this.jdField_a_of_type_JavaUtilArrayList.add(i, new GroupSearchEngine.17(this, paramObject, "fts message", 40));
          if (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
            this.jdField_a_of_type_JavaUtilArrayList.remove(i + 1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("GroupSearchEngine", 2, "update() searchEngines add FTSMessageSearchEngine");
          }
          return;
        }
        return;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "update() illegal");
      }
      return;
      label196:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */