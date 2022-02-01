package com.tencent.mobileqq.kandian.repo.account;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class UserLevelInfo
  implements Serializable
{
  public int currentOpType;
  public long dailyTopicNum;
  public String errorDialogContent;
  public String errorDialogTitle;
  public boolean isInLevelGrayList;
  public String jumpUrl;
  public long level;
  public Map<Integer, String> operFobidWording = new HashMap();
  public Map<Integer, Boolean> opesAllowedMap = new HashMap();
  public long uin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserLevelInfo{uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.level);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", opesAllowed=");
    localStringBuilder.append(this.opesAllowedMap);
    localStringBuilder.append(", currentOpType=");
    localStringBuilder.append(this.currentOpType);
    localStringBuilder.append(", dailyTopicNum");
    localStringBuilder.append(this.dailyTopicNum);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.UserLevelInfo
 * JD-Core Version:    0.7.0.1
 */