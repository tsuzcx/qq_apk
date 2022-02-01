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
  private static final Comparator<GroupSearchEngine.SearchEngineEntity> c = new GroupSearchEngine.1();
  private static final ThreadPoolExecutor d = new GroupSearchEngine.3(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new GroupSearchEngine.2());
  private long a = -1L;
  private boolean b;
  private Future e;
  private GroupSearchEngine.SearchRunnable f;
  private ScheduledFuture g;
  private GroupSearchEngine.TroopMemberSearchRunnable h;
  private ScheduledThreadPoolExecutor i;
  private ArrayList<GroupSearchEngine.SearchEngineEntity> j;
  private QQAppInterface k;
  private String l;
  private int m;
  
  public GroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.k = paramQQAppInterface;
    this.m = paramInt;
    this.j = h();
    ((IFTSMsgInterface)((IFTSDBRuntimeService)paramQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(1)).a(this);
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
    boolean bool1 = SearchConfigUtils.g();
    boolean bool2 = SearchConfigUtils.f();
    if (bool1)
    {
      paramArrayList.add(new GroupSearchEngine.12(this, new CreateDiscussionSearchEngine(paramQQAppInterface, paramInt), "create_discussion", 120, paramInt));
      IFTSDBRuntimeService localIFTSDBRuntimeService = (IFTSDBRuntimeService)paramQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "");
      if ((bool2) && (localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(paramQQAppInterface)) && (localIFTSDBRuntimeService.hasInit()) && (SQLiteFTSUtils.f(paramQQAppInterface)))
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
      if ((bool2) && (localIFTSDBRuntimeService.getEnable()) && (SQLiteFTSUtils.a(paramQQAppInterface)) && (localIFTSDBRuntimeService.hasInit()) && (SQLiteFTSUtils.d(paramQQAppInterface) != 1) && ((!SQLiteFTSUtils.a(paramQQAppInterface)) || (SQLiteFTSUtils.f(paramQQAppInterface))))
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
  
  private ArrayList<GroupSearchEngine.SearchEngineEntity> h()
  {
    ArrayList localArrayList = new ArrayList();
    int n = this.m;
    if (n == 12)
    {
      localArrayList.add(new GroupSearchEngine.4(this, new PublicAccountSearchEngine(this.k, n), "public_account", 50));
      localArrayList.add(new GroupSearchEngine.5(this, new NetSearchEngine(this.k, d, this.m), "net_search", 0));
      Collections.sort(localArrayList, c);
      return localArrayList;
    }
    if (n == 14)
    {
      localArrayList.add(new GroupSearchEngine.6(this, new PublicAccountSearchEngine(this.k, n), "public_account", 50));
      localArrayList.add(new GroupSearchEngine.7(this, new NetSearchEngine(this.k, d, this.m), "net_search", 0));
      Collections.sort(localArrayList, c);
      return localArrayList;
    }
    localArrayList.add(new GroupSearchEngine.8(this, new ContactSearchEngine(this.k, n, 33751869, null), "people", 20));
    if (!StudyModeManager.h())
    {
      a(localArrayList, this.k, this.m);
      b(localArrayList, this.k, this.m);
      c(localArrayList, this.k, this.m);
    }
    d(localArrayList, this.k, this.m);
    a(localArrayList, this.k);
    e(localArrayList, this.k, this.m);
    Collections.sort(localArrayList, c);
    return localArrayList;
  }
  
  private void i()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((Future)localObject).cancel(true);
      localObject = this.e;
      if ((localObject instanceof Runnable)) {
        d.remove((Runnable)localObject);
      }
    }
    localObject = this.f;
    if (localObject != null) {
      ((GroupSearchEngine.SearchRunnable)localObject).a();
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((ScheduledFuture)localObject).cancel(true);
      localObject = this.i;
      if (localObject != null)
      {
        ScheduledFuture localScheduledFuture = this.g;
        if ((localScheduledFuture instanceof Runnable)) {
          ((ScheduledThreadPoolExecutor)localObject).remove((Runnable)localScheduledFuture);
        }
      }
    }
    localObject = this.h;
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
    SearchConfigManager.a(this.k);
    synchronized (this.j)
    {
      Collections.sort(this.j, c);
      int n = 0;
      while (n < this.j.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).c.a();
        n += 1;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("GroupSearchEngine.init() cost time : ");
        ((StringBuilder)???).append(l2 - l1);
        QLog.d("GroupSearchEngine", 2, ((StringBuilder)???).toString());
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.k.getCurrentAccountUin(), "GroupSearchEngineInit", true, l2 - l1, 0L, SearchUtils.a(null), "", false);
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<ISearchResultGroupModel> paramISearchListener)
  {
    this.l = paramSearchRequest.a;
    if (paramSearchRequest.b == null) {
      paramSearchRequest.b = new Bundle();
    }
    paramSearchRequest.b.putBoolean("bSearchNet", true);
    paramSearchRequest.b.putInt("iNumber", 11);
    paramSearchRequest.b.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    paramSearchRequest.b.putBoolean("searchTroopMember", false);
    i();
    this.f = new GroupSearchEngine.SearchRunnable(this, paramSearchRequest, paramISearchListener);
    this.e = d.submit(this.f);
    SearchUtils.a("all_result", "active_local", new String[] { this.l });
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    if (this.j == null) {
      return;
    }
    SearchStatisticsConstants.b();
    ArrayList localArrayList = this.j;
    int n = 0;
    try
    {
      while (n < this.j.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).c.b();
        n += 1;
      }
      i();
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
    ArrayList localArrayList = this.j;
    int n = 0;
    try
    {
      while (n < this.j.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).c.c();
        n += 1;
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
    ArrayList localArrayList = this.j;
    int n = 0;
    try
    {
      while (n < this.j.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).c.d();
        n += 1;
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
    Object localObject1 = ((IFTSDBRuntimeService)this.k.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(1);
    if (localObject1 != null) {
      ((IFTSOperator)localObject1).b(this);
    }
    localObject1 = this.j;
    int i1 = 0;
    int n = 0;
    try
    {
      while (n < this.j.size())
      {
        ((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).c.e();
        n += 1;
      }
      if (this.a != -1L)
      {
        HashMap localHashMap = new HashMap();
        localObject1 = this.j;
        n = i1;
        try
        {
          while (n < this.j.size())
          {
            localHashMap.put(((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).f, String.valueOf(((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).d));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).f);
            ((StringBuilder)localObject2).append("_size");
            localHashMap.put(((StringBuilder)localObject2).toString(), String.valueOf(((GroupSearchEngine.SearchEngineEntity)this.j.get(n)).e));
            n += 1;
          }
          Object localObject2 = this.l;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localHashMap.put("keyword", localObject1);
          localObject1 = this.l;
          if (localObject1 == null) {
            localObject1 = "0";
          } else {
            localObject1 = Integer.toString(((String)localObject1).trim().split("\\s+").length);
          }
          localHashMap.put("keyword_count", localObject1);
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.k.getCurrentAccountUin(), "GroupSearchEngineSearch", true, this.a, 0L, SearchUtils.a(localHashMap), "", false);
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
    ArrayList localArrayList = this.j;
    int n = 0;
    for (;;)
    {
      try
      {
        if (n < this.j.size())
        {
          GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.j.get(n);
          if ((localSearchEngineEntity.c instanceof FTSMessageSearchEngine)) {
            ((FTSMessageSearchEngine)localSearchEngineEntity.c).f();
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
        n += 1;
      }
    }
  }
  
  public void g()
  {
    ArrayList localArrayList = this.j;
    int n = 0;
    for (;;)
    {
      try
      {
        if (n < this.j.size())
        {
          GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.j.get(n);
          if ((localSearchEngineEntity.c instanceof FTSMessageSearchEngine)) {
            ((FTSMessageSearchEngine)localSearchEngineEntity.c).g();
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
        n += 1;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int n;
    if (((IFTSDBRuntimeService)this.k.getRuntimeService(IFTSDBRuntimeService.class, "")).getEnable())
    {
      paramObservable = this.j;
      n = 0;
    }
    for (;;)
    {
      try
      {
        if (n < this.j.size())
        {
          paramObject = (GroupSearchEngine.SearchEngineEntity)this.j.get(n);
          if ((paramObject.c instanceof FTSMessageSearchEngine))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if (!(paramObject.c instanceof MessageSearchEngine)) {
            break label193;
          }
          paramObject = new FTSMessageSearchEngine(this.k);
          paramObject.a();
          this.j.add(n, new GroupSearchEngine.17(this, paramObject, "fts message", 40));
          if (SQLiteFTSUtils.d(this.k) == 0) {
            this.j.remove(n + 1);
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
      label193:
      n += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */