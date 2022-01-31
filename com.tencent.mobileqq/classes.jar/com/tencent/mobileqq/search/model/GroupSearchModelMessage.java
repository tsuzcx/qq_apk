package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelMessage
  implements ISearchResultGroupModel
{
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelMessage(List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return "聊天记录";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    MessageSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelMessage
 * JD-Core Version:    0.7.0.1
 */