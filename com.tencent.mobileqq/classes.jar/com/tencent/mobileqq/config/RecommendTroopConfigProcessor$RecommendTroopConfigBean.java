package com.tencent.mobileqq.config;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.JSONConverter;

public class RecommendTroopConfigProcessor$RecommendTroopConfigBean
{
  @Alias(a="poll_interval")
  public int a = 10;
  @Alias(a="jump_url")
  public String b = "";
  @Alias(a="search_empty_show_troop_recommend")
  public int c = 0;
  
  public static RecommendTroopConfigBean a(String paramString)
  {
    return (RecommendTroopConfigBean)JSONConverter.a(paramString, RecommendTroopConfigBean.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.RecommendTroopConfigProcessor.RecommendTroopConfigBean
 * JD-Core Version:    0.7.0.1
 */