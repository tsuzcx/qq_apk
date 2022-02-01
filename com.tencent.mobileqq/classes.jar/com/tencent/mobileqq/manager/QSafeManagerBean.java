package com.tencent.mobileqq.manager;

public class QSafeManagerBean
{
  private int a;
  private int b;
  private String c;
  private String d;
  
  public String a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QSafeManagerBean{mZipThreshold=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mVersion=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mAntiTheftUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSafeProtectUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.manager.QSafeManagerBean
 * JD-Core Version:    0.7.0.1
 */