package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class sgame_qgroup_datacard$QueryUserInfoReq
  extends MessageMicro<QueryUserInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field groupId = PBField.initInt64(0L);
  public final PBInt64Field showUin = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "groupId", "showUin" }, new Object[] { localLong, localLong }, QueryUserInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryUserInfoReq
 * JD-Core Version:    0.7.0.1
 */