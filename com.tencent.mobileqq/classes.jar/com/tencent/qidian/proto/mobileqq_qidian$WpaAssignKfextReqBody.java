package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$WpaAssignKfextReqBody
  extends MessageMicro<WpaAssignKfextReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_need_sigmsg = PBField.initBool(false);
  public final PBBytesField bytes_sigT_kf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_rkey = PBField.initString("");
  public final PBUInt32Field uint32_wpa_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_assign_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_customer_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "uint32_wpa_type", "bytes_sigT_kf", "uint64_assign_id", "uint64_customer_uin", "str_rkey", "bool_need_sigmsg" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), "", Boolean.valueOf(false) }, WpaAssignKfextReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextReqBody
 * JD-Core Version:    0.7.0.1
 */