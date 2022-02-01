package com.tencent.mobileqq.search.business.contact.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelTroopMember
  extends IContactSearchModel
{
  private TroopMemberInfo a;
  private String b;
  private long c;
  private int d = 1;
  private String e;
  private String f;
  
  public ContactSearchModelTroopMember(AppInterface paramAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramAppInterface, paramInt, 0L);
    this.a = paramTroopMemberInfo;
    f(6);
  }
  
  private void s()
  {
    int i = this.d;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          this.e = this.a.autoremark;
          this.f = SearchUtils.a(new String[] { this.a.friendnick, this.a.memberuin });
          return;
        }
        this.e = this.a.troopnick;
        this.f = SearchUtils.a(new String[] { this.a.friendnick, this.a.memberuin });
        return;
      }
      this.e = SearchUtils.a(new String[] { this.a.troopnick, this.a.autoremark });
      if (!TextUtils.isEmpty(this.e))
      {
        this.f = this.a.friendnick;
        return;
      }
      this.e = this.a.friendnick;
      this.f = this.a.memberuin;
      return;
    }
    this.e = SearchUtils.a(new String[] { this.a.troopnick, this.a.autoremark, this.a.friendnick });
    this.f = this.a.memberuin;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.b(this.n)) {
      return HardCodeUtil.a(2131900701);
    }
    return HardCodeUtil.a(2131900692);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterTroopTmpChatWin(paramView.getContext(), this.a.memberuin, this.a.troopuin, 1000, m(), false, null, null);
      SearchUtils.a(this.b, 20, 1, paramView);
      SearchUtils.a(this.b, 20, paramView, false);
      SearchUtils.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        SearchUtils.a("search", "contact", "contacts", 0, 0, new String[] { SearchUtils.a(this.n) });
      }
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.b, this.p, (String)i(), o());
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
    else
    {
      SearchUtils.a(paramView, this);
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return this.a.memberuin;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.a.memberuin;
  }
  
  public int j()
  {
    return 1000;
  }
  
  public String m()
  {
    return this.e;
  }
  
  public String n()
  {
    return this.f;
  }
  
  protected long n_(String paramString)
  {
    this.b = paramString;
    this.c = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.a.troopnick, IContactSearchable.k);
    if (l > this.c)
    {
      this.c = l;
      this.d = 2;
    }
    l = SearchUtils.b(paramString, this.a.autoremark, IContactSearchable.o);
    if (l > this.c)
    {
      this.c = l;
      this.d = 3;
    }
    l = SearchUtils.b(paramString, this.a.friendnick, IContactSearchable.p);
    if (l > this.c)
    {
      this.c = l;
      this.d = 1;
    }
    l = SearchUtils.a(paramString, this.a.memberuin, IContactSearchable.s, false);
    if (l > this.c)
    {
      this.c = l;
      this.d = 0;
    }
    l = this.c;
    if (l != -9223372036854775808L)
    {
      this.c = (l + IContactSearchable.D);
      s();
    }
    return this.c;
  }
  
  public int o()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroopMember
 * JD-Core Version:    0.7.0.1
 */