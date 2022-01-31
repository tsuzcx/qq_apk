package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Bdh_extinfo$QQVoiceExtReq
  extends MessageMicro<QQVoiceExtReq>
{
  public static final int BYTES_QID_FIELD_NUMBER = 1;
  public static final int UINT32_BITS_FIELD_NUMBER = 4;
  public static final int UINT32_CHANNEL_FIELD_NUMBER = 5;
  public static final int UINT32_FMT_FIELD_NUMBER = 2;
  public static final int UINT32_PINYIN_FIELD_NUMBER = 6;
  public static final int UINT32_RATE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_qid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bits = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fmt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pinyin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rate = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "bytes_qid", "uint32_fmt", "uint32_rate", "uint32_bits", "uint32_channel", "uint32_pinyin" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QQVoiceExtReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.QQVoiceExtReq
 * JD-Core Version:    0.7.0.1
 */