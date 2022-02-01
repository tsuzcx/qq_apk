package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelMessage
  implements ISearchResultGroupModel
{
  public static final String a;
  private List<ISearchResultModel> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705414);
  }
  
  public GroupSearchModelMessage(List<ISearchResultModel> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
  }
  
  public int a()
  {
    return 3;
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
    SearchUtils.a(this.b, 40, 0, paramView);
    MessageSearchActivity.a(paramView.getContext(), this.b);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelMessage
 * JD-Core Version:    0.7.0.1
 */