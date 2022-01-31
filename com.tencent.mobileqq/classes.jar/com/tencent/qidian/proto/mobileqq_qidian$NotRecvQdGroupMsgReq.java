package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$NotRecvQdGroupMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_extuin", "uint64_kfuin", "uint64_taskid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, NotRecvQdGroupMsgReq.class);
  public final PBUInt64Field uint64_extuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_taskid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.NotRecvQdGroupMsgReq
 * JD-Core Version:    0.7.0.1
 */