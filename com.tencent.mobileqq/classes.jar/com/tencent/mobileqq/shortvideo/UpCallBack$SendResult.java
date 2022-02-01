package com.tencent.mobileqq.shortvideo;

public class UpCallBack$SendResult
{
  public int a;
  public int b;
  public String c;
  public String d;
  public long e;
  public String f;
  public String g;
  public long h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSendResult");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("result:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errCode:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errStr:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("path:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("size:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uuid:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("groupFileID:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.UpCallBack.SendResult
 * JD-Core Version:    0.7.0.1
 */