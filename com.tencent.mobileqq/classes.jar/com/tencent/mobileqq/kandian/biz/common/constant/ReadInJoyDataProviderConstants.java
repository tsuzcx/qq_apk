package com.tencent.mobileqq.kandian.biz.common.constant;

import android.net.Uri;

public class ReadInJoyDataProviderConstants
{
  public static String a = "content://qq.readinjoy/";
  public static final Uri b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("common_records");
    b = Uri.parse(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.constant.ReadInJoyDataProviderConstants
 * JD-Core Version:    0.7.0.1
 */