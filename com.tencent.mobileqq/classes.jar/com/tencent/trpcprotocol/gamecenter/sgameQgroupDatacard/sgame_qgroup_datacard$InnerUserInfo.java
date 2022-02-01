package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class sgame_qgroup_datacard$InnerUserInfo
  extends MessageMicro<InnerUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72, 80 }, new String[] { "uin", "updateTime", "grade", "loseNumber", "winNumber", "mvpNumber", "bestHeroList", "groupFightScore", "matchNumber", "bestOccupation" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, InnerUserInfo.class);
  public final PBRepeatMessageField<sgame_qgroup_datacard.InnerUserHeroInfo> bestHeroList = PBField.initRepeatMessage(sgame_qgroup_datacard.InnerUserHeroInfo.class);
  public final PBEnumField bestOccupation = PBField.initEnum(0);
  public final PBEnumField grade = PBField.initEnum(0);
  public final PBInt64Field groupFightScore = PBField.initInt64(0L);
  public final PBInt64Field loseNumber = PBField.initInt64(0L);
  public final PBInt64Field matchNumber = PBField.initInt64(0L);
  public final PBInt64Field mvpNumber = PBField.initInt64(0L);
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBInt64Field updateTime = PBField.initInt64(0L);
  public final PBInt64Field winNumber = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.InnerUserInfo
 * JD-Core Version:    0.7.0.1
 */