package com.tencent.qapmsdk.dns.b;

public class c
{
  public String a;
  public int b;
  public double c;
  
  public c(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IpCachedItem{ip='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hitTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", avgElapse=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.b.c
 * JD-Core Version:    0.7.0.1
 */