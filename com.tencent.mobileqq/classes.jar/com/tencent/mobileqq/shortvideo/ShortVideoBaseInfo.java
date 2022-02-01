package com.tencent.mobileqq.shortvideo;

public abstract class ShortVideoBaseInfo
  extends ShortVideoInfoInterface
{
  public String a;
  public int b = -1;
  public int c = -1;
  public String d;
  public String e;
  public String f;
  public long g;
  public boolean h = false;
  public String i;
  public String j;
  public String k;
  
  public String a()
  {
    return null;
  }
  
  public boolean b()
  {
    StringBuilder localStringBuilder;
    if (this.b == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqBusiType invalid, reqBusiType:");
      localStringBuilder.append(this.b);
      a("ShortVideoBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.c == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uinType invalid,uinType:");
      localStringBuilder.append(this.c);
      a("ShortVideoBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.e == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("peerUin invalid,peerUin:");
      localStringBuilder.append(this.e);
      a("ShortVideoBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoBaseInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uniseq:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("reqBusiType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("selfUin:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("peerUin:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("secondId:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbMD5:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errInfo:");
    localStringBuilder.append(this.V);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBaseInfo
 * JD-Core Version:    0.7.0.1
 */