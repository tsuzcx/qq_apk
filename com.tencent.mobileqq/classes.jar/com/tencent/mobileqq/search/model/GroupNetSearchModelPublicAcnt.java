package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupNetSearchModelPublicAcnt
  extends ISearchResultGroupModel
{
  private List<ISearchResultModel> a;
  private String b;
  private SearchResult c;
  
  public GroupNetSearchModelPublicAcnt(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString)
  {
    this.a = paramList;
    this.b = paramString;
    this.c = paramSearchResult;
  }
  
  public String a()
  {
    if (UniteSearchActivity.f == 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131903333));
      localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext()));
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131903332);
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.b, 90, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra("last_key_words", this.b);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    localIntent.putExtra("jump_src_key", 0);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.c);
    paramView = paramView.getContext();
    if ((paramView != null) && ((paramView instanceof BaseActivity)))
    {
      paramView = ((BaseActivity)paramView).app;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramView, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.b, "", false);
    }
  }
  
  public List<ISearchResultModel> b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcnt
 * JD-Core Version:    0.7.0.1
 */