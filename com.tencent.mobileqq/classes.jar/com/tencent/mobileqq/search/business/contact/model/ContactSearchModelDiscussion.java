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
  boolean a = false;
  private DiscussionInfo b;
  private List<DiscussionMemberInfo> c;
  private long d;
  private String e;
  private List<String> f;
  private List<String> g;
  private Set<DiscussionMemberInfo> h;
  private CharSequence i;
  private CharSequence j;
  private long k = IContactSearchable.P;
  private boolean w = false;
  private String x;
  
  public ContactSearchModelDiscussion(AppInterface paramAppInterface, int paramInt1, DiscussionInfo paramDiscussionInfo, List<DiscussionMemberInfo> paramList, int paramInt2)
  {
    super(paramAppInterface, paramInt1, paramInt2);
    this.b = paramDiscussionInfo;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.c = ((List)localObject);
    this.w = (paramDiscussionInfo.hasRenamed() ^ true);
    this.x = paramAppInterface.getCurrentAccountUin();
    f(7);
  }
  
  private long a(RecentUserProxy paramRecentUserProxy, String paramString1, long paramLong, String paramString2)
  {
    int m = SearchConfigManager.sReduceDiscussionWeight;
    if (m != 0)
    {
      if ((m != 1) && (m != 2)) {
        return SearchUtils.a(paramString2, paramString1, paramLong);
      }
      if (paramRecentUserProxy.a(this.b.uin)) {
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
    int m = 0;
    int n;
    long l1;
    Object localObject1;
    long l2;
    for (;;)
    {
      n = paramList.size();
      l1 = -9223372036854775808L;
      if (m >= n) {
        break;
      }
      n = 0;
      while (n < ((List)paramList.get(m)).size())
      {
        localObject1 = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(m)).get(n)).c;
        if (!((Map)localObject4).containsKey(localObject1))
        {
          ((Map)localObject4).put(localObject1, Integer.valueOf(-1));
          localHashMap1.put(localObject1, Long.valueOf(0L));
        }
        l2 = l1;
        if (((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(m)).get(n)).a > l1) {
          l2 = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(m)).get(n)).a;
        }
        n += 1;
        l1 = l2;
      }
      arrayOfLong[m] = l1;
      m += 1;
    }
    m = 0;
    long l3;
    while (m < paramList.size())
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
        n = m;
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
        if (a(n, paramList, arrayOfLong, localHashMap1, arrayOfInt, (Map)localObject1, localObject2, (Set)localObject4, localHashMap2)) {
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
        m = 0;
        while (m <= n)
        {
          if (localObject3[m] != 0) {
            arrayOfLong[m] -= l2;
          }
          m += 1;
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
      m = n + 1;
      localObject4 = localObject1;
    }
    m = 0;
    while (m < paramList.size())
    {
      l3 = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(m)).get(arrayOfInt[m])).a;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.h.add(((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(m)).get(arrayOfInt[m])).c);
      this.f.add(((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(m)).get(arrayOfInt[m])).b);
      m += 1;
      l1 = l2;
    }
    return l1;
  }
  
  static boolean a(int paramInt, List<List<ContactSearchModelDiscussion.DiscussionMemberMatchInfo>> paramList, long[] paramArrayOfLong, Map<DiscussionMemberInfo, Long> paramMap1, int[] paramArrayOfInt, Map<DiscussionMemberInfo, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<DiscussionMemberInfo> paramSet, Map<DiscussionMemberInfo, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int m = 0;
    while (m < ((List)paramList.get(paramInt)).size())
    {
      DiscussionMemberInfo localDiscussionMemberInfo = ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(paramInt)).get(m)).c;
      if (!paramSet.contains(localDiscussionMemberInfo))
      {
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localDiscussionMemberInfo)).longValue() - ((ContactSearchModelDiscussion.DiscussionMemberMatchInfo)((List)paramList.get(paramInt)).get(m)).a;
        if (l == 0L)
        {
          paramSet.add(localDiscussionMemberInfo);
          int n = ((Integer)paramMap.get(localDiscussionMemberInfo)).intValue();
          if (n != -1) {
            if (!a(n, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)) {
              break label234;
            }
          }
          paramMap.put(localDiscussionMemberInfo, Integer.valueOf(paramInt));
          paramArrayOfInt[paramInt] = m;
          return true;
        }
        else if (l < ((Long)paramMap2.get(localDiscussionMemberInfo)).longValue())
        {
          paramMap2.put(localDiscussionMemberInfo, Long.valueOf(l));
        }
      }
      label234:
      m += 1;
    }
    return false;
  }
  
  private Object[] a(DiscussionMemberInfo paramDiscussionMemberInfo, String paramString)
  {
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.m.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    long l2 = a(localRecentUserProxy, paramDiscussionMemberInfo.inteRemark, IContactSearchable.o, paramString);
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
    long l3 = a(localRecentUserProxy, paramDiscussionMemberInfo.memberName, IContactSearchable.p, paramString);
    long l1 = l2;
    if (l3 > l2)
    {
      str = paramDiscussionMemberInfo.memberName;
      l1 = l3;
    }
    Friends localFriends = e(paramDiscussionMemberInfo.memberUin);
    l3 = l1;
    paramDiscussionMemberInfo = str;
    if (localFriends != null)
    {
      l3 = l1;
      paramDiscussionMemberInfo = str;
      if (localFriends.isFriend())
      {
        l3 = a(localRecentUserProxy, localFriends.remark, IContactSearchable.n, paramString);
        l2 = l1;
        paramDiscussionMemberInfo = str;
        if (l3 > l1)
        {
          paramDiscussionMemberInfo = localFriends.remark;
          l2 = l3;
        }
        l1 = a(localRecentUserProxy, localFriends.name, IContactSearchable.p, paramString);
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
  
  private Friends e(String paramString)
  {
    return ((IFriendDataService)this.m.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
  }
  
  private long f(String paramString)
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
        int m = 0;
        while (m < paramString.length)
        {
          this.g.add(paramString[m]);
          ArrayList localArrayList2 = new ArrayList();
          localArrayList1.add(localArrayList2);
          int n = 0;
          while (n < this.c.size())
          {
            if (!((DiscussionMemberInfo)this.c.get(n)).memberUin.equals(this.x))
            {
              Object[] arrayOfObject = a((DiscussionMemberInfo)this.c.get(n), paramString[m]);
              l1 = ((Long)arrayOfObject[0]).longValue();
              if (l1 != -9223372036854775808L)
              {
                ContactSearchModelDiscussion.DiscussionMemberMatchInfo localDiscussionMemberMatchInfo = new ContactSearchModelDiscussion.DiscussionMemberMatchInfo();
                localDiscussionMemberMatchInfo.a = l1;
                localDiscussionMemberMatchInfo.b = ((String)arrayOfObject[1]);
                localDiscussionMemberMatchInfo.c = ((DiscussionMemberInfo)this.c.get(n));
                localArrayList2.add(localDiscussionMemberMatchInfo);
              }
            }
            n += 1;
          }
          if (localArrayList2.isEmpty()) {
            return -9223372036854775808L;
          }
          m += 1;
        }
        l1 = a(localArrayList1);
      }
    }
    return l1;
  }
  
  private void s()
  {
    boolean bool = SearchUtils.b(this.n);
    int i3 = 0;
    int m = 0;
    if ((!bool) && (this.n != 5))
    {
      this.i = HardCodeUtil.a(2131900739);
      localObject1 = new SpannableStringBuilder();
      if (!this.b.hasRenamed())
      {
        ((SpannableStringBuilder)localObject1).append("(");
        localObject2 = this.c;
        if (localObject2 != null) {
          m = ((List)localObject2).size();
        }
        ((SpannableStringBuilder)localObject1).append(String.valueOf(m));
        ((SpannableStringBuilder)localObject1).append(")");
      }
      else if (!this.f.isEmpty())
      {
        ((SpannableStringBuilder)localObject1).append("(");
        m = this.f.size() - 1;
        while (m >= 0)
        {
          ((SpannableStringBuilder)localObject1).append(SearchUtils.b((String)this.f.get(m), (String)this.g.get(m), 6));
          if (m > 0) {
            ((SpannableStringBuilder)localObject1).append("、");
          }
          m -= 1;
        }
        ((SpannableStringBuilder)localObject1).append(")");
      }
      this.j = ((CharSequence)localObject1);
      return;
    }
    Object localObject2 = new SpannableStringBuilder();
    if (this.c != null)
    {
      ((SpannableStringBuilder)localObject2).append("包含: ");
      int n = this.f.size() - 1;
      m = 0;
      int i2;
      for (;;)
      {
        if (n >= 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (m < 10) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((i1 & i2) == 0) {
          break;
        }
        ((SpannableStringBuilder)localObject2).append(SearchUtils.b((String)this.f.get(n), (String)this.g.get(n), 6));
        m += 1;
        if (m < this.c.size()) {
          ((SpannableStringBuilder)localObject2).append("、");
        }
        n -= 1;
      }
      int i1 = 0;
      n = m;
      m = i1;
      for (;;)
      {
        if (m < this.c.size()) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (n < 10) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((i1 & i2) == 0) {
          break;
        }
        localObject1 = (DiscussionMemberInfo)this.c.get(m);
        i1 = n;
        if (!this.h.contains(localObject1))
        {
          if (((DiscussionMemberInfo)localObject1).inteRemark != null) {
            localObject1 = ((DiscussionMemberInfo)localObject1).inteRemark;
          } else {
            localObject1 = ((DiscussionMemberInfo)localObject1).memberName;
          }
          i1 = n;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            n += 1;
            ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
            i1 = n;
            if (n < this.c.size())
            {
              ((SpannableStringBuilder)localObject2).append("、");
              i1 = n;
            }
          }
        }
        m += 1;
        n = i1;
      }
    }
    this.i = ((CharSequence)localObject2);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("(");
    localObject2 = this.c;
    m = i3;
    if (localObject2 != null) {
      m = ((List)localObject2).size();
    }
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131900681));
    this.j = ((StringBuilder)localObject1).toString();
  }
  
  public CharSequence a()
  {
    return this.i;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.m, this.b.uin, 3000, this.b.discussionName, false);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.e);
      SearchUtils.a(this.m, d().toString(), this.b.uin, "", 3000);
      SearchUtils.a(this.e, 20, 3, paramView);
      SearchUtils.a(this.e, 30, paramView, false);
      SearchUtils.b(this.e);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "group", "groups", 0, 0, new String[] { SearchUtils.a(this.n) });
      }
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.e, this.p, (String)i(), o());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) {
        if ((this.p != null) && (!TextUtils.isEmpty(this.p))) {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D31", 2, 0, null, null);
        } else {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D3B", 0, 0, null, null);
        }
      }
    }
    else
    {
      SearchUtils.a(paramView, this);
    }
    new ReportTask(this.m).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.b.uin }).a();
  }
  
  public int b()
  {
    return 101;
  }
  
  public String c()
  {
    return this.b.uin;
  }
  
  public CharSequence d()
  {
    if (this.w) {
      return m();
    }
    return super.d();
  }
  
  public CharSequence e()
  {
    return this.j;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.b.uin;
  }
  
  public int j()
  {
    return 3000;
  }
  
  public String m()
  {
    return SearchUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), this.b);
  }
  
  public String n()
  {
    return this.j.toString();
  }
  
  protected long n_(String paramString)
  {
    this.a = false;
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = new HashSet();
    this.e = paramString;
    this.d = -9223372036854775808L;
    boolean bool = this.w;
    int n = 1;
    if (!bool)
    {
      l1 = SearchUtils.b(paramString, this.b.discussionName, IContactSearchable.i);
      if (l1 > this.d)
      {
        this.d = l1;
        this.a = true;
      }
    }
    long l1 = -9223372036854775808L;
    DiscussionMemberInfo localDiscussionMemberInfo = null;
    Object localObject = localDiscussionMemberInfo;
    int m = 0;
    while (m < this.c.size())
    {
      long l2;
      if (((DiscussionMemberInfo)this.c.get(m)).memberUin.equals(this.x))
      {
        l2 = l1;
      }
      else
      {
        Object[] arrayOfObject = a((DiscussionMemberInfo)this.c.get(m), paramString);
        long l3 = ((Long)arrayOfObject[0]).longValue();
        l2 = l1;
        if (l3 > l1)
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)this.c.get(m);
          localObject = (String)arrayOfObject[1];
          l2 = l3;
        }
      }
      m += 1;
      l1 = l2;
    }
    if (localDiscussionMemberInfo != null)
    {
      this.h.add(localDiscussionMemberInfo);
      this.f.add(localObject);
      this.g.add(paramString);
    }
    if (l1 > this.d)
    {
      this.d = l1;
      this.a = false;
    }
    if (this.d == -9223372036854775808L)
    {
      l1 = f(paramString);
      if (l1 > this.d)
      {
        this.d = l1;
        this.a = false;
      }
    }
    if (this.h.size() == this.c.size())
    {
      m = n;
    }
    else
    {
      if (this.h.size() == this.c.size() - 1)
      {
        paramString = this.m.getCurrentAccountUin();
        localObject = this.h.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if ((paramString != null) && (paramString.equals(localDiscussionMemberInfo.memberUin)))
          {
            m = 1;
            break label456;
          }
        }
        m = 0;
        label456:
        if (m == 0)
        {
          m = n;
          break label467;
        }
      }
      m = 0;
    }
    label467:
    this.k = IContactSearchable.E;
    paramString = ((IRecentUserProxyService)this.m.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (m != 0) {
      this.k = IContactSearchable.C;
    } else if (paramString.a(this.b.uin))
    {
      if (this.a) {
        this.k = IContactSearchable.E;
      } else {
        this.k = IContactSearchable.N;
      }
    }
    else {
      this.k = IContactSearchable.P;
    }
    l1 = this.d;
    if (l1 != -9223372036854775808L)
    {
      this.d = (l1 + this.k);
      s();
    }
    return this.d;
  }
  
  public int o()
  {
    return 3;
  }
  
  protected boolean p()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion
 * JD-Core Version:    0.7.0.1
 */