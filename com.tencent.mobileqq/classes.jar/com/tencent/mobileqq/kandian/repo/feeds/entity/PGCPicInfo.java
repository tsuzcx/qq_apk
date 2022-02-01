package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;

public class PGCPicInfo
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public long h;
  public PGCVideoInfo i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PGCPicInfo{picWidth=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", picHeight=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", picMd5='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbnailUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAnimation=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", picDesc='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", galleryIndex=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", pgcVideoInfo=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo
 * JD-Core Version:    0.7.0.1
 */