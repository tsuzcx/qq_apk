package com.tencent.mobileqq.now.wnsilivehead;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WnsHeadProto$ForwardReq
  extends MessageMicro<ForwardReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField a2 = PBField.initString("");
  public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField client_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field codec = PBField.initUInt32(0);
  public final PBUInt32Field orginal_key_type = PBField.initUInt32(0);
  public final PBStringField original_id = PBField.initString("");
  public final PBUInt32Field original_id_type = PBField.initUInt32(0);
  public final PBStringField original_key = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field stream_type = PBField.initUInt32(0);
  public final PBUInt32Field target_env = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBStringField token = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
  public final PBUInt32Field version_code = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 56, 64, 74, 82, 88, 96, 106, 112, 130, 136 }, new String[] { "uid", "tinyid", "a2", "platform", "version", "busi_buf", "version_code", "stream_type", "original_id", "original_key", "original_id_type", "codec", "token", "target_env", "client_id", "orginal_key_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ForwardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto.ForwardReq
 * JD-Core Version:    0.7.0.1
 */