package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TtsResBody$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField islast = PBField.initBool(false);
  public final PBUInt32Field opus_bit_rate = PBField.initUInt32(0);
  public final PBUInt32Field opus_channels = PBField.initUInt32(0);
  public final PBUInt32Field opus_frame_size = PBField.initUInt32(0);
  public final PBUInt32Field opus_sample_rate = PBField.initUInt32(0);
  public final PBUInt32Field out_seq = PBField.initUInt32(0);
  public final PBUInt32Field pcm_sample_rate = PBField.initUInt32(0);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField session_id = PBField.initString("");
  public final PBRepeatMessageField<TtsResBody.voice_item> voice_data = PBField.initRepeatMessage(TtsResBody.voice_item.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 64, 72, 80 }, new String[] { "ret_code", "session_id", "out_seq", "voice_data", "islast", "pcm_sample_rate", "opus_sample_rate", "opus_channels", "opus_bit_rate", "opus_frame_size" }, new Object[] { localInteger, "", localInteger, null, Boolean.valueOf(false), localInteger, localInteger, localInteger, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.TtsResBody.RspBody
 * JD-Core Version:    0.7.0.1
 */