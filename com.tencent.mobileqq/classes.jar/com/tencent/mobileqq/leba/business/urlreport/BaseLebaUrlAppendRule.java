package com.tencent.mobileqq.leba.business.urlreport;

public abstract class BaseLebaUrlAppendRule
  implements ILebaUrlAppendRule
{
  public String a(String paramString)
  {
    Object localObject = paramString;
    if (a(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(a());
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.urlreport.BaseLebaUrlAppendRule
 * JD-Core Version:    0.7.0.1
 */