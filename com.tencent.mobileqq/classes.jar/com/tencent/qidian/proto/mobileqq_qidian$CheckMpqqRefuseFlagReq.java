package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$CheckMpqqRefuseFlagReq
  extends MessageMicro<CheckMpqqRefuseFlagReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mpqq_uin", "uint64_qq_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, CheckMpqqRefuseFlagReq.class);
  public final PBUInt64Field uint64_mpqq_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagReq
 * JD-Core Version:    0.7.0.1
 */