package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class sgame_qgroup_datacard$QueryGroupMemberInfoRsp
  extends MessageMicro<QueryGroupMemberInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "memberList" }, new Object[] { null }, QueryGroupMemberInfoRsp.class);
  public final PBRepeatMessageField<sgame_qgroup_datacard.GroupMemberInfo> memberList = PBField.initRepeatMessage(sgame_qgroup_datacard.GroupMemberInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupMemberInfoRsp
 * JD-Core Version:    0.7.0.1
 */