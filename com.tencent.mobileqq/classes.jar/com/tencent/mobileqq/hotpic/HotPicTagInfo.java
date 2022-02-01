package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class HotPicTagInfo
  extends Entity
  implements Comparable<HotPicTagInfo>
{
  public int position;
  @unique
  public int tagId;
  public String tagName;
  public int tagType;
  public int version;
  
  public int compareTo(HotPicTagInfo paramHotPicTagInfo)
  {
    int i = this.position;
    int j = paramHotPicTagInfo.position;
    if (i < j) {
      return -1;
    }
    if (i == j) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicTagInfo
 * JD-Core Version:    0.7.0.1
 */