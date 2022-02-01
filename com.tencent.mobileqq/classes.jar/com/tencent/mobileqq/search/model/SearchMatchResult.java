package com.tencent.mobileqq.search.model;

public class SearchMatchResult
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("source = ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" editDistance = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" matchDegree = ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchMatchResult
 * JD-Core Version:    0.7.0.1
 */