package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;

public class RecommendTroopItem
  extends Entity
{
  private static final String JUMP_SCHEME = "mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=%s&subsource_id=%s";
  public int activity;
  public String authSig;
  @notColumn
  public boolean hasRequestJoin;
  public String intro;
  public List<oidb_0x9fb.Label> labelList;
  public String labelStr;
  public int memberNum;
  public String name;
  public int privilege;
  public String recomAlgol;
  public String recommendReason;
  public int troopType;
  @unique
  public String uin;
  public byte[] x935RgroupInfo;
  public byte[] x9fbRgroupInfo;
  
  public String getJumpUrl(int paramInt)
  {
    return String.format("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=%s&subsource_id=%s", new Object[] { this.uin, Integer.valueOf(paramInt) });
  }
  
  public boolean isJoined()
  {
    return (this.privilege == 0) || (this.privilege == 1) || (this.privilege == 2);
  }
  
  public String toString()
  {
    return "RecommendTroopItem{uin='" + this.uin + '\'' + ", name='" + this.name + '\'' + ", intro='" + this.intro + '\'' + ", memberNum=" + this.memberNum + ", troopType=" + this.troopType + ", recommendReason='" + this.recommendReason + '\'' + ", recomAlgol='" + this.recomAlgol + '\'' + ", activityValue=" + this.activity + '\'' + ", privilege=" + this.privilege + '\'' + ", isRequestJoin=" + this.hasRequestJoin + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.RecommendTroopItem
 * JD-Core Version:    0.7.0.1
 */