package com.tencent.mobileqq.listentogether;

public class MusicExtendedReqParam
{
  public String a;
  public boolean b;
  public boolean c;
  
  public MusicExtendedReqParam(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicExtendedReqParam{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needUrl=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", needLyric=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.MusicExtendedReqParam
 * JD-Core Version:    0.7.0.1
 */