package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.annotations.SerializedName;

public class WriteTogetherTemplateConfBean$Template
{
  @SerializedName("id")
  public int a;
  @SerializedName("title")
  public String a;
  @SerializedName("templateContent")
  public String b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Template{id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", templateContent='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template
 * JD-Core Version:    0.7.0.1
 */