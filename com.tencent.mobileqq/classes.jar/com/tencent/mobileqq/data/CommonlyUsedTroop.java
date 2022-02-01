package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class CommonlyUsedTroop
  extends Entity
{
  public long addedTimestamp;
  @unique
  public String troopUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.CommonlyUsedTroop
 * JD-Core Version:    0.7.0.1
 */