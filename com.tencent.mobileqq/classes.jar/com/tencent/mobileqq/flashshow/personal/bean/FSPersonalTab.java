package com.tencent.mobileqq.flashshow.personal.bean;

public class FSPersonalTab
{
  private String a;
  private String b;
  
  public FSPersonalTab(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FSPersonalTab)paramObject;
      return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.bean.FSPersonalTab
 * JD-Core Version:    0.7.0.1
 */