package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class sgame_qgroup_datacard$InnerUserHeroInfo
  extends MessageMicro<InnerUserHeroInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "heroId", "fightScore", "skill", "mainOccupation" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, InnerUserHeroInfo.class);
  public final PBInt64Field fightScore = PBField.initInt64(0L);
  public final PBInt64Field heroId = PBField.initInt64(0L);
  public final PBEnumField mainOccupation = PBField.initEnum(0);
  public final PBEnumField skill = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.InnerUserHeroInfo
 * JD-Core Version:    0.7.0.1
 */