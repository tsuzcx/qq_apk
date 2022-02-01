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
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Comparator<IContactSearchModel> jdField_a_of_type_JavaUtilComparator = new ApproximateSearchEngine.1();
  private static Queue<ApproximateSearchEngine.SearchResultCache> jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private int jdField_a_of_type_Int = 0;
  protected AppInterface a;
  private ISearchListener<IContactSearchModel> jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
  private String jdField_a_of_type_JavaLangString;
  private List<IContactSearchModel> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private ApproximateSearchEngine.TypedReportInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo = { new ApproximateSearchEngine.TypedReportInfo(1, "friend"), new ApproximateSearchEngine.TypedReportInfo(768, "phone_contact"), new ApproximateSearchEngine.TypedReportInfo(8, "discussion"), new ApproximateSearchEngine.TypedReportInfo(16, "troop") };
  private int jdField_b_of_type_Int;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  private List<WeakReference<ApproximateSearchEngine.CancelFlag>> jdField_b_of_type_JavaUtilList = new ArrayList();
  private String c;
  
  public ApproximateSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.c = paramString;
    this.jdField_b_of_type_JavaLangString = "people";
  }
  
  public ApproximateSearchEngine(AppInterface paramAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(int paramInt)
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
  
  private ArrayList<Entity> a()
  {
    return ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
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
  
  private List<IContactSearchModel> a(ApproximateSearchEngine.CancelFlag paramCancelFlag)
  {
    int i = 0;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      if (i >= localObject1.length) {
        break;
      }
      if (!"global_troop_member".equals(Integer.valueOf(localObject1[i].jdField_a_of_type_Int))) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long = -1L;
      }
      i += 1;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
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
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return null;
      }
      localArrayList2.addAll(this.jdField_a_of_type_JavaUtilList);
      i = 0;
      while (i < localArrayList2.size())
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
        synchronized ((IContactSearchModel)localArrayList2.get(i))
        {
          SearchMatchResult localSearchMatchResult = ((IContactSearchModel)???).a((String)localObject1);
          if ((localSearchMatchResult != null) && (localSearchMatchResult.a)) {
            localArrayList1.add(???);
          }
          i += 1;
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilQueue.iterator();
        Object localObject1 = null;
        int i = -2147483648;
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (ApproximateSearchEngine.SearchResultCache)localIterator.next();
          if ((paramString.contains(((ApproximateSearchEngine.SearchResultCache)localObject2).jdField_a_of_type_JavaLangString)) && (((ApproximateSearchEngine.SearchResultCache)localObject2).jdField_a_of_type_JavaLangString.length() > i))
          {
            i = ((ApproximateSearchEngine.SearchResultCache)localObject2).jdField_a_of_type_JavaLangString.length();
            localObject1 = localObject2;
          }
        }
        if ((localObject1 != null) && (((ApproximateSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getBestCache hit cache, cur keyword = ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" , cache keyword = ");
            ((StringBuilder)localObject2).append(((ApproximateSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(" , cache size = ");
            ((StringBuilder)localObject2).append(((ApproximateSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaUtilList.size());
            QLog.d("ApproximateSearchEngine", 2, ((StringBuilder)localObject2).toString());
          }
          paramString = ((ApproximateSearchEngine.SearchResultCache)localObject1).jdField_a_of_type_JavaUtilList;
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
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.trim().contains(" ")) && (paramList != null))
      {
        Queue localQueue = jdField_a_of_type_JavaUtilQueue;
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
              if (localSearchResultCache.jdField_a_of_type_JavaUtilList.isEmpty()) {
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
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i;
    if ((paramIContactSearchModel2.c() != null) && (paramIContactSearchModel1.c() != null)) {
      i = paramIContactSearchModel1.c().toString().compareTo(paramIContactSearchModel2.c().toString());
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
          j = paramIContactSearchModel1.d().toString().compareTo(paramIContactSearchModel2.d().toString());
        }
      }
    }
    return j;
  }
  
  private List<IContactSearchModel> b(SearchRequest paramSearchRequest)
  {
    ApproximateSearchEngine.CancelFlag localCancelFlag = new ApproximateSearchEngine.CancelFlag(this, false);
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localCancelFlag));
      this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      paramSearchRequest = this.jdField_a_of_type_JavaLangString;
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
  
  protected List<IContactSearchModel> a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i].jdField_b_of_type_Int = 0;
      localObject1[i].jdField_a_of_type_Long = 0L;
      i += 1;
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject1 = a();
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
              AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
              i = this.jdField_b_of_type_Int;
              if (localFriends.gathtertype == 1) {
                localObject1 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getString(2131720101);
              } else {
                localObject1 = localGroups.group_name;
              }
              ((List)localObject3).add(new ContactSearchModelFriend(localAppInterface, i, localFriends, (String)localObject1, 0L));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i = a(1);
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      localObject1[i].jdField_a_of_type_Long = (l2 - l1);
      localObject1[i].jdField_b_of_type_Int = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
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
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      localObject3[i].jdField_a_of_type_Long = (l2 - l1);
      localObject3[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
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
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      localObject3[i].jdField_a_of_type_Long = (l2 - l1);
      localObject3[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (ArrayList)((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelDiscussion(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject4, null, 0));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(8);
      localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      localObject3[i].jdField_a_of_type_Long = (l2 - l1);
      localObject3[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = a();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelTroop(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, 0L));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      paramInt = a(16);
      localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchBusinessContactApproximateSearchEngine$TypedReportInfo;
      localObject3[paramInt].jdField_a_of_type_Long = (l2 - l1);
      localObject3[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilSet;
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
        if (!this.jdField_a_of_type_JavaUtilSet.contains(((IContactSearchModel)localObject1).a())) {
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
    List localList = a(this.jdField_a_of_type_Int);
    if (localList != null) {}
    try
    {
      if (localList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localList);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    finally {}
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<IContactSearchModel> paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
    ThreadManager.postImmediately(new ApproximateSearchEngine.2(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List<IContactSearchModel> paramList1, List<IContactSearchModel> paramList2, ApproximateSearchEngine.CancelFlag arg3, String paramString)
  {
    ApproximateSearchEngine.CancelFlag localCancelFlag = ???;
    if (??? == null)
    {
      localCancelFlag = new ApproximateSearchEngine.CancelFlag(this, false);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localCancelFlag));
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
          QLog.d("ApproximateSearchEngine", 2, paramList1.toString());
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
          QLog.d("ApproximateSearchEngine", 2, paramList1.toString());
        }
        return true;
      }
      localIContactSearchModel1 = (IContactSearchModel)localIContactSearchModel1.clone();
      if (localIContactSearchModel1 != null) {
        paramList1.add(localIContactSearchModel1);
      }
    }
    Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
    paramList2.addAll(paramList1);
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
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
      this.jdField_b_of_type_JavaUtilList = localArrayList;
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
    jdField_a_of_type_JavaUtilQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ApproximateSearchEngine
 * JD-Core Version:    0.7.0.1
 */