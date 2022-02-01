package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class WriteTogetherTemplateConfBean
{
  @SerializedName("templateArray")
  public WriteTogetherTemplateConfBean.Template[] a;
  @SerializedName("templateConfig")
  public WriteTogetherTemplateConfBean.TemplateBean[] a;
  
  public WriteTogetherTemplateConfBean()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$TemplateBean = new WriteTogetherTemplateConfBean.TemplateBean[0];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template = new WriteTogetherTemplateConfBean.Template[0];
  }
  
  public static WriteTogetherTemplateConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (WriteTogetherTemplateConfBean)new Gson().fromJson(paramString, WriteTogetherTemplateConfBean.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean
 * JD-Core Version:    0.7.0.1
 */