package com.tencent.mobileqq.data;

import auko;
import aumc;

public class EqqConfig
  extends auko
{
  @aumc
  public String data;
  
  public EqqConfig() {}
  
  public EqqConfig(String paramString)
  {
    this.data = paramString;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.EqqConfig
 * JD-Core Version:    0.7.0.1
 */