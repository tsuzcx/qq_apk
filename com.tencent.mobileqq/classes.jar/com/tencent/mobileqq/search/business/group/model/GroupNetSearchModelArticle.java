package com.tencent.mobileqq.search.business.group.model;

import addcontacts.AccountSearchPb.hotwordrecord;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.business.net.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupNetSearchModelArticle
  extends ISearchResultGroupModel
{
  private List<ISearchResultModel> a;
  private String b;
  private SearchResult c;
  private String d;
  
  public GroupNetSearchModelArticle(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString1, String paramString2)
  {
    this.a = paramList;
    this.b = paramString1;
    this.c = paramSearchResult;
    this.d = paramString2;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131903336);
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.b, 110, 0, paramView);
    GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)this.a.get(0);
    if ((localGroupNetSearchModelArticleItem != null) && (!TextUtils.isEmpty(this.d)))
    {
      Object localObject = new ActivityURIRequest(paramView.getContext(), "/pubaccount/browser");
      ((ActivityURIRequest)localObject).extra().putString("url", this.d);
      QRoute.startUri((URIRequest)localObject, null);
      if (localGroupNetSearchModelArticleItem.j() != null)
      {
        localObject = localGroupNetSearchModelArticleItem.j().hotword.get();
        int i = localGroupNetSearchModelArticleItem.j().hotword_type.get();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localGroupNetSearchModelArticleItem.g(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.b, "0");
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
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupNetSearchModelArticle
 * JD-Core Version:    0.7.0.1
 */