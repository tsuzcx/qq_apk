package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetQiDianGroupInfoReq
  extends MessageMicro<GetQiDianGroupInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_groupcode", "uint64_groupowner" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetQiDianGroupInfoReq.class);
  public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
  public final PBUInt64Field uint64_groupowner = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetQiDianGroupInfoReq
 * JD-Core Version:    0.7.0.1
 */