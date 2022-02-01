package com.tencent.mobileqq.nearpeople.mytab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NearbyMyTabCard
  implements Serializable
{
  public int age;
  public int carrier;
  public int charmLevel;
  public int charmValue;
  public List<NearbyMyTabCard.NearbyMyTabConfig> configList = new ArrayList();
  public int currentCharm;
  public int gender;
  public int giftNum;
  public int godFlag;
  public int likeTotalNum;
  public int newLikeNum;
  public int nextCharm;
  public String nickName = "";
  public Long uin;
  public List<Object> visitors = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("[");
    localStringBuilder.append("uin = ");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", nickName = ");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append(", newLikeNum = ");
    localStringBuilder.append(this.newLikeNum);
    localStringBuilder.append(", charmValue = ");
    localStringBuilder.append(this.charmValue);
    localStringBuilder.append(", charmLevel = ");
    localStringBuilder.append(this.charmLevel);
    localStringBuilder.append(", currentCharm = ");
    localStringBuilder.append(this.currentCharm);
    localStringBuilder.append(", nextCharm = ");
    localStringBuilder.append(this.nextCharm);
    localStringBuilder.append(", giftNum = ");
    localStringBuilder.append(this.giftNum);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard
 * JD-Core Version:    0.7.0.1
 */