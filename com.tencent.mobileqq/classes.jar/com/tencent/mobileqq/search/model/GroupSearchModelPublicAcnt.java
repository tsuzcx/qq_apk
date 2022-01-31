package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class GroupSearchModelPublicAcnt
  implements ISearchResultGroupModel
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelPublicAcnt(List paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("pref_fts_native_search_public_account_max_num", 3);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 12) {
      return "精选" + PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return "关注的公众号";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView);
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity))) {
      ReportController.b(((BaseActivity)localContext).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.jdField_a_of_type_JavaLangString, "");
    }
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      SearchUtils.a("all_result", "clk_public_uin_more", new String[] { "" + this.jdField_a_of_type_JavaLangString });
    }
    PublicAcntSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelPublicAcnt
 * JD-Core Version:    0.7.0.1
 */