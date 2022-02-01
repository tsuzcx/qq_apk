package com.tencent.mobileqq.statistics.natmem;

import android.text.TextUtils;

final class NativeMemoryInfo$BackTraceLine
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  final String b;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof BackTraceLine)) {
        return false;
      }
      paramObject = (BackTraceLine)paramObject;
    } while ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.b, paramObject.b)));
    return false;
  }
  
  public String toString()
  {
    String str = this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString + " " + this.b;
    return "BackTraceLine{" + str + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NativeMemoryInfo.BackTraceLine
 * JD-Core Version:    0.7.0.1
 */