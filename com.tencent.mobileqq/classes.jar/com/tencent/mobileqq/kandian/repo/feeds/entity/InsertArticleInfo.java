package com.tencent.mobileqq.kandian.repo.feeds.entity;

public class InsertArticleInfo
{
  public long a;
  public int b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("articleId : ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("  launchFrom: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo
 * JD-Core Version:    0.7.0.1
 */