package com.tencent.mobileqq.search.business.group.model;

import addcontacts.AccountSearchPb.record;
import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.util.SearchUtils;
import mqq.app.MobileQQ;

public class GroupNetSearchModelPeopleItem
  extends ISearchResultPositionModel
{
  private AccountSearchPb.record a;
  private String b;
  private CharSequence c;
  private CharSequence d;
  
  public GroupNetSearchModelPeopleItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.a = paramrecord;
    this.b = paramString;
    this.c = paramCharSequence;
  }
  
  public CharSequence a()
  {
    return HardCodeUtil.a(2131903334);
  }
  
  public void a(View paramView)
  {
    ((ISearchActivityJumpFetcher)QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity((Activity)paramView.getContext(), new SearchResultItem(this.a), (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime(), true, 1);
    SearchUtils.a(this.b, 70, 0, paramView);
    SearchUtils.a(this.b, 70, paramView, false);
  }
  
  public int b()
  {
    if (this.a.uin.get() != 0L) {
      return 1;
    }
    return 11;
  }
  
  public String c()
  {
    if (this.a.uin.get() != 0L) {
      return String.valueOf(this.a.uin.get());
    }
    return this.a.mobile.get();
  }
  
  public CharSequence d()
  {
    return this.c;
  }
  
  public CharSequence e()
  {
    if (this.d == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      String str;
      if (this.a.uin.get() != 0L) {
        str = String.valueOf(this.a.uin.get());
      } else {
        str = this.a.mobile.get();
      }
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      this.d = SearchUtils.a(localStringBuilder.toString(), this.b);
    }
    return this.d;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupNetSearchModelPeopleItem
 * JD-Core Version:    0.7.0.1
 */