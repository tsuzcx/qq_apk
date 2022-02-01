package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class sgame_qgroup_datacard$GroupMemberInfo
  extends MessageMicro<GroupMemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField grade = PBField.initEnum(0);
  public final PBStringField gradeIcon = PBField.initString("");
  public final PBStringField gradeName = PBField.initString("");
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBInt64Field uin = PBField.initInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "uin", "ret", "msg", "grade", "gradeName", "gradeIcon" }, new Object[] { Long.valueOf(0L), localInteger, "", localInteger, "", "" }, GroupMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.GroupMemberInfo
 * JD-Core Version:    0.7.0.1
 */