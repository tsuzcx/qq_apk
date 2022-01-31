package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelLocalContactApproximate
  implements ISearchResultGroupModel
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  
  public GroupSearchModelLocalContactApproximate(List paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return "相关联系人";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ContactSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 197437, true);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 0, paramView);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelLocalContactApproximate
 * JD-Core Version:    0.7.0.1
 */