package com.tencent.mobileqq.search.business.contact.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContactSearchModelGlobalTroop
  extends IContactSearchModel
{
  private long a;
  protected TroopInfo a;
  protected CharSequence a;
  public String a;
  protected List<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> a;
  protected Set<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> a;
  private long b;
  protected String b;
  protected List<String> b;
  protected List<String> c;
  
  public ContactSearchModelGlobalTroop(AppInterface paramAppInterface, int paramInt, String paramString, List<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> paramList)
  {
    super(paramAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = IContactSearchable.T;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = SearchUtils.a(paramAppInterface, this.jdField_a_of_type_JavaLangString);
    if (((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop())
      {
        this.jdField_b_of_type_Long = IContactSearchable.K;
        return;
      }
      this.jdField_b_of_type_Long = IContactSearchable.U;
    }
  }
  
  private long a(RecentUserProxy paramRecentUserProxy, String paramString1, long paramLong, String paramString2)
  {
    int i = SearchConfigManager.sReduceDiscussionWeight;
    if ((i != 0) && (i != 1))
    {
      if (i != 2) {
        return SearchUtils.a(paramString2, paramString1, paramLong, false, false, true);
      }
      if (paramRecentUserProxy.a(this.jdField_a_of_type_JavaLangString)) {
        return SearchUtils.a(paramString2, paramString1, paramLong, false, false, false);
      }
      return SearchUtils.a(paramString2, paramString1, paramLong, false, false, true);
    }
    return SearchUtils.a(paramString2, paramString1, paramLong, false, false, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop() ^ true);
  }
  
  private long a(List<List<ContactSearchModelGlobalTroop.TroopMemberMatchInfo>> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int[] arrayOfInt = new int[paramList.size()];
    Object localObject4 = new HashMap();
    int i = 0;
    int j;
    long l1;
    Object localObject1;
    long l2;
    for (;;)
    {
      j = paramList.size();
      l1 = -9223372036854775808L;
      if (i >= j) {
        break;
      }
      j = 0;
      while (j < ((List)paramList.get(i)).size())
      {
        localObject1 = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(i)).get(j)).jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelContactSearchModelGlobalTroop$TroopSearchMemberInfo;
        if (!((Map)localObject4).containsKey(localObject1))
        {
          ((Map)localObject4).put(localObject1, Integer.valueOf(-1));
          localHashMap1.put(localObject1, Long.valueOf(0L));
        }
        l2 = l1;
        if (((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
        }
        j += 1;
        l1 = l2;
      }
      arrayOfLong[i] = l1;
      i += 1;
    }
    i = 0;
    long l3;
    while (i < paramList.size())
    {
      Object localObject5 = new boolean[paramList.size()];
      Arrays.fill((boolean[])localObject5, false);
      HashSet localHashSet = new HashSet();
      Iterator localIterator = localHashMap1.keySet().iterator();
      Object localObject3;
      Object localObject2;
      for (;;)
      {
        localObject3 = localHashSet;
        localObject2 = localObject5;
        j = i;
        localObject1 = localObject4;
        if (!localIterator.hasNext()) {
          break;
        }
        localHashMap2.put((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localIterator.next(), Long.valueOf(9223372036854775807L));
      }
      for (;;)
      {
        localObject4 = localObject3;
        localObject3 = localObject2;
        if (a(j, paramList, arrayOfLong, localHashMap1, arrayOfInt, (Map)localObject1, localObject2, (Set)localObject4, localHashMap2)) {
          break label670;
        }
        localObject5 = localHashMap2.keySet().iterator();
        l2 = 9223372036854775807L;
        localObject2 = localObject4;
        if (((Iterator)localObject5).hasNext())
        {
          localObject4 = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)((Iterator)localObject5).next();
          if (localObject2.contains(localObject4)) {
            l3 = l2;
          }
          for (;;)
          {
            l2 = l3;
            break;
            long l4 = ((Long)localHashMap2.get(localObject4)).longValue();
            l3 = l2;
            if (l4 < l2) {
              l3 = l4;
            }
          }
        }
        if (l2 == 9223372036854775807L) {
          break;
        }
        if (l2 == 0L) {
          return -9223372036854775808L;
        }
        i = 0;
        while (i <= j)
        {
          if (localObject3[i] != 0) {
            arrayOfLong[i] -= l2;
          }
          i += 1;
        }
        localObject4 = localHashMap1.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)((Iterator)localObject4).next();
          if (!localObject2.contains(localObject5)) {
            localHashMap2.put(localObject5, Long.valueOf(((Long)localHashMap2.get(localObject5)).longValue() - l2));
          } else {
            localHashMap1.put(localObject5, Long.valueOf(((Long)localHashMap1.get(localObject5)).longValue() + l2));
          }
        }
        localObject2.clear();
        Arrays.fill((boolean[])localObject3, false);
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
      return -9223372036854775808L;
      label670:
      i = j + 1;
      localObject4 = localObject1;
    }
    i = 0;
    while (i < paramList.size())
    {
      l3 = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.jdField_a_of_type_JavaUtilSet.add(((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelContactSearchModelGlobalTroop$TroopSearchMemberInfo);
      this.jdField_b_of_type_JavaUtilList.add(((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
      i += 1;
      l1 = l2;
    }
    return l1;
  }
  
  static boolean a(int paramInt, List<List<ContactSearchModelGlobalTroop.TroopMemberMatchInfo>> paramList, long[] paramArrayOfLong, Map<ContactSearchModelGlobalTroop.TroopSearchMemberInfo, Long> paramMap1, int[] paramArrayOfInt, Map<ContactSearchModelGlobalTroop.TroopSearchMemberInfo, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> paramSet, Map<ContactSearchModelGlobalTroop.TroopSearchMemberInfo, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    while (i < ((List)paramList.get(paramInt)).size())
    {
      ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelContactSearchModelGlobalTroop$TroopSearchMemberInfo;
      if (!paramSet.contains(localTroopSearchMemberInfo))
      {
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localTroopSearchMemberInfo)).longValue() - ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localTroopSearchMemberInfo);
          int j = ((Integer)paramMap.get(localTroopSearchMemberInfo)).intValue();
          if (j != -1) {
            if (!a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)) {
              break label234;
            }
          }
          paramMap.put(localTroopSearchMemberInfo, Integer.valueOf(paramInt));
          paramArrayOfInt[paramInt] = i;
          return true;
        }
        else if (l < ((Long)paramMap2.get(localTroopSearchMemberInfo)).longValue())
        {
          paramMap2.put(localTroopSearchMemberInfo, Long.valueOf(l));
        }
      }
      label234:
      i += 1;
    }
    return false;
  }
  
  private Object[] a(ContactSearchModelGlobalTroop.TroopSearchMemberInfo paramTroopSearchMemberInfo, String paramString)
  {
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
      l1 = IContactSearchable.i;
    } else {
      l1 = IContactSearchable.q;
    }
    long l1 = a(localRecentUserProxy, paramTroopSearchMemberInfo.c, l1, paramString);
    String str;
    if (l1 > -9223372036854775808L)
    {
      str = paramTroopSearchMemberInfo.c;
      paramTroopSearchMemberInfo.jdField_a_of_type_Int = 66;
    }
    else
    {
      str = null;
      l1 = -9223372036854775808L;
    }
    long l3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) {
      l3 = IContactSearchable.h;
    } else {
      l3 = IContactSearchable.l;
    }
    long l4 = a(localRecentUserProxy, paramTroopSearchMemberInfo.jdField_b_of_type_JavaLangString, l3, paramString);
    long l2 = l1;
    if (l4 > l1)
    {
      str = paramTroopSearchMemberInfo.jdField_b_of_type_JavaLangString;
      paramTroopSearchMemberInfo.jdField_a_of_type_Int = 88;
      l2 = l4;
    }
    l1 = a(localRecentUserProxy, paramTroopSearchMemberInfo.d, l3, paramString);
    if (l1 > l2)
    {
      str = paramTroopSearchMemberInfo.d;
      paramTroopSearchMemberInfo.jdField_a_of_type_Int = 99;
      l2 = l1;
    }
    return new Object[] { Long.valueOf(l2), str };
  }
  
  private long c(String paramString)
  {
    paramString = paramString.split("\\s+");
    long l2 = -9223372036854775808L;
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.length >= 2)
      {
        ArrayList localArrayList1 = new ArrayList();
        int i = 0;
        while (i < paramString.length)
        {
          this.c.add(paramString[i]);
          ArrayList localArrayList2 = new ArrayList();
          localArrayList1.add(localArrayList2);
          int j = 0;
          while (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            Object localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j);
            Object[] arrayOfObject = a((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject, paramString[i]);
            l1 = ((Long)arrayOfObject[0]).longValue();
            if ((((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Long == -9223372036854775808L) || (l1 > ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Long))
            {
              ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Long = l1;
              ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_Int = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Int;
            }
            if (l1 != -9223372036854775808L)
            {
              localObject = new ContactSearchModelGlobalTroop.TroopMemberMatchInfo();
              ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)localObject).jdField_a_of_type_Long = l1;
              ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)localObject).jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
              ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)localObject).jdField_a_of_type_ComTencentMobileqqSearchBusinessContactModelContactSearchModelGlobalTroop$TroopSearchMemberInfo = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j));
              localArrayList2.add(localObject);
            }
            j += 1;
          }
          if (localArrayList2.isEmpty()) {
            return -9223372036854775808L;
          }
          i += 1;
        }
        l1 = a(localArrayList1);
      }
    }
    return l1;
  }
  
  public int a()
  {
    return 4;
  }
  
  public long a()
  {
    return super.a();
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l1 = -9223372036854775808L;
    ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = null;
    Object localObject = localTroopSearchMemberInfo;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object[] arrayOfObject = a((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
      long l3 = ((Long)arrayOfObject[0]).longValue();
      long l2 = l1;
      if (l3 > l1)
      {
        localTroopSearchMemberInfo = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        localObject = (String)arrayOfObject[1];
        l2 = l3;
      }
      i += 1;
      l1 = l2;
    }
    if (localTroopSearchMemberInfo != null)
    {
      this.jdField_a_of_type_JavaUtilSet.add(localTroopSearchMemberInfo);
      this.jdField_b_of_type_JavaUtilList.add(localObject);
      this.c.add(paramString);
    }
    if (l1 > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l1;
    }
    if (this.jdField_a_of_type_Long == -9223372036854775808L)
    {
      l1 = c(paramString);
      if (l1 > this.jdField_a_of_type_Long) {
        this.jdField_a_of_type_Long = l1;
      }
    }
    l1 = this.jdField_a_of_type_Long;
    if (l1 != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long = (l1 + this.jdField_b_of_type_Long);
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localSpannableStringBuilder.append("包含: ");
      int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
      int i = 0;
      int m;
      for (;;)
      {
        if (j >= 0) {
          k = 1;
        } else {
          k = 0;
        }
        if (i < 10) {
          m = 1;
        } else {
          m = 0;
        }
        if ((k & m) == 0) {
          break;
        }
        localSpannableStringBuilder.append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.c.get(j), 6, false));
        i += 1;
        localSpannableStringBuilder.append("、");
        j -= 1;
      }
      int k = 0;
      j = i;
      i = k;
      for (;;)
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          k = 1;
        } else {
          k = 0;
        }
        if (j < 10) {
          m = 1;
        } else {
          m = 0;
        }
        if ((k & m) == 0) {
          break;
        }
        Object localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        k = j;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          if (this.c.size() == 1) {
            m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_a_of_type_Int;
          } else {
            m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_Int;
          }
          if (m == 66)
          {
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).c;
          }
          else if (m == 88)
          {
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_JavaLangString;
          }
          else
          {
            k = j;
            if (m != 99) {
              break label320;
            }
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).d;
          }
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k = j + 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.append("、");
          }
        }
        label320:
        i += 1;
        j = k;
      }
    }
    if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、'))
    {
      this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      String str = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, true);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, 1, str, false);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_a_of_type_JavaLangString, "", 1);
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, 2, paramView);
      SearchUtils.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
        } else {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
        }
      }
    }
    if (SearchConfigManager.needSeparate) {
      SearchUtils.a("search", "group", "groups", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopName())) {
      return c();
    }
    return super.b();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getRealTroopName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, true);
  }
  
  public int d()
  {
    return 1;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int e()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop
 * JD-Core Version:    0.7.0.1
 */