package com.tencent.open.agent.entity;

public class Permission
{
  public int a;
  public String b;
  public boolean c;
  public String d;
  public int e;
  public boolean f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[flag=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isNew=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", api=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isChecked=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.entity.Permission
 * JD-Core Version:    0.7.0.1
 */