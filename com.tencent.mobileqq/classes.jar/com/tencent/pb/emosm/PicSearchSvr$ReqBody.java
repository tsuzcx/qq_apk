package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PicSearchSvr$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_app_qua = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> bytes_key_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_user_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_open_emotion = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_support_emotion = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint64_to_uin", "bytes_user_text", "bytes_key_word", "uin32_gender", "uint32_age", "uint32_open_emotion", "bytes_app_qua", "uint32_support_emotion" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.PicSearchSvr.ReqBody
 * JD-Core Version:    0.7.0.1
 */