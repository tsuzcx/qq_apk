package com.tencent.mobileqq.search.business.contact;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.fts.interfaces.IFTSTroopInterface;
import com.tencent.mobileqq.fts.query.QueryArgs;
import com.tencent.mobileqq.fts.query.QueryArgs.Builder;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.TroopAssistantSearchInfo;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.util.ReportTask;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGameMsgBox;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop.TroopSearchMemberInfo;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.model.TroopBatchAddFrdsSearchModelMember;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

public class ContactSearchEngine
  implements ISearchEngine<IContactSearchModel>
{
  public static boolean a = false;
  private static final Comparator<IContactSearchModel> d = new ContactSearchEngine.1();
  private static final Comparator<IContactSearchModel> e = new ContactSearchEngine.2();
  private static final Comparator<RecentUser> f = new ContactSearchEngine.3();
  private ConcurrentHashMap<String, Integer> A = new ConcurrentHashMap();
  private Queue<ContactSearchEngine.SearchResultCache> B = new ConcurrentLinkedQueue();
  private Queue<ContactSearchEngine.SearchResultCache> C = new ConcurrentLinkedQueue();
  private List<WeakReference<ContactSearchEngine.CancelFlag>> D = new ArrayList();
  private Object E = new Object();
  private ISearchListener<IContactSearchModel> F;
  protected AppInterface b;
  boolean c = false;
  private List<IContactSearchModel> g;
  private Map<String, ArrayList<DiscussionMemberInfo>> h;
  private List<ArrayList<DiscussionMemberInfo>> i;
  private int j = 0;
  private String k;
  private String l;
  private int m;
  private String n;
  private Set<String> o;
  private CreateDiscussionSearchEngine p;
  private boolean q = false;
  private long r = -1L;
  private long s;
  private long t;
  private int u;
  private ContactSearchEngine.TypedReportInfo[] v = { new ContactSearchEngine.TypedReportInfo(1, "friend"), new ContactSearchEngine.TypedReportInfo(768, "phone_contact"), new ContactSearchEngine.TypedReportInfo(4, "discussion_member"), new ContactSearchEngine.TypedReportInfo(8, "discussion"), new ContactSearchEngine.TypedReportInfo(16, "troop"), new ContactSearchEngine.TypedReportInfo(32, "recent_user"), new ContactSearchEngine.TypedReportInfo(64, "tool"), new ContactSearchEngine.TypedReportInfo(2048, "circle_buddy"), new ContactSearchEngine.TypedReportInfo(131072, "global_troop_member"), new ContactSearchEngine.TypedReportInfo(8388608, "qcircle_friends"), new ContactSearchEngine.TypedReportInfo(16777216, "qcircle_official_account") };
  private long w = -1L;
  private long x = -1L;
  private long y = -1L;
  private long z = -1L;
  
  public ContactSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.b = paramAppInterface;
    this.j = paramInt2;
    this.m = paramInt1;
    this.o = paramSet;
    this.n = paramString;
    if (paramInt2 != 29)
    {
      if (paramInt2 == 33751869) {
        this.l = "people";
      }
    }
    else {
      this.l = "msg";
    }
    if (SearchUtils.b(paramInt1)) {
      this.q = false;
    }
  }
  
  public ContactSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(IContactSearchModel paramIContactSearchModel)
  {
    if ((paramIContactSearchModel instanceof ContactSearchModelFriend)) {
      return 0;
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelPhoneContact)) {
      return 1;
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
      return 2;
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelDiscussion)) {
      return 3;
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelTroop)) {
      return 4;
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelRecentUser)) {
      return 5;
    }
    return -1;
  }
  
  private List<IContactSearchModel> a(ContactSearchEngine.CancelFlag paramCancelFlag)
  {
    int i1 = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = this.v;
      if (i1 >= localObject1.length) {
        break;
      }
      if (!"global_troop_member".equals(Integer.valueOf(localObject1[i1].a))) {
        this.v[i1].d = -1L;
      }
      i1 += 1;
    }
    String str = this.k;
    Object localObject2 = a(str, false);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("searchContactWithoutTroopMember use cache, keyword = ");
        ((StringBuilder)localObject1).append(str);
        QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.g;
    }
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new ArrayList();
    i1 = 0;
    while (i1 < ((List)localObject1).size())
    {
      if (paramCancelFlag.a())
      {
        if (QLog.isColorLevel())
        {
          paramCancelFlag = new StringBuilder();
          paramCancelFlag.append("searchContactWithoutTroopMember canceled, keyword = ");
          paramCancelFlag.append(str);
          QLog.d("ContactSearchEngine", 2, paramCancelFlag.toString());
        }
        return null;
      }
      IContactSearchModel localIContactSearchModel = (IContactSearchModel)((List)localObject1).get(i1);
      long l1 = System.nanoTime();
      try
      {
        localIContactSearchModel.d(str);
        long l2 = System.nanoTime();
        int i2 = a(localIContactSearchModel);
        if (i2 != -1)
        {
          ContactSearchEngine.TypedReportInfo localTypedReportInfo = this.v[i2];
          localTypedReportInfo.d += l2 - l1;
        }
        if (localIContactSearchModel.u() != -9223372036854775808L) {
          ((List)localObject2).add(localIContactSearchModel);
        }
        i1 += 1;
      }
      finally {}
    }
    i1 = 0;
    for (;;)
    {
      paramCancelFlag = this.v;
      if (i1 >= paramCancelFlag.length) {
        break;
      }
      paramCancelFlag[i1].d /= 1000000L;
      i1 += 1;
    }
    a(str, (List)localObject2, false);
    return localObject2;
  }
  
  private List<IContactSearchModel> a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")))
      {
        if (paramBoolean) {
          localObject1 = this.C;
        } else {
          localObject1 = this.B;
        }
        Iterator localIterator = ((Queue)localObject1).iterator();
        Object localObject1 = null;
        int i1 = -2147483648;
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (ContactSearchEngine.SearchResultCache)localIterator.next();
          if ((paramString.startsWith(((ContactSearchEngine.SearchResultCache)localObject2).a)) && (((ContactSearchEngine.SearchResultCache)localObject2).a.length() > i1))
          {
            i1 = ((ContactSearchEngine.SearchResultCache)localObject2).a.length();
            localObject1 = localObject2;
          }
        }
        if ((localObject1 != null) && (((ContactSearchEngine.SearchResultCache)localObject1).b != null))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getBestCache hit cache, cur keyword = ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" , cache keyword = ");
            ((StringBuilder)localObject2).append(((ContactSearchEngine.SearchResultCache)localObject1).a);
            ((StringBuilder)localObject2).append(" , cache size = ");
            ((StringBuilder)localObject2).append(((ContactSearchEngine.SearchResultCache)localObject1).b.size());
            QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = ((ContactSearchEngine.SearchResultCache)localObject1).b;
          return paramString;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getBestCache miss cache, cur keyword = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject1).toString());
        }
        return null;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(String paramString, List<IContactSearchModel> paramList, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")) && (paramList != null))
      {
        Queue localQueue;
        if (paramBoolean) {
          localQueue = this.C;
        } else {
          localQueue = this.B;
        }
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
              ContactSearchEngine.SearchResultCache localSearchResultCache = (ContactSearchEngine.SearchResultCache)localIterator.next();
              if (localSearchResultCache.b.isEmpty()) {
                localQueue.remove(localSearchResultCache);
              }
            }
            if (localQueue.size() == 2) {
              localQueue.poll();
            }
          }
        }
        localQueue.add(new ContactSearchEngine.SearchResultCache(this, paramString, paramList));
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(List<IContactSearchModel> paramList)
  {
    Object localObject1 = ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getCircleFriendMap();
    if ((localObject1 == null) && (((Map)localObject1).isEmpty()))
    {
      QLog.d("ContactSearchEngine", 1, "[addCircleFriendGroupList] current result is empty.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Entity)((Iterator)localObject2).next();
          if ((localObject3 instanceof Friends))
          {
            localObject3 = (Friends)localObject3;
            localArrayList.add(new ContactSearchModelFriend(this.b, this.m, (Friends)localObject3, str, c(((Friends)localObject3).uin)));
          }
        }
      }
    }
    paramList.addAll(localArrayList);
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 8)
        {
          if (paramInt != 16)
          {
            if (paramInt != 32)
            {
              if (paramInt != 768)
              {
                if (paramInt != 2048)
                {
                  if (paramInt != 131072)
                  {
                    if (paramInt != 8388608)
                    {
                      if (paramInt != 16777216) {
                        return -1;
                      }
                      return 10;
                    }
                    return 9;
                  }
                  return 8;
                }
                return 7;
              }
              return 1;
            }
            return 5;
          }
          return 4;
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
      i1 = paramIContactSearchModel2.m().toString().compareTo(paramIContactSearchModel1.m().toString());
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
          i2 = paramIContactSearchModel2.n().toString().compareTo(paramIContactSearchModel1.n().toString());
        }
      }
    }
    return i2;
  }
  
  private List<IContactSearchModel> b(SearchRequest paramSearchRequest)
  {
    Object localObject2 = new ContactSearchEngine.CancelFlag(this, false);
    synchronized (this.E)
    {
      this.D.add(new WeakReference(localObject2));
      this.k = paramSearchRequest.a;
      boolean bool;
      if (paramSearchRequest.b != null) {
        bool = paramSearchRequest.b.getBoolean("searchRequestFromHome", false);
      } else {
        bool = false;
      }
      ??? = this.k;
      if (((ContactSearchEngine.CancelFlag)localObject2).a())
      {
        if (QLog.isColorLevel())
        {
          paramSearchRequest = new StringBuilder();
          paramSearchRequest.append("searchContact canceled, keyword = ");
          paramSearchRequest.append((String)???);
          QLog.d("ContactSearchEngine", 2, paramSearchRequest.toString());
        }
        return null;
      }
      long l1 = System.currentTimeMillis();
      Object localObject3 = new ArrayList();
      Object localObject4 = a((ContactSearchEngine.CancelFlag)localObject2);
      this.u = 0;
      int i1 = this.j;
      if (((0x10000 & i1) == 0) && ((0x20000 & i1) == 0) && ((0x200000 & i1) == 0) && ((0x400000 & i1) == 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      int i2 = i1;
      if (localObject4 != null)
      {
        i2 = i1;
        if (i1 != 0)
        {
          i2 = i1;
          if (bool)
          {
            Object localObject5 = new HashSet();
            l2 = IContactSearchable.v;
            long l3 = IContactSearchable.z;
            long l4 = IContactSearchable.Z;
            Iterator localIterator = ((List)localObject4).iterator();
            for (;;)
            {
              i2 = i1;
              if (!localIterator.hasNext()) {
                break;
              }
              IContactSearchModel localIContactSearchModel = (IContactSearchModel)localIterator.next();
              if (((ContactSearchEngine.CancelFlag)localObject2).a())
              {
                if (QLog.isColorLevel())
                {
                  paramSearchRequest = new StringBuilder();
                  paramSearchRequest.append("searchContact canceled, keyword = ");
                  paramSearchRequest.append((String)???);
                  QLog.d("ContactSearchEngine", 2, paramSearchRequest.toString());
                }
                return null;
              }
              if (((localIContactSearchModel instanceof ContactSearchModelDiscussion)) || ((localIContactSearchModel instanceof ContactSearchModelTroop))) {
                this.u += 1;
              }
              if (localIContactSearchModel.u() > l2 + l3 + l4) {
                ((Set)localObject5).add(localIContactSearchModel.i());
              }
              if (((Set)localObject5).size() > 5)
              {
                if (QLog.isColorLevel())
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("searchContact no need to search troop member, keyword = ");
                  ((StringBuilder)localObject5).append((String)???);
                  QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject5).toString());
                }
                i2 = 0;
                break;
              }
            }
          }
        }
      }
      if (((ContactSearchEngine.CancelFlag)localObject2).a())
      {
        if (QLog.isColorLevel())
        {
          paramSearchRequest = new StringBuilder();
          paramSearchRequest.append("searchContact canceled, keyword = ");
          paramSearchRequest.append((String)???);
          QLog.d("ContactSearchEngine", 2, paramSearchRequest.toString());
        }
        return null;
      }
      if ((paramSearchRequest.b != null) && (paramSearchRequest.b.containsKey("searchTroopMember"))) {
        bool = paramSearchRequest.b.getBoolean("searchTroopMember");
      } else {
        bool = true;
      }
      if (i2 != 0)
      {
        if (bool) {
          paramSearchRequest = b((ContactSearchEngine.CancelFlag)localObject2);
        } else {
          paramSearchRequest.b.putBoolean("searchTroopMember", true);
        }
      }
      else {
        paramSearchRequest = null;
      }
      if (((ContactSearchEngine.CancelFlag)localObject2).a())
      {
        if (QLog.isColorLevel())
        {
          paramSearchRequest = new StringBuilder();
          paramSearchRequest.append("searchContact canceled, keyword = ");
          paramSearchRequest.append((String)???);
          QLog.d("ContactSearchEngine", 2, paramSearchRequest.toString());
        }
        return null;
      }
      if (localObject4 != null) {
        ((List)localObject3).addAll((Collection)localObject4);
      }
      if (paramSearchRequest != null) {
        ((List)localObject3).addAll(paramSearchRequest);
      }
      localObject4 = new ArrayList();
      if (a((List)localObject3, (List)localObject4, (ContactSearchEngine.CancelFlag)localObject2, (String)???)) {
        return null;
      }
      paramSearchRequest = new ArrayList();
      localObject2 = ((List)localObject4).iterator();
      i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
        if ((localObject3 instanceof ContactSearchModelGlobalTroop))
        {
          i2 = i1 + 1;
          i1 = i2;
          if (i2 <= 200)
          {
            paramSearchRequest.add(localObject3);
            i1 = i2;
          }
        }
        else
        {
          paramSearchRequest.add(localObject3);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ContactSearchEngine.search() troopCount:");
        ((StringBuilder)localObject2).append(i1);
        QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ContactSearchEngine.search() type = ");
        ((StringBuilder)localObject2).append(this.l);
        ((StringBuilder)localObject2).append(" ; cost time : ");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append(" ; size = ");
        ((StringBuilder)localObject2).append(paramSearchRequest.size());
        ((StringBuilder)localObject2).append(" ; keyword = ");
        ((StringBuilder)localObject2).append((String)???);
        QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
        if (a)
        {
          i1 = 0;
          while (i1 < this.v.length)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ContactSearchEngine.search() type = ");
            ((StringBuilder)localObject2).append(this.v[i1].e);
            ((StringBuilder)localObject2).append(" ; cost time : ");
            ((StringBuilder)localObject2).append(this.v[i1].d);
            ((StringBuilder)localObject2).append(" ; size = ");
            ((StringBuilder)localObject2).append(this.v[i1].c);
            ((StringBuilder)localObject2).append(" ; keyword = ");
            ((StringBuilder)localObject2).append((String)???);
            QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
            i1 += 1;
          }
        }
      }
      this.r = (l2 - l1);
      this.s = paramSearchRequest.size();
      ??? = new HashMap();
      ((HashMap)???).put("result_size", String.valueOf(paramSearchRequest.size()));
      i1 = 0;
      while (i1 < 5)
      {
        if (i1 < paramSearchRequest.size())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("result_top_");
          ((StringBuilder)localObject2).append(i1);
          ((HashMap)???).put(((StringBuilder)localObject2).toString(), String.valueOf(((IContactSearchModel)paramSearchRequest.get(i1)).u()));
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("result_top_");
          ((StringBuilder)localObject2).append(i1);
          ((HashMap)???).put(((StringBuilder)localObject2).toString(), "0");
        }
        i1 += 1;
      }
      this.c = false;
      localObject2 = paramSearchRequest.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
        ((IContactSearchModel)localObject3).v = ((HashMap)???);
        if ("9970".equals(((IContactSearchModel)localObject3).c())) {
          this.c = true;
        }
      }
      return paramSearchRequest;
    }
    for (;;)
    {
      throw paramSearchRequest;
    }
  }
  
  private List<IContactSearchModel> b(ContactSearchEngine.CancelFlag paramCancelFlag)
  {
    int i1 = this.j;
    if (((i1 & 0x10000) == 0) && ((i1 & 0x20000) == 0) && ((i1 & 0x200000) == 0) && ((i1 & 0x400000) == 0)) {
      return null;
    }
    String str = this.k;
    Object localObject2 = a(str, true);
    if ((localObject2 != null) && (((List)localObject2).size() < 100))
    {
      ??? = localObject2;
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("searchTroopMember use cache, keyword = ");
        ((StringBuilder)???).append(str);
        QLog.d("ContactSearchEngine", 2, ((StringBuilder)???).toString());
        ??? = localObject2;
      }
    }
    long l1;
    do
    {
      localObject2 = ???;
      break;
      localObject2 = new ArrayList();
      l1 = System.currentTimeMillis();
      ??? = localObject2;
    } while (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).bEnableFtsTroop());
    ??? = (IFTSTroopInterface)((IFTSDBRuntimeService)this.b.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
    Object localObject3 = new QueryArgs.Builder(this.b).a(1).a(str).a().a();
    if (paramCancelFlag.a())
    {
      if (QLog.isColorLevel())
      {
        paramCancelFlag = new StringBuilder();
        paramCancelFlag.append("searchTroopMember canceled, keyword = ");
        paramCancelFlag.append(str);
        QLog.d("ContactSearchEngine", 2, paramCancelFlag.toString());
      }
      return null;
    }
    long l2 = System.currentTimeMillis() - l1;
    int i4 = b(131072);
    this.v[i4].d = (l2 * 1000000L);
    this.y = l2;
    this.x = ((IFTSTroopInterface)???).a(false);
    if (localObject3 != null) {
      i1 = ((List)localObject3).size();
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("ContactSearchEngine.TroopGlobalquery cost time : ");
      ((StringBuilder)???).append(l2);
      ((StringBuilder)???).append("; size : ");
      ((StringBuilder)???).append(i1);
      ((StringBuilder)???).append("; keyWord: ");
      ((StringBuilder)???).append(str);
      QLog.d("ContactSearchEngine", 2, ((StringBuilder)???).toString());
    }
    int i2 = this.j;
    if (((i2 & 0x10000) == 0) && ((i2 & 0x20000) == 0)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      ??? = new ArrayList();
      int i3 = 0;
      Object localObject4;
      while (i3 < ((List)localObject3).size())
      {
        if (paramCancelFlag.a())
        {
          if (QLog.isColorLevel())
          {
            paramCancelFlag = new StringBuilder();
            paramCancelFlag.append("searchTroopMember canceled, keyword = ");
            paramCancelFlag.append(str);
            QLog.d("ContactSearchEngine", 2, paramCancelFlag.toString());
          }
          return null;
        }
        localObject4 = (TroopIndex)((List)localObject3).get(i3);
        if (SearchUtils.h(this.b, String.valueOf(((TroopIndex)localObject4).mTroopUin)) != 3) {
          if (i2 != 0) {
            ((List)???).add(localObject4);
          } else if (a(String.valueOf(((TroopIndex)localObject4).mTroopUin)).isNewTroop()) {
            ((List)???).add(localObject4);
          }
        }
        i3 += 1;
      }
      if (((List)???).size() > 0)
      {
        i2 = this.j;
        if (((i2 & 0x20000) == 0) && ((i2 & 0x400000) == 0))
        {
          i2 = 0;
        }
        else
        {
          localObject3 = new ArrayList();
          this.b.getCurrentAccountUin();
          i2 = 0;
          while (i2 < ((List)???).size())
          {
            if (paramCancelFlag.a())
            {
              if (QLog.isColorLevel())
              {
                paramCancelFlag = new StringBuilder();
                paramCancelFlag.append("searchTroopMember canceled, keyword = ");
                paramCancelFlag.append(str);
                QLog.d("ContactSearchEngine", 2, paramCancelFlag.toString());
              }
              return null;
            }
            localObject4 = (TroopIndex)((List)???).get(i2);
            if (!"50000000".equals(((TroopIndex)localObject4).mMemberUin)) {
              if (!a(String.valueOf(((TroopIndex)localObject4).mTroopUin)).isNewTroop()) {
                ((List)localObject3).add(new ContactSearchModelGlobalTroopMember(this.b, this.m, ((TroopIndex)localObject4).mTroopUin, ((TroopIndex)localObject4).mMemberUin, ((TroopIndex)localObject4).mMemberCard, ((TroopIndex)localObject4).mMemberName));
              } else {
                ((List)localObject3).add(new ContactSearchModelNewTroopMember(this.b, this.m, ((TroopIndex)localObject4).mTroopUin, ((TroopIndex)localObject4).mMemberUin, ((TroopIndex)localObject4).mMemberCard, ((TroopIndex)localObject4).mMemberName));
              }
            }
            i2 += 1;
          }
          ((List)localObject2).addAll((Collection)localObject3);
          i2 = 0 + ((List)localObject3).size();
        }
        i3 = this.j;
        if (((0x10000 & i3) == 0) && ((i3 & 0x200000) == 0)) {
          break label1292;
        }
        localObject3 = new ArrayList();
        localObject4 = new HashMap();
        i3 = 0;
        Object localObject5;
        while (i3 < ((List)???).size())
        {
          if (paramCancelFlag.a())
          {
            if (QLog.isColorLevel())
            {
              paramCancelFlag = new StringBuilder();
              paramCancelFlag.append("searchTroopMember canceled, keyword = ");
              paramCancelFlag.append(str);
              QLog.d("ContactSearchEngine", 2, paramCancelFlag.toString());
            }
            return null;
          }
          localObject5 = (TroopIndex)((List)???).get(i3);
          ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = new ContactSearchModelGlobalTroop.TroopSearchMemberInfo(((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberNick);
          ArrayList localArrayList;
          if (!((HashMap)localObject4).containsKey(((TroopIndex)localObject5).mTroopUin))
          {
            localArrayList = new ArrayList();
            localArrayList.add(localTroopSearchMemberInfo);
            ((HashMap)localObject4).put(((TroopIndex)localObject5).mTroopUin, localArrayList);
          }
          else
          {
            localArrayList = (ArrayList)((HashMap)localObject4).get(((TroopIndex)localObject5).mTroopUin);
            localArrayList.add(localTroopSearchMemberInfo);
            ((HashMap)localObject4).put(((TroopIndex)localObject5).mTroopUin, localArrayList);
          }
          i3 += 1;
        }
        ??? = ((HashMap)localObject4).keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject5 = (String)((Iterator)???).next();
          if (!a(String.valueOf(localObject5)).isNewTroop()) {
            ((List)localObject3).add(new ContactSearchModelGlobalTroop(this.b, this.m, (String)localObject5, (List)((HashMap)localObject4).get(localObject5)));
          } else {
            ((List)localObject3).add(new ContactSearchModelNewTroop(this.b, this.m, (String)localObject5, (List)((HashMap)localObject4).get(localObject5)));
          }
        }
        ((List)localObject2).addAll((Collection)localObject3);
        i2 += ((List)localObject3).size();
        break label1292;
      }
    }
    i2 = 0;
    label1292:
    l2 = System.currentTimeMillis() - l1 - l2;
    ??? = this.v;
    ???[i4].c = i2;
    ???[i4].b = l2;
    this.z = (System.currentTimeMillis() - l1);
    this.w = i1;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("ContactSearchEngine.troopGlobalDataProcess cost time : ");
      ((StringBuilder)???).append(l2);
      ((StringBuilder)???).append("; size : ");
      ((StringBuilder)???).append(i2);
      ((StringBuilder)???).append("; keyWord: ");
      ((StringBuilder)???).append(str);
      QLog.d("ContactSearchEngine", 2, ((StringBuilder)???).toString());
    }
    localObject3 = new ArrayList();
    i1 = 0;
    while (i1 < ((List)localObject2).size())
    {
      if (paramCancelFlag.a())
      {
        if (QLog.isColorLevel())
        {
          paramCancelFlag = new StringBuilder();
          paramCancelFlag.append("searchTroopMember canceled, keyword = ");
          paramCancelFlag.append(str);
          QLog.d("ContactSearchEngine", 2, paramCancelFlag.toString());
        }
        return null;
      }
      synchronized ((IContactSearchModel)((List)localObject2).get(i1))
      {
        ((IContactSearchModel)???).d(str);
        if (((IContactSearchModel)???).u() != -9223372036854775808L) {
          ((List)localObject3).add(???);
        }
        i1 += 1;
      }
    }
    if (((List)localObject3).size() < 100) {
      a(str, (List)localObject3, true);
    }
    return localObject3;
  }
  
  private int c(String paramString)
  {
    paramString = (Integer)this.A.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private List<IContactSearchModel> c(SearchRequest paramSearchRequest)
  {
    ContactSearchEngine.CancelFlag localCancelFlag = new ContactSearchEngine.CancelFlag(this, false);
    synchronized (this.E)
    {
      this.D.add(new WeakReference(localCancelFlag));
      this.k = paramSearchRequest.a;
      return b(localCancelFlag);
    }
  }
  
  private ArrayList<Friends> d(String paramString)
  {
    try
    {
      paramString = (ArrayList)((IFriendDataService)this.b.getRuntimeService(IFriendDataService.class, "")).getFriendList(Integer.parseInt(paramString));
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return new ArrayList();
  }
  
  private boolean e(String paramString)
  {
    return ((IFriendDataService)this.b.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString);
  }
  
  private Friends f(String paramString)
  {
    return ((IFriendDataService)this.b.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
  }
  
  private void i()
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((IRecentUserProxyService)((AppInterface)localObject1).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int i3 = 0;
    Object localObject3 = ((RecentUserProxy)localObject1).a(true, true, false);
    Object localObject2 = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopAssistantSearchInfos(this.b);
    if (localObject3 != null) {
      i2 = ((List)localObject3).size();
    } else {
      i2 = 0;
    }
    if (localObject2 != null) {
      i1 = ((List)localObject2).size();
    } else {
      i1 = 0;
    }
    localObject1 = new ArrayList(i2 + i1);
    ((List)localObject1).addAll((Collection)localObject3);
    int i2 = 0;
    while (i2 < i1)
    {
      localObject3 = new RecentUser();
      ((RecentUser)localObject3).uin = ((TroopAssistantSearchInfo)((List)localObject2).get(i2)).a;
      ((RecentUser)localObject3).lastmsgtime = ((TroopAssistantSearchInfo)((List)localObject2).get(i2)).b;
      ((List)localObject1).add(localObject3);
      i2 += 1;
    }
    Collections.sort((List)localObject1, f);
    i2 = ((List)localObject1).size();
    int i1 = i3;
    while ((i1 < i2) && (i1 < 999))
    {
      localObject2 = (RecentUser)((List)localObject1).get(i1);
      this.A.put(((RecentUser)localObject2).uin, Integer.valueOf(999 - i1));
      i1 += 1;
    }
  }
  
  private List<Groups> j()
  {
    return ((IFriendDataService)this.b.getRuntimeService(IFriendDataService.class, "")).getGroupList();
  }
  
  private Map<String, ArrayList<DiscussionMemberInfo>> k()
  {
    m();
    return this.h;
  }
  
  private List<ArrayList<DiscussionMemberInfo>> l()
  {
    m();
    return this.i;
  }
  
  private void m()
  {
    try
    {
      if (this.h == null)
      {
        Object localObject2 = (ArrayList)((IDiscussionService)this.b.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
        String[] arrayOfString = new String[((List)localObject2).size()];
        localObject2 = ((List)localObject2).iterator();
        int i2 = 0;
        int i1 = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DiscussionInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((DiscussionInfo)localObject3).uin != null) && (((DiscussionInfo)localObject3).uin.length() > 0))
          {
            arrayOfString[i1] = ((DiscussionInfo)localObject3).uin;
            i1 += 1;
          }
        }
        localObject2 = (Map)((IDiscussionService)this.b.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberMapByUins(arrayOfString);
        Object localObject3 = new ArrayList(arrayOfString.length);
        int i3 = arrayOfString.length;
        i1 = i2;
        while (i1 < i3)
        {
          ((List)localObject3).add((ArrayList)((Map)localObject2).get(arrayOfString[i1]));
          i1 += 1;
        }
        this.h = ((Map)localObject2);
        this.i = ((List)localObject3);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  TroopInfo a(String paramString)
  {
    return ((ITroopInfoService)this.b.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  protected List<IContactSearchModel> a(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      localObject1 = this.v;
      if (i1 >= localObject1.length) {
        break;
      }
      localObject1[i1].c = 0;
      localObject1[i1].b = 0L;
      i1 += 1;
    }
    i();
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = "";
    long l1;
    Object localObject2;
    long l2;
    if ((paramInt & 0x20) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = ((IRecentUserProxyService)this.b.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(false);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((RecentUser)localObject4).uin)) && (!"50000000".equals(((RecentUser)localObject4).uin)))
          {
            i1 = ((RecentUser)localObject4).getType();
            if (i1 != 1000) {
              switch (i1)
              {
              default: 
                break;
              }
            } else if (!e(((RecentUser)localObject4).uin)) {
              ((List)localObject1).add(new ContactSearchModelRecentUser(this.b, this.m, (RecentUser)localObject4, c(((RecentUser)localObject4).uin)));
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(32);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject1).size();
    }
    Object localObject5;
    Object localObject6;
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject5 = new ArrayList();
      this.b.getCurrentAccountUin();
      localObject1 = j();
      if (localObject1 != null) {
        for (localObject1 = ((List)localObject1).iterator(); ((Iterator)localObject1).hasNext(); localObject1 = localObject2)
        {
          localObject4 = (Groups)((Iterator)localObject1).next();
          localObject6 = d(String.valueOf(((Groups)localObject4).group_id));
          localObject2 = localObject1;
          if (localObject6 != null)
          {
            localObject6 = ((List)localObject6).iterator();
            for (;;)
            {
              localObject2 = localObject1;
              if (!((Iterator)localObject6).hasNext()) {
                break;
              }
              localFriends = (Friends)((Iterator)localObject6).next();
              if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).filterQidianMasterSearch(this.b, localFriends, this.m))
              {
                AppInterface localAppInterface = this.b;
                i1 = this.m;
                if (localFriends.gathtertype == 1) {
                  localObject2 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(2131917726);
                } else {
                  localObject2 = ((Groups)localObject4).group_name;
                }
                ((List)localObject5).add(new ContactSearchModelFriend(localAppInterface, i1, localFriends, (String)localObject2, c(localFriends.uin)));
              }
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject5);
      l2 = System.currentTimeMillis();
      i1 = b(1);
      localObject1 = this.v;
      localObject1[i1].b = (l2 - l1);
      localObject1[i1].c = ((List)localObject5).size();
    }
    if ((0x2000000 & paramInt) != 0)
    {
      localObject1 = (IGameMsgBoxManager)this.b.getRuntimeService(IGameMsgBoxManager.class, "");
      localObject4 = ((IGameMsgBoxManager)localObject1).getGameMsgBoxRecentUsers();
      localObject2 = new ArrayList();
      if (localObject4 != null)
      {
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (RecentUser)((Iterator)localObject4).next();
          localObject6 = ((IGameMsgBoxManager)localObject1).findGameDetailInfoByConvertUin(((RecentUser)localObject5).uin);
          if (localObject6 != null) {
            ((List)localObject2).add(new ContactSearchModelGameMsgBox(this.b, this.m, c(((RecentUser)localObject5).uin), ((RecentUser)localObject5).uin, (GameDetailInfo)localObject6));
          }
        }
      }
      localArrayList.addAll((Collection)localObject2);
    }
    if ((0x800000 & paramInt) != 0) {
      a(localArrayList);
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IPhoneContactService)localObject2).getContactListForDisplay();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = (List)((List)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.b, this.m, (PhoneContact)localObject4));
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(768);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IPhoneContactService)localObject2).getContactListForDisplay();
        if ((localObject2 != null) && (((List)localObject2).size() > 1))
        {
          localObject2 = (List)((List)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.b, this.m, (PhoneContact)localObject4));
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(768);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IPhoneContactService)localObject2).getContactListForPhoneSelector();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.b, this.m, (PhoneContact)localObject4));
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(768);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IPhoneContactService)localObject2).getContactListForSelector();
        if ((localObject2 != null) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.b, this.m, (PhoneContact)localObject4));
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(768);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = l();
      localObject4 = new HashSet();
      this.b.getCurrentAccountUin();
      i1 = 0;
      while (i1 < ((List)localObject2).size())
      {
        int i2 = 0;
        while (i2 < ((ArrayList)((List)localObject2).get(i1)).size())
        {
          localObject5 = (DiscussionMemberInfo)((ArrayList)((List)localObject2).get(i1)).get(i2);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(((DiscussionMemberInfo)localObject5).memberUin);
          ((StringBuilder)localObject6).append(((DiscussionMemberInfo)localObject5).inteRemark);
          ((StringBuilder)localObject6).append(((DiscussionMemberInfo)localObject5).memberName);
          localObject6 = ((StringBuilder)localObject6).toString();
          if (!((Set)localObject4).contains(localObject6))
          {
            localFriends = f(((DiscussionMemberInfo)localObject5).memberUin);
            if ((localFriends == null) || (!localFriends.isFriend()))
            {
              ((Set)localObject4).add(localObject6);
              ((List)localObject1).add(new ContactSearchModelDiscussionMember(this.b, this.m, (DiscussionMemberInfo)localObject5));
            }
          }
          i2 += 1;
        }
        i1 += 1;
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = b(4);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject1).size();
    }
    Object localObject4 = null;
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = (ArrayList)((IDiscussionService)this.b.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
      if (localObject1 != null)
      {
        localObject5 = ((List)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (DiscussionInfo)((Iterator)localObject5).next();
          localObject1 = k();
          if (localObject1 != null) {
            localObject1 = (List)((Map)localObject1).get(((DiscussionInfo)localObject6).uin);
          } else {
            localObject1 = null;
          }
          ((List)localObject2).add(new ContactSearchModelDiscussion(this.b, this.m, (DiscussionInfo)localObject6, (List)localObject1, c(((DiscussionInfo)localObject6).uin)));
        }
      }
      localArrayList.addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i1 = b(8);
      localObject1 = this.v;
      localObject1[i1].b = (l2 - l1);
      localObject1[i1].c = ((List)localObject2).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject5 = new ArrayList();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).initAssistTroopCache(this.b);
      localObject2 = g();
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject6 = ((List)localObject2).iterator();
        localObject2 = localObject3;
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject1 = (TroopInfo)((Iterator)localObject6).next();
          ((List)localObject5).add(new ContactSearchModelTroop(this.b, this.m, (TroopInfo)localObject1, c(((TroopInfo)localObject1).troopuin)));
        }
      }
      localArrayList.addAll((Collection)localObject5);
      l2 = System.currentTimeMillis();
      i1 = b(16);
      localObject2 = this.v;
      localObject2[i1].b = (l2 - l1);
      localObject2[i1].c = ((List)localObject5).size();
    }
    else
    {
      localObject1 = "";
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9993L), 6000, c(String.valueOf(9993L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9973L), 9002, c(String.valueOf(9973L))));
      if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()))
      {
        ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(AppConstants.KANDIAN_MERGE_UIN), 7220, c(String.valueOf(AppConstants.KANDIAN_MERGE_UIN))));
      }
      else
      {
        ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9975L), 7210, c(String.valueOf(9975L))));
        if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) {
          ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, AppConstants.NEW_KANDIAN_UIN, 1008, c(String.valueOf(AppConstants.NEW_KANDIAN_UIN))));
        }
      }
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9970L), 7120, c(String.valueOf(9970L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230, c(String.valueOf(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN))));
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9980L), 9000, c(String.valueOf(9980L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9994L), 5000, c(String.valueOf(9994L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9992L), 7000, c(String.valueOf(9992L))));
      if (((IBlessApi)QRoute.api(IBlessApi.class)).isSearchable(this.b))
      {
        ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(9960L), 9003, c(String.valueOf(9960L))));
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is added.");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
      }
      ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN), 4000, c(String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN))));
      localObject3 = ((IRecentUserProxyService)this.b.getRuntimeService(IRecentUserProxyService.class, (String)localObject1)).getRecentUserCache().a(true);
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (RecentUser)((Iterator)localObject3).next();
          i1 = ((RecentUser)localObject5).getType();
          if (((i1 == 1001) || (i1 == 5000) || (i1 == 7000) || (i1 == 7120) || (i1 == 7230) || (i1 == 9000) || (i1 == 10002) || (i1 == 10004)) && (!TextUtils.isEmpty(((RecentUser)localObject5).uin))) {
            ((List)localObject2).add(new ContactSearchModelTool(this.b, this.m, ((RecentUser)localObject5).uin, ((RecentUser)localObject5).getType(), c(((RecentUser)localObject5).uin)));
          }
        }
      }
      localArrayList.addAll((Collection)localObject2);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject3 = new ArrayList();
      localObject5 = k();
      localObject2 = localObject4;
      if (localObject5 != null) {
        localObject2 = (List)((Map)localObject5).get(this.n);
      }
      if (localObject2 != null)
      {
        this.b.getCurrentAccountUin();
        i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          localObject4 = (DiscussionMemberInfo)((List)localObject2).get(i1);
          ((List)localObject3).add(new ContactSearchModelDiscussionMember(this.b, this.m, (DiscussionMemberInfo)localObject4));
          i1 += 1;
        }
        localArrayList.addAll((Collection)localObject3);
      }
    }
    if (((paramInt & 0x2000) != 0) || ((paramInt & 0x40000) != 0) || ((0x100000 & paramInt) != 0))
    {
      localObject4 = new ArrayList();
      localObject2 = this.b.getEntityManagerFactory().createEntityManager();
      this.b.getCurrentAccountUin();
      localObject3 = ((EntityManager)localObject2).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.n }, null, null, null, null);
      localObject5 = b(this.n);
      if (localObject5 == null) {
        localObject2 = localObject1;
      } else {
        localObject2 = ((TroopInfo)localObject5).troopcode;
      }
      if (localObject3 != null)
      {
        localObject6 = ((List)localObject3).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject3 = (TroopMemberInfo)((Iterator)localObject6).next();
          if ((Utils.e(((TroopMemberInfo)localObject3).memberuin)) && (((paramInt & 0x40000) == 0) || (localObject5 == null) || (((TroopInfo)localObject5).isTroopAdmin(((TroopMemberInfo)localObject3).memberuin)) || (((TroopInfo)localObject5).isTroopOwner(((TroopMemberInfo)localObject3).memberuin))))
          {
            if ((0x100000 & paramInt) != 0) {
              localObject3 = new TroopBatchAddFrdsSearchModelMember(this.b, this.m, (TroopMemberInfo)localObject3, (String)localObject2);
            } else {
              localObject3 = new ContactSearchModelTroopMember(this.b, this.m, (TroopMemberInfo)localObject3);
            }
            ((List)localObject4).add(localObject3);
          }
        }
      }
      localArrayList.addAll((Collection)localObject4);
    }
    if ((paramInt & 0x80000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = ((IPhoneContactService)this.b.getRuntimeService(IPhoneContactService.class, (String)localObject1)).getBindAllFriendList();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (PhoneContact)((Iterator)localObject1).next();
          ((List)localObject2).add(new ContactSearchModelPhoneContact(this.b, this.m, (PhoneContact)localObject3));
        }
      }
      localArrayList.addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      paramInt = b(768);
      localObject1 = this.v;
      localObject1[paramInt].b = (l2 - l1);
      localObject1[paramInt].c = ((List)localObject2).size();
    }
    Object localObject1 = this.o;
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
    {
      localObject2 = new ArrayList();
      localObject3 = localArrayList.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (IContactSearchModel)((Iterator)localObject3).next();
        if (!this.o.contains(((IContactSearchModel)localObject1).c())) {
          ((List)localObject2).add(localObject1);
        }
      }
    }
    localObject1 = localArrayList;
    return localObject1;
  }
  
  public List<IContactSearchModel> a(SearchRequest paramSearchRequest)
  {
    Object localObject = paramSearchRequest.b;
    boolean bool3 = false;
    boolean bool1;
    boolean bool2;
    if (localObject != null)
    {
      bool1 = paramSearchRequest.b.getBoolean("searchCreateDiscussion", false);
      bool2 = paramSearchRequest.b.getBoolean("searchTroopMember", false);
    }
    else
    {
      bool1 = false;
      bool2 = false;
    }
    if (this.j == 64)
    {
      bool1 = false;
      bool2 = bool3;
    }
    if (bool1)
    {
      localObject = this.p;
      if (localObject != null) {
        return ((CreateDiscussionSearchEngine)localObject).a(paramSearchRequest);
      }
      return new ArrayList();
    }
    if (bool2) {
      return c(paramSearchRequest);
    }
    return b(paramSearchRequest);
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.g = a(this.j);
    if (this.q)
    {
      this.p = new CreateDiscussionSearchEngine(this.b, this.m);
      this.p.a();
    }
    long l2 = System.currentTimeMillis();
    boolean bool = QLog.isColorLevel();
    int i2 = 0;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ContactSearchEngine.init() type = ");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(" ; cost time : ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" ; size = ");
      ((StringBuilder)localObject).append(this.g.size());
      QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject).toString());
      if (a)
      {
        i1 = 0;
        while (i1 < this.v.length)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ContactSearchEngine.init() type = ");
          ((StringBuilder)localObject).append(this.v[i1].e);
          ((StringBuilder)localObject).append(" ; cost time : ");
          ((StringBuilder)localObject).append(this.v[i1].b);
          ((StringBuilder)localObject).append(" ; size = ");
          ((StringBuilder)localObject).append(this.v[i1].c);
          QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject).toString());
          i1 += 1;
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("type", this.l);
    int i1 = i2;
    while (i1 < this.v.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time_");
      localStringBuilder.append(this.v[i1].e);
      ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(this.v[i1].b));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("size_");
      localStringBuilder.append(this.v[i1].e);
      ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(this.v[i1].c));
      i1 += 1;
    }
    StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.b.getCurrentAccountUin(), "ContactSearchEngineInit", true, l2 - l1, this.g.size(), (HashMap)localObject, "", false);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<IContactSearchModel> paramISearchListener)
  {
    this.F = paramISearchListener;
    ThreadManager.postImmediately(new ContactSearchEngine.4(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List<IContactSearchModel> paramList1, List<IContactSearchModel> paramList2, ContactSearchEngine.CancelFlag arg3, String paramString)
  {
    ContactSearchEngine.CancelFlag localCancelFlag = ???;
    if (??? == null)
    {
      localCancelFlag = new ContactSearchEngine.CancelFlag(this, false);
      synchronized (this.E)
      {
        this.D.add(new WeakReference(localCancelFlag));
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
          QLog.d("ContactSearchEngine", 2, paramList1.toString());
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
          QLog.d("ContactSearchEngine", 2, paramList1.toString());
        }
        return true;
      }
      localIContactSearchModel1 = (IContactSearchModel)localIContactSearchModel1.clone();
      if (localIContactSearchModel1 != null) {
        paramList1.add(localIContactSearchModel1);
      }
    }
    try
    {
      Collections.sort(paramList1, d);
      label313:
      int i1 = Math.min(paramList1.size(), 30);
      ??? = paramList1.subList(0, i1);
      paramString = f();
      if (paramString == null) {
        Collections.sort(???, e);
      }
      paramList2.addAll(???);
      paramList2.addAll(paramList1.subList(i1, paramList1.size()));
      if (paramString != null) {
        Collections.sort(paramList2, paramString);
      }
      return false;
    }
    catch (Throwable ???)
    {
      break label313;
    }
  }
  
  TroopInfo b(String paramString)
  {
    return ((ITroopInfoService)this.b.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  public void b()
  {
    synchronized (this.E)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.D.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        ContactSearchEngine.CancelFlag localCancelFlag = (ContactSearchEngine.CancelFlag)localWeakReference.get();
        if (localCancelFlag != null)
        {
          localCancelFlag.a(true);
          localArrayList.add(localWeakReference);
        }
      }
      this.D = localArrayList;
      ??? = this.p;
      if (??? != null) {
        ((CreateDiscussionSearchEngine)???).b();
      }
      this.F = null;
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
    if (this.r != -1L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.l);
      String str = this.k;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("keyword", localObject);
      localHashMap.put("totalSize", String.valueOf(this.t));
      int i1 = 0;
      while (i1 < this.v.length)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("time_");
        ((StringBuilder)localObject).append(this.v[i1].e);
        localHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(this.v[i1].d));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("size_");
        ((StringBuilder)localObject).append(this.v[i1].e);
        localHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(this.v[i1].c));
        i1 += 1;
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.y));
      localHashMap.put("size_global_troop_member", String.valueOf(this.w));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.z));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.x));
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.b.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.r, this.s, localHashMap, "", false);
      if (this.c)
      {
        ReportController.b(this.b, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.c = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troopMemberSearchTime = ");
        ((StringBuilder)localObject).append(this.z);
        ((StringBuilder)localObject).append(" ; troopMemberQueryTime = ");
        ((StringBuilder)localObject).append(this.y);
        ((StringBuilder)localObject).append(" ; troopMemberTotalSize = ");
        ((StringBuilder)localObject).append(this.x);
        ((StringBuilder)localObject).append(" ; troopMemberResultSize = ");
        ((StringBuilder)localObject).append(this.w);
        QLog.d("ContactSearchEngineSearch", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.u > 0) {
      new ReportTask(this.b).a("dc00899").b("Grp_listNew").c("search_result").d("exp_grp").a(new String[] { String.valueOf(this.u) }).a();
    }
  }
  
  public Comparator<IContactSearchModel> f()
  {
    return null;
  }
  
  ArrayList<Entity> g()
  {
    return ((ITroopInfoService)this.b.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
  }
  
  public int h()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ContactSearchEngine
 * JD-Core Version:    0.7.0.1
 */