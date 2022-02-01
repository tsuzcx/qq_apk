package com.tencent.mobileqq.richmedia.conn;

public class HostInfo
  implements Cloneable
{
  public String a;
  public int b;
  public int c = 0;
  public long d = -1L;
  public int e = 0;
  public int f = 0;
  public int g;
  
  public HostInfo(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public HostInfo a()
  {
    return (HostInfo)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(":");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" failCount:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.HostInfo
 * JD-Core Version:    0.7.0.1
 */