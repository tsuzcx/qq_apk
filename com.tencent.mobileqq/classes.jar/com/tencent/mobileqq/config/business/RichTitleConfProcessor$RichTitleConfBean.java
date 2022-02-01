package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.JSONConverter;

public class RichTitleConfProcessor$RichTitleConfBean
{
  @Alias(a="c2c_time_interval")
  public double a = 72.0D;
  
  public static RichTitleConfBean a(String paramString)
  {
    return (RichTitleConfBean)JSONConverter.a(paramString, RichTitleConfBean.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RichTitleConfProcessor.RichTitleConfBean
 * JD-Core Version:    0.7.0.1
 */