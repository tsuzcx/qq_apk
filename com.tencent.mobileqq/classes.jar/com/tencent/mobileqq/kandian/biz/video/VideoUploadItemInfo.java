package com.tencent.mobileqq.kandian.biz.video;

public class VideoUploadItemInfo
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public boolean i = true;
  public boolean j;
  public int k;
  public int l;
  public boolean m = false;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("localPath:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbPath:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbWidth:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("thumbHeight:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("sendSizeSpec:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileTime:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileSource:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("supportProgressive:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileWidth:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("fileHeight:");
    localStringBuilder.append(this.l);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUploadItemInfo
 * JD-Core Version:    0.7.0.1
 */