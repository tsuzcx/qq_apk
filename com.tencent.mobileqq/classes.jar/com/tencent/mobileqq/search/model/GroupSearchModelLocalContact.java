package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelLocalContact
  implements ISearchResultGroupModel
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private ISearchResultModel jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
  public List<ISearchResultModel> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705388);
  }
  
  public GroupSearchModelLocalContact(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("fts_native_contactor_maxnum", 3);
  }
  
  public ISearchResultModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    if (SearchConfigManager.needSeparate) {}
    for (int i = 1;; i = 0)
    {
      ContactSearchActivity.a(paramView.getContext(), this.b, this.jdField_a_of_type_Int, 197437, i);
      SearchUtils.a(this.b, 20, 0, paramView);
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        SearchUtils.a("all_result", "more_contact", new String[] { "" + this.b });
        if (SearchConfigManager.needSeparate) {
          SearchUtils.a("search", "contact", "more", 0, 0, new String[] { SearchUtils.a(this.jdField_a_of_type_Int) });
        }
        UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D39", 0, 0, null, null);
      }
      return;
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel = paramISearchResultModel;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelLocalContact
 * JD-Core Version:    0.7.0.1
 */