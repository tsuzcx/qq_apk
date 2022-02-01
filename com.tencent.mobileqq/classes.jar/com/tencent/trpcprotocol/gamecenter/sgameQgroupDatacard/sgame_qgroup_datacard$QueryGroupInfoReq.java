package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class sgame_qgroup_datacard$QueryGroupInfoReq
  extends MessageMicro<QueryGroupInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "groupId" }, new Object[] { Long.valueOf(0L) }, QueryGroupInfoReq.class);
  public final PBInt64Field groupId = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupInfoReq
 * JD-Core Version:    0.7.0.1
 */