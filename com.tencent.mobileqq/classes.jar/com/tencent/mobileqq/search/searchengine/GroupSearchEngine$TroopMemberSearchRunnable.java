package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class GroupSearchEngine$TroopMemberSearchRunnable
  implements Runnable
{
  private ISearchListener a;
  private SearchRequest b;
  private ArrayList<IModel> c;
  private boolean d;
  private String e;
  private CountDownLatch f;
  private WeakReference<GroupSearchEngine> g;
  
  public GroupSearchEngine$TroopMemberSearchRunnable(SearchRequest paramSearchRequest, ArrayList<IModel> paramArrayList, ISearchListener paramISearchListener, String paramString, CountDownLatch paramCountDownLatch, GroupSearchEngine paramGroupSearchEngine)
  {
    this.b = paramSearchRequest;
    this.c = paramArrayList;
    this.a = paramISearchListener;
    this.e = paramString;
    this.f = paramCountDownLatch;
    this.g = new WeakReference(paramGroupSearchEngine);
  }
  
  public void a()
  {
    a(this.c);
  }
  
  public void a(ArrayList<IModel> paramArrayList)
  {
    try
    {
      this.f.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    if (this.d) {
      return;
    }
    if (this.a == null) {
      return;
    }
    if (this.b.b.getBoolean("hasLocalPeopleOrTroop", false))
    {
      this.a.a(paramArrayList, 5);
      return;
    }
    this.a.a(paramArrayList, 4);
  }
  
  public void b()
  {
    this.d = true;
    this.a = null;
    while (this.f.getCount() > 0L) {
      this.f.countDown();
    }
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TroopMemberSearchRunnable, begin local search at :");
      ((StringBuilder)localObject1).append(l);
      QLog.d("GroupSearchEngine", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (GroupSearchEngine)this.g.get();
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = GroupSearchEngine.c((GroupSearchEngine)localObject1);
    } else {
      localObject2 = "";
    }
    int j;
    if (localObject1 != null) {
      j = GroupSearchEngine.d((GroupSearchEngine)localObject1);
    } else {
      j = 0;
    }
    if ((localObject1 != null) && (this.e.equals(localObject2)))
    {
      Object localObject4 = GroupSearchEngine.b((GroupSearchEngine)localObject1);
      localObject1 = null;
      int i = 0;
      Object localObject3;
      for (;;)
      {
        localObject3 = localObject1;
        if (i >= ((ArrayList)localObject4).size()) {
          break;
        }
        if ((((GroupSearchEngine.SearchEngineEntity)((ArrayList)localObject4).get(i)).c instanceof ContactSearchEngine))
        {
          localObject3 = (ContactSearchEngine)((GroupSearchEngine.SearchEngineEntity)((ArrayList)localObject4).get(i)).c;
          localObject1 = localObject3;
          if (((ContactSearchEngine)localObject3).h() != 64) {
            break;
          }
        }
        i += 1;
      }
      if ((!this.d) && (localObject3 != null) && (this.c != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, start search");
        }
        localObject4 = ((ContactSearchEngine)localObject3).a(this.b);
        if ((!this.d) && (localObject4 != null) && (!((List)localObject4).isEmpty()))
        {
          localObject1 = new ArrayList();
          ((List)localObject1).addAll((Collection)localObject4);
          Object localObject5;
          int k;
          if (!this.c.isEmpty())
          {
            localObject4 = this.c.iterator();
            int m = -1;
            i = -1;
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (IModel)((Iterator)localObject4).next();
              k = i + 1;
              i = k;
              if ((localObject5 instanceof GroupSearchModelLocalContact))
              {
                localObject4 = ((GroupSearchModelLocalContact)localObject5).a.iterator();
                while (((Iterator)localObject4).hasNext()) {
                  ((List)localObject1).add((IContactSearchModel)((Iterator)localObject4).next());
                }
                i = 1;
                break label414;
              }
            }
            int n = 0;
            k = i;
            i = n;
            label414:
            if (i != 0)
            {
              localObject4 = this.c;
              i = k - 1;
              ((ArrayList)localObject4).remove(i);
              this.c.remove(i);
            }
            if (SearchConfigManager.needSeparate)
            {
              localObject4 = this.c.iterator();
              i = m;
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (IModel)((Iterator)localObject4).next();
                k = i + 1;
                i = k;
                if ((localObject5 instanceof GroupSearchModelLocalTroop))
                {
                  localObject4 = ((GroupSearchModelLocalTroop)localObject5).a.iterator();
                  while (((Iterator)localObject4).hasNext()) {
                    ((List)localObject1).add((IContactSearchModel)((Iterator)localObject4).next());
                  }
                  i = 1;
                  break label560;
                }
              }
              m = 0;
              k = i;
              i = m;
              label560:
              if (i != 0)
              {
                localObject4 = this.c;
                i = k - 1;
                ((ArrayList)localObject4).remove(i);
                this.c.remove(i);
              }
            }
          }
          localObject4 = new ArrayList();
          ((ContactSearchEngine)localObject3).a((List)localObject1, (List)localObject4, null, (String)localObject2);
          if ((!this.d) && (!((List)localObject4).isEmpty()))
          {
            localObject1 = new ArrayList();
            localObject3 = ((List)localObject4).iterator();
            i = 0;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (IContactSearchModel)((Iterator)localObject3).next();
              if ((localObject4 instanceof ContactSearchModelGlobalTroop))
              {
                k = i + 1;
                i = k;
                if (k <= 200)
                {
                  ((List)localObject1).add(localObject4);
                  i = k;
                }
              }
              else
              {
                ((List)localObject1).add(localObject4);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("TroopMemberSearchRunnable troopCount:");
              ((StringBuilder)localObject3).append(i);
              QLog.d("GroupSearchEngine", 2, ((StringBuilder)localObject3).toString());
            }
            localObject3 = new ArrayList(((List)localObject1).size());
            localObject4 = new ArrayList(((List)localObject1).size());
            if (SearchConfigManager.needSeparate)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject5 = (IContactSearchModel)((Iterator)localObject1).next();
                if (SearchUtils.a((ISearchResultModel)localObject5)) {
                  ((List)localObject4).add(localObject5);
                } else {
                  ((List)localObject3).add(localObject5);
                }
              }
            }
            ((List)localObject3).addAll((Collection)localObject1);
            localObject1 = new ArrayList();
            SearchUtil.a(new GroupSearchModelLocalContact((List)localObject3, (String)localObject2, j), (List)localObject1);
            if ((SearchConfigManager.needSeparate) && (((List)localObject4).size() > 0)) {
              SearchUtil.a(new GroupSearchModelLocalTroop((List)localObject4, (String)localObject2, j), (List)localObject1);
            }
            if (!this.c.isEmpty()) {
              ((ArrayList)localObject1).addAll(this.c);
            }
            if ((!this.d) && (this.e.equals(localObject2)))
            {
              if ((this.a != null) && (!((ArrayList)localObject1).isEmpty())) {
                a((ArrayList)localObject1);
              }
              localObject1 = (GroupSearchEngine)this.g.get();
              if (localObject1 != null)
              {
                GroupSearchEngine.a((GroupSearchEngine)localObject1, System.currentTimeMillis() - l);
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("TroopMemberSearchRunnable, end search, cost: ");
                  ((StringBuilder)localObject2).append(GroupSearchEngine.g((GroupSearchEngine)localObject1));
                  QLog.d("GroupSearchEngine", 2, ((StringBuilder)localObject2).toString());
                }
              }
              return;
            }
            a();
            return;
          }
          a();
          return;
        }
        a();
        return;
      }
      a();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.TroopMemberSearchRunnable
 * JD-Core Version:    0.7.0.1
 */