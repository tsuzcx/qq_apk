package com.tencent.mobileqq.leba.business.urlreport;

public class LebaVKeyAppendRule
  extends BaseLebaUrlAppendRule
{
  private String a;
  
  public LebaVKeyAppendRule(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return String.format("&mqqvkey=%s", new Object[] { this.a });
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.contains("plg_vkey=1"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.urlreport.LebaVKeyAppendRule
 * JD-Core Version:    0.7.0.1
 */