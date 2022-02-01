package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.List;

public class GroupSearchModelMostUsed
  implements ISearchResultGroupModel
{
  public static final String a;
  private final List<ISearchResultModel> a;
  private final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705409);
  }
  
  public GroupSearchModelMostUsed(List<ISearchResultModel> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
  }
  
  public int a()
  {
    return 2147483647;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView) {}
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupSearchModelMostUsed
 * JD-Core Version:    0.7.0.1
 */