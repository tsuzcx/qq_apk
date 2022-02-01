package com.tencent.mobileqq.troop.essence.data;

import java.io.Serializable;
import java.util.List;

public class TroopCardEssenceMsg
  implements Serializable
{
  public String jumpUrl;
  public List<TroopCardEssenceMsg.EssenceMsgContent> msgContent;
  public String troopUin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopCardEssenceMsg{troopUin='");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgContent=");
    localStringBuilder.append(this.msgContent);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg
 * JD-Core Version:    0.7.0.1
 */