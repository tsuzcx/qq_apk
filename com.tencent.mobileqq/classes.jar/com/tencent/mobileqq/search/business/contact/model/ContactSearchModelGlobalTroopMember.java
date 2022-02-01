package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

public class ContactSearchModelGlobalTroopMember
  extends IContactSearchModel
{
  public String a;
  protected String b;
  protected String c;
  protected String d;
  protected long e;
  protected int f;
  protected String g;
  protected String h;
  protected String i;
  protected TroopInfo j;
  protected long k = IContactSearchable.Z;
  
  public ContactSearchModelGlobalTroopMember(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramAppInterface, paramInt, 0L);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.j = SearchUtils.g(paramAppInterface, this.a);
    if (this.j.isNewTroop()) {
      this.k = IContactSearchable.K;
    }
    f(6);
  }
  
  private void s()
  {
    int m = this.f;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          this.g = "";
          this.h = null;
          return;
        }
        this.g = this.c;
        if (!TextUtils.isEmpty(this.d))
        {
          this.h = this.d;
          return;
        }
        this.h = this.b;
        return;
      }
      if (!TextUtils.isEmpty(this.c))
      {
        this.g = this.c;
        this.h = this.d;
        return;
      }
      this.g = this.d;
      this.h = this.b;
      return;
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.g = this.c;
      this.h = this.b;
      return;
    }
    if (!TextUtils.isEmpty(this.d))
    {
      this.g = this.d;
      this.h = this.b;
      return;
    }
    this.g = this.b;
    this.h = null;
  }
  
  public CharSequence a()
  {
    String str = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).getTroopName(this.m, this.a, true);
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131900685));
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131900677);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      String str2 = SearchUtils.f(this.m, this.a);
      Object localObject = SearchUtils.d(this.m, this.b);
      if (!((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isRobotUin(this.b))
      {
        if ((localObject != null) && (((Friends)localObject).isFriend()))
        {
          ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.m, this.b, 0, SearchUtils.a((Friends)localObject), false);
          SearchUtils.a(this.m, SearchUtils.a((Friends)localObject), this.b, "", 0);
        }
        else
        {
          ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.b, str2, 1000, d().toString(), false, null, null);
          String str1 = d().toString();
          localObject = str1;
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isColorLevel()) {
              QLog.d(l, 2, "saveSearchHistory title is null");
            }
            str1 = m();
            localObject = str1;
            if (TextUtils.isEmpty(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.d(l, 2, "saveSearchHistory titlestr is null");
              }
              localObject = n();
            }
          }
          SearchUtils.a(this.m, (String)localObject, this.b, str2, 1000);
        }
      }
      else
      {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).openRobotProfileCard(paramView.getContext(), null, this.b);
        SearchUtils.a(this.m, d().toString(), this.b, str2, 1000);
      }
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.i);
      SearchUtils.a(this.i, 20, 1, paramView);
      SearchUtils.a(this.i, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.n) });
      }
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.i, this.p, (String)i(), o());
      }
      if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(paramView.getContext()))
      {
        if ((this.p != null) && (!TextUtils.isEmpty(this.p)))
        {
          UniteSearchReportController.a(null, 0, this.n, "0X8009D31", 1, 0, null, null);
          return;
        }
        UniteSearchReportController.a(null, 0, this.n, "0X8009D37", 0, 0, null, null);
      }
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.b;
  }
  
  public int j()
  {
    return 1000;
  }
  
  public String m()
  {
    return this.g;
  }
  
  public String n()
  {
    return this.h;
  }
  
  protected long n_(String paramString)
  {
    this.i = paramString;
    this.e = -9223372036854775808L;
    boolean bool = this.j.isNewTroop() ^ true;
    if (this.j.isNewTroop()) {
      l = IContactSearchable.m;
    } else {
      l = IContactSearchable.u;
    }
    long l = SearchUtils.a(paramString, this.c, l, false, false, bool);
    if (l > this.e)
    {
      this.e = l;
      this.f = 2;
    }
    if (this.j.isNewTroop()) {
      l = IContactSearchable.l;
    } else {
      l = IContactSearchable.p;
    }
    l = SearchUtils.a(paramString, this.d, l, false, false, bool);
    if (l > this.e)
    {
      this.e = l;
      this.f = 1;
    }
    l = SearchUtils.a(paramString, this.b, IContactSearchable.s, false, true, true);
    if (l > this.e)
    {
      this.e = l;
      this.f = 0;
    }
    l = this.e;
    if (l != -9223372036854775808L)
    {
      this.e = (l + this.k);
      s();
    }
    return this.e;
  }
  
  public int o()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGlobalTroopMember
 * JD-Core Version:    0.7.0.1
 */