package com.tencent.mobileqq.leba.business.urlreport;

public abstract class BaseLebaUrlAppendRule
  implements ILebaUrlAppendRule
{
  public String a(String paramString)
  {
    String str = paramString;
    if (a(paramString)) {
      str = paramString + a();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.urlreport.BaseLebaUrlAppendRule
 * JD-Core Version:    0.7.0.1
 */