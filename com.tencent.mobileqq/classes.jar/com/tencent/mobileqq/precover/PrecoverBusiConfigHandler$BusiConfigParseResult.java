package com.tencent.mobileqq.precover;

import com.tencent.mobileqq.data.PrecoverResource;
import java.util.List;

class PrecoverBusiConfigHandler$BusiConfigParseResult
{
  public int a;
  public String a;
  public List<PrecoverResource> a;
  public int b;
  public String b;
  
  PrecoverBusiConfigHandler$BusiConfigParseResult()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("BusiConfigParseResult: result=").append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(",resParseResultType=").append(this.jdField_b_of_type_Int);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(",resList.size=");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      localStringBuilder2.append(i);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverBusiConfigHandler.BusiConfigParseResult
 * JD-Core Version:    0.7.0.1
 */