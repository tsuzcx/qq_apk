package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$VerifyWpaUinAndKeyReq
  extends MessageMicro<VerifyWpaUinAndKeyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uint64_dst_uin", "str_key", "str_json_info", "str_rkey", "uint32_terminal_type", "uint32_terminal_version" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, VerifyWpaUinAndKeyReq.class);
  public final PBStringField str_json_info = PBField.initString("");
  public final PBStringField str_key = PBField.initString("");
  public final PBStringField str_rkey = PBField.initString("");
  public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_terminal_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyReq
 * JD-Core Version:    0.7.0.1
 */