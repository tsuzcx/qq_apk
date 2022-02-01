package com.tencent.mobileqq.troop.association.data;

import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import java.util.List;

public class AllianceItem
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("AllianceItem{uin='");
    localStringBuilder2.append(this.uin);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", adminUin='");
    localStringBuilder2.append(this.adminUin);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", createTime='");
    localStringBuilder2.append(this.createTime);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", associatedTroopCount='");
    localStringBuilder2.append(this.associatedTroopCount);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", nextTroopUin='");
    localStringBuilder2.append(this.nextTroopUin);
    localStringBuilder2.append('\'');
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.associatedTroopList != null)
    {
      localStringBuilder1.append(", associatedTroopList='");
      int j = this.associatedTroopList.size();
      int i = 0;
      while (i < j)
      {
        if (i == j - 1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(((AssociatedTroopItem)this.associatedTroopList.get(i)).toString());
          localStringBuilder2.append("'");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(((AssociatedTroopItem)this.associatedTroopList.get(i)).toString());
          localStringBuilder2.append("、");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        i += 1;
      }
    }
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.association.data.AllianceItem
 * JD-Core Version:    0.7.0.1
 */