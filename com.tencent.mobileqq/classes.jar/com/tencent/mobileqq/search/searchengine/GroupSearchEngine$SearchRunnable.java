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
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
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
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
  private SearchRequest jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupSearchEngine$SearchRunnable(GroupSearchEngine paramGroupSearchEngine, SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
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
    while (k < GroupSearchEngine.a(this.this$0).size())
    {
      localObject2 = (GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.this$0).get(k);
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof NetSearchEngine)) {
        try
        {
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
          Thread.sleep(300L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      Object localObject3 = SearchUtil.a(((GroupSearchEngine.SearchEngineEntity)localObject2).a);
      SearchCostStat.a((String)localObject3);
      localObject1 = ((GroupSearchEngine.SearchEngineEntity)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest);
      SearchCostStat.b((String)localObject3);
      int i = j;
      if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof MessageSearchEngine)) {
        if (localObject1 != null)
        {
          i = j;
          if (!((List)localObject1).isEmpty()) {}
        }
        else if (!localArrayList.isEmpty())
        {
          localObject3 = new GroupSearchModelMessage(null, this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_JavaLangString);
          localArrayList.add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject3));
          localArrayList.add(localObject3);
          SearchStatisticsConstants.a(40);
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
          if ((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof NetSearchEngine))
          {
            j = i;
            if (localArrayList.isEmpty()) {
              j = 0;
            }
          }
          i = j;
          if (j != 0)
          {
            localObject3 = new GroupSearchModelMessage(null, this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_JavaLangString);
            localArrayList.add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject3));
            localArrayList.add(localObject3);
            SearchStatisticsConstants.a(40);
            i = 0;
          }
          localArrayList.addAll((Collection)localObject1);
          j = i;
          if (!(((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof NetSearchEngine))
          {
            SearchStatisticsConstants.a(((GroupSearchEngine.SearchEngineEntity)localObject2).c);
            j = i;
          }
        }
      }
      if (((((GroupSearchEngine.SearchEngineEntity)localObject2).a instanceof ContactSearchEngine)) && (((ContactSearchEngine)((GroupSearchEngine.SearchEngineEntity)GroupSearchEngine.a(this.this$0).get(k)).a).a() != 64))
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null) && (!localArrayList.isEmpty())) {
          this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localArrayList);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", true);
        localObject2 = ((GroupSearchEngine.SearchEngineEntity)localObject2).a.a(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject2 = (ISearchResultModel)((List)localObject2).get(0);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = (GroupSearchModelLocalContact)((List)localObject1).get(1);
          }
          else
          {
            localObject3 = new ArrayList();
            localObject1 = new GroupSearchModelLocalContact(null, GroupSearchEngine.a(this.this$0), GroupSearchEngine.a(this.this$0));
            ((List)localObject3).add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject1));
            ((List)localObject3).add(localObject1);
            localArrayList.addAll((Collection)localObject3);
            if (((List)localObject3).size() > 0) {
              this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
            }
          }
          ((GroupSearchModelLocalContact)localObject1).a((ISearchResultModel)localObject2);
          if (this.jdField_a_of_type_Boolean) {
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null) && (!localArrayList.isEmpty())) {
            this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localArrayList);
          }
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null) && (!localArrayList.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localArrayList);
      }
      k += 1;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");
    Object localObject1 = new CountDownLatch(1);
    if (bool)
    {
      SearchCostStat.a("SearchGroupMember");
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchCreateDiscussion", false);
      if (GroupSearchEngine.a(this.this$0) == null) {
        GroupSearchEngine.a(this.this$0, (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1));
      }
      GroupSearchEngine.a(this.this$0, new GroupSearchEngine.TroopMemberSearchRunnable(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest, (ArrayList)((ArrayList)localArrayList).clone(), this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener, GroupSearchEngine.a(this.this$0), (CountDownLatch)localObject1, this.this$0));
      localObject2 = this.this$0;
      GroupSearchEngine.a((GroupSearchEngine)localObject2, GroupSearchEngine.a((GroupSearchEngine)localObject2).schedule(GroupSearchEngine.a(this.this$0), 0L, TimeUnit.MILLISECONDS));
      SearchCostStat.b("SearchGroupMember");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
    if (localObject2 != null) {
      if (bool)
      {
        ((ISearchListener)localObject2).a(localArrayList, 1);
        ((CountDownLatch)localObject1).countDown();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("hasLocalPeopleOrTroop", false))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localArrayList, 5);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(localArrayList, 4);
      }
    }
    SearchCostStat.b("RunSearchRunnable");
    SearchCostStat.a(4);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    long l2 = System.currentTimeMillis();
    GroupSearchEngine.a(this.this$0, l2 - l1);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("search process cost:");
      ((StringBuilder)localObject1).append(GroupSearchEngine.a(this.this$0));
      QLog.d("GroupSearchEngine", 4, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */