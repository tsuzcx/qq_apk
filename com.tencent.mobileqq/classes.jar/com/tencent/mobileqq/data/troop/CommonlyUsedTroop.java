package com.tencent.mobileqq.data.troop;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class CommonlyUsedTroop
  extends Entity
{
  public long addedTimestamp;
  @unique
  public String troopUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.CommonlyUsedTroop
 * JD-Core Version:    0.7.0.1
 */