package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class sgame_qgroup_datacard$GradeDistributed
  extends MessageMicro<GradeDistributed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "grade", "userCount" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GradeDistributed.class);
  public final PBEnumField grade = PBField.initEnum(0);
  public final PBInt64Field userCount = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.GradeDistributed
 * JD-Core Version:    0.7.0.1
 */