package com.tencent.mobileqq.shortvideo;

class ShortVideoSoManager$CfgParser
{
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  ShortVideoSoManager$CfgParser(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  int a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (!"".equals(localObject)))
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_JavaLangString.split("\\_");
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (localObject == null) {
        return -1;
      }
      if (localObject.length < 2) {
        return -2;
      }
      return 0;
    }
    return -3;
  }
  
  int a(char paramChar)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (!"".equals(localObject)))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\");
      localStringBuilder.append(paramChar);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String)localObject).split(localStringBuilder.toString());
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (localObject == null) {
        return -1;
      }
      if (localObject.length < 2) {
        return -2;
      }
      return 0;
    }
    return -3;
  }
  
  String a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0].trim();
  }
  
  String b()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
  
  String c()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0].trim();
  }
  
  String d()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[1].trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoSoManager.CfgParser
 * JD-Core Version:    0.7.0.1
 */