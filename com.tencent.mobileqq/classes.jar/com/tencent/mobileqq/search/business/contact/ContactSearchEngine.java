package com.tencent.mobileqq.search.business.contact;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
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
  private static final Comparator<IContactSearchModel> jdField_a_of_type_JavaUtilComparator = new ContactSearchEngine.1();
  public static boolean a = false;
  private static final Comparator<IContactSearchModel> jdField_b_of_type_JavaUtilComparator = new ContactSearchEngine.2();
  private static final Comparator<RecentUser> jdField_c_of_type_JavaUtilComparator = new ContactSearchEngine.3();
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  protected AppInterface a;
  private ISearchListener<IContactSearchModel> jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
  private CreateDiscussionSearchEngine jdField_a_of_type_ComTencentMobileqqSearchBusinessContactCreateDiscussionSearchEngine;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List<IContactSearchModel> jdField_a_of_type_JavaUtilList;
  private Map<String, ArrayList<DiscussionMemberInfo>> jdField_a_of_type_JavaUtilMap;
  private Queue<ContactSearchEngine.SearchResultCache> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ContactSearchEngine.TypedReportInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo = { new ContactSearchEngine.TypedReportInfo(1, "friend"), new ContactSearchEngine.TypedReportInfo(768, "phone_contact"), new ContactSearchEngine.TypedReportInfo(4, "discussion_member"), new ContactSearchEngine.TypedReportInfo(8, "discussion"), new ContactSearchEngine.TypedReportInfo(16, "troop"), new ContactSearchEngine.TypedReportInfo(32, "recent_user"), new ContactSearchEngine.TypedReportInfo(64, "tool"), new ContactSearchEngine.TypedReportInfo(2048, "circle_buddy"), new ContactSearchEngine.TypedReportInfo(131072, "global_troop_member"), new ContactSearchEngine.TypedReportInfo(8388608, "qcircle_friends"), new ContactSearchEngine.TypedReportInfo(16777216, "qcircle_official_account") };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private List<ArrayList<DiscussionMemberInfo>> jdField_b_of_type_JavaUtilList;
  private Queue<ContactSearchEngine.SearchResultCache> jdField_b_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private List<WeakReference<ContactSearchEngine.CancelFlag>> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private long d = -1L;
  private long e = -1L;
  private long f = -1L;
  private long g = -1L;
  
  public ContactSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_c_of_type_JavaLangString = paramString;
    if (paramInt2 != 29)
    {
      if (paramInt2 == 197437) {
        this.jdField_b_of_type_JavaLangString = "people";
      }
    }
    else {
      this.jdField_b_of_type_JavaLangString = "msg";
    }
    if (SearchUtils.a(paramInt1)) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public ContactSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(int paramInt)
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
  
  private int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private Friends a(String paramString)
  {
    return ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
  }
  
  private ArrayList<Friends> a(String paramString)
  {
    try
    {
      paramString = (ArrayList)((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriendList(Integer.parseInt(paramString));
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return new ArrayList();
  }
  
  private List<Groups> a()
  {
    return ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getGroupList();
  }
  
  private List<IContactSearchModel> a(ContactSearchEngine.CancelFlag paramCancelFlag)
  {
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      if (i >= localObject1.length) {
        break;
      }
      if (!"global_troop_member".equals(Integer.valueOf(localObject1[i].jdField_a_of_type_Int))) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long = -1L;
      }
      i += 1;
    }
    String str = this.jdField_a_of_type_JavaLangString;
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
      localObject1 = this.jdField_a_of_type_JavaUtilList;
    }
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new ArrayList();
    i = 0;
    while (i < ((List)localObject1).size())
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
      IContactSearchModel localIContactSearchModel = (IContactSearchModel)((List)localObject1).get(i);
      long l1 = System.nanoTime();
      try
      {
        localIContactSearchModel.b(str);
        long l2 = System.nanoTime();
        int j = a(localIContactSearchModel);
        if (j != -1)
        {
          ContactSearchEngine.TypedReportInfo localTypedReportInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[j];
          localTypedReportInfo.jdField_b_of_type_Long += l2 - l1;
        }
        if (localIContactSearchModel.b() != -9223372036854775808L) {
          ((List)localObject2).add(localIContactSearchModel);
        }
        i += 1;
      }
      finally {}
    }
    i = 0;
    for (;;)
    {
      paramCancelFlag = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      if (i >= paramCancelFlag.length) {
        break;
      }
      paramCancelFlag[i].jdField_b_of_type_Long /= 1000000L;
      i += 1;
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
          localObject1 = this.jdField_b_of_type_JavaUtilQueue;
        } else {
          localObject1 = this.jdField_a_of_type_JavaUtilQueue;
        }
        Iterator localIterator = ((Queue)localObject1).iterator();
        Object localObject1 = null;
        int i = -2147483648;
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (ContactSearchEngine.SearchResultCache)localIterator.next();
          if ((paramString.startsWith(((ContactSearchEngine.SearchResultCache)localObject2).jdField_a_of_type_JavaLangString)) && (((ContactSearchEngine.SearchResultCache)localObject2).jdField_a_of_type_JavaLangString.length() > i))
          {
            i = ((ContactSearchEngine.SearchResultCache)localObject2).jdField_a_of_type_JavaLangString.length();
            localObject1 = localObject2;
          }
        }
        if ((localObject1 != null) && (((ContactSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getBestCache hit cache, cur keyword = ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" , cache keyword = ");
            ((StringBuilder)localObject2).append(((ContactSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(" , cache size = ");
            ((StringBuilder)localObject2).append(((ContactSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaUtilList.size());
            QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = ((ContactSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaUtilList;
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
  
  private Map<String, ArrayList<DiscussionMemberInfo>> a()
  {
    g();
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  private void a(String paramString, List<IContactSearchModel> paramList, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")) && (paramList != null))
      {
        Queue localQueue;
        if (paramBoolean) {
          localQueue = this.jdField_b_of_type_JavaUtilQueue;
        } else {
          localQueue = this.jdField_a_of_type_JavaUtilQueue;
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
              if (localSearchResultCache.jdField_a_of_type_JavaUtilList.isEmpty()) {
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
            localArrayList.add(new ContactSearchModelFriend(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (Friends)localObject3, str, a(((Friends)localObject3).uin)));
          }
        }
      }
    }
    paramList.addAll(localArrayList);
  }
  
  private boolean a(String paramString)
  {
    return ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString);
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i;
    if ((paramIContactSearchModel2.c() != null) && (paramIContactSearchModel1.c() != null)) {
      i = paramIContactSearchModel2.c().toString().compareTo(paramIContactSearchModel1.c().toString());
    } else {
      i = 0;
    }
    int j = i;
    if (i == 0)
    {
      j = i;
      if (paramIContactSearchModel2.d() != null)
      {
        j = i;
        if (paramIContactSearchModel1.d() != null) {
          j = paramIContactSearchModel2.d().toString().compareTo(paramIContactSearchModel1.d().toString());
        }
      }
    }
    return j;
  }
  
  private List<ArrayList<DiscussionMemberInfo>> b()
  {
    g();
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  private List<IContactSearchModel> b(SearchRequest paramSearchRequest)
  {
    Object localObject2 = new ContactSearchEngine.CancelFlag(this, false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localObject2));
      this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      boolean bool;
      if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) {
        bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchRequestFromHome", false);
      } else {
        bool = false;
      }
      ??? = this.jdField_a_of_type_JavaLangString;
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
      this.jdField_c_of_type_Int = 0;
      int i = this.jdField_a_of_type_Int;
      if (((0x10000 & i) == 0) && ((0x20000 & i) == 0) && ((0x200000 & i) == 0) && ((0x400000 & i) == 0)) {
        i = 0;
      } else {
        i = 1;
      }
      int j = i;
      if (localObject4 != null)
      {
        j = i;
        if (i != 0)
        {
          j = i;
          if (bool)
          {
            Object localObject5 = new HashSet();
            l2 = IContactSearchable.r;
            long l3 = IContactSearchable.v;
            long l4 = IContactSearchable.V;
            Iterator localIterator = ((List)localObject4).iterator();
            for (;;)
            {
              j = i;
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
                this.jdField_c_of_type_Int += 1;
              }
              if (localIContactSearchModel.b() > l2 + l3 + l4) {
                ((Set)localObject5).add(localIContactSearchModel.a());
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
                j = 0;
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
      if ((paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) && (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.containsKey("searchTroopMember"))) {
        bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");
      } else {
        bool = true;
      }
      if (j != 0)
      {
        if (bool) {
          paramSearchRequest = b((ContactSearchEngine.CancelFlag)localObject2);
        } else {
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", true);
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
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
        if ((localObject3 instanceof ContactSearchModelGlobalTroop))
        {
          j = i + 1;
          i = j;
          if (j <= 200)
          {
            paramSearchRequest.add(localObject3);
            i = j;
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
        ((StringBuilder)localObject2).append(i);
        QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ContactSearchEngine.search() type = ");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" ; cost time : ");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append(" ; size = ");
        ((StringBuilder)localObject2).append(paramSearchRequest.size());
        ((StringBuilder)localObject2).append(" ; keyword = ");
        ((StringBuilder)localObject2).append((String)???);
        QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
        if (jdField_a_of_type_Boolean)
        {
          i = 0;
          while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo.length)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ContactSearchEngine.search() type = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(" ; cost time : ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long);
            ((StringBuilder)localObject2).append(" ; size = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int);
            ((StringBuilder)localObject2).append(" ; keyword = ");
            ((StringBuilder)localObject2).append((String)???);
            QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject2).toString());
            i += 1;
          }
        }
      }
      this.jdField_a_of_type_Long = (l2 - l1);
      this.jdField_b_of_type_Long = paramSearchRequest.size();
      ??? = new HashMap();
      ((HashMap)???).put("result_size", String.valueOf(paramSearchRequest.size()));
      i = 0;
      while (i < 5)
      {
        if (i < paramSearchRequest.size())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("result_top_");
          ((StringBuilder)localObject2).append(i);
          ((HashMap)???).put(((StringBuilder)localObject2).toString(), String.valueOf(((IContactSearchModel)paramSearchRequest.get(i)).b()));
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("result_top_");
          ((StringBuilder)localObject2).append(i);
          ((HashMap)???).put(((StringBuilder)localObject2).toString(), "0");
        }
        i += 1;
      }
      this.jdField_b_of_type_Boolean = false;
      localObject2 = paramSearchRequest.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
        ((IContactSearchModel)localObject3).a = ((HashMap)???);
        if ("9970".equals(((IContactSearchModel)localObject3).a())) {
          this.jdField_b_of_type_Boolean = true;
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
    int i = this.jdField_a_of_type_Int;
    if (((i & 0x10000) == 0) && ((i & 0x20000) == 0) && ((i & 0x200000) == 0) && ((i & 0x400000) == 0)) {
      return null;
    }
    String str = this.jdField_a_of_type_JavaLangString;
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
    ??? = (IFTSTroopInterface)((IFTSDBRuntimeService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
    Object localObject3 = new QueryArgs.Builder(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(1).a(str).a().a();
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
    int m = a(131072);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[m].jdField_b_of_type_Long = (l2 * 1000000L);
    this.f = l2;
    this.e = ((IFTSTroopInterface)???).a(false);
    if (localObject3 != null) {
      i = ((List)localObject3).size();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("ContactSearchEngine.TroopGlobalquery cost time : ");
      ((StringBuilder)???).append(l2);
      ((StringBuilder)???).append("; size : ");
      ((StringBuilder)???).append(i);
      ((StringBuilder)???).append("; keyWord: ");
      ((StringBuilder)???).append(str);
      QLog.d("ContactSearchEngine", 2, ((StringBuilder)???).toString());
    }
    int j = this.jdField_a_of_type_Int;
    if (((j & 0x10000) == 0) && ((j & 0x20000) == 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      ??? = new ArrayList();
      int k = 0;
      Object localObject4;
      while (k < ((List)localObject3).size())
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
        localObject4 = (TroopIndex)((List)localObject3).get(k);
        if (SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(((TroopIndex)localObject4).mTroopUin)) != 3) {
          if (j != 0) {
            ((List)???).add(localObject4);
          } else if (a(String.valueOf(((TroopIndex)localObject4).mTroopUin)).isNewTroop()) {
            ((List)???).add(localObject4);
          }
        }
        k += 1;
      }
      if (((List)???).size() > 0)
      {
        j = this.jdField_a_of_type_Int;
        if (((j & 0x20000) == 0) && ((j & 0x400000) == 0))
        {
          j = 0;
        }
        else
        {
          localObject3 = new ArrayList();
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
          j = 0;
          while (j < ((List)???).size())
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
            localObject4 = (TroopIndex)((List)???).get(j);
            if (!"50000000".equals(((TroopIndex)localObject4).mMemberUin)) {
              if (!a(String.valueOf(((TroopIndex)localObject4).mTroopUin)).isNewTroop()) {
                ((List)localObject3).add(new ContactSearchModelGlobalTroopMember(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject4).mTroopUin, ((TroopIndex)localObject4).mMemberUin, ((TroopIndex)localObject4).mMemberCard, ((TroopIndex)localObject4).mMemberName));
              } else {
                ((List)localObject3).add(new ContactSearchModelNewTroopMember(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject4).mTroopUin, ((TroopIndex)localObject4).mMemberUin, ((TroopIndex)localObject4).mMemberCard, ((TroopIndex)localObject4).mMemberName));
              }
            }
            j += 1;
          }
          ((List)localObject2).addAll((Collection)localObject3);
          j = 0 + ((List)localObject3).size();
        }
        k = this.jdField_a_of_type_Int;
        if (((0x10000 & k) == 0) && ((k & 0x200000) == 0)) {
          break label1297;
        }
        localObject3 = new ArrayList();
        localObject4 = new HashMap();
        k = 0;
        Object localObject5;
        while (k < ((List)???).size())
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
          localObject5 = (TroopIndex)((List)???).get(k);
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
          k += 1;
        }
        ??? = ((HashMap)localObject4).keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject5 = (String)((Iterator)???).next();
          if (!a(String.valueOf(localObject5)).isNewTroop()) {
            ((List)localObject3).add(new ContactSearchModelGlobalTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (String)localObject5, (List)((HashMap)localObject4).get(localObject5)));
          } else {
            ((List)localObject3).add(new ContactSearchModelNewTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (String)localObject5, (List)((HashMap)localObject4).get(localObject5)));
          }
        }
        ((List)localObject2).addAll((Collection)localObject3);
        j += ((List)localObject3).size();
        break label1297;
      }
    }
    j = 0;
    label1297:
    l2 = System.currentTimeMillis() - l1 - l2;
    ??? = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
    ???[m].jdField_b_of_type_Int = j;
    ???[m].jdField_a_of_type_Long = l2;
    this.g = (System.currentTimeMillis() - l1);
    this.d = i;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("ContactSearchEngine.troopGlobalDataProcess cost time : ");
      ((StringBuilder)???).append(l2);
      ((StringBuilder)???).append("; size : ");
      ((StringBuilder)???).append(j);
      ((StringBuilder)???).append("; keyWord: ");
      ((StringBuilder)???).append(str);
      QLog.d("ContactSearchEngine", 2, ((StringBuilder)???).toString());
    }
    localObject3 = new ArrayList();
    i = 0;
    while (i < ((List)localObject2).size())
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
      synchronized ((IContactSearchModel)((List)localObject2).get(i))
      {
        ((IContactSearchModel)???).b(str);
        if (((IContactSearchModel)???).b() != -9223372036854775808L) {
          ((List)localObject3).add(???);
        }
        i += 1;
      }
    }
    if (((List)localObject3).size() < 100) {
      a(str, (List)localObject3, true);
    }
    return localObject3;
  }
  
  private List<IContactSearchModel> c(SearchRequest paramSearchRequest)
  {
    ContactSearchEngine.CancelFlag localCancelFlag = new ContactSearchEngine.CancelFlag(this, false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localCancelFlag));
      this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      return b(localCancelFlag);
    }
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((IRecentUserProxyService)((AppInterface)localObject1).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int k = 0;
    Object localObject3 = ((RecentUserProxy)localObject1).a(true, true, false);
    Object localObject2 = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopAssistantSearchInfos(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localObject3 != null) {
      j = ((List)localObject3).size();
    } else {
      j = 0;
    }
    if (localObject2 != null) {
      i = ((List)localObject2).size();
    } else {
      i = 0;
    }
    localObject1 = new ArrayList(j + i);
    ((List)localObject1).addAll((Collection)localObject3);
    int j = 0;
    while (j < i)
    {
      localObject3 = new RecentUser();
      ((RecentUser)localObject3).uin = ((TroopAssistantSearchInfo)((List)localObject2).get(j)).jdField_a_of_type_JavaLangString;
      ((RecentUser)localObject3).lastmsgtime = ((TroopAssistantSearchInfo)((List)localObject2).get(j)).jdField_a_of_type_Long;
      ((List)localObject1).add(localObject3);
      j += 1;
    }
    Collections.sort((List)localObject1, jdField_c_of_type_JavaUtilComparator);
    j = ((List)localObject1).size();
    int i = k;
    while ((i < j) && (i < 999))
    {
      localObject2 = (RecentUser)((List)localObject1).get(i);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RecentUser)localObject2).uin, Integer.valueOf(999 - i));
      i += 1;
    }
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        Object localObject2 = (ArrayList)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
        String[] arrayOfString = new String[((List)localObject2).size()];
        localObject2 = ((List)localObject2).iterator();
        int j = 0;
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DiscussionInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((DiscussionInfo)localObject3).uin != null) && (((DiscussionInfo)localObject3).uin.length() > 0))
          {
            arrayOfString[i] = ((DiscussionInfo)localObject3).uin;
            i += 1;
          }
        }
        localObject2 = (Map)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberMapByUins(arrayOfString);
        Object localObject3 = new ArrayList(arrayOfString.length);
        int k = arrayOfString.length;
        i = j;
        while (i < k)
        {
          ((List)localObject3).add((ArrayList)((Map)localObject2).get(arrayOfString[i]));
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilMap = ((Map)localObject2);
        this.jdField_b_of_type_JavaUtilList = ((List)localObject3);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  TroopInfo a(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  ArrayList<Entity> a()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
  }
  
  public Comparator<IContactSearchModel> a()
  {
    return null;
  }
  
  protected List<IContactSearchModel> a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i].jdField_b_of_type_Int = 0;
      localObject1[i].jdField_a_of_type_Long = 0L;
      i += 1;
    }
    f();
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = "";
    long l1;
    Object localObject2;
    long l2;
    if ((paramInt & 0x20) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(false);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((RecentUser)localObject4).uin)) && (!"50000000".equals(((RecentUser)localObject4).uin)))
          {
            i = ((RecentUser)localObject4).getType();
            if (i != 1000) {
              switch (i)
              {
              default: 
                break;
              }
            } else if (!a(((RecentUser)localObject4).uin)) {
              ((List)localObject1).add(new ContactSearchModelRecentUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (RecentUser)localObject4, a(((RecentUser)localObject4).uin)));
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(32);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject5;
    Object localObject6;
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject5 = new ArrayList();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject1 = a();
      if (localObject1 != null) {
        for (localObject1 = ((List)localObject1).iterator(); ((Iterator)localObject1).hasNext(); localObject1 = localObject2)
        {
          localObject4 = (Groups)((Iterator)localObject1).next();
          localObject6 = a(String.valueOf(((Groups)localObject4).group_id));
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
              if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).filterQidianMasterSearch(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localFriends, this.jdField_b_of_type_Int))
              {
                AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
                i = this.jdField_b_of_type_Int;
                if (localFriends.gathtertype == 1) {
                  localObject2 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(2131720101);
                } else {
                  localObject2 = ((Groups)localObject4).group_name;
                }
                ((List)localObject5).add(new ContactSearchModelFriend(localAppInterface, i, localFriends, (String)localObject2, a(localFriends.uin)));
              }
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject5);
      l2 = System.currentTimeMillis();
      i = a(1);
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject1[i].jdField_a_of_type_Long = (l2 - l1);
      localObject1[i].jdField_b_of_type_Int = ((List)localObject5).size();
    }
    if ((0x800000 & paramInt) != 0) {
      a(localArrayList);
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
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
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
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
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IPhoneContactService)localObject2).getContactListForPhoneSelector();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (localObject2 != null)
      {
        localObject2 = ((IPhoneContactService)localObject2).getContactListForSelector();
        if ((localObject2 != null) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = b();
      localObject4 = new HashSet();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      i = 0;
      while (i < ((List)localObject2).size())
      {
        int j = 0;
        while (j < ((ArrayList)((List)localObject2).get(i)).size())
        {
          localObject5 = (DiscussionMemberInfo)((ArrayList)((List)localObject2).get(i)).get(j);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(((DiscussionMemberInfo)localObject5).memberUin);
          ((StringBuilder)localObject6).append(((DiscussionMemberInfo)localObject5).inteRemark);
          ((StringBuilder)localObject6).append(((DiscussionMemberInfo)localObject5).memberName);
          localObject6 = ((StringBuilder)localObject6).toString();
          if (!((Set)localObject4).contains(localObject6))
          {
            localFriends = a(((DiscussionMemberInfo)localObject5).memberUin);
            if ((localFriends == null) || (!localFriends.isFriend()))
            {
              ((Set)localObject4).add(localObject6);
              ((List)localObject1).add(new ContactSearchModelDiscussionMember(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject5));
            }
          }
          j += 1;
        }
        i += 1;
      }
      localArrayList.addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(4);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject4 = null;
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = (ArrayList)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
      if (localObject1 != null)
      {
        localObject5 = ((List)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (DiscussionInfo)((Iterator)localObject5).next();
          localObject1 = a();
          if (localObject1 != null) {
            localObject1 = (List)((Map)localObject1).get(((DiscussionInfo)localObject6).uin);
          } else {
            localObject1 = null;
          }
          ((List)localObject2).add(new ContactSearchModelDiscussion(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject6, (List)localObject1, a(((DiscussionInfo)localObject6).uin)));
        }
      }
      localArrayList.addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(8);
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject1[i].jdField_a_of_type_Long = (l2 - l1);
      localObject1[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject5 = new ArrayList();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).initAssistTroopCache(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      localObject2 = a();
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
          ((List)localObject5).add(new ContactSearchModelTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject1, a(((TroopInfo)localObject1).troopuin)));
        }
      }
      localArrayList.addAll((Collection)localObject5);
      l2 = System.currentTimeMillis();
      i = a(16);
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject2[i].jdField_a_of_type_Long = (l2 - l1);
      localObject2[i].jdField_b_of_type_Int = ((List)localObject5).size();
    }
    else
    {
      localObject1 = "";
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9993L), 6000, a(String.valueOf(9993L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9973L), 9002, a(String.valueOf(9973L))));
      if ((((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) && (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()))
      {
        ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(AppConstants.KANDIAN_MERGE_UIN), 7220, a(String.valueOf(AppConstants.KANDIAN_MERGE_UIN))));
      }
      else
      {
        ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9975L), 7210, a(String.valueOf(9975L))));
        if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()) {
          ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, AppConstants.NEW_KANDIAN_UIN, 1008, a(String.valueOf(AppConstants.NEW_KANDIAN_UIN))));
        }
      }
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9970L), 7120, a(String.valueOf(9970L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, AppConstants.SERVICE_ACCOUNT_FOLDER_UIN, 7230, a(String.valueOf(AppConstants.SERVICE_ACCOUNT_FOLDER_UIN))));
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9980L), 9000, a(String.valueOf(9980L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9994L), 5000, a(String.valueOf(9994L))));
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9992L), 7000, a(String.valueOf(9992L))));
      if (((IBlessApi)QRoute.api(IBlessApi.class)).isSearchable(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
      {
        ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(9960L), 9003, a(String.valueOf(9960L))));
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is added.");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
      }
      ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN), 4000, a(String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN))));
      localObject3 = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, (String)localObject1)).getRecentUserCache().a(true);
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (RecentUser)((Iterator)localObject3).next();
          i = ((RecentUser)localObject5).getType();
          if (((i == 1001) || (i == 5000) || (i == 7000) || (i == 7120) || (i == 7230) || (i == 9000) || (i == 10002) || (i == 10004)) && (!TextUtils.isEmpty(((RecentUser)localObject5).uin))) {
            ((List)localObject2).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, ((RecentUser)localObject5).uin, ((RecentUser)localObject5).getType(), a(((RecentUser)localObject5).uin)));
          }
        }
      }
      localArrayList.addAll((Collection)localObject2);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject3 = new ArrayList();
      localObject5 = a();
      localObject2 = localObject4;
      if (localObject5 != null) {
        localObject2 = (List)((Map)localObject5).get(this.jdField_c_of_type_JavaLangString);
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject4 = (DiscussionMemberInfo)((List)localObject2).get(i);
          ((List)localObject3).add(new ContactSearchModelDiscussionMember(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject4));
          i += 1;
        }
        localArrayList.addAll((Collection)localObject3);
      }
    }
    if (((paramInt & 0x2000) != 0) || ((paramInt & 0x40000) != 0) || ((0x100000 & paramInt) != 0))
    {
      localObject4 = new ArrayList();
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject3 = ((EntityManager)localObject2).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_c_of_type_JavaLangString }, null, null, null, null);
      localObject5 = b(this.jdField_c_of_type_JavaLangString);
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
          if ((Utils.d(((TroopMemberInfo)localObject3).memberuin)) && (((paramInt & 0x40000) == 0) || (localObject5 == null) || (((TroopInfo)localObject5).isTroopAdmin(((TroopMemberInfo)localObject3).memberuin)) || (((TroopInfo)localObject5).isTroopOwner(((TroopMemberInfo)localObject3).memberuin))))
          {
            if ((0x100000 & paramInt) != 0) {
              localObject3 = new TroopBatchAddFrdsSearchModelMember(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject3, (String)localObject2);
            } else {
              localObject3 = new ContactSearchModelTroopMember(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject3);
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
      localObject1 = ((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, (String)localObject1)).getBindAllFriendList();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (PhoneContact)((Iterator)localObject1).next();
          ((List)localObject2).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject3));
        }
      }
      localArrayList.addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      paramInt = a(768);
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo;
      localObject1[paramInt].jdField_a_of_type_Long = (l2 - l1);
      localObject1[paramInt].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilSet;
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
        if (!this.jdField_a_of_type_JavaUtilSet.contains(((IContactSearchModel)localObject1).a())) {
          ((List)localObject2).add(localObject1);
        }
      }
    }
    localObject1 = localArrayList;
    return localObject1;
  }
  
  public List<IContactSearchModel> a(SearchRequest paramSearchRequest)
  {
    Object localObject = paramSearchRequest.jdField_a_of_type_AndroidOsBundle;
    boolean bool3 = false;
    boolean bool1;
    boolean bool2;
    if (localObject != null)
    {
      bool1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchCreateDiscussion", false);
      bool2 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember", false);
    }
    else
    {
      bool1 = false;
      bool2 = false;
    }
    if (this.jdField_a_of_type_Int == 64)
    {
      bool1 = false;
      bool2 = bool3;
    }
    if (bool1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactCreateDiscussionSearchEngine;
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
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactCreateDiscussionSearchEngine = new CreateDiscussionSearchEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactCreateDiscussionSearchEngine.a();
    }
    long l2 = System.currentTimeMillis();
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ContactSearchEngine.init() type = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" ; cost time : ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" ; size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject).toString());
      if (jdField_a_of_type_Boolean)
      {
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo.length)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ContactSearchEngine.init() type = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" ; cost time : ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long);
          ((StringBuilder)localObject).append(" ; size = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int);
          QLog.d("ContactSearchEngine", 2, ((StringBuilder)localObject).toString());
          i += 1;
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("type", this.jdField_b_of_type_JavaLangString);
    int i = j;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time_");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString);
      ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("size_");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString);
      ((HashMap)localObject).put(localStringBuilder.toString(), String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int));
      i += 1;
    }
    StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "ContactSearchEngineInit", true, l2 - l1, this.jdField_a_of_type_JavaUtilList.size(), (HashMap)localObject, "", false);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<IContactSearchModel> paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
    ThreadManager.postImmediately(new ContactSearchEngine.4(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List<IContactSearchModel> paramList1, List<IContactSearchModel> paramList2, ContactSearchEngine.CancelFlag arg3, String paramString)
  {
    ContactSearchEngine.CancelFlag localCancelFlag = ???;
    if (??? == null)
    {
      localCancelFlag = new ContactSearchEngine.CancelFlag(this, false);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localCancelFlag));
      }
    }
    ??? = new HashMap();
    paramList1 = paramList1.iterator();
    IContactSearchModel localIContactSearchModel1;
    while (paramList1.hasNext())
    {
      localIContactSearchModel1 = (IContactSearchModel)paramList1.next();
      IContactSearchModel localIContactSearchModel2 = (IContactSearchModel)???.get(localIContactSearchModel1.a());
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
      if ((localIContactSearchModel2 == null) || (localIContactSearchModel2.b() < localIContactSearchModel1.b())) {
        ???.put(localIContactSearchModel1.a(), localIContactSearchModel1);
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
      Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
      label315:
      int i = Math.min(paramList1.size(), 30);
      ??? = paramList1.subList(0, i);
      paramString = a();
      if (paramString == null) {
        Collections.sort(???, jdField_b_of_type_JavaUtilComparator);
      }
      paramList2.addAll(???);
      paramList2.addAll(paramList1.subList(i, paramList1.size()));
      if (paramString != null) {
        Collections.sort(paramList2, paramString);
      }
      return false;
    }
    catch (Throwable ???)
    {
      break label315;
    }
  }
  
  TroopInfo b(String paramString)
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
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
      this.jdField_c_of_type_JavaUtilList = localArrayList;
      ??? = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactCreateDiscussionSearchEngine;
      if (??? != null) {
        ((CreateDiscussionSearchEngine)???).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
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
    if (this.jdField_a_of_type_Long != -1L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.jdField_b_of_type_JavaLangString);
      String str = this.jdField_a_of_type_JavaLangString;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localHashMap.put("keyword", localObject);
      localHashMap.put("totalSize", String.valueOf(this.jdField_c_of_type_Long));
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo.length)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("time_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString);
        localHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("size_");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString);
        localHashMap.put(((StringBuilder)localObject).toString(), String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int));
        i += 1;
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.f));
      localHashMap.put("size_global_troop_member", String.valueOf(this.d));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.g));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.e));
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "", false);
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troopMemberSearchTime = ");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(" ; troopMemberQueryTime = ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" ; troopMemberTotalSize = ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" ; troopMemberResultSize = ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("ContactSearchEngineSearch", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (this.jdField_c_of_type_Int > 0) {
      new ReportTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("exp_grp").a(new String[] { String.valueOf(this.jdField_c_of_type_Int) }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ContactSearchEngine
 * JD-Core Version:    0.7.0.1
 */