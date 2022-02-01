package com.tencent.mobileqq.search.business.net.model;

import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;

public class GroupNetSearchModelArticleItem
  extends ISearchResultPositionModel
{
  private AccountSearchPb.record a;
  private AccountSearchPb.hotwordrecord b = null;
  private String c;
  private CharSequence d;
  private String e;
  private CharSequence f;
  
  public GroupNetSearchModelArticleItem(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    this.b = paramhotwordrecord;
    this.c = paramString1;
    this.d = paramCharSequence1;
    this.e = paramString2;
    this.f = paramCharSequence2;
  }
  
  public GroupNetSearchModelArticleItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.a = paramrecord;
    this.c = paramString;
    this.d = paramCharSequence;
  }
  
  public CharSequence a()
  {
    AccountSearchPb.hotwordrecord localhotwordrecord = this.b;
    if ((localhotwordrecord != null) && (localhotwordrecord.hotword_description.has())) {
      return this.b.hotword_description.get();
    }
    return null;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.c, 110, 0, paramView);
    Bundle localBundle = new Bundle();
    if (this.b != null)
    {
      localBundle.putString("url", this.e);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, g(), this.b.hotword.get(), String.valueOf(this.b.hotword_type.get()), "1");
    }
    else
    {
      AccountSearchPb.record localrecord = this.a;
      if (localrecord != null) {
        localBundle.putString("url", localrecord.article_short_url.get());
      }
    }
    paramView = new ActivityURIRequest(paramView.getContext(), "/pubaccount/browser");
    paramView.extra().putAll(localBundle);
    QRoute.startUri(paramView, null);
    if (this.a != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "", this.c, String.valueOf(this.a.account_id.get()));
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public String c()
  {
    return null;
  }
  
  public CharSequence d()
  {
    return this.d;
  }
  
  public CharSequence e()
  {
    if (this.b != null) {
      return this.f;
    }
    return HardCodeUtil.a(2131903337);
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
  
  public AccountSearchPb.record i()
  {
    return this.a;
  }
  
  public AccountSearchPb.hotwordrecord j()
  {
    return this.b;
  }
  
  public String m()
  {
    AccountSearchPb.hotwordrecord localhotwordrecord = this.b;
    if (localhotwordrecord != null) {
      return localhotwordrecord.hotword_cover_url.get();
    }
    return this.a.title_image.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.GroupNetSearchModelArticleItem
 * JD-Core Version:    0.7.0.1
 */