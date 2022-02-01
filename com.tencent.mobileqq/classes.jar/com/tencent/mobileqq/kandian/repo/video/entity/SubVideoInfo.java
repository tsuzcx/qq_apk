package com.tencent.mobileqq.kandian.repo.video.entity;

import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class SubVideoInfo
{
  public long a;
  public String b;
  public String c;
  public String d;
  public UrlJumpInfo e;
  public int f;
  public int g;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append("rowKey=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n");
    localStringBuilder.append("title=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("picUrl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    localStringBuilder.append("jumpUrl=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("playCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n");
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.SubVideoInfo
 * JD-Core Version:    0.7.0.1
 */