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
    localStringBuilder.append("uin").append(":").append(this.uin);
    localStringBuilder.append(",").append("todayVoteCount").append(":").append(this.likeCountOfToday);
    localStringBuilder.append(",").append("rank").append(":").append(this.rankingNum);
    localStringBuilder.append(",").append("total").append(":").append(this.totalLikeCount);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.LikeRankingInfo
 * JD-Core Version:    0.7.0.1
 */