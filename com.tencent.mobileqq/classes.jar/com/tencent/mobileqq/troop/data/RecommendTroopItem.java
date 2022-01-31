package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class RecommendTroopItem
  extends Entity
{
  public String intro;
  public List labelList;
  public int memberNum;
  public String name;
  public String recommendReason;
  public int troopType;
  @unique
  public String uin;
  public byte[] x9fbRgroupInfo;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.RecommendTroopItem
 * JD-Core Version:    0.7.0.1
 */