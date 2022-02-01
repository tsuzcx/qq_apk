package com.tencent.mobileqq.troop.recommend.data;

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
    int i = this.privilege;
    if ((i != 0) && (i != 1)) {
      return i == 2;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecommendTroopItem{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", intro='");
    localStringBuilder.append(this.intro);
    localStringBuilder.append('\'');
    localStringBuilder.append(", memberNum=");
    localStringBuilder.append(this.memberNum);
    localStringBuilder.append(", troopType=");
    localStringBuilder.append(this.troopType);
    localStringBuilder.append(", recommendReason='");
    localStringBuilder.append(this.recommendReason);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recomAlgol='");
    localStringBuilder.append(this.recomAlgol);
    localStringBuilder.append('\'');
    localStringBuilder.append(", activityValue=");
    localStringBuilder.append(this.activity);
    localStringBuilder.append('\'');
    localStringBuilder.append(", privilege=");
    localStringBuilder.append(this.privilege);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isRequestJoin=");
    localStringBuilder.append(this.hasRequestJoin);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem
 * JD-Core Version:    0.7.0.1
 */