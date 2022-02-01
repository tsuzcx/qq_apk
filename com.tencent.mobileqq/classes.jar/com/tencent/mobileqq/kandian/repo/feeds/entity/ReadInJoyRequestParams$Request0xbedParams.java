package com.tencent.mobileqq.kandian.repo.feeds.entity;

import java.util.List;

public class ReadInJoyRequestParams$Request0xbedParams
{
  public int a;
  public int b;
  public long c;
  public long d;
  public String e;
  public String f;
  public long g;
  public long h;
  public int i;
  public byte[] j;
  public List<Long> k;
  public int l;
  public ReadInJoyRequestParams.Request0xbedParams.InnerMsg m;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelID:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" channelType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" upDateTimes：");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" beginRecommendSeq：");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" endRecommendSeq：");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" beginCollectionID:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" endCollectionID:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("   subscriptionArticleList:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" innerMsg:");
    localStringBuilder.append(this.m);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xbedParams
 * JD-Core Version:    0.7.0.1
 */