package com.tencent.mobileqq.search.searchengine;

import ahha;
import ahhb;
import ahhc;
import ahhd;
import ahhe;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroop.TroopSearchMemberInfo;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
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
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ContactSearchEngine
  implements ISearchEngine
{
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new ahha();
  public static boolean a;
  private static final Comparator jdField_b_of_type_JavaUtilComparator = new ahhb();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  public QQAppInterface a;
  private CreateDiscussionSearchEngine jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine;
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private Queue jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private Set jdField_a_of_type_JavaUtilSet;
  private ContactSearchEngine.TypedReportInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo = { new ContactSearchEngine.TypedReportInfo(1, "friend"), new ContactSearchEngine.TypedReportInfo(768, "phone_contact"), new ContactSearchEngine.TypedReportInfo(4, "discussion_member"), new ContactSearchEngine.TypedReportInfo(8, "discussion"), new ContactSearchEngine.TypedReportInfo(16, "troop"), new ContactSearchEngine.TypedReportInfo(32, "recent_user"), new ContactSearchEngine.TypedReportInfo(64, "tool"), new ContactSearchEngine.TypedReportInfo(2048, "circle_buddy"), new ContactSearchEngine.TypedReportInfo(131072, "global_troop_member") };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private Queue jdField_b_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private long d = -1L;
  private long e = -1L;
  private long f = -1L;
  private long g = -1L;
  
  public ContactSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_c_of_type_JavaLangString = paramString;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (SearchUtils.a(paramInt1)) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
      this.jdField_b_of_type_JavaLangString = "people";
      continue;
      this.jdField_b_of_type_JavaLangString = "msg";
    }
  }
  
  public ContactSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set paramSet)
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
    case 4: 
      return 2;
    case 8: 
      return 3;
    case 16: 
      return 4;
    case 32: 
      return 5;
    case 2048: 
      return 7;
    }
    return 8;
  }
  
  public static int a(IContactSearchModel paramIContactSearchModel)
  {
    int i = -1;
    if ((paramIContactSearchModel instanceof ContactSearchModelFriend)) {
      i = 0;
    }
    do
    {
      return i;
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
    } while (!(paramIContactSearchModel instanceof ContactSearchModelRecentUser));
    return 5;
  }
  
  private int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private List a()
  {
    g();
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  private List a(ahhd paramahhd)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long = -1L;
      }
    }
    String str = this.jdField_a_of_type_JavaLangString;
    List localList = a(str, false);
    if (localList != null)
    {
      if (!QLog.isColorLevel()) {
        break label343;
      }
      QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
    }
    label343:
    for (;;)
    {
      if (localList == null)
      {
        return null;
        localList = this.jdField_a_of_type_JavaUtilList;
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < localList.size())
        {
          if (paramahhd.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          IContactSearchModel localIContactSearchModel = (IContactSearchModel)localList.get(i);
          long l1 = System.nanoTime();
          try
          {
            localIContactSearchModel.b(str);
            long l2 = System.nanoTime();
            int j = a(localIContactSearchModel);
            if (j != -1)
            {
              ContactSearchEngine.TypedReportInfo localTypedReportInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[j];
              localTypedReportInfo.jdField_b_of_type_Long = (l2 - l1 + localTypedReportInfo.jdField_b_of_type_Long);
            }
            if (localIContactSearchModel.b() != -9223372036854775808L) {
              localArrayList.add(localIContactSearchModel);
            }
            i += 1;
          }
          finally {}
        }
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long /= 1000000L;
          i += 1;
        }
        a(str, localArrayList, false);
        return localArrayList;
      }
    }
  }
  
  private List a(String paramString, boolean paramBoolean)
  {
    label252:
    label255:
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i = -2147483648;
        Object localObject;
        if (paramBoolean)
        {
          localObject = this.jdField_b_of_type_JavaUtilQueue;
          Iterator localIterator = ((Queue)localObject).iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            ahhe localahhe = (ahhe)localIterator.next();
            if ((!paramString.contains(localahhe.jdField_a_of_type_JavaLangString)) || (localahhe.jdField_a_of_type_JavaLangString.length() <= i)) {
              break label252;
            }
            i = localahhe.jdField_a_of_type_JavaLangString.length();
            localObject = localahhe;
            break label255;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilQueue;
          continue;
        }
        if ((localObject != null) && (((ahhe)localObject).jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + ((ahhe)localObject).jdField_a_of_type_JavaLangString + " , cache size = " + ((ahhe)localObject).jdField_a_of_type_JavaUtilList.size());
          }
          paramString = ((ahhe)localObject).jdField_a_of_type_JavaUtilList;
          return paramString;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  private Map a()
  {
    g();
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  private void a(String paramString, List paramList, boolean paramBoolean)
  {
    Queue localQueue;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
          return;
        }
        if (paramBoolean)
        {
          localQueue = this.jdField_b_of_type_JavaUtilQueue;
          if (localQueue.size() <= 2) {
            break;
          }
          localQueue.poll();
          continue;
        }
        localQueue = this.jdField_a_of_type_JavaUtilQueue;
      }
      finally {}
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label124;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new ahhe(this, paramString, paramList));
      return;
      label124:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        ahhe localahhe = (ahhe)localIterator.next();
        if (localahhe.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localahhe);
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
  
  private List b(ahhd paramahhd)
  {
    String str;
    Object localObject1;
    Object localObject3;
    long l1;
    Object localObject4;
    long l2;
    int n;
    int j;
    int k;
    label498:
    label504:
    Object localObject5;
    label558:
    label590:
    Object localObject6;
    if (((0x10000 & this.jdField_a_of_type_Int) != 0) || ((0x20000 & this.jdField_a_of_type_Int) != 0) || ((0x200000 & this.jdField_a_of_type_Int) != 0) || ((0x400000 & this.jdField_a_of_type_Int) != 0))
    {
      str = this.jdField_a_of_type_JavaLangString;
      localObject1 = a(str, true);
      if ((localObject1 != null) && (((List)localObject1).size() < 100))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchTroopMember use cache, keyword = " + str);
        }
        localObject3 = new ArrayList();
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label1412;
        }
        if (paramahhd.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      else
      {
        localObject1 = new ArrayList();
        l1 = System.currentTimeMillis();
        int m = 0;
        ??? = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2);
        localObject4 = ((FTSTroopOperator)???).a(str);
        if (paramahhd.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
        l2 = System.currentTimeMillis() - l1;
        n = a(131072);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[n].jdField_b_of_type_Long = (1000000L * l2);
        this.f = l2;
        this.e = ((FTSTroopOperator)???).a();
        if (localObject4 != null)
        {
          j = ((List)localObject4).size();
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.TroopGlobalquery cost time : " + l2 + "; size : " + j + "; keyWord: " + str);
          }
          ??? = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (((0x10000 & this.jdField_a_of_type_Int) == 0) && ((0x20000 & this.jdField_a_of_type_Int) == 0)) {
            break label498;
          }
        }
        for (k = 1;; k = 0)
        {
          i = m;
          if (localObject4 == null) {
            break label1243;
          }
          i = m;
          if (((List)localObject4).size() <= 0) {
            break label1243;
          }
          localObject3 = new ArrayList();
          i = 0;
          if (i >= ((List)localObject4).size()) {
            break label590;
          }
          if (!paramahhd.a()) {
            break label504;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
          j = 0;
          break;
        }
        localObject5 = (TroopIndex)((List)localObject4).get(i);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(((TroopIndex)localObject5).mTroopUin)) != 3)
        {
          if (k == 0) {
            break label558;
          }
          ((List)localObject3).add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break;
          if (((TroopManager)???).b(String.valueOf(((TroopIndex)localObject5).mTroopUin)).isNewTroop()) {
            ((List)localObject3).add(localObject5);
          }
        }
        i = m;
        if (((List)localObject3).size() > 0)
        {
          if (((0x20000 & this.jdField_a_of_type_Int) == 0) && ((0x400000 & this.jdField_a_of_type_Int) == 0)) {
            break label1441;
          }
          localObject4 = new ArrayList();
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          i = 0;
          if (i < ((List)localObject3).size())
          {
            if (paramahhd.a())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
              }
              return null;
            }
            localObject6 = (TroopIndex)((List)localObject3).get(i);
            if ((localObject5 != null) && (((String)localObject5).equals(((TroopIndex)localObject6).mMemberUin))) {}
            for (;;)
            {
              i += 1;
              break;
              if (!((TroopManager)???).b(String.valueOf(((TroopIndex)localObject6).mTroopUin)).isNewTroop()) {
                ((List)localObject4).add(new ContactSearchModelGlobalTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject6).mTroopUin, ((TroopIndex)localObject6).mMemberUin, ((TroopIndex)localObject6).mMemberCard, ((TroopIndex)localObject6).mMemberName));
              } else {
                ((List)localObject4).add(new ContactSearchModelNewTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((TroopIndex)localObject6).mTroopUin, ((TroopIndex)localObject6).mMemberUin, ((TroopIndex)localObject6).mMemberCard, ((TroopIndex)localObject6).mMemberName));
              }
            }
          }
          ((List)localObject1).addAll((Collection)localObject4);
        }
      }
    }
    label1412:
    label1441:
    for (int i = ((List)localObject4).size() + 0;; i = 0)
    {
      if (((0x10000 & this.jdField_a_of_type_Int) != 0) || ((0x200000 & this.jdField_a_of_type_Int) != 0))
      {
        localObject4 = new ArrayList();
        localObject5 = new HashMap();
        k = 0;
        if (k < ((List)localObject3).size())
        {
          if (paramahhd.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          localObject6 = (TroopIndex)((List)localObject3).get(k);
          ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = new ContactSearchModelGlobalTroop.TroopSearchMemberInfo(((TroopIndex)localObject6).mMemberCard, ((TroopIndex)localObject6).mMemberName, ((TroopIndex)localObject6).mMemberUin, ((TroopIndex)localObject6).mMemberNick);
          ArrayList localArrayList;
          if (!((HashMap)localObject5).containsKey(((TroopIndex)localObject6).mTroopUin))
          {
            localArrayList = new ArrayList();
            localArrayList.add(localTroopSearchMemberInfo);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
          for (;;)
          {
            k += 1;
            break;
            localArrayList = (ArrayList)((HashMap)localObject5).get(((TroopIndex)localObject6).mTroopUin);
            localArrayList.add(localTroopSearchMemberInfo);
            ((HashMap)localObject5).put(((TroopIndex)localObject6).mTroopUin, localArrayList);
          }
        }
        localObject3 = ((HashMap)localObject5).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject6 = (String)((Iterator)localObject3).next();
          if (!((TroopManager)???).b(String.valueOf(localObject6)).isNewTroop()) {
            ((List)localObject4).add(new ContactSearchModelGlobalTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          } else {
            ((List)localObject4).add(new ContactSearchModelNewTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (String)localObject6, (List)((HashMap)localObject5).get(localObject6)));
          }
        }
        ((List)localObject1).addAll((Collection)localObject4);
        i += ((List)localObject4).size();
      }
      for (;;)
      {
        for (;;)
        {
          label1243:
          l2 = System.currentTimeMillis() - l1 - l2;
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[n].jdField_b_of_type_Int = i;
          this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[n].jdField_a_of_type_Long = l2;
          this.g = (System.currentTimeMillis() - l1);
          this.d = j;
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.troopGlobalDataProcess cost time : " + l2 + "; size : " + i + "; keyWord: " + str);
          }
          break;
          synchronized ((IContactSearchModel)((List)localObject1).get(i))
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
        return null;
      }
    }
  }
  
  private List b(SearchRequest paramSearchRequest)
  {
    Object localObject2 = new ahhd(this, false);
    boolean bool;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localObject2));
        this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
        if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null)
        {
          bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchRequestFromHome", false);
          ??? = this.jdField_a_of_type_JavaLangString;
          if (!((ahhd)localObject2).a()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
        }
      }
      bool = false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject3 = new ArrayList();
    Object localObject4 = a((ahhd)localObject2);
    this.jdField_c_of_type_Int = 0;
    int i;
    HashSet localHashSet;
    long l2;
    long l3;
    long l4;
    Iterator localIterator;
    int j;
    if (((0x10000 & this.jdField_a_of_type_Int) != 0) || ((0x20000 & this.jdField_a_of_type_Int) != 0) || ((0x200000 & this.jdField_a_of_type_Int) != 0) || ((0x400000 & this.jdField_a_of_type_Int) != 0))
    {
      i = 1;
      if ((localObject4 != null) && (i != 0) && (bool))
      {
        localHashSet = new HashSet();
        l2 = IContactSearchable.r;
        l3 = IContactSearchable.v;
        l4 = IContactSearchable.V;
        localIterator = ((List)localObject4).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          IContactSearchModel localIContactSearchModel = (IContactSearchModel)localIterator.next();
          if (((ahhd)localObject2).a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
            }
            return null;
            i = 0;
            break;
          }
          if (((localIContactSearchModel instanceof ContactSearchModelDiscussion)) || ((localIContactSearchModel instanceof ContactSearchModelTroop))) {
            this.jdField_c_of_type_Int += 1;
          }
          if (localIContactSearchModel.b() > l2 + l3 + l4) {
            localHashSet.add(localIContactSearchModel.a());
          }
          if (localHashSet.size() > 5)
          {
            j = 0;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("ContactSearchEngine", 2, "searchContact no need to search troop member, keyword = " + (String)???);
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (((ahhd)localObject2).a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
        }
        return null;
      }
      if ((paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) && (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.containsKey("searchTroopMember"))) {}
      for (bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");; bool = true)
      {
        if (i != 0) {
          if (!bool) {}
        }
        for (paramSearchRequest = b((ahhd)localObject2); ((ahhd)localObject2).a(); paramSearchRequest = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", true);
        }
        if (localObject4 != null) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
        if (paramSearchRequest != null) {
          ((List)localObject3).addAll(paramSearchRequest);
        }
        localObject4 = new ArrayList();
        if (a((List)localObject3, (List)localObject4, (ahhd)localObject2, (String)???)) {
          return null;
        }
        paramSearchRequest = new ArrayList();
        localObject2 = ((List)localObject4).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
          if ((localObject3 instanceof ContactSearchModelGlobalTroop))
          {
            j = i + 1;
            i = j;
            if (j > 200) {
              break label715;
            }
            paramSearchRequest.add(localObject3);
            i = j;
          }
          label715:
          for (;;)
          {
            break;
            paramSearchRequest.add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() troopCount:" + i);
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_b_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + paramSearchRequest.size() + " ; keyword = " + (String)???);
          if (jdField_a_of_type_Boolean)
          {
            i = 0;
            while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
            {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int + " ; keyword = " + (String)???);
              i += 1;
            }
          }
        }
        this.jdField_a_of_type_Long = (l2 - l1);
        this.jdField_b_of_type_Long = paramSearchRequest.size();
        ??? = new HashMap();
        ((HashMap)???).put("result_size", String.valueOf(paramSearchRequest.size()));
        i = 0;
        if (i < 5)
        {
          if (i < paramSearchRequest.size()) {
            ((HashMap)???).put("result_top_" + i, String.valueOf(((IContactSearchModel)paramSearchRequest.get(i)).b()));
          }
          for (;;)
          {
            i += 1;
            break;
            ((HashMap)???).put("result_top_" + i, "0");
          }
        }
        this.jdField_b_of_type_Boolean = false;
        localObject2 = paramSearchRequest.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
          ((IContactSearchModel)localObject3).jdField_a_of_type_JavaUtilHashMap = ((HashMap)???);
          if ("9970".equals(((IContactSearchModel)localObject3).a())) {
            this.jdField_b_of_type_Boolean = true;
          }
        }
        return paramSearchRequest;
      }
    }
  }
  
  private List c(SearchRequest paramSearchRequest)
  {
    ahhd localahhd = new ahhd(this, false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localahhd));
      this.jdField_a_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      return b(localahhd);
    }
  }
  
  private void f()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true, true, false);
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while ((i < j) && (i < 999))
      {
        RecentUser localRecentUser = (RecentUser)localList.get(i);
        this.jdField_a_of_type_JavaUtilHashMap.put(localRecentUser.uin, Integer.valueOf(999 - i));
        i += 1;
      }
    }
  }
  
  private void g()
  {
    Object localObject4 = null;
    label200:
    label205:
    label208:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap == null)
        {
          Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (localObject1 == null) {
            break label200;
          }
          localObject4 = ((DiscussionManager)localObject1).a();
          String[] arrayOfString = new String[((List)localObject4).size()];
          localObject4 = ((List)localObject4).iterator();
          int i = 0;
          if (((Iterator)localObject4).hasNext())
          {
            DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject4).next();
            if ((localDiscussionInfo != null) && (localDiscussionInfo.uin != null) && (localDiscussionInfo.uin.length() > 0))
            {
              arrayOfString[i] = localDiscussionInfo.uin;
              i += 1;
              break label205;
            }
          }
          else
          {
            localObject1 = ((DiscussionManager)localObject1).a(arrayOfString);
            localObject4 = new ArrayList(arrayOfString.length);
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label208;
            }
            ((List)localObject4).add((ArrayList)((Map)localObject1).get(arrayOfString[i]));
            i += 1;
            continue;
            this.jdField_a_of_type_JavaUtilMap = ((Map)localObject1);
            this.jdField_b_of_type_JavaUtilList = ((List)localObject4);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      break label205;
      Object localObject3 = null;
      continue;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Comparator a()
  {
    return null;
  }
  
  protected List a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = 0L;
      i += 1;
    }
    f();
    Object localObject3 = new ArrayList();
    long l1;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    long l2;
    if ((paramInt & 0x20) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((RecentUser)localObject4).uin)) {
            switch (((RecentUser)localObject4).type)
            {
            case 1001: 
            case 1002: 
            case 1003: 
            default: 
              break;
            case 1000: 
            case 1004: 
            case 1005: 
            case 1006: 
              localObject5 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
              if ((localObject5 != null) && (!((FriendsManager)localObject5).b(((RecentUser)localObject4).uin))) {
                ((List)localObject1).add(new ContactSearchModelRecentUser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (RecentUser)localObject4, a(((RecentUser)localObject4).uin)));
              }
              break;
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(32);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject6;
    Object localObject7;
    Object localObject8;
    label431:
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject4 != null)
      {
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = ((FriendsManager)localObject4).b();
        if (localObject1 != null)
        {
          localObject6 = ((List)localObject1).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (Groups)((Iterator)localObject6).next();
            localObject1 = ((FriendsManager)localObject4).a(String.valueOf(((Groups)localObject7).group_id));
            if (localObject1 != null)
            {
              localObject8 = ((List)localObject1).iterator();
              QQAppInterface localQQAppInterface;
              while (((Iterator)localObject8).hasNext())
              {
                localFriends = (Friends)((Iterator)localObject8).next();
                if ((!localFriends.uin.equals(localObject5)) && (QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFriends, this.jdField_b_of_type_Int)))
                {
                  localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  i = this.jdField_b_of_type_Int;
                  if (localFriends.gathtertype != 1) {
                    break label554;
                  }
                }
              }
              label554:
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131437746);; localObject1 = ((Groups)localObject7).group_name)
              {
                ((List)localObject2).add(new ContactSearchModelFriend(localQQAppInterface, i, localFriends, (String)localObject1, a(localFriends.uin)));
                break label431;
                break;
              }
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject2 != null)
      {
        localObject2 = ((PhoneContactManager)localObject2).e();
        if (localObject2 != null)
        {
          localObject2 = (List)((List)localObject2).get(0);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject2 != null)
      {
        localObject2 = ((PhoneContactManager)localObject2).e();
        if (localObject2 != null)
        {
          localObject2 = (List)((List)localObject2).get(1);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject2 != null)
      {
        localObject2 = ((PhoneContactManager)localObject2).g();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject2 != null)
      {
        localObject2 = ((PhoneContactManager)localObject2).f();
        if ((localObject2 != null) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject2).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject2 != null)
      {
        localObject4 = a();
        localObject5 = new HashSet();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = 0;
        while (i < ((List)localObject4).size())
        {
          int j = 0;
          if (j < ((ArrayList)((List)localObject4).get(i)).size())
          {
            localObject7 = (DiscussionMemberInfo)((ArrayList)((List)localObject4).get(i)).get(j);
            localObject8 = ((DiscussionMemberInfo)localObject7).memberUin + ((DiscussionMemberInfo)localObject7).inteRemark + ((DiscussionMemberInfo)localObject7).memberName;
            if (((Set)localObject5).contains(localObject8)) {}
            for (;;)
            {
              j += 1;
              break;
              if (!((String)localObject6).equals(((DiscussionMemberInfo)localObject7).memberUin))
              {
                localFriends = ((FriendsManager)localObject2).a(((DiscussionMemberInfo)localObject7).memberUin);
                if ((localFriends == null) || (!localFriends.isFriend()))
                {
                  ((Set)localObject5).add(localObject8);
                  ((List)localObject1).add(new ContactSearchModelDiscussionMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject7));
                }
              }
            }
          }
          i += 1;
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(4);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList();
      localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
      if (localObject1 != null)
      {
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (DiscussionInfo)((Iterator)localObject4).next();
          localObject1 = null;
          localObject6 = a();
          if (localObject6 != null) {
            localObject1 = (List)((Map)localObject6).get(((DiscussionInfo)localObject5).uin);
          }
          ((List)localObject2).add(new ContactSearchModelDiscussion(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionInfo)localObject5, (List)localObject1, a(((DiscussionInfo)localObject5).uin)));
        }
      }
      ((List)localObject3).addAll((Collection)localObject2);
      l2 = System.currentTimeMillis();
      i = a(8);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject2).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject1 = new ArrayList();
      localObject2 = ((TroopManager)localObject2).a();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject2).next();
          if (!((TroopInfo)localObject4).isQidianPrivateTroop()) {
            ((List)localObject1).add(new ContactSearchModelTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopInfo)localObject4, a(((TroopInfo)localObject4).troopuin)));
          }
        }
      }
      ((List)localObject3).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = a(16);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9993L), 6000, a(String.valueOf(9993L))));
      ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9973L), 9002, a(String.valueOf(9973L))));
      if ((ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!ReadInJoyHelper.h()))
      {
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(AppConstants.as), 7220, a(String.valueOf(AppConstants.as))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9970L), 7120, a(String.valueOf(9970L))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, AppConstants.at, 7230, a(String.valueOf(AppConstants.at))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9980L), 9000, a(String.valueOf(9980L))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9994L), 5000, a(String.valueOf(9994L))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9992L), 7000, a(String.valueOf(9992L))));
        localObject2 = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137);
        if ((localObject2 == null) || (!((BlessManager)localObject2).b())) {
          break label2780;
        }
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9960L), 9003, a(String.valueOf(9960L))));
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is added.");
        }
      }
      for (;;)
      {
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(AppConstants.C), 4000, a(String.valueOf(AppConstants.C))));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
        if (localObject2 == null) {
          break label2798;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject2).next();
          switch (((RecentUser)localObject4).type)
          {
          default: 
            break;
          case 1001: 
          case 5000: 
          case 7000: 
          case 7120: 
          case 7230: 
          case 9000: 
          case 10002: 
          case 10004: 
            if (!TextUtils.isEmpty(((RecentUser)localObject4).uin)) {
              ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).type, a(((RecentUser)localObject4).uin)));
            }
            break;
          }
        }
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, String.valueOf(9975L), 7210, a(String.valueOf(9975L))));
        if (ReadInJoyHelper.h()) {
          break;
        }
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, AppConstants.ar, 1008, a(String.valueOf(AppConstants.ar))));
        break;
        label2780:
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
        }
      }
      label2798:
      ((List)localObject3).addAll((Collection)localObject1);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = new ArrayList();
      localObject1 = a();
      if (localObject1 == null) {
        break label3535;
      }
    }
    label3078:
    label3244:
    label3266:
    label3535:
    for (Object localObject1 = (List)((Map)localObject1).get(this.jdField_c_of_type_JavaLangString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject5 = (DiscussionMemberInfo)((List)localObject1).get(i);
          if (((String)localObject4).equals(((DiscussionMemberInfo)localObject5).memberUin)) {}
          for (;;)
          {
            i += 1;
            break;
            ((List)localObject2).add(new ContactSearchModelDiscussionMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (DiscussionMemberInfo)localObject5));
          }
        }
        ((List)localObject3).addAll((Collection)localObject2);
      }
      if (((paramInt & 0x2000) != 0) || ((0x40000 & paramInt) != 0) || ((0x100000 & paramInt) != 0))
      {
        localObject4 = new ArrayList();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = ((EntityManager)localObject1).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_c_of_type_JavaLangString }, null, null, null, null);
        localObject6 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_c_of_type_JavaLangString);
        if (localObject6 == null)
        {
          localObject1 = "";
          if (localObject2 == null) {
            break label3266;
          }
          localObject7 = ((List)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject7).hasNext()) {
              break;
            }
            localObject2 = (TroopMemberInfo)((Iterator)localObject7).next();
          } while ((!Utils.d(((TroopMemberInfo)localObject2).memberuin)) || (((paramInt & 0x2000) != 0) && (((String)localObject5).equals(((TroopMemberInfo)localObject2).memberuin))) || (((0x100000 & paramInt) != 0) && (((String)localObject5).equals(((TroopMemberInfo)localObject2).memberuin))) || (((0x40000 & paramInt) != 0) && (localObject6 != null) && (!((TroopInfo)localObject6).isTroopAdmin(((TroopMemberInfo)localObject2).memberuin)) && (!((TroopInfo)localObject6).isTroopOwner(((TroopMemberInfo)localObject2).memberuin))));
          if ((0x100000 & paramInt) == 0) {
            break label3244;
          }
        }
        for (localObject2 = new TroopBatchAddFrdsSearchModelMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject2, (String)localObject1);; localObject2 = new ContactSearchModelTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (TroopMemberInfo)localObject2))
        {
          ((List)localObject4).add(localObject2);
          break label3078;
          localObject1 = ((TroopInfo)localObject6).troopcode;
          break;
        }
        ((List)localObject3).addAll((Collection)localObject4);
      }
      if ((0x80000 & paramInt) != 0)
      {
        l1 = System.currentTimeMillis();
        localObject1 = new ArrayList();
        localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (localObject2 != null)
        {
          localObject2 = ((PhoneContactManagerImp)localObject2).b();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject2).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, (PhoneContact)localObject4));
            }
          }
        }
        ((List)localObject3).addAll((Collection)localObject1);
        l2 = System.currentTimeMillis();
        paramInt = a(768);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[paramInt].jdField_a_of_type_Long = (l2 - l1);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
      }
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
          if (!this.jdField_a_of_type_JavaUtilSet.contains(((IContactSearchModel)localObject3).a())) {
            ((List)localObject1).add(localObject3);
          }
        }
        return localObject1;
      }
      return localObject3;
    }
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    boolean bool3 = false;
    boolean bool1;
    boolean bool2;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchCreateDiscussion", false);
      bool2 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember", false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 64)
      {
        bool1 = false;
        bool2 = bool3;
      }
      for (;;)
      {
        if (bool1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine != null) {
            return this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine.a(paramSearchRequest);
          }
        }
        else
        {
          if (bool2) {
            return c(paramSearchRequest);
          }
          return b(paramSearchRequest);
        }
        return new ArrayList();
      }
      bool2 = false;
      bool1 = false;
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine = new CreateDiscussionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine.a();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_b_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (jdField_a_of_type_Boolean)
      {
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int);
          i += 1;
        }
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.jdField_b_of_type_JavaLangString);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
    {
      localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_Long));
      localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int));
      i += 1;
    }
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ContactSearchEngineInit", true, l2 - l1, this.jdField_a_of_type_JavaUtilList.size(), localHashMap, "", false);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    ThreadManager.postImmediately(new ahhc(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List paramList1, List paramList2, ahhd arg3, String paramString)
  {
    ahhd localahhd = ???;
    if (??? == null) {
      localahhd = new ahhd(this, false);
    }
    IContactSearchModel localIContactSearchModel1;
    for (;;)
    {
      IContactSearchModel localIContactSearchModel2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localahhd));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localIContactSearchModel1 = (IContactSearchModel)paramList1.next();
        localIContactSearchModel2 = (IContactSearchModel)???.get(localIContactSearchModel1.a());
        if (localahhd.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
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
      if (localahhd.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localIContactSearchModel1 = (IContactSearchModel)localIContactSearchModel1.clone();
      if (localIContactSearchModel1 != null) {
        paramList1.add(localIContactSearchModel1);
      }
    }
    Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
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
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        ahhd localahhd = (ahhd)localWeakReference.get();
        if (localahhd != null)
        {
          localahhd.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_c_of_type_JavaUtilList = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_a_of_type_Long != -1L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaLangString == null) {}
      for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
      {
        localHashMap.put("keyword", str);
        localHashMap.put("totalSize", String.valueOf(this.jdField_c_of_type_Long));
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
        {
          localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Long));
          localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i].jdField_b_of_type_Int));
          i += 1;
        }
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.f));
      localHashMap.put("size_global_troop_member", String.valueOf(this.d));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.g));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.e));
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ContactSearchEngineSearch", true, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "", false);
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngineSearch", 2, "troopMemberSearchTime = " + this.g + " ; troopMemberQueryTime = " + this.f + " ; troopMemberTotalSize = " + this.e + " ; troopMemberResultSize = " + this.d);
      }
    }
    if (this.jdField_c_of_type_Int > 0) {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("exp_grp").a(new String[] { String.valueOf(this.jdField_c_of_type_Int) }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine
 * JD-Core Version:    0.7.0.1
 */