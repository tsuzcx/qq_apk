package com.tencent.mobileqq.leba.business.urlreport;

public class LebaUinUrlAppendRule
  extends BaseLebaUrlAppendRule
{
  private String a;
  
  public LebaUinUrlAppendRule(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return String.format("&mqquin=%s", new Object[] { this.a });
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("plg_uin=1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.urlreport.LebaUinUrlAppendRule
 * JD-Core Version:    0.7.0.1
 */