package com.tencent.mobileqq.kandian.biz.common.constant;

import android.net.Uri;

public class ReadInJoyDataProviderConstants
{
  public static final Uri a;
  public static String a = "content://qq.readinjoy/";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("common_records");
    jdField_a_of_type_AndroidNetUri = Uri.parse(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.constant.ReadInJoyDataProviderConstants
 * JD-Core Version:    0.7.0.1
 */