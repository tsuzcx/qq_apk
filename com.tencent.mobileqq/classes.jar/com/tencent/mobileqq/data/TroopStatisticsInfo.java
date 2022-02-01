package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopStatisticsInfo
  extends Entity
{
  public long count;
  @unique
  public String troopUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopStatisticsInfo
 * JD-Core Version:    0.7.0.1
 */