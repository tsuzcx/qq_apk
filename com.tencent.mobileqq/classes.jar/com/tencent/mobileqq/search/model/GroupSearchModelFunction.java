package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import java.util.List;

public class GroupSearchModelFunction
  implements ISearchResultGroupModel
{
  private final String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelFunction(List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("fts_native_function_maxnum", 3);
  }
  
  public String a()
  {
    return SearchEntryConfigManager.a();
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    FunctionSearchActivity.a((BaseActivity)paramView.getContext(), this.jdField_a_of_type_JavaLangString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelFunction
 * JD-Core Version:    0.7.0.1
 */