package com.tencent.mobileqq.qqlive.filter.data;

import java.util.Map;

public class MetaMaterial
{
  public Map<String, String> a;
  public String b;
  public int c;
  public int d;
  public String e;
  
  public String a()
  {
    return (String)this.a.get("md5");
  }
  
  public String b()
  {
    return (String)this.a.get("url");
  }
  
  public String c()
  {
    return (String)this.a.get("id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.data.MetaMaterial
 * JD-Core Version:    0.7.0.1
 */