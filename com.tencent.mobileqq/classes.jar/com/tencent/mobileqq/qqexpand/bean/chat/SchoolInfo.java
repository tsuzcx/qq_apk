package com.tencent.mobileqq.qqexpand.bean.chat;

public class SchoolInfo
{
  public long a;
  public String a;
  public String b;
  
  public SchoolInfo(String paramString1, String paramString2, long paramLong)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{schoolId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    localStringBuilder.append("{schoolName: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{schoolState: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.chat.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */