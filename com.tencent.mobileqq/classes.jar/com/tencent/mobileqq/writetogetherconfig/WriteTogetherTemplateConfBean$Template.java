package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.annotations.SerializedName;

public class WriteTogetherTemplateConfBean$Template
{
  @SerializedName("id")
  public int a;
  @SerializedName("title")
  public String b;
  @SerializedName("templateContent")
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Template{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", templateContent='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template
 * JD-Core Version:    0.7.0.1
 */