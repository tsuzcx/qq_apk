package com.tencent.qmsp.sdk.g.e;

public class e
{
  public int a;
  public long b;
  public String c;
  
  public e(String paramString, int paramInt)
  {
    this.c = paramString;
    this.a = paramInt;
    this.b = (System.currentTimeMillis() + 86400000L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ValueData{value='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", expired=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.e
 * JD-Core Version:    0.7.0.1
 */