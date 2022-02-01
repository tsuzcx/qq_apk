package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiniCard$QZoneInfo
{
  public String a;
  public List<String> a;
  public String b = "";
  
  public MiniCard$QZoneInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("qzoneName");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("updateContent");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("imgUrls");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()));
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard.QZoneInfo
 * JD-Core Version:    0.7.0.1
 */