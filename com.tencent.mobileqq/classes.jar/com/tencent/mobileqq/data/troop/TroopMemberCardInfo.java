package com.tencent.mobileqq.data.troop;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="troopuin,memberuin")
public class TroopMemberCardInfo
  extends Entity
{
  public int charm;
  public String colorNick;
  public int colorNickId;
  public String email;
  public String job;
  public String level;
  public int mVipLevel;
  public int mVipType;
  public String memberuin;
  public String memo;
  public String name;
  public String nick;
  public byte sex = -1;
  public String tel;
  public int torchFlag;
  public String troopuin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopMemberCardInfo
 * JD-Core Version:    0.7.0.1
 */