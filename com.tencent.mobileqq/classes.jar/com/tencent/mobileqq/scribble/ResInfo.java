package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.jsonconverter.Alias;

public class ResInfo
{
  @Alias(a="resType")
  public int a;
  @Alias(a="sourceUrl")
  public String a;
  @Alias(a="downloading")
  public boolean a;
  @Alias(a="sourceId")
  public int b;
  @Alias(a="sourceMd5")
  public String b;
  @Alias(a="predownload")
  public int c;
  @Alias(a="name")
  public String c;
  @Alias(a="isShow")
  public int d = 1;
  @Alias(a="showInApp")
  public int e;
  @Alias(a="orderIndex")
  public int f = 0;
  
  public ResInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  ResInfo a(ResInfo paramResInfo)
  {
    ResInfo localResInfo = new ResInfo();
    localResInfo.jdField_a_of_type_Int = paramResInfo.jdField_a_of_type_Int;
    localResInfo.jdField_b_of_type_Int = paramResInfo.jdField_b_of_type_Int;
    localResInfo.jdField_a_of_type_JavaLangString = paramResInfo.jdField_a_of_type_JavaLangString;
    localResInfo.jdField_b_of_type_JavaLangString = paramResInfo.jdField_b_of_type_JavaLangString;
    localResInfo.jdField_c_of_type_JavaLangString = paramResInfo.jdField_c_of_type_JavaLangString;
    localResInfo.jdField_c_of_type_Int = paramResInfo.jdField_c_of_type_Int;
    localResInfo.jdField_a_of_type_Boolean = paramResInfo.jdField_a_of_type_Boolean;
    localResInfo.d = paramResInfo.d;
    localResInfo.e = paramResInfo.e;
    localResInfo.f = paramResInfo.f;
    return localResInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ResInfo
 * JD-Core Version:    0.7.0.1
 */