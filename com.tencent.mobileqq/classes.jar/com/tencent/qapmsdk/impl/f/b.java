package com.tencent.qapmsdk.impl.f;

public class b
{
  private String a;
  private String b;
  private String c = "/";
  private b.a d = null;
  private int e = -1;
  private boolean f = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hostAddress: " + this.a);
    localStringBuilder.append("hostname: " + this.b);
    localStringBuilder.append("httpPath: " + this.c);
    localStringBuilder.append("scheme: " + this.d);
    localStringBuilder.append("hostPort: " + this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.f.b
 * JD-Core Version:    0.7.0.1
 */