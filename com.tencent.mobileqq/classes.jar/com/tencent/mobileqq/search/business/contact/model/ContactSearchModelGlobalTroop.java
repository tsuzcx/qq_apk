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
  public String a;
  protected List<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> b;
  protected String c;
  protected CharSequence d;
  protected List<String> e;
  protected List<String> f;
  protected Set<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> g;
  protected TroopInfo h;
  private long i;
  private long j = IContactSearchable.X;
  
  public ContactSearchModelGlobalTroop(AppInterface paramAppInterface, int paramInt, String paramString, List<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> paramList)
  {
    super(paramAppInterface, paramInt, 0L);
    this.a = paramString;
    this.b = paramList;
    this.h = SearchUtils.g(paramAppInterface, this.a);
    if (((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramString)) {
      if (this.h.isNewTroop()) {
        this.j = IContactSearchable.O;
      } else {
        this.j = IContactSearchable.Y;
      }
    }
    f(7);
  }
  
  private long a(RecentUserProxy paramRecentUserProxy, String paramString1, long paramLong, String paramString2)
  {
    int k = SearchConfigManager.sReduceDiscussionWeight;
    if ((k != 0) && (k != 1))
    {
      if (k != 2) {
        return SearchUtils.a(paramString2, paramString1, paramLong, false, false, true);
      }
      if (paramRecentUserProxy.a(this.a)) {
        return SearchUtils.a(paramString2, paramString1, paramLong, false, false, false);
      }
      return SearchUtils.a(paramString2, paramString1, paramLong, false, false, true);
    }
    return SearchUtils.a(paramString2, paramString1, paramLong, false, false, this.h.isNewTroop() ^ true);
  }
  
  private long a(List<List<ContactSearchModelGlobalTroop.TroopMemberMatchInfo>> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int[] arrayOfInt = new int[paramList.size()];
    Object localObject4 = new HashMap();
    int k = 0;
    int m;
    long l1;
    Object localObject1;
    long l2;
    for (;;)
    {
      m = paramList.size();
      l1 = -9223372036854775808L;
      if (k >= m) {
        break;
      }
      m = 0;
      while (m < ((List)paramList.get(k)).size())
      {
        localObject1 = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(k)).get(m)).c;
        if (!((Map)localObject4).containsKey(localObject1))
        {
          ((Map)localObject4).put(localObject1, Integer.valueOf(-1));
          localHashMap1.put(localObject1, Long.valueOf(0L));
        }
        l2 = l1;
        if (((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(k)).get(m)).a > l1) {
          l2 = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(k)).get(m)).a;
        }
        m += 1;
        l1 = l2;
      }
      arrayOfLong[k] = l1;
      k += 1;
    }
    k = 0;
    long l3;
    while (k < paramList.size())
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
        m = k;
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
        if (a(m, paramList, arrayOfLong, localHashMap1, arrayOfInt, (Map)localObject1, localObject2, (Set)localObject4, localHashMap2)) {
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
        k = 0;
        while (k <= m)
        {
          if (localObject3[k] != 0) {
            arrayOfLong[k] -= l2;
          }
          k += 1;
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
      k = m + 1;
      localObject4 = localObject1;
    }
    k = 0;
    while (k < paramList.size())
    {
      l3 = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(k)).get(arrayOfInt[k])).a;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.g.add(((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(k)).get(arrayOfInt[k])).c);
      this.e.add(((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(k)).get(arrayOfInt[k])).b);
      k += 1;
      l1 = l2;
    }
    return l1;
  }
  
  static boolean a(int paramInt, List<List<ContactSearchModelGlobalTroop.TroopMemberMatchInfo>> paramList, long[] paramArrayOfLong, Map<ContactSearchModelGlobalTroop.TroopSearchMemberInfo, Long> paramMap1, int[] paramArrayOfInt, Map<ContactSearchModelGlobalTroop.TroopSearchMemberInfo, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> paramSet, Map<ContactSearchModelGlobalTroop.TroopSearchMemberInfo, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int k = 0;
    while (k < ((List)paramList.get(paramInt)).size())
    {
      ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(paramInt)).get(k)).c;
      if (!paramSet.contains(localTroopSearchMemberInfo))
      {
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localTroopSearchMemberInfo)).longValue() - ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)((List)paramList.get(paramInt)).get(k)).a;
        if (l == 0L)
        {
          paramSet.add(localTroopSearchMemberInfo);
          int m = ((Integer)paramMap.get(localTroopSearchMemberInfo)).intValue();
          if (m != -1) {
            if (!a(m, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)) {
              break label234;
            }
          }
          paramMap.put(localTroopSearchMemberInfo, Integer.valueOf(paramInt));
          paramArrayOfInt[paramInt] = k;
          return true;
        }
        else if (l < ((Long)paramMap2.get(localTroopSearchMemberInfo)).longValue())
        {
          paramMap2.put(localTroopSearchMemberInfo, Long.valueOf(l));
        }
      }
      label234:
      k += 1;
    }
    return false;
  }
  
  private Object[] a(ContactSearchModelGlobalTroop.TroopSearchMemberInfo paramTroopSearchMemberInfo, String paramString)
  {
    RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.m.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if (this.h.isNewTroop()) {
      l1 = IContactSearchable.m;
    } else {
      l1 = IContactSearchable.u;
    }
    long l1 = a(localRecentUserProxy, paramTroopSearchMemberInfo.c, l1, paramString);
    String str;
    if (l1 > -9223372036854775808L)
    {
      str = paramTroopSearchMemberInfo.c;
      paramTroopSearchMemberInfo.f = 66;
    }
    else
    {
      str = null;
      l1 = -9223372036854775808L;
    }
    long l3;
    if (this.h.isNewTroop()) {
      l3 = IContactSearchable.l;
    } else {
      l3 = IContactSearchable.p;
    }
    long l4 = a(localRecentUserProxy, paramTroopSearchMemberInfo.b, l3, paramString);
    long l2 = l1;
    if (l4 > l1)
    {
      str = paramTroopSearchMemberInfo.b;
      paramTroopSearchMemberInfo.f = 88;
      l2 = l4;
    }
    l1 = a(localRecentUserProxy, paramTroopSearchMemberInfo.d, l3, paramString);
    if (l1 > l2)
    {
      str = paramTroopSearchMemberInfo.d;
      paramTroopSearchMemberInfo.f = 99;
      l2 = l1;
    }
    return new Object[] { Long.valueOf(l2), str };
  }
  
  private long e(String paramString)
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
        int k = 0;
        while (k < paramString.length)
        {
          this.f.add(paramString[k]);
          ArrayList localArrayList2 = new ArrayList();
          localArrayList1.add(localArrayList2);
          int m = 0;
          while (m < this.b.size())
          {
            Object localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.b.get(m);
            Object[] arrayOfObject = a((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject, paramString[k]);
            l1 = ((Long)arrayOfObject[0]).longValue();
            if ((((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).e == -9223372036854775808L) || (l1 > ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).e))
            {
              ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).e = l1;
              ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).g = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).f;
            }
            if (l1 != -9223372036854775808L)
            {
              localObject = new ContactSearchModelGlobalTroop.TroopMemberMatchInfo();
              ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)localObject).a = l1;
              ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)localObject).b = ((String)arrayOfObject[1]);
              ((ContactSearchModelGlobalTroop.TroopMemberMatchInfo)localObject).c = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.b.get(m));
              localArrayList2.add(localObject);
            }
            m += 1;
          }
          if (localArrayList2.isEmpty()) {
            return -9223372036854775808L;
          }
          k += 1;
        }
        l1 = a(localArrayList1);
      }
    }
    return l1;
  }
  
  public CharSequence a()
  {
    return this.d;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      String str = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.m, this.a, true);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.m, this.a, 1, str, false);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.c);
      SearchUtils.a(this.m, d().toString(), this.a, "", 1);
      SearchUtils.a(this.c, 20, 2, paramView);
      SearchUtils.a(this.c, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.c, this.p, (String)i(), o());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext())) {
        if ((this.p != null) && (!TextUtils.isEmpty(this.p))) {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D31", 2, 0, null, null);
        } else {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D3B", 0, 0, null, null);
        }
      }
    }
    if (SearchConfigManager.needSeparate) {
      SearchUtils.a("search", "group", "groups", 0, 0, new String[] { SearchUtils.a(this.n) });
    }
  }
  
  public int b()
  {
    return 4;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public CharSequence d()
  {
    if ((this.h.isNewTroop()) && (!this.h.hasSetTroopName())) {
      return m();
    }
    return super.d();
  }
  
  public long dk_()
  {
    return super.dk_();
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.a;
  }
  
  public int j()
  {
    return 1;
  }
  
  public String m()
  {
    return ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getRealTroopName(this.m, this.a, true);
  }
  
  public String n()
  {
    return this.a;
  }
  
  protected long n_(String paramString)
  {
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new HashSet();
    this.c = paramString;
    this.i = -9223372036854775808L;
    long l1 = -9223372036854775808L;
    ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = null;
    Object localObject = localTroopSearchMemberInfo;
    int k = 0;
    while (k < this.b.size())
    {
      Object[] arrayOfObject = a((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.b.get(k), paramString);
      long l3 = ((Long)arrayOfObject[0]).longValue();
      long l2 = l1;
      if (l3 > l1)
      {
        localTroopSearchMemberInfo = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.b.get(k);
        localObject = (String)arrayOfObject[1];
        l2 = l3;
      }
      k += 1;
      l1 = l2;
    }
    if (localTroopSearchMemberInfo != null)
    {
      this.g.add(localTroopSearchMemberInfo);
      this.e.add(localObject);
      this.f.add(paramString);
    }
    if (l1 > this.i) {
      this.i = l1;
    }
    if (this.i == -9223372036854775808L)
    {
      l1 = e(paramString);
      if (l1 > this.i) {
        this.i = l1;
      }
    }
    l1 = this.i;
    if (l1 != -9223372036854775808L)
    {
      this.i = (l1 + this.j);
      s();
    }
    return this.i;
  }
  
  public int o()
  {
    return 2;
  }
  
  protected void s()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.b != null)
    {
      localSpannableStringBuilder.append("包含: ");
      int m = this.e.size() - 1;
      int k = 0;
      int i1;
      for (;;)
      {
        if (m >= 0) {
          n = 1;
        } else {
          n = 0;
        }
        if (k < 10) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((n & i1) == 0) {
          break;
        }
        localSpannableStringBuilder.append(SearchUtils.a((String)this.e.get(m), (String)this.f.get(m), 6, false));
        k += 1;
        localSpannableStringBuilder.append("、");
        m -= 1;
      }
      int n = 0;
      m = k;
      k = n;
      for (;;)
      {
        if (k < this.b.size()) {
          n = 1;
        } else {
          n = 0;
        }
        if (m < 10) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((n & i1) == 0) {
          break;
        }
        Object localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.b.get(k);
        n = m;
        if (!this.g.contains(localObject))
        {
          if (this.f.size() == 1) {
            i1 = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).f;
          } else {
            i1 = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).g;
          }
          if (i1 == 66)
          {
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).c;
          }
          else if (i1 == 88)
          {
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).b;
          }
          else
          {
            n = m;
            if (i1 != 99) {
              break label320;
            }
            localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).d;
          }
          n = m;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            n = m + 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            localSpannableStringBuilder.append("、");
          }
        }
        label320:
        k += 1;
        m = n;
      }
    }
    if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、'))
    {
      this.d = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      return;
    }
    this.d = localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroop
 * JD-Core Version:    0.7.0.1
 */