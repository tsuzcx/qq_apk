package com.tencent.mobileqq.statistics.natmem;

import android.text.TextUtils;

final class NativeMemoryInfo$BackTraceLine
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  final String b;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BackTraceLine)) {
      return false;
    }
    paramObject = (BackTraceLine)paramObject;
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.b, paramObject.b));
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(this.b);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackTraceLine{");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NativeMemoryInfo.BackTraceLine
 * JD-Core Version:    0.7.0.1
 */