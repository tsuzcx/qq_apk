package com.tencent.mobileqq.search.business.contact;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

public class ApproximateSearchEngine
  implements ISearchEngine<IContactSearchModel>
{
  private static final Comparator<IContactSearchModel> b = new ApproximateSearchEngine.1();
  private static Queue<ApproximateSearchEngine.SearchResultCache> k = new ConcurrentLinkedQueue();
  private static Object l = new Object();
  protected AppInterface a;
  private List<IContactSearchModel> c = new ArrayList();
  private int d = 0;
  private String e;
  private String f;
  private int g;
  private String h;
  private Set<String> i;
  private ApproximateSearchEngine.TypedReportInfo[] j = { new ApproximateSearchEngine.TypedReportInfo(1, "friend"), new ApproximateSearchEngine.TypedReportInfo(768, "phone_contact"), new ApproximateSearchEngine.TypedReportInfo(8, "discussion"), new ApproximateSearchEngine.TypedReportInfo(16, "troop") };
  private List<WeakReference<ApproximateSearchEngine.CancelFlag>> m = new ArrayList();
  private Object n = new Object();
  private ISearchListener<IContactSearchModel> o;
  
  public ApproximateSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.a = paramAppInterface;
    this.d = paramInt2;
    this.g = paramInt1;
    this.i = paramSet;
    this.h = paramString;
    this.f = "people";
  }
  
  public ApproximateSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  private ArrayList<Friends> a(String paramString)
  {
    try
    {
      paramString = (ArrayList)((IFriendDataService)this.a.getRuntimeService(IFriendDataService.class, "")).getFriendList(Integer.parseInt(paramString));
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return new ArrayList();
  }
  
  private List<IContactSearchModel> a(ApproximateSearchEngine.CancelFlag paramCancelFlag)
  {
    int i1 = 0;
    for (;;)
    {
      localObject1 = this.j;
      if (i1 >= localObject1.length) {
        break;
      }
      if (!"global_troop_member".equals(Integer.valueOf(localObject1[i1].a))) {
        this.j[i1].d = -1L;
      }
      i1 += 1;
    }
    Object localObject1 = this.e;
    ??? = a((String)localObject1, false);
    ArrayList localArrayList1 = new ArrayList();
    if (??? != null)
    {
      if (QLog.isColorLevel())
      {
        paramCancelFlag = new StringBuilder();
        paramCancelFlag.append("searchContactWithoutTroopMember use cache, keyword = ");
        paramCancelFlag.append((String)localObject1);
        QLog.i("ApproximateSearchEngine", 2, paramCancelFlag.toString());
      }
      localArrayList1.addAll((Collection)???);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      if (this.c.size() == 0) {
        return null;
      }
      localArrayList2.addAll(this.c);
      i1 = 0;
      while (i1 < localArrayList2.size())
      {
        if (paramCancelFlag.a())
        {
          if (QLog.isColorLevel())
          {
            paramCancelFlag = new StringBuilder();
            paramCancelFlag.append("searchContactWithoutTroopMember canceled, keyword = ");
            paramCancelFlag.append((String)localObject1);
            QLog.d("ApproximateSearchEngine", 2, paramCancelFlag.toString());
          }
          return null;
        }
        synchronized ((IContactSearchModel)localArrayList2.get(i1))
        {
          SearchMatchResult localSearchMatchResult = ((IContactSearchModel)???).b((String)localObject1);
          if ((localSearchMatchResult != null) && (localSearchMatchResult.a)) {
            localArrayList1.add(???);
          }
          i1 += 1;
        }
      }
      a((String)localObject1, localArrayList1, false);
      return localArrayList1;
    }
    finally {}
    for (;;)
    {
      throw paramCancelFlag;
    }
  }
  
  private List<IContactSearchModel> a(String paramString, boolean paramBoolean)
  {
    synchronized (l)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")))
      {
        Iterator localIterator = k.iterator();
        Object localObject1 = null;
        int i1 = -2147483648;
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (ApproximateSearchEngine.SearchResultCache)localIterator.next();
          if ((paramString.contains(((ApproximateSearchEngine.SearchResultCache)localObject2).a)) && (((ApproximateSearchEngine.SearchResultCache)localObject2).a.length() > i1))
          {
            i1 = ((ApproximateSearchEngine.SearchResultCache)localObject2).a.length();
            localObject1 = localObject2;
          }
        }
        if ((localObject1 != null) && (((ApproximateSearchEngine.SearchResultCache)localObject1).b != null))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getBestCache hit cache, cur keyword = ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" , cache keyword = ");
            ((StringBuilder)localObject2).append(((ApproximateSearchEngine.SearchResultCache)localObject1).a);
            ((StringBuilder)localObject2).append(" , cache size = ");
            ((StringBuilder)localObject2).append(((ApproximateSearchEngine.SearchResultCache)localObject1).b.size());
            QLog.d("ApproximateSearchEngine", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = ((ApproximateSearchEngine.SearchResultCache)localObject1).b;
          return paramString;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getBestCache miss cache, cur keyword = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("ApproximateSearchEngine", 2, ((StringBuilder)localObject1).toString());
        }
        return null;
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(String paramString, List<IContactSearchModel> paramList, boolean paramBoolean)
  {
    synchronized (l)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")) && (paramList != null))
      {
        Queue localQueue = k;
        while (localQueue.size() > 2) {
          localQueue.poll();
        }
        if (localQueue.size() == 2) {
          if (!paramList.isEmpty())
          {
            localQueue.poll();
          }
          else
          {
            Iterator localIterator = localQueue.iterator();
            while (localIterator.hasNext())
            {
              ApproximateSearchEngine.SearchResultCache localSearchResultCache = (ApproximateSearchEngine.SearchResultCache)localIterator.next();
              if (localSearchResultCache.b.isEmpty()) {
                localQueue.remove(localSearchResultCache);
              }
            }
            if (localQueue.size() == 2) {
              localQueue.poll();
            }
          }
        }
        localQueue.add(new ApproximateSearchEngine.SearchResultCache(this, paramString, paramList));
        return;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt != 768) {
            return -1;
          }
          return 1;
        }
        return 3;
      }
      return 2;
    }
    return 0;
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i1;
    if ((paramIContactSearchModel2.m() != null) && (paramIContactSearchModel1.m() != null)) {
      i1 = paramIContactSearchModel1.m().toString().compareTo(paramIContactSearchModel2.m().toString());
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (i1 == 0)
    {
      i2 = i1;
      if (paramIContactSearchModel2.n() != null)
      {
        i2 = i1;
        if (paramIContactSearchModel1.n() != null) {
          i2 = paramIContactSearchModel1.n().toString().compareTo(paramIContactSearchModel2.n().toString());
        }
      }
    }
    return i2;
  }
  
  private List<IContactSearchModel> b(SearchRequest paramSearchRequest)
  {
    ApproximateSearchEngine.CancelFlag localCancelFlag = new ApproximateSearchEngine.CancelFlag(this, false);
    synchronized (this.n)
    {
      this.m.add(new WeakReference(localCancelFlag));
      this.e = paramSearchRequest.a;
      paramSearchRequest = this.e;
      if (localCancelFlag.a())
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("searchContact canceled, keyword = ");
          ((StringBuilder)???).append(paramSearchRequest);
          QLog.d("ApproximateSearchEngine", 2, ((StringBuilder)???).toString());
        }
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      ??? = a(localCancelFlag);
      if (localCancelFlag.a())
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("searchContact canceled, keyword = ");
          ((StringBuilder)???).append(paramSearchRequest);
          QLog.d("ApproximateSearchEngine", 2, ((StringBuilder)???).toString());
        }
        return null;
      }
      if (??? != null) {
        localArrayList.addAll((Collection)???);
      }
      ??? = new ArrayList();
      boolean bool = a(localArrayList, (List)???, localCancelFlag, paramSearchRequest);
      paramSearchRequest = (SearchRequest)???;
      if (((List)???).size() > 40) {
        paramSearchRequest = ((List)???).subList(0, 40);
      }
      if (bool) {
        return null;
      }
      return paramSearchRequest;
    }
  }
  
  private List<Groups> f()
  {
    return ((IFriendDataService)this.a.getRuntimeService(IFriendDataService.class, "")).getGroupList();
  }
  
  private ArrayList<Entity> g()
  {
    return ((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
  }
  
  protected List<IContactSearchModel> a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      localObject1 = this.j;
      if (i1 >= localObject1.length) {
        break;
      }
      localObject1[i1].c = 0;
      localObject1[i1].b = 0L;
      i1 += 1;
    }
    Object localObject2 = new ArrayList();
    long l1;
    Object localObject3;
    Object localObject4;
    long l2;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      this.a.getCurrentAccountUin();
      localObject1 = f();
      if (localObject1 != null)
      {
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          localObject1 = a(String.valueOf(localGroups.group_id));
          if (localObject1 != null)
          {
            Iterator localIterator = ((List)localObject1).iterator();
            while (localIterator.hasNext())
            {
              Friends localFriends = (Friends)localIterator.next();
              AppInterface localAppInterface = this.a;
              i1 = this.g;
              if (localFriends.gathtertype == 1) {
                localObject1 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(2131917726);
              } else {
                localObject1 = localGroups.group_name;
              }
              ((List)localObject3).add(new ContactSearchModelFriend(localAppInterface, i1, localFriends, (String)localObject1, 0L));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i1 = b(1);
      localObject1 = this.j;
      localObject1[i1].b = (l2 - l1);
      localObject1[i1].c = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "");
      if (localObject3 != null)
      {
        localObject3 = ((IPhoneContactService)localObject3).getContactListForDisplay();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = (List)((List)localObject3).get(0);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.a, this.g, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(768);
      localObject3 = this.j;
      localObject3[i1].b = (l2 - l1);
      localObject3[i1].c = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "");
      if (localObject3 != null)
      {
        localObject3 = ((IPhoneContactService)localObject3).getContactListForDisplay();
        if ((localObject3 != null) && (((List)localObject3).size() > 1))
        {
          localObject3 = (List)((List)localObject3).get(1);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.a, this.g, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(768);
      localObject3 = this.j;
      localObject3[i1].b = (l2 - l1);
      localObject3[i1].c = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (ArrayList)((IDiscussionService)this.a.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelDiscussion(this.a, this.g, (DiscussionInfo)localObject4, null, 0));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(8);
      localObject3 = this.j;
      localObject3[i1].b = (l2 - l1);
      localObject3[i1].c = ((List)localObject1).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = g();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelTroop(this.a, this.g, (TroopInfo)localObject4, 0L));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      paramInt = b(16);
      localObject3 = this.j;
      localObject3[paramInt].b = (l2 - l1);
      localObject3[paramInt].c = ((List)localObject1).size();
    }
    Object localObject1 = this.i;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
    {
      localObject3 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        localObject1 = localObject3;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (IContactSearchModel)((Iterator)localObject2).next();
        if (!this.i.contains(((IContactSearchModel)localObject1).c())) {
          ((List)localObject3).add(localObject1);
        }
      }
    }
    localObject1 = localObject2;
    return localObject1;
  }
  
  public List<IContactSearchModel> a(SearchRequest paramSearchRequest)
  {
    return b(paramSearchRequest);
  }
  
  public void a()
  {
    List localList = a(this.d);
    if (localList != null) {}
    try
    {
      if (localList.size() > 0)
      {
        this.c.clear();
        this.c.addAll(localList);
      }
      else
      {
        this.c.clear();
      }
      return;
    }
    finally {}
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<IContactSearchModel> paramISearchListener)
  {
    this.o = paramISearchListener;
    ThreadManager.postImmediately(new ApproximateSearchEngine.2(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List<IContactSearchModel> paramList1, List<IContactSearchModel> paramList2, ApproximateSearchEngine.CancelFlag arg3, String paramString)
  {
    ApproximateSearchEngine.CancelFlag localCancelFlag = ???;
    if (??? == null)
    {
      localCancelFlag = new ApproximateSearchEngine.CancelFlag(this, false);
      synchronized (this.n)
      {
        this.m.add(new WeakReference(localCancelFlag));
      }
    }
    ??? = new HashMap();
    paramList1 = paramList1.iterator();
    IContactSearchModel localIContactSearchModel1;
    while (paramList1.hasNext())
    {
      localIContactSearchModel1 = (IContactSearchModel)paramList1.next();
      IContactSearchModel localIContactSearchModel2 = (IContactSearchModel)???.get(localIContactSearchModel1.i());
      if (localCancelFlag.a())
      {
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("searchContact canceled, keyword = ");
          paramList1.append(paramString);
          QLog.d("ApproximateSearchEngine", 2, paramList1.toString());
        }
        return true;
      }
      if ((localIContactSearchModel2 == null) || (localIContactSearchModel2.u() < localIContactSearchModel1.u())) {
        ???.put(localIContactSearchModel1.i(), localIContactSearchModel1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localIContactSearchModel1 = (IContactSearchModel)???.next();
      if (localCancelFlag.a())
      {
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("searchContact canceled, keyword = ");
          paramList1.append(paramString);
          QLog.d("ApproximateSearchEngine", 2, paramList1.toString());
        }
        return true;
      }
      localIContactSearchModel1 = (IContactSearchModel)localIContactSearchModel1.clone();
      if (localIContactSearchModel1 != null) {
        paramList1.add(localIContactSearchModel1);
      }
    }
    Collections.sort(paramList1, b);
    paramList2.addAll(paramList1);
    return false;
  }
  
  public void b()
  {
    synchronized (this.n)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        ApproximateSearchEngine.CancelFlag localCancelFlag = (ApproximateSearchEngine.CancelFlag)localWeakReference.get();
        if (localCancelFlag != null)
        {
          localCancelFlag.a(true);
          localArrayList.add(localWeakReference);
        }
      }
      this.m = localArrayList;
      this.o = null;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    k.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine
 * JD-Core Version:    0.7.0.1
 */