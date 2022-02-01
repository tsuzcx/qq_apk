package com.tencent.mobileqq.kandian.repo.fastweb.entity;

public class FastWebShareInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String a(int paramInt)
  {
    if (paramInt == 72) {
      return this.d;
    }
    if (paramInt == 73) {
      return this.d;
    }
    if (paramInt == 2) {
      return this.d;
    }
    if (paramInt == 3) {
      return this.e;
    }
    if (paramInt == 12) {
      return this.a;
    }
    if (paramInt == 9) {
      return this.c;
    }
    if (paramInt == 10) {
      return this.b;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("weibo : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("qq : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("wx : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("pyq : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("qzone : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.entity.FastWebShareInfo
 * JD-Core Version:    0.7.0.1
 */