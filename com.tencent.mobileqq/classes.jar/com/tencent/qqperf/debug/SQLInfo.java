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
    return 1500 + this.jdField_a_of_type_Long + "," + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString + "," + this.c + "," + this.jdField_b_of_type_Long + "," + this.d + "," + this.e + "," + this.f + "\r\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.SQLInfo
 * JD-Core Version:    0.7.0.1
 */