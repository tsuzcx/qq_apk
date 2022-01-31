package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import java.util.List;

public abstract class FTSGroupSearchModelEntity
  implements ISearchResultGroupModel
{
  public String a;
  protected List a;
  
  public FTSGroupSearchModelEntity(List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 3;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSGroupSearchModelEntity
 * JD-Core Version:    0.7.0.1
 */