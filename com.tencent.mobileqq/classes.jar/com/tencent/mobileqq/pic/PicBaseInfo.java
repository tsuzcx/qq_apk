package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;

public abstract class PicBaseInfo
  extends PicInfoInterface
{
  public String a;
  public int b = -1;
  public int c = -1;
  public String d;
  public String e;
  public String f;
  public long g;
  public int h;
  public Object i;
  public int j = 5;
  public boolean k = false;
  public String l;
  public String m;
  
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
      localStringBuilder.append("busiType invalid,busiType:");
      localStringBuilder.append(this.b);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.c == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uinType invalid,uinType:");
      localStringBuilder.append(this.c);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    if (this.e == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("peerUin invalid,peerUin:");
      localStringBuilder.append(this.e);
      a("PicBaseInfo.check", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  abstract String c();
  
  public boolean d()
  {
    return e() != null;
  }
  
  public File e()
  {
    return AbsDownloader.getFile(c());
  }
  
  public String f()
  {
    return AbsDownloader.getFilePath(c());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPicBaseInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("uniseq:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("busiType:");
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
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("errInfo:");
    localStringBuilder.append(this.H);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicBaseInfo
 * JD-Core Version:    0.7.0.1
 */