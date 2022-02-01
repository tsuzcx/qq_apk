package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Bdh_extinfo$QQVoiceResult
  extends MessageMicro<QQVoiceResult>
{
  public static final int BYTES_PINYIN_FIELD_NUMBER = 2;
  public static final int BYTES_TEXT_FIELD_NUMBER = 1;
  public static final int UINT32_SOURCE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pinyin = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_text", "bytes_pinyin", "uint32_source" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, QQVoiceResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.QQVoiceResult
 * JD-Core Version:    0.7.0.1
 */