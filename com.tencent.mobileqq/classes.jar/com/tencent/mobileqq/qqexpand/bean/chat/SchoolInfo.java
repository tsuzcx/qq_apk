package com.tencent.mobileqq.qqexpand.bean.chat;

public class SchoolInfo
{
  public String a;
  public String b;
  public long c;
  
  public SchoolInfo(String paramString1, String paramString2, long paramLong)
  {
    this.b = paramString1;
    this.a = paramString2;
    this.c = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{schoolId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    localStringBuilder.append("{schoolName: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    localStringBuilder.append("{schoolState: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.chat.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */