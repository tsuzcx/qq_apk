package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class sgame_qgroup_datacard$UserHeroInfo
  extends MessageMicro<UserHeroInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "heroId", "icon", "skill" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, UserHeroInfo.class);
  public final PBInt64Field heroId = PBField.initInt64(0L);
  public final PBStringField icon = PBField.initString("");
  public final PBEnumField skill = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.UserHeroInfo
 * JD-Core Version:    0.7.0.1
 */