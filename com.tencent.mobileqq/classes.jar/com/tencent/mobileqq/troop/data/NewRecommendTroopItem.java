package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import java.util.List;
import tencent.im.oidb.cmd0x935.oidb_0x935.Label;

public class NewRecommendTroopItem
  extends Entity
{
  public int group_flag;
  public int group_flag_ext;
  public List<oidb_0x935.Label> labelList;
  public int memberNum;
  public String memo;
  public String name;
  public String owner_uin;
  public String recommendReason;
  oidb_0x935.Label tag_wording;
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NewRecommendTroopItem
 * JD-Core Version:    0.7.0.1
 */