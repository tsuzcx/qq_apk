package com.tencent.mobileqq.qassistant.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd67$VoiceAssistantReq
  extends MessageMicro<VoiceAssistantReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field scene = PBField.initInt32(0);
  public final PBStringField str_voice_id = PBField.initString("");
  public final PBUInt32Field uint32_bits_per_sample = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first = PBField.initUInt32(0);
  public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_samples_per_sec = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_encode_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_file_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88 }, new String[] { "uint64_uin", "uint32_bits_per_sample", "uint32_voice_file_type", "uint32_voice_encode_type", "uint32_samples_per_sec", "str_voice_id", "uint32_offset", "uint32_is_first", "uint32_is_end", "uint32_service_id", "scene" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, localInteger }, VoiceAssistantReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.proto.cmd67.VoiceAssistantReq
 * JD-Core Version:    0.7.0.1
 */