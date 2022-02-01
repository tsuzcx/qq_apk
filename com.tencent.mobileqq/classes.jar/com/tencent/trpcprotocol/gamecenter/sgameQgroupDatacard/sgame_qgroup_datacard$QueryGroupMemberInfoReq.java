package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class sgame_qgroup_datacard$QueryGroupMemberInfoReq
  extends MessageMicro<QueryGroupMemberInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "groupId", "uinList" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, QueryGroupMemberInfoReq.class);
  public final PBInt64Field groupId = PBField.initInt64(0L);
  public final PBRepeatField<Long> uinList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupMemberInfoReq
 * JD-Core Version:    0.7.0.1
 */