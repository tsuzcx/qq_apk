package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetAccountTypeRspBody
  extends MessageMicro<GetAccountTypeRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_result", "uint64_kfext_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetAccountTypeRspBody.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetAccountTypeRspBody
 * JD-Core Version:    0.7.0.1
 */