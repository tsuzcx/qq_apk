package com.tencent.mobileqq.writetogetherconfig;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class WriteTogetherTemplateConfBean
{
  @SerializedName("templateConfig")
  public WriteTogetherTemplateConfBean.TemplateBean[] a = new WriteTogetherTemplateConfBean.TemplateBean[0];
  @SerializedName("templateArray")
  public WriteTogetherTemplateConfBean.Template[] b = new WriteTogetherTemplateConfBean.Template[0];
  
  public static WriteTogetherTemplateConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (WriteTogetherTemplateConfBean)new Gson().fromJson(paramString, WriteTogetherTemplateConfBean.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean
 * JD-Core Version:    0.7.0.1
 */