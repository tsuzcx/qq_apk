package com.tencent.mobileqq.nearby.now.location;

public class StringFormatUtil
{
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private String b;
  
  public StringFormatUtil(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public StringFormatUtil a()
  {
    int i = 0;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    if (this.b.equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("<font color='#00a5e0'>").append(this.jdField_a_of_type_JavaLangString).append("</font>");
      return this;
    }
    String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split(this.b);
    if (arrayOfString.length == 1)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(arrayOfString[0]);
      return this;
    }
    int j = arrayOfString.length;
    label85:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if (str.length() != 0) {
        break label110;
      }
    }
    for (;;)
    {
      i += 1;
      break label85;
      break;
      label110:
      this.jdField_a_of_type_JavaLangStringBuilder.append("<font color='#00a5e0'>").append(this.b).append("</font>").append(str);
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder != null) {
      return this.jdField_a_of_type_JavaLangStringBuilder.toString();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.StringFormatUtil
 * JD-Core Version:    0.7.0.1
 */