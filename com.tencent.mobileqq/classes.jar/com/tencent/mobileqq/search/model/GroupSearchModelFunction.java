package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import java.util.List;

public class GroupSearchModelFunction
  implements ISearchResultGroupModel
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  public final List<ISearchResultModel> a;
  
  public GroupSearchModelFunction(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return SearchEntryConfigManager.a("fts_native_function_maxnum", 3);
  }
  
  public String a()
  {
    return SearchEntryConfigManager.a();
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    FunctionSearchActivity.a((BaseActivity)paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4B", 0, 0, null, null);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelFunction
 * JD-Core Version:    0.7.0.1
 */