package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchCostStat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class GroupSearchEngine$SearchRunnable
  implements Runnable
{
  private ISearchListener a;
  private SearchRequest b;
  private boolean c;
  
  public GroupSearchEngine$SearchRunnable(GroupSearchEngine paramGroupSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.b = paramSearchRequest;
    this.a = paramISearchListener;
  }
  
  public void a()
  {
    this.c = true;
    this.a = null;
  }
  
  public void run()
  {
    SearchCostStat.a("RunSearchRunnable");
    SearchCostStat.a(1);
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("begin local search at :");
      localStringBuilder.append(l1);
      QLog.d("GroupSearchEngine", 2, localStringBuilder.toString());
    }
    int k = 0;
    int j = 0;
    while (k < GroupSearchEngine.b(this.this$0).size())
    {
      localObject2 = (GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.b(this.this$0).get(k);
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).c instanceof NetSearchEngine)) {
        try
        {
          if (this.c) {
            return;
          }
          Thread.sleep(300L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (this.c) {
        return;
      }
      String str = SearchUtil.a(((GroupSearchEngine.SearchEngineEntity)localObject2).c);
      SearchCostStat.a(str);
      localObject1 = ((GroupSearchEngine.SearchEngineEntity)localObject2).a(this.b);
      SearchCostStat.b(str);
      int i = j;
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).c instanceof MessageSearchEngine)) {
        if (localObject1 != null)
        {
          i = j;
          if (!((List)localObject1).isEmpty()) {}
        }
        else if (!localArrayList.isEmpty())
        {
          SearchUtil.a(new GroupSearchModelMessage(null, this.b.a), localArrayList);
          SearchStatisticsConstants.b(40);
          i = j;
        }
        else
        {
          i = 1;
        }
      }
      j = i;
      if (localObject1 != null)
      {
        j = i;
        if (!((List)localObject1).isEmpty())
        {
          j = i;
          if ((((GroupSearchEngine.SearchEngineEntity)localObject2).c instanceof NetSearchEngine))
          {
            j = i;
            if (localArrayList.isEmpty()) {
              j = 0;
            }
          }
          i = j;
          if (j != 0)
          {
            SearchUtil.a(new GroupSearchModelMessage(null, this.b.a), localArrayList);
            SearchStatisticsConstants.b(40);
            i = 0;
          }
          localArrayList.addAll((Collection)localObject1);
          j = i;
          if (!(((GroupSearchEngine.SearchEngineEntity)localObject2).c instanceof NetSearchEngine))
          {
            SearchStatisticsConstants.b(((GroupSearchEngine.SearchEngineEntity)localObject2).g);
            j = i;
          }
        }
      }
      if (((((GroupSearchEngine.SearchEngineEntity)localObject2).c instanceof ContactSearchEngine)) && (((ContactSearchEngine)((GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.b(this.this$0).get(k)).c).h() != 64))
      {
        if (this.c) {
          return;
        }
        if ((this.a != null) && (!localArrayList.isEmpty())) {
          this.a.a(localArrayList);
        }
        if (this.b.b == null) {
          this.b.b = new Bundle();
        }
        this.b.b.putBoolean("searchCreateDiscussion", true);
        localObject2 = ((GroupSearchEngine.SearchEngineEntity)localObject2).c.a(this.b);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = (ISearchResultModel)((List)localObject2).get(0);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = (GroupSearchModelLocalContact)((List)localObject1).get(1);
          }
          else
          {
            localObject1 = new GroupSearchModelLocalContact(null, GroupSearchEngine.c(this.this$0), GroupSearchEngine.d(this.this$0));
            SearchUtil.a((ISearchResultGroupModel)localObject1, localArrayList);
            this.b.b.putBoolean("hasLocalPeopleOrTroop", true);
          }
          ((GroupSearchModelLocalContact)localObject1).a((ISearchResultModel)localObject2);
          if (this.c) {
            return;
          }
          if ((this.a != null) && (!localArrayList.isEmpty())) {
            this.a.a(localArrayList);
          }
        }
      }
      if (this.c) {
        return;
      }
      if ((this.a != null) && (!localArrayList.isEmpty())) {
        this.a.a(localArrayList);
      }
      k += 1;
    }
    if (this.c) {
      return;
    }
    if (this.b.b == null) {
      this.b.b = new Bundle();
    }
    boolean bool = this.b.b.getBoolean("searchTroopMember");
    Object localObject1 = new CountDownLatch(1);
    if (bool)
    {
      SearchCostStat.a("SearchGroupMember");
      this.b.b.putBoolean("searchCreateDiscussion", false);
      if (GroupSearchEngine.e(this.this$0) == null) {
        GroupSearchEngine.a(this.this$0, (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1));
      }
      GroupSearchEngine.a(this.this$0, new GroupSearchEngine.TroopMemberSearchRunnable(this.b, (ArrayList)((ArrayList)localArrayList).clone(), this.a, GroupSearchEngine.c(this.this$0), (CountDownLatch)localObject1, this.this$0));
      localObject2 = this.this$0;
      GroupSearchEngine.a((GroupSearchEngine)localObject2, GroupSearchEngine.e((GroupSearchEngine)localObject2).schedule(GroupSearchEngine.f(this.this$0), 0L, TimeUnit.MILLISECONDS));
      SearchCostStat.b("SearchGroupMember");
    }
    Object localObject2 = this.a;
    if (localObject2 != null) {
      if (bool)
      {
        ((ISearchListener)localObject2).a(localArrayList, 1);
        ((CountDownLatch)localObject1).countDown();
      }
      else if (this.b.b.getBoolean("hasLocalPeopleOrTroop", false))
      {
        this.a.a(localArrayList, 5);
      }
      else
      {
        this.a.a(localArrayList, 4);
      }
    }
    SearchCostStat.b("RunSearchRunnable");
    SearchCostStat.a(4);
    if (this.c) {
      return;
    }
    long l2 = System.currentTimeMillis();
    GroupSearchEngine.a(this.this$0, l2 - l1);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("search process cost:");
      ((StringBuilder)localObject1).append(GroupSearchEngine.g(this.this$0));
      QLog.d("GroupSearchEngine", 4, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */