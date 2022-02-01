package com.tencent.mobileqq.onlinestatus.config.olympic;

public class OlympicConfBean
{
  private OlympicConfBean.OlympicConfig a;
  private String b;
  
  public OlympicConfBean()
  {
    this.b = "";
    this.a = new OlympicConfBean.OlympicConfig();
  }
  
  public OlympicConfBean(String paramString, OlympicConfBean.OlympicConfig paramOlympicConfig)
  {
    this.b = paramString;
    this.a = paramOlympicConfig;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public OlympicConfBean.OlympicConfig b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean
 * JD-Core Version:    0.7.0.1
 */