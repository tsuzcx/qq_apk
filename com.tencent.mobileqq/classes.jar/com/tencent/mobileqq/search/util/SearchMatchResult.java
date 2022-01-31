package com.tencent.mobileqq.search.util;

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
  
  public String a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      localObject1 = localObject2;
      if (this.jdField_c_of_type_JavaLangString.length() < this.a + this.b) {}
    }
    try
    {
      localObject1 = this.jdField_c_of_type_JavaLangString.substring(this.a, this.a + this.b);
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String toString()
  {
    return "source = " + this.jdField_c_of_type_JavaLangString + " editDistance = " + this.d + " matchDegree = " + this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchMatchResult
 * JD-Core Version:    0.7.0.1
 */