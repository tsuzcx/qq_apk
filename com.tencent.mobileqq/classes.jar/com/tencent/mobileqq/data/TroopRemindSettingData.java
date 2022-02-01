package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopRemindSettingData
  extends Entity
{
  public int isOpenState;
  @unique
  public String troopUin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopRemindSettingData
 * JD-Core Version:    0.7.0.1
 */