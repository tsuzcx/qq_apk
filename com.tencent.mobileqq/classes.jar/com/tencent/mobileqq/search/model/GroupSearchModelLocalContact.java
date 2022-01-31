package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelLocalContact
  implements ISearchResultGroupModel
{
  private int jdField_a_of_type_Int;
  private ISearchResultModel jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  
  public GroupSearchModelLocalContact(List paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
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
    return "联系人";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ContactSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 197437);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      SearchUtils.a("all_result", "more_contact", new String[] { "" + this.jdField_a_of_type_JavaLangString });
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel = paramISearchResultModel;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelLocalContact
 * JD-Core Version:    0.7.0.1
 */