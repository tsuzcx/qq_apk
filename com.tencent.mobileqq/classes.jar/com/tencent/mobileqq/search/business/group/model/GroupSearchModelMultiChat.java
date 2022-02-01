package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public class GroupSearchModelMultiChat
  implements ISearchResultGroupModel
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final List<ISearchResultModel> jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelMultiChat(List<ISearchResultModel> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return HardCodeUtil.a(2131705484);
  }
  
  public List<ISearchResultModel> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView) {}
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat
 * JD-Core Version:    0.7.0.1
 */