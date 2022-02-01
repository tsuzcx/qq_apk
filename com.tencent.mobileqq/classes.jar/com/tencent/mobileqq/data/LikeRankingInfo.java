package com.tencent.mobileqq.data;

public class LikeRankingInfo
{
  public int likeCountOfToday;
  public int rankingNum;
  public int totalLikeCount;
  public long uin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin");
    localStringBuilder.append(":");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(",");
    localStringBuilder.append("todayVoteCount");
    localStringBuilder.append(":");
    localStringBuilder.append(this.likeCountOfToday);
    localStringBuilder.append(",");
    localStringBuilder.append("rank");
    localStringBuilder.append(":");
    localStringBuilder.append(this.rankingNum);
    localStringBuilder.append(",");
    localStringBuilder.append("total");
    localStringBuilder.append(":");
    localStringBuilder.append(this.totalLikeCount);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.LikeRankingInfo
 * JD-Core Version:    0.7.0.1
 */