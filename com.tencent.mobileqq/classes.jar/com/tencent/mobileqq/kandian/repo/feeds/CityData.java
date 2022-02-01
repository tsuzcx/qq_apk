package com.tencent.mobileqq.kandian.repo.feeds;

public class CityData
{
  public int a = 2;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public CityData(String paramString)
  {
    this.a = 1;
    this.b = paramString;
  }
  
  public CityData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = 2;
    this.e = paramString1;
    this.d = paramString2;
    this.c = paramString3;
    this.f = paramString4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" index = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" city = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" province = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" country = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" citycode = ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.CityData
 * JD-Core Version:    0.7.0.1
 */