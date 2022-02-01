package com.tencent.mobileqq.kandian.repo.feeds.entity;

import java.io.Serializable;

public class LebaKDCellInfo
  implements Serializable
{
  public long articleID;
  public String extraInfo;
  public int templateID;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" articleID:");
    localStringBuilder.append(this.articleID);
    localStringBuilder.append(" templateID:");
    localStringBuilder.append(this.templateID);
    localStringBuilder.append(" extraInfo:");
    localStringBuilder.append(this.extraInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.LebaKDCellInfo
 * JD-Core Version:    0.7.0.1
 */