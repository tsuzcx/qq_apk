package com.tencent.mobileqq.troop.recommend.data;

public class RecentRecommendTroopItem
  extends RecommendTroopItem
{
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecommendTroopItem{uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|, name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append("|, labelStr=");
    localStringBuilder.append(this.labelStr);
    localStringBuilder.append("|, labelList=");
    localStringBuilder.append(this.labelList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem
 * JD-Core Version:    0.7.0.1
 */