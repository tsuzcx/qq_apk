package com.tencent.now_proxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class pb_now_proxy$ForwardReq
  extends MessageMicro<ForwardReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField a2 = PBField.initString("");
  public final PBRepeatMessageField<pb_now_proxy.AuthInfo> authInfo = PBField.initRepeatMessage(pb_now_proxy.AuthInfo.class);
  public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field codec = PBField.initUInt32(0);
  public final PBStringField original_id = PBField.initString("");
  public final PBUInt32Field original_id_type = PBField.initUInt32(0);
  public final PBStringField original_key = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field stream_type = PBField.initUInt32(0);
  public final PBUInt32Field subcmd = PBField.initUInt32(0);
  public final PBUInt32Field target_env = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBStringField token = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
  public final PBUInt32Field version_code = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 90, 98, 104, 112, 122, 128, 138 }, new String[] { "cmd", "subcmd", "uid", "tinyid", "a2", "platform", "version", "busi_buf", "version_code", "stream_type", "original_id", "original_key", "original_id_type", "codec", "token", "target_env", "authInfo" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), Long.valueOf(0L), "", localInteger, "", localByteStringMicro, localInteger, localInteger, "", "", localInteger, localInteger, "", localInteger, null }, ForwardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.now_proxy.pb_now_proxy.ForwardReq
 * JD-Core Version:    0.7.0.1
 */