package com.tencent.mobileqq.config;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.JSONConverter;

public class RecommendTroopConfigProcessor$RecommendTroopConfigBean
{
  @Alias(a="poll_interval")
  public int a;
  @Alias(a="jump_url")
  public String a;
  @Alias(a="search_empty_show_troop_recommend")
  public int b = 0;
  
  public RecommendTroopConfigProcessor$RecommendTroopConfigBean()
  {
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static RecommendTroopConfigBean a(String paramString)
  {
    return (RecommendTroopConfigBean)JSONConverter.a(paramString, RecommendTroopConfigBean.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.RecommendTroopConfigProcessor.RecommendTroopConfigBean
 * JD-Core Version:    0.7.0.1
 */