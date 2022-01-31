package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import java.util.List;

public class GroupNetSearchModelArticle
  implements ISearchResultGroupModel
{
  private SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private String b;
  
  public GroupNetSearchModelArticle(SearchResult paramSearchResult, List paramList, String paramString1, String paramString2)
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
    return "相关文章";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 110, 0, paramView);
    GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localGroupNetSearchModelArticleItem != null) && (!TextUtils.isEmpty(this.b)))
    {
      Object localObject = new Intent(paramView.getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.b);
      paramView.getContext().startActivity((Intent)localObject);
      if (localGroupNetSearchModelArticleItem.a() != null)
      {
        localObject = localGroupNetSearchModelArticleItem.a().hotword.get();
        int i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
        PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F28", "0X8006F28", 0, 0, localGroupNetSearchModelArticleItem.b(), (String)localObject, String.valueOf(i), "2");
      }
    }
    paramView.getContext();
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8006536", "0X8006536", 0, 0, "", "0", this.jdField_a_of_type_JavaLangString, "0");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupNetSearchModelArticle
 * JD-Core Version:    0.7.0.1
 */