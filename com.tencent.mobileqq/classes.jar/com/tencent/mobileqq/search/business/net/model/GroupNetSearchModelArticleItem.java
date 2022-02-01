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
  private AccountSearchPb.hotwordrecord jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord = null;
  private AccountSearchPb.record jdField_a_of_type_AddcontactsAccountSearchPb$record;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  
  public GroupNetSearchModelArticleItem(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord = paramhotwordrecord;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence2;
  }
  
  public GroupNetSearchModelArticleItem(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AddcontactsAccountSearchPb$record = paramrecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int a()
  {
    return 0;
  }
  
  public AccountSearchPb.hotwordrecord a()
  {
    return this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord;
  }
  
  public AccountSearchPb.record a()
  {
    return this.jdField_a_of_type_AddcontactsAccountSearchPb$record;
  }
  
  public CharSequence a()
  {
    AccountSearchPb.hotwordrecord localhotwordrecord = this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord;
    if ((localhotwordrecord != null) && (localhotwordrecord.hotword_description.has())) {
      return this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
    }
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord != null)
    {
      localBundle.putString("url", this.jdField_b_of_type_JavaLangString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, b(), this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "1");
    }
    else
    {
      AccountSearchPb.record localrecord = this.jdField_a_of_type_AddcontactsAccountSearchPb$record;
      if (localrecord != null) {
        localBundle.putString("url", localrecord.article_short_url.get());
      }
    }
    paramView = new ActivityURIRequest(paramView.getContext(), "/pubaccount/browser");
    paramView.extra().putAll(localBundle);
    QRoute.startUri(paramView, null);
    if (this.jdField_a_of_type_AddcontactsAccountSearchPb$record != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$record.account_id.get()));
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    if (this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord != null) {
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    return HardCodeUtil.a(2131705449);
  }
  
  public String c()
  {
    AccountSearchPb.hotwordrecord localhotwordrecord = this.jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord;
    if (localhotwordrecord != null) {
      return localhotwordrecord.hotword_cover_url.get();
    }
    return this.jdField_a_of_type_AddcontactsAccountSearchPb$record.title_image.get();
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.GroupNetSearchModelArticleItem
 * JD-Core Version:    0.7.0.1
 */