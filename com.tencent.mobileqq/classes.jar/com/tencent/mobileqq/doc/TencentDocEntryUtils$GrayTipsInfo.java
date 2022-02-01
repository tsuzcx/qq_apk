package com.tencent.mobileqq.doc;

public class TencentDocEntryUtils$GrayTipsInfo
{
  public int a;
  public String a;
  public boolean a;
  public String b = "";
  public String c = "";
  
  public TencentDocEntryUtils$GrayTipsInfo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enable:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",");
    localStringBuilder.append("mPlainContent:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append("mHighLightContent:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append("times:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append("mJumpLinkUrls:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocEntryUtils.GrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */