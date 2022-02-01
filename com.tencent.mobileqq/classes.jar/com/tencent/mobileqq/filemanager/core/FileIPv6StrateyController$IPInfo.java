package com.tencent.mobileqq.filemanager.core;

public class FileIPv6StrateyController$IPInfo
{
  public int a;
  public String a;
  
  public FileIPv6StrateyController$IPInfo(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.startsWith("[")) && (this.jdField_a_of_type_JavaLangString.endsWith("]")))
    {
      str = this.jdField_a_of_type_JavaLangString;
      return str.substring(1, str.length() - 1);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(":");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo
 * JD-Core Version:    0.7.0.1
 */