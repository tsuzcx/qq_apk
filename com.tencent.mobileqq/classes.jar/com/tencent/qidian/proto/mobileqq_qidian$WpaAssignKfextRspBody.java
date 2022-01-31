package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$WpaAssignKfextRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sigT_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sigmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "int32_result", "uint64_ext_uin", "bytes_sigT_ext", "str_err_msg", "uint32_aio_type", "bytes_sigmsg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, "", Integer.valueOf(0), localByteStringMicro2 }, WpaAssignKfextRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextRspBody
 * JD-Core Version:    0.7.0.1
 */