package com.tencent.mobileqq.troop.api.essence.data;

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
    return "TroopCardEssenceMsg{troopUin='" + this.troopUin + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", msgContent=" + this.msgContent + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg
 * JD-Core Version:    0.7.0.1
 */