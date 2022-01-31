package com.tencent.mobileqq.search.searchengine;

import ahgw;
import ahgx;
import ahgy;
import ahgz;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.util.SearchMatchResult;
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

public class ApproximateSearchEngine
  implements ISearchEngine
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new ahgw();
  private static Queue jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private int jdField_a_of_type_Int;
  protected QQAppInterface a;
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet;
  private ApproximateSearchEngine.TypedReportInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo = { new ApproximateSearchEngine.TypedReportInfo(1, "friend"), new ApproximateSearchEngine.TypedReportInfo(768, "phone_contact"), new ApproximateSearchEngine.TypedReportInfo(8, "discussion"), new ApproximateSearchEngine.TypedReportInfo(16, "troop") };
  private int jdField_b_of_type_Int;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private String c;
  
  public ApproximateSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.c = paramString;
    this.jdField_b_of_type_JavaLangString = "people";
  }
  
  public ApproximateSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set paramSet)
  {
    this(paramQQAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 768: 
      return 1;
    case 8: 
      return 2;
    }
    return 3;
  }
  
  private List a(ahgy paramahgy)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long = -1L;
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    ??? = a(str, false);
    ArrayList localArrayList1 = new ArrayList();
    if (??? != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
      }
      localArrayList1.addAll((Collection)???);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          return null;
        }
        localArrayList2.addAll(this.jdField_a_of_type_JavaUtilList);
        i = 0;
        if (i >= localArrayList2.size()) {
          break;
        }
        if (paramahgy.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      finally {}
      synchronized ((IContactSearchModel)localArrayList2.get(i))
      {
        SearchMatchResult localSearchMatchResult = ((IContactSearchModel)???).a(str);
        if ((localSearchMatchResult != null) && (localSearchMatchResult.a)) {
          localArrayList1.add(???);
        }
        i += 1;
      }
    }
    a(str, localArrayList1, false);
    return localArrayList1;
  }
  
  private List a(String paramString, boolean paramBoolean)
  {
    label238:
    label241:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i = -2147483648;
        Iterator localIterator = jdField_a_of_type_JavaUtilQueue.iterator();
        Object localObject1 = null;
        if (localIterator.hasNext())
        {
          ahgz localahgz = (ahgz)localIterator.next();
          if ((!paramString.contains(localahgz.jdField_a_of_type_JavaLangString)) || (localahgz.jdField_a_of_type_JavaLangString.length() <= i)) {
            break label238;
          }
          i = localahgz.jdField_a_of_type_JavaLangString.length();
          localObject1 = localahgz;
          break label241;
        }
        if ((localObject1 != null) && (localObject1.jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + localObject1.jdField_a_of_type_JavaLangString + " , cache size = " + localObject1.jdField_a_of_type_JavaUtilList.size());
          }
          paramString = localObject1.jdField_a_of_type_JavaUtilList;
          return paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApproximateSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  private void a(String paramString, List paramList, boolean paramBoolean)
  {
    Queue localQueue;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
        return;
      }
      localQueue = jdField_a_of_type_JavaUtilQueue;
      if (localQueue.size() > 2) {
        localQueue.poll();
      }
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label118;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new ahgz(this, paramString, paramList));
      return;
      label118:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        ahgz localahgz = (ahgz)localIterator.next();
        if (localahgz.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localahgz);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int j = 0;
    int i = j;
    if (paramIContactSearchModel2.c() != null)
    {
      i = j;
      if (paramIContactSearchModel1.c() != null) {
        i = paramIContactSearchModel1.c().toString().compareTo(paramIContactSearchModel2.c().toString());
      }
    }
    j = i;
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
  
  private List c(SearchRequest paramSearchRequest)
  {
    ahgy localahgy = new ahgy(this, false);
    boolean bool;
    do
    {
      ArrayList localArrayList;
      do
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localahgy));
          this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
          paramSearchRequest = this.jdField_a_of_type_JavaLangString;
          if (localahgy.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramSearchRequest);
            }
            return null;
          }
        }
        localArrayList = new ArrayList();
        ??? = a(localahgy);
        if (!localahgy.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramSearchRequest);
      return null;
      if (??? != null) {
        localArrayList.addAll((Collection)???);
      }
      ??? = new ArrayList();
      bool = a(localArrayList, (List)???, localahgy, paramSearchRequest);
      paramSearchRequest = (SearchRequest)???;
      if (((List)???).size() > 40) {
        paramSearchRequest = ((List)???).subList(0, 40);
      }
    } while (bool);
    return paramSearchRequest;
  }
  
  protected List a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = 0L;
      i += 1;
    }
    Object localObject2 = new ArrayList();
    long l1;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    label169:
    long l2;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject4 != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = ((FriendsManager)localObject4).b();
        if (localObject1 != null)
        {
          Iterator localIterator1 = ((List)localObject1).iterator();
          while (localIterator1.hasNext())
          {
            Groups localGroups = (Groups)localIterator1.next();
            localObject1 = ((FriendsManager)localObject4).a(String.valueOf(localGroups.group_id));
            if (localObject1 != null)
            {
              Iterator localIterator2 = ((List)localObject1).iterator();
              Friends localFriends;
              QQAppInterface localQQAppInterface;
              while (localIterator2.hasNext())
              {
                localFriends = (Friends)localIterator2.next();
                if (!localFriends.uin.equals(str))
                {
                  localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  i = this.jdField_b_of_type_Int;
                  if (localFriends.gathtertype != 1) {
                    break label267;
                  }
                }
              }
              label267:
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131437746);; localObject1 = localGroups.group_name)
              {
                ((List)localObject3).add(new ContactSearchModelFriend(localQQAppInterface, i, localFriends, (String)localObject1, 0L));
                break label169;
                break;
              }
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i = a(1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject3 != null)
      {
        localObject3 = ((PhoneContactManager)localObject3).e();
        if (localObject3 != null)
        {
          localObject3 = (List)((List)localObject3).get(0);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject3 != null)
      {
        localObject3 = ((PhoneContactManager)localObject3).e();
        if (localObject3 != null)
        {
          localObject3 = (List)((List)localObject3).get(1);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelDiscussion(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject4, null, 0));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(8);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject1 = new ArrayList();
      localObject3 = ((TroopManager)localObject3).a();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, 0L));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      paramInt = a(16);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[paramInt].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineApproximateSearchEngine$TypedReportInfo[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
        if (!this.jdField_a_of_type_JavaUtilSet.contains(((IContactSearchModel)localObject3).a())) {
          ((List)localObject1).add(localObject3);
        }
      }
      return localObject1;
    }
    return localObject2;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    return c(paramSearchRequest);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 66	com/tencent/mobileqq/search/searchengine/ApproximateSearchEngine:jdField_a_of_type_Int	I
    //   5: invokevirtual 388	com/tencent/mobileqq/search/searchengine/ApproximateSearchEngine:a	(I)Ljava/util/List;
    //   8: astore_1
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnull +35 -> 47
    //   15: aload_1
    //   16: invokeinterface 147 1 0
    //   21: ifle +26 -> 47
    //   24: aload_0
    //   25: getfield 43	com/tencent/mobileqq/search/searchengine/ApproximateSearchEngine:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   28: invokeinterface 391 1 0
    //   33: aload_0
    //   34: getfield 43	com/tencent/mobileqq/search/searchengine/ApproximateSearchEngine:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: aload_1
    //   38: invokeinterface 143 2 0
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 43	com/tencent/mobileqq/search/searchengine/ApproximateSearchEngine:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   51: invokeinterface 391 1 0
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ApproximateSearchEngine
    //   8	30	1	localList	List
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	44	59	finally
    //   44	46	59	finally
    //   47	56	59	finally
    //   60	62	59	finally
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    ThreadManager.postImmediately(new ahgx(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List paramList1, List paramList2, ahgy arg3, String paramString)
  {
    ahgy localahgy = ???;
    if (??? == null) {
      localahgy = new ahgy(this, false);
    }
    IContactSearchModel localIContactSearchModel1;
    for (;;)
    {
      IContactSearchModel localIContactSearchModel2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilList.add(new WeakReference(localahgy));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localIContactSearchModel1 = (IContactSearchModel)paramList1.next();
        localIContactSearchModel2 = (IContactSearchModel)???.get(localIContactSearchModel1.a());
        if (localahgy.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
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
      if (localahgy.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
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
  
  public List b(SearchRequest paramSearchRequest)
  {
    int i = 1;
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localArrayList1.addAll(this.jdField_a_of_type_JavaUtilList);
      if ((localArrayList1 == null) || (localArrayList1.size() == 0)) {
        return null;
      }
    }
    finally {}
    ArrayList localArrayList2;
    int j;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null)
    {
      i = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getInt("voice_search_pre", 1);
      if (i <= 1) {}
    }
    else
    {
      localArrayList2 = new ArrayList(i);
      paramSearchRequest = paramSearchRequest.jdField_a_of_type_JavaLangString;
      j = 0;
    }
    for (;;)
    {
      if (j >= localArrayList1.size()) {
        break label165;
      }
      IContactSearchModel localIContactSearchModel = (IContactSearchModel)localArrayList1.get(j);
      localIContactSearchModel.b(paramSearchRequest);
      if (localIContactSearchModel.b() != -9223372036854775808L) {
        localArrayList2.add(localIContactSearchModel);
      }
      if (localArrayList2.size() >= i)
      {
        return localArrayList2;
        i = 1;
        break;
      }
      j += 1;
    }
    label165:
    return localArrayList2;
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
        ahgy localahgy = (ahgy)localWeakReference.get();
        if (localahgy != null)
        {
          localahgy.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_b_of_type_JavaUtilList = localObject2;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    jdField_a_of_type_JavaUtilQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine
 * JD-Core Version:    0.7.0.1
 */