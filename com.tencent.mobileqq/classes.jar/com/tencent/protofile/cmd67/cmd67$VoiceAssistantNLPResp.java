package com.tencent.protofile.cmd67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd67$VoiceAssistantNLPResp
  extends MessageMicro<VoiceAssistantNLPResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 53 }, new String[] { "uint32_ret_code", "str_voice_id", "msg_intents", "msg_slots", "str_dialog_status", "time_use" }, new Object[] { Integer.valueOf(0), "", null, null, "", Float.valueOf(0.0F) }, VoiceAssistantNLPResp.class);
  public final PBRepeatMessageField<cmd67.Intent> msg_intents = PBField.initRepeatMessage(cmd67.Intent.class);
  public final PBRepeatMessageField<cmd67.Slot> msg_slots = PBField.initRepeatMessage(cmd67.Slot.class);
  public final PBStringField str_dialog_status = PBField.initString("");
  public final PBStringField str_voice_id = PBField.initString("");
  public final PBFloatField time_use = PBField.initFloat(0.0F);
  public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.cmd67.cmd67.VoiceAssistantNLPResp
 * JD-Core Version:    0.7.0.1
 */