package com.tencent.mobileqq.troop.associations;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import java.util.List;

public class AllianceItem
  extends Entity
  implements Serializable
{
  public String adminName;
  public String adminUin;
  public int associatedTroopCount;
  public List<AssociatedTroopItem> associatedTroopList;
  public long createTime;
  public String nextTroopUin;
  @unique
  public String uin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AllianceItem{uin='" + this.uin + '\'' + ", adminUin='" + this.adminUin + '\'' + ", createTime='" + this.createTime + '\'' + ", associatedTroopCount='" + this.associatedTroopCount + '\'' + ", nextTroopUin='" + this.nextTroopUin + '\'');
    if (this.associatedTroopList != null)
    {
      localStringBuilder.append(", associatedTroopList='");
      int j = this.associatedTroopList.size();
      int i = 0;
      if (i < j)
      {
        if (i == j - 1) {
          localStringBuilder.append(((AssociatedTroopItem)this.associatedTroopList.get(i)).toString() + "'");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(((AssociatedTroopItem)this.associatedTroopList.get(i)).toString() + "、");
        }
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.associations.AllianceItem
 * JD-Core Version:    0.7.0.1
 */