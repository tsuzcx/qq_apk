package com.tencent.mobileqq.search.business.contact.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.ReportTask;
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
import mqq.app.MobileQQ;

public class ContactSearchModelDiscussion
  extends IContactSearchModel
{
  private long jdField_a_of_type_Long;
  private DiscussionInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private List<DiscussionMemberInfo> jdField_a_of_type_JavaUtilList;
  private Set<DiscussionMemberInfo> jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = IContactSearchable.L;
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private List<String> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean = false;
  
  public ContactSearchModelDiscussion(AppInterface paramAppInterface, int paramInt1, DiscussionInfo paramDiscussionInfo, List<DiscussionMemberInfo> paramList, int paramInt2)
  {
    super(paramAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    this.jdField_c_of_type_Boolean = (paramDiscussionInfo.hasRenamed() ^ true);
    this.jdField_b_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
  }
  
  private long a(RecentUserProxy paramRecentUserProxy, String paramString1, long paramLong, String paramString2)
  {
    int i = SearchConfigManager.sReduceDiscussionWeight;
    if (i != 0)
    {
      if ((i != 1) && (i != 2)) {
        return SearchUtils.a(paramString2, paramString1, paramLong);
      }
      if (paramRecentUserProxy.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin)) {
        return SearchUtils.a(paramString2, paramString1, paramLong, true, false, false);
      }
      return SearchUtils.a(paramString2, paramString1, paramLong);
    }
    return SearchUtils.a(paramString2, paramString1, paramLong);
  }
  
  private long a(List<List<ContactSearchModelDiscussion.DiscussionMemberMatchInfo>> paramList)
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
        localObject1 = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(i)).get(j)).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
        if (!((Map)localObject4).containsKey(localObject1))
        {
          ((Map)localObject4).put(localObject1, Integer.valueOf(-1));
          localHashMap1.put(localObject1, Long.valueOf(0L));
        }
        l2 = l1;
        if (((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long > l1) {
          l2 = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(i)).get(j)).jdField_a_of_type_Long;
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
        localHashMap2.put((DiscussionMemberInfo)localIterator.next(), Long.valueOf(9223372036854775807L));
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
          localObject4 = (DiscussionMemberInfo)((Iterator)localObject5).next();
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
          localObject5 = (DiscussionMemberInfo)((Iterator)localObject4).next();
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
      l3 = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_Long;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.jdField_a_of_type_JavaUtilSet.add(((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo);
      this.jdField_b_of_type_JavaUtilList.add(((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(i)).get(arrayOfInt[i])).jdField_a_of_type_JavaLangString);
      i += 1;
      l1 = l2;
    }
    return l1;
  }
  
  private Friends a(String paramString)
  {
    return ((IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
  }
  
  private void a()
  {
    boolean bool = SearchUtils.a(this.jdField_b_of_type_Int);
    int n = 0;
    int i = 0;
    if ((!bool) && (this.jdField_b_of_type_Int != 5))
    {
      this.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702749);
      localObject1 = new SpannableStringBuilder();
      if (!this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.hasRenamed())
      {
        ((SpannableStringBuilder)localObject1).append("(");
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        if (localObject2 != null) {
          i = ((List)localObject2).size();
        }
        ((SpannableStringBuilder)localObject1).append(String.valueOf(i));
        ((SpannableStringBuilder)localObject1).append(")");
      }
      else if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        ((SpannableStringBuilder)localObject1).append("(");
        i = this.jdField_b_of_type_JavaUtilList.size() - 1;
        while (i >= 0)
        {
          ((SpannableStringBuilder)localObject1).append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(i), (String)this.jdField_c_of_type_JavaUtilList.get(i), 6));
          if (i > 0) {
            ((SpannableStringBuilder)localObject1).append("、");
          }
          i -= 1;
        }
        ((SpannableStringBuilder)localObject1).append(")");
      }
      this.jdField_c_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      return;
    }
    Object localObject2 = new SpannableStringBuilder();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      ((SpannableStringBuilder)localObject2).append("包含: ");
      int j = this.jdField_b_of_type_JavaUtilList.size() - 1;
      i = 0;
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
        ((SpannableStringBuilder)localObject2).append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6));
        i += 1;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          ((SpannableStringBuilder)localObject2).append("、");
        }
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
        localObject1 = (DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        k = j;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject1))
        {
          if (((DiscussionMemberInfo)localObject1).inteRemark != null) {
            localObject1 = ((DiscussionMemberInfo)localObject1).inteRemark;
          } else {
            localObject1 = ((DiscussionMemberInfo)localObject1).memberName;
          }
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            j += 1;
            ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
            k = j;
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              ((SpannableStringBuilder)localObject2).append("、");
              k = j;
            }
          }
        }
        i += 1;
        j = k;
      }
    }
    this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("(");
    localObject2 = this.jdField_a_of_type_JavaUtilList;
    i = n;
    if (localObject2 != null) {
      i = ((List)localObject2).size();
    }
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131702691));
    this.jdField_c_of_type_JavaLangCharSequence = ((StringBuilder)localObject1).toString();
  }
  
  static boolean a(int paramInt, List<List<ContactSearchModelDiscussion.DiscussionMemberMatchInfo>> paramList, long[] paramArrayOfLong, Map<DiscussionMemberInfo, Long> paramMap1, int[] paramArrayOfInt, Map<DiscussionMemberInfo, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<DiscussionMemberInfo> paramSet, Map<DiscussionMemberInfo, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    while (i < ((List)paramList.get(paramInt)).size())
    {
      DiscussionMemberInfo localDiscussionMemberInfo = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
      if (!paramSet.contains(localDiscussionMemberInfo))
      {
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localDiscussionMemberInfo)).longValue() - ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(paramInt)).get(i)).jdField_a_of_type_Long;
        if (l == 0L)
        {
          paramSet.add(localDiscussionMemberInfo);
          int j = ((Integer)paramMap.get(localDiscussionMemberInfo)).intValue();
          if (j != -1) {
            if (!a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)) {
              break label234;
            }
          }
          paramMap.put(localDiscussionMemberInfo, Integer.valueOf(paramInt));
          paramArrayOfInt[paramInt] = i;
          return true;
        }
        else if (l < ((Long)paramMap2.get(localDiscussionMemberInfo)).longValue())
        {
          paramMap2.put(localDiscussionMemberInfo, Long.valueOf(l));
        }
      }
      label234:
      i += 1;
    }
    return false;
  }
  
  private Object[] a(DiscussionMemberInfo paramDiscussionMemberInfo, String paramString)
  {
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    long l2 = a(localRecentUserProxy, paramDiscussionMemberInfo.inteRemark, IContactSearchable.k, paramString);
    String str;
    if (l2 > -9223372036854775808L)
    {
      str = paramDiscussionMemberInfo.inteRemark;
    }
    else
    {
      str = null;
      l2 = -9223372036854775808L;
    }
    long l3 = a(localRecentUserProxy, paramDiscussionMemberInfo.memberName, IContactSearchable.l, paramString);
    long l1 = l2;
    if (l3 > l2)
    {
      str = paramDiscussionMemberInfo.memberName;
      l1 = l3;
    }
    Friends localFriends = a(paramDiscussionMemberInfo.memberUin);
    l3 = l1;
    paramDiscussionMemberInfo = str;
    if (localFriends != null)
    {
      l3 = l1;
      paramDiscussionMemberInfo = str;
      if (localFriends.isFriend())
      {
        l3 = a(localRecentUserProxy, localFriends.remark, IContactSearchable.j, paramString);
        l2 = l1;
        paramDiscussionMemberInfo = str;
        if (l3 > l1)
        {
          paramDiscussionMemberInfo = localFriends.remark;
          l2 = l3;
        }
        l1 = a(localRecentUserProxy, localFriends.name, IContactSearchable.l, paramString);
        l3 = l2;
        if (l1 > l2)
        {
          paramDiscussionMemberInfo = localFriends.name;
          l3 = l1;
        }
      }
    }
    return new Object[] { Long.valueOf(l3), paramDiscussionMemberInfo };
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
          this.jdField_c_of_type_JavaUtilList.add(paramString[i]);
          ArrayList localArrayList2 = new ArrayList();
          localArrayList1.add(localArrayList2);
          int j = 0;
          while (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (!((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j)).memberUin.equals(this.jdField_b_of_type_JavaLangString))
            {
              Object[] arrayOfObject = a((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j), paramString[i]);
              l1 = ((Long)arrayOfObject[0]).longValue();
              if (l1 != -9223372036854775808L)
              {
                ContactSearchModelDiscussion.DiscussionMemberMatchInfo localDiscussionMemberMatchInfo = new ContactSearchModelDiscussion.DiscussionMemberMatchInfo();
                localDiscussionMemberMatchInfo.jdField_a_of_type_Long = l1;
                localDiscussionMemberMatchInfo.jdField_a_of_type_JavaLangString = ((String)arrayOfObject[1]);
                localDiscussionMemberMatchInfo.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = ((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(j));
                localArrayList2.add(localDiscussionMemberMatchInfo);
              }
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
    return 101;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    boolean bool = this.jdField_c_of_type_Boolean;
    int j = 1;
    if (!bool)
    {
      l1 = SearchUtils.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, IContactSearchable.e);
      if (l1 > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Boolean = true;
      }
    }
    long l1 = -9223372036854775808L;
    DiscussionMemberInfo localDiscussionMemberInfo = null;
    Object localObject = localDiscussionMemberInfo;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      long l2;
      if (((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i)).memberUin.equals(this.jdField_b_of_type_JavaLangString))
      {
        l2 = l1;
      }
      else
      {
        Object[] arrayOfObject = a((DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i), paramString);
        long l3 = ((Long)arrayOfObject[0]).longValue();
        l2 = l1;
        if (l3 > l1)
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject = (String)arrayOfObject[1];
          l2 = l3;
        }
      }
      i += 1;
      l1 = l2;
    }
    if (localDiscussionMemberInfo != null)
    {
      this.jdField_a_of_type_JavaUtilSet.add(localDiscussionMemberInfo);
      this.jdField_b_of_type_JavaUtilList.add(localObject);
      this.jdField_c_of_type_JavaUtilList.add(paramString);
    }
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Long == -9223372036854775808L)
    {
      l1 = c(paramString);
      if (l1 > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_JavaUtilList.size())
    {
      i = j;
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if ((paramString != null) && (paramString.equals(localDiscussionMemberInfo.memberUin)))
          {
            i = 1;
            break label456;
          }
        }
        i = 0;
        label456:
        if (i == 0)
        {
          i = j;
          break label467;
        }
      }
      i = 0;
    }
    label467:
    this.jdField_b_of_type_Long = IContactSearchable.A;
    paramString = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (i != 0) {
      this.jdField_b_of_type_Long = IContactSearchable.y;
    } else if (paramString.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin))
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Long = IContactSearchable.A;
      } else {
        this.jdField_b_of_type_Long = IContactSearchable.J;
      }
    }
    else {
      this.jdField_b_of_type_Long = IContactSearchable.L;
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
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, 3000, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName, false);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, b().toString(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, "", 3000);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 3, paramView);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 30, paramView, false);
      SearchUtils.a(this.jdField_a_of_type_JavaLangString);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "group", "groups", 0, 0, new String[] { SearchUtils.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
        } else {
          UniteSearchReportController.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
        }
      }
    }
    else
    {
      SearchUtils.a(paramView, this);
    }
    new ReportTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin }).a();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return c();
    }
    return super.b();
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public CharSequence c()
  {
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
  
  public String c()
  {
    return SearchUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
  }
  
  public int d()
  {
    return 3000;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangCharSequence.toString();
  }
  
  public int e()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion
 * JD-Core Version:    0.7.0.1
 */