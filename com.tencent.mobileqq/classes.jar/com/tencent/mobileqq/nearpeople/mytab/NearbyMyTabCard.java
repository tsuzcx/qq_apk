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
  public List configList = new ArrayList();
  public int currentCharm;
  public int gender;
  public int giftNum;
  public int godFlag;
  public int likeTotalNum;
  public int newLikeNum;
  public int nextCharm;
  public String nickName = "";
  public Long uin;
  public List visitors = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("[").append("uin = ").append(this.uin).append(", nickName = ").append(this.nickName).append(", newLikeNum = ").append(this.newLikeNum).append(", charmValue = ").append(this.charmValue).append(", charmLevel = ").append(this.charmLevel).append(", currentCharm = ").append(this.currentCharm).append(", nextCharm = ").append(this.nextCharm).append(", giftNum = ").append(this.giftNum).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard
 * JD-Core Version:    0.7.0.1
 */