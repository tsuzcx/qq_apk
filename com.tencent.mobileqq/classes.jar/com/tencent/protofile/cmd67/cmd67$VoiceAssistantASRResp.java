package com.tencent.protofile.cmd67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd67$VoiceAssistantASRResp
  extends MessageMicro<VoiceAssistantASRResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 61, 66, 74 }, new String[] { "uint32_ret_code", "str_voice_id", "uint32_is_final", "str_text", "uint32_ack_offset", "int32_ack_len", "time_use", "contact_res", "reco_res" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), null, null }, VoiceAssistantASRResp.class);
  public cmd67.VoiceAssistASRContactResp contact_res = new cmd67.VoiceAssistASRContactResp();
  public final PBInt32Field int32_ack_len = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd67.ASRRecoRes> reco_res = PBField.initRepeatMessage(cmd67.ASRRecoRes.class);
  public final PBStringField str_text = PBField.initString("");
  public final PBStringField str_voice_id = PBField.initString("");
  public final PBFloatField time_use = PBField.initFloat(0.0F);
  public final PBUInt32Field uint32_ack_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd67.cmd67.VoiceAssistantASRResp
 * JD-Core Version:    0.7.0.1
 */