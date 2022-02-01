package com.tencent.mobileqq.troop.navigatebar;

public class BaseAioMsgNavigateBarDelegate$Entity
{
  private boolean a;
  private String b;
  private Object c;
  private String d;
  private Object e;
  
  public BaseAioMsgNavigateBarDelegate$Entity(boolean paramBoolean, String paramString1, Object paramObject, String paramString2)
  {
    this.a = paramBoolean;
    this.b = paramString1;
    this.c = paramObject;
    this.d = paramString2;
    this.e = null;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Object c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public Object e()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Entity{show=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", senderUin='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBarDelegate.Entity
 * JD-Core Version:    0.7.0.1
 */