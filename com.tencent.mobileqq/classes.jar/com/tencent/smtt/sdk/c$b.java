package com.tencent.smtt.sdk;

public class c$b
{
  public int a = -1;
  public int b = -1;
  public String c = "";
  public long d = -1L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{seqId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", extra='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", expired=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */