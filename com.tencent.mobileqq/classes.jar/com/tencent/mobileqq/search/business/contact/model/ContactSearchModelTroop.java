package com.tencent.mobileqq.search.business.contact.model;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.ReportTask;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.temporaryban.api.ITemporarilyBannedTroopUtilApi;

public class ContactSearchModelTroop
  extends IContactSearchModel
{
  public int a;
  private TroopInfo b;
  private long c;
  private String d;
  private String e;
  private String f;
  private long g = IContactSearchable.Q;
  
  public ContactSearchModelTroop(AppInterface paramAppInterface, int paramInt, TroopInfo paramTroopInfo, long paramLong)
  {
    super(paramAppInterface, paramInt, paramLong);
    this.b = paramTroopInfo;
    if (((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().a(paramTroopInfo.troopuin)) {
      this.g = IContactSearchable.G;
    } else if ((this.b.troopmask == 2) && (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isUinInAssist(paramTroopInfo.troopuin))) {
      this.g = IContactSearchable.G;
    }
    f(7);
  }
  
  private void w()
  {
    this.d = this.b.getNewTroopNameOrTroopName();
    if (this.b.isQidianPrivateTroop())
    {
      this.e = "";
      return;
    }
    if (this.b.isNewTroop())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.wMemberNumClient);
      localStringBuilder.append(HardCodeUtil.a(2131900687));
      this.e = String.valueOf(localStringBuilder.toString());
      return;
    }
    this.e = this.b.troopuin;
  }
  
  public CharSequence a()
  {
    if ((this.a == 3) && (!TextUtils.isEmpty(this.b.troopRemark)) && (this.n != -1) && (this.n != 7)) {
      return s();
    }
    if (SearchUtils.b(this.n)) {
      return "";
    }
    if (this.n == 8) {
      return "";
    }
    return HardCodeUtil.a(2131900729);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (SearchUtils.b(this.n))
    {
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).markEnterAioFromSearch();
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", this.b.troopuin);
      localIntent.putExtra("uintype", 1);
      if (!((ITemporarilyBannedTroopUtilApi)QRoute.api(ITemporarilyBannedTroopUtilApi.class)).checkTemporarilyBannedTroop(paramView.getContext(), this.m, localIntent)) {
        ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).enterChatWin(paramView.getContext(), this.m, this.b.troopuin, 1, this.b.getTroopDisplayName(), false);
      }
      SearchUtils.a(this.f, 20, 2, paramView);
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).saveCurrentSearchKeyword(this.m, this.f);
      SearchUtils.a(this.m, d().toString(), this.b.troopuin, this.b.troopcode, 1);
      SearchUtils.a(this.f, 30, paramView, false);
      SearchUtils.a(this, paramView);
      if (((i() instanceof String)) && (!this.r)) {
        SearchUtils.b(this.m, this.f, this.p, (String)i(), o());
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
    new ReportTask(this.m).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.b.troopuin }).a();
  }
  
  public int b()
  {
    return 4;
  }
  
  public String c()
  {
    return this.b.troopuin;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.b.troopuin;
  }
  
  public int j()
  {
    return 1;
  }
  
  public String m()
  {
    return this.d;
  }
  
  public String n()
  {
    return this.e;
  }
  
  protected long n_(String paramString)
  {
    this.f = paramString;
    this.c = -9223372036854775808L;
    if (!TextUtils.isEmpty(this.b.troopRemark))
    {
      l = SearchUtils.b(paramString, this.b.troopRemark, IContactSearchable.j);
      if (l > this.c)
      {
        this.c = l;
        this.a = 3;
      }
    }
    long l = SearchUtils.b(paramString, this.b.getNewTroopNameOrTroopName(), IContactSearchable.j);
    if (l > this.c)
    {
      this.c = l;
      this.a = 1;
      if ((this.b.isNewTroop()) && (!this.b.hasSetTroopName())) {
        return -9223372036854775808L;
      }
    }
    l = SearchUtils.a(paramString, this.b.troopuin, IContactSearchable.s, false);
    if (l > this.c)
    {
      if (this.b.isQidianPrivateTroop()) {
        return -9223372036854775808L;
      }
      if (this.b.isNewTroop()) {
        return -9223372036854775808L;
      }
      this.c = l;
      this.a = 2;
    }
    l = this.c;
    if (l != -9223372036854775808L)
    {
      this.c = (l + this.g);
      w();
    }
    return this.c;
  }
  
  public int o()
  {
    return 2;
  }
  
  public CharSequence s()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(HardCodeUtil.a(2131900708));
    if (!TextUtils.isEmpty(this.b.troopRemark)) {
      localSpannableStringBuilder.append(SearchUtils.a(this.b.troopRemark, this.f, 6, false));
    }
    return localSpannableStringBuilder;
  }
  
  public TroopInfo t()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop
 * JD-Core Version:    0.7.0.1
 */