package com.tencent.mobileqq.ocr.data;

import java.util.ArrayList;

public class ARCloudOcrResult$YoutuOcrResult
{
  public int a;
  public String a;
  public ArrayList<String> a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",ssoErrMsg:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",errCode:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",errMsg:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",session_id:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",content:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",language");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",ocr_language_list");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.ARCloudOcrResult.YoutuOcrResult
 * JD-Core Version:    0.7.0.1
 */