package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupNetSearchModelPublicAcnt
  implements ISearchResultGroupModel
{
  private SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  private String jdField_a_of_type_JavaLangString;
  private List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  
  public GroupNetSearchModelPublicAcnt(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    if (UniteSearchActivity.d == 12) {
      return HardCodeUtil.a(2131705371) + ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return HardCodeUtil.a(2131705370);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 90, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    localIntent.putExtra("jump_src_key", 0);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult);
    paramView = paramView.getContext();
    if ((paramView != null) && ((paramView instanceof BaseActivity)))
    {
      paramView = ((BaseActivity)paramView).app;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramView, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.jdField_a_of_type_JavaLangString, "", false);
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcnt
 * JD-Core Version:    0.7.0.1
 */