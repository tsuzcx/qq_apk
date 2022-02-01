package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.Utils;
import java.util.Arrays;

class SpliceBean
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public SpliceBean(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SpliceBean)paramObject;
      return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && (Utils.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.SpliceBean
 * JD-Core Version:    0.7.0.1
 */