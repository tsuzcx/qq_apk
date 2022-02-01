package com.tencent.mobileqq.mutualmark;

import android.support.annotation.NonNull;

public class MutualMarkGrayTipsHelper$GrayTipHighlightItemInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public MutualMarkGrayTipsHelper$GrayTipHighlightItemInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      return str.contains("icon");
    }
    return false;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GrayTipHighlightItemInfo{");
    localStringBuilder.append("old_key:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("old_start:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("id:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("start:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("end:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("key:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("url:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo
 * JD-Core Version:    0.7.0.1
 */