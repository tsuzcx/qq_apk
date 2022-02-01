package com.tencent.qqperf.debug;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;

public class SQLInfo
  extends RecyclablePool.Recyclable
{
  int jdField_a_of_type_Int = 6;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  StackTraceElement[] jdField_a_of_type_ArrayOfJavaLangStackTraceElement;
  int jdField_b_of_type_Int = 2018;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  String f = "n";
  
  public void recycle()
  {
    super.recycle();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_b_of_type_Long = 0L;
    this.d = "";
    this.jdField_a_of_type_ArrayOfJavaLangStackTraceElement = null;
    this.e = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1500);
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.debug.SQLInfo
 * JD-Core Version:    0.7.0.1
 */