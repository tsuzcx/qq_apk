package com.tencent.mobileqq.ocr.data;

import java.util.ArrayList;
import java.util.HashMap;

public class ARCloudOcrResult$YoutuOcrResult
{
  public int a;
  public String a;
  public ArrayList a;
  public HashMap a;
  public int b;
  public String b;
  public ArrayList b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:").append(this.jdField_a_of_type_Int).append(",ssoErrMsg:").append(this.jdField_a_of_type_JavaLangString).append(",errCode:").append(this.jdField_b_of_type_Int).append(",errMsg:").append(this.jdField_b_of_type_JavaLangString).append(",session_id:").append(this.c).append(",content:").append(this.d).append(",language").append(this.e).append(",ocr_language_list").append(this.jdField_a_of_type_JavaUtilArrayList).append(",dst_translage_language_list").append(this.jdField_b_of_type_JavaUtilArrayList).append(",language_descs").append(this.jdField_a_of_type_JavaUtilHashMap);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.ARCloudOcrResult.YoutuOcrResult
 * JD-Core Version:    0.7.0.1
 */