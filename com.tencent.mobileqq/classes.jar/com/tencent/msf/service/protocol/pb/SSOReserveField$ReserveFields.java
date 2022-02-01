package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SSOReserveField$ReserveFields
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field app_recv = PBField.initUInt64(0L);
  public final PBBytesField client_ipcookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field env_id = PBField.initUInt32(0);
  public final PBStringField extra = PBField.initString("");
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBUInt32Field locale_id = PBField.initUInt32(0);
  public final PBBytesField qimei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field sdk_recv = PBField.initUInt64(0L);
  public final PBUInt64Field sdk_send = PBField.initUInt64(0L);
  public final PBUInt64Field sso_recv = PBField.initUInt64(0L);
  public final PBUInt64Field sso_send = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98 }, new String[] { "type", "extra", "app_recv", "sdk_send", "sdk_recv", "sso_send", "sso_recv", "client_ipcookie", "flag", "env_id", "locale_id", "qimei" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ReserveFields.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.SSOReserveField.ReserveFields
 * JD-Core Version:    0.7.0.1
 */