package com.tencent.mobileqq.kandian.repo.biu;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class BiuInfo
{
  public boolean a;
  public long b = -1L;
  public String c = "";
  public String d = "";
  public AbsBaseArticleInfo e;
  public int f = -1;
  public String g = "";
  public String h = "";
  public String i;
  public int j;
  
  public void a()
  {
    this.a = false;
    this.b = -1L;
    this.c = "";
    this.d = "";
    this.e = null;
    this.f = -1;
    this.i = "";
    this.h = "";
    this.j = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BiuInfo{isFromRecommendFeeds=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", feedsID=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", biuComment='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", biuMediaUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleInfo=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", contentSrc=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", commentBtnJumpUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentShareUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardJumpUrl='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isCardAvailable=");
    localStringBuilder.append(this.j);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.BiuInfo
 * JD-Core Version:    0.7.0.1
 */