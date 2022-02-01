package com.tencent.mobileqq.search.model;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class GroupNetSearchModelArticle
  implements ISearchResultGroupModel
{
  private SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  private String jdField_a_of_type_JavaLangString;
  private List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  private String b;
  
  public GroupNetSearchModelArticle(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    this.b = paramString2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705374);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localGroupNetSearchModelArticleItem != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new ActivityURIRequest(paramView.getContext(), "/pubaccount/browser");
      ((ActivityURIRequest)localObject).extra().putString("url", this.b);
      QRoute.startUri((URIRequest)localObject, null);
      if (localGroupNetSearchModelArticleItem.a() != null)
      {
        localObject = localGroupNetSearchModelArticleItem.a().hotword.get();
        int i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localGroupNetSearchModelArticleItem.a(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelArticle
 * JD-Core Version:    0.7.0.1
 */