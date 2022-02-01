package com.tencent.mobileqq.kandian.repo.feeds;

public class CityData
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public CityData(String paramString)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public CityData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Int = 2;
    this.d = paramString1;
    this.c = paramString2;
    this.b = paramString3;
    this.e = paramString4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" index = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" city = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" province = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" country = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" citycode = ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.CityData
 * JD-Core Version:    0.7.0.1
 */