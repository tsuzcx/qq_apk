package com.tencent.mobileqq.config.business;

public class WatchTogetherBean
{
  private int a;
  private int b;
  private String c;
  private String d;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchTogetherBean{version=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpExtensionInfo='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WatchTogetherBean
 * JD-Core Version:    0.7.0.1
 */