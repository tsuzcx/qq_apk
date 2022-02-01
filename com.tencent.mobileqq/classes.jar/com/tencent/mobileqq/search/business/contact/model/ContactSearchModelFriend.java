package com.tencent.mobileqq.search.business.contact.model;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.model.SearchMatchResult;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpellingAll;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ContactSearchModelFriend
  extends IContactSearchModel
{
  public ChnToSpell.ChnSpelling a;
  public ChnToSpell.ChnSpelling b;
  public ChnToSpell.ChnSpellingAll c;
  public ChnToSpell.ChnSpelling d;
  public ChnToSpell.ChnSpelling e;
  public ChnToSpell.ChnSpellingAll f;
  private Friends g;
  private String h;
  private long i;
  private int j;
  private String k;
  private String w;
  private String x;
  private long y = IContactSearchable.I;
  
  public ContactSearchModelFriend(AppInterface paramAppInterface, int paramInt, Friends paramFriends, String paramString, long paramLong)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.h = paramString;
    this.g = paramFriends;
    if (((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().e(paramFriends.uin)) {
      this.y = IContactSearchable.D;
    } else if (paramFriends.gathtertype == 1) {
      this.y = IContactSearchable.J;
    } else if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isQidianMaster(paramFriends.cSpecialFlag)) {
      this.y = IContactSearchable.aa;
    } else if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isSpecialCareInfo(paramFriends.uin)) {
      this.y = IContactSearchable.H;
    }
    if (!TextUtils.isEmpty(paramFriends.remark))
    {
      this.c = ChnToSpell.a(paramFriends.remark);
      paramAppInterface = this.c;
      if (paramAppInterface != null)
      {
        this.a = paramAppInterface.a();
        this.b = this.c.b();
      }
    }
    if (!TextUtils.isEmpty(paramFriends.name))
    {
      this.f = ChnToSpell.a(paramFriends.name);
      paramAppInterface = this.f;
      if (paramAppInterface != null)
      {
        this.d = paramAppInterface.a();
        this.e = this.f.b();
      }
    }
    f(6);
  }
  
  private void t()
  {
    int m = this.j;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            this.k = "";
            return;
          }
          if (!TextUtils.isEmpty(this.g.remark))
          {
            this.k = this.g.remark;
            this.w = this.g.alias;
            return;
          }
          if (!TextUtils.isEmpty(this.g.name))
          {
            this.k = this.g.name;
            this.w = this.g.alias;
            return;
          }
          this.k = this.g.alias;
          this.w = this.g.uin;
          return;
        }
        this.k = this.g.remark;
        this.w = SearchUtils.a(new String[] { this.g.name, this.g.alias, this.g.uin });
        return;
      }
      if (!TextUtils.isEmpty(this.g.remark))
      {
        this.k = this.g.remark;
        this.w = this.g.name;
        return;
      }
      this.k = this.g.name;
      this.w = SearchUtils.a(new String[] { this.g.alias, this.g.uin });
      return;
    }
    if (!TextUtils.isEmpty(this.g.remark))
    {
      this.k = this.g.remark;
      this.w = this.g.uin;
      return;
    }
    if (!TextUtils.isEmpty(this.g.name))
    {
      this.k = this.g.name;
      this.w = this.g.uin;
      return;
    }
    this.k = this.g.uin;
    this.w = null;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.b(this.n))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131900702));
      localStringBuilder.append(this.h);
      return localStringBuilder.toString();
    }
    return this.h;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    Object localObject;
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).setContactSearchRecentAndHistroy(paramView.getContext(), this.m, this.g.uin, this.g, this.x, paramView);
      String str = d().toString();
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d(l, 2, "saveSearchHistory title is null");
        }
        str = m();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d(l, 2, "saveSearchHistory titlestr is null");
          }
          localObject = n();
        }
      }
      SearchUtils.a(this.m, (String)localObject, this.g.uin, "", 0);
      SearchUtils.a(this.x, 20, paramView, false);
      ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).reportContactResultItemClick(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.n) });
      }
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.x, this.p, (String)i(), o());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
      {
        if ((this.p != null) && (!TextUtils.isEmpty(this.p)))
        {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D31", ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getMostUseConstantsReportContact(), 0, null, null);
          return;
        }
        UniteSearchReportController.a(null, 0, this.n, "0X8009D37", 0, 0, null, null);
      }
    }
    else
    {
      if (11 == this.n)
      {
        localObject = (QBaseActivity)paramView.getContext();
        if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isSpecialCareInfo(this.g.uin))
        {
          QQToast.makeText((Context)localObject, ((QBaseActivity)localObject).getString(2131897332), 0).show(((QBaseActivity)localObject).getTitleBarHeight());
          return;
        }
      }
      ((ISearchUtilFetcher)QRoute.api(ISearchUtilFetcher.class)).selectContactResult(paramView, this);
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public SearchMatchResult b(String paramString)
  {
    this.x = paramString;
    Object localObject1 = ChnToSpell.a(paramString);
    SearchMatchResult localSearchMatchResult = SearchUtils.a(paramString, (ChnToSpell.ChnSpellingAll)localObject1, this.g.remark, this.c, IContactSearchable.k);
    localObject1 = SearchUtils.a(paramString, (ChnToSpell.ChnSpellingAll)localObject1, this.g.name, this.f, IContactSearchable.k);
    Object localObject2;
    if ((localSearchMatchResult != null) && (localSearchMatchResult.a))
    {
      if ((localObject1 != null) && (((SearchMatchResult)localObject1).a) && (((SearchMatchResult)localObject1).h > localSearchMatchResult.h)) {
        this.j = 1;
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        this.j = 2;
        localObject2 = localSearchMatchResult;
      }
    }
    else
    {
      localObject2 = null;
    }
    if ((localObject2 != null) && (((SearchMatchResult)localObject2).a))
    {
      this.r = true;
      this.q = ((SearchMatchResult)localObject2);
      t();
      return localObject2;
    }
    return super.b(paramString);
  }
  
  public String c()
  {
    return this.g.uin;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.x;
  }
  
  public boolean h()
  {
    if ((this.n != 21) && (this.n != 1)) {
      return this.n == 2;
    }
    return true;
  }
  
  public Object i()
  {
    return this.g.uin;
  }
  
  public int j()
  {
    return 0;
  }
  
  public String m()
  {
    return this.k;
  }
  
  public String n()
  {
    return this.w;
  }
  
  protected long n_(String paramString)
  {
    this.x = paramString;
    this.i = -9223372036854775808L;
    long l = SearchUtils.a(paramString, this.g.remark, this.a, this.b, IContactSearchable.k);
    if (l > this.i)
    {
      this.i = l;
      this.j = 2;
    }
    l = SearchUtils.a(paramString, this.g.name, this.d, this.e, IContactSearchable.p);
    if (l > this.i)
    {
      this.i = l;
      this.j = 1;
    }
    l = SearchUtils.a(paramString, this.g.alias, IContactSearchable.r, false);
    if (l > this.i)
    {
      this.i = l;
      this.j = 3;
    }
    if (!TextUtils.isEmpty(this.g.strMasterUin)) {
      l = SearchUtils.a(paramString, this.g.strMasterUin, IContactSearchable.s, false);
    } else {
      l = SearchUtils.a(paramString, this.g.uin, IContactSearchable.s, false);
    }
    if (l > this.i)
    {
      this.i = l;
      this.j = 0;
    }
    l = this.i;
    if (l != -9223372036854775808L)
    {
      this.i = (l + this.y);
      t();
    }
    return this.i;
  }
  
  public int o()
  {
    return 1;
  }
  
  public CharSequence q()
  {
    CharSequence localCharSequence1 = d();
    CharSequence localCharSequence2 = e();
    int m = this.j;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2) {
          if (m == 3) {
            break label89;
          }
        } else {
          return localCharSequence1;
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.g.remark)) {
          return localCharSequence1;
        }
        if ((localCharSequence2 != null) && (localCharSequence2.length() > 2)) {
          return localCharSequence2.subSequence(1, localCharSequence2.length() - 1);
        }
      }
      return super.q();
    }
    label89:
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (localCharSequence1 != null) {
      localSpannableStringBuilder.append(localCharSequence1);
    }
    if (localCharSequence2 != null) {
      localSpannableStringBuilder.append(localCharSequence2);
    }
    return localSpannableStringBuilder;
  }
  
  public Pair<CharSequence, CharSequence> r()
  {
    int m = this.j;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return null;
          }
          if (!TextUtils.isEmpty(this.g.remark)) {
            return new Pair(this.g.remark, SearchUtils.c(this.g.alias, this.x, 6, true));
          }
          if (!TextUtils.isEmpty(this.g.name)) {
            return new Pair(this.g.name, SearchUtils.c(this.g.alias, this.x, 6, true));
          }
          return new Pair(SearchUtils.b(this.g.alias, this.x, 6, true), null);
        }
        return new Pair(SearchUtils.b(this.g.remark, this.x, 6, true), null);
      }
      if (!TextUtils.isEmpty(this.g.remark)) {
        return new Pair(this.g.remark, SearchUtils.c(this.g.name, this.x, 6, true));
      }
      return new Pair(SearchUtils.b(this.g.name, this.x, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.g.remark)) {
      return new Pair(this.g.remark, SearchUtils.c(this.g.uin, this.x, 6, false));
    }
    if (!TextUtils.isEmpty(this.g.name)) {
      return new Pair(this.g.name, SearchUtils.c(this.g.uin, this.x, 6, false));
    }
    return new Pair(SearchUtils.b(this.g.uin, this.x, 6, false), null);
  }
  
  public int s()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend
 * JD-Core Version:    0.7.0.1
 */