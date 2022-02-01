package com.tencent.protofile.cmd67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd67$VoiceAssistASRContactResp
  extends MessageMicro<VoiceAssistASRContactResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "ret", "voice_id", "sr_seq", "type", "err_no", "reco_res" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, VoiceAssistASRContactResp.class);
  public final PBInt32Field err_no = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd67.ASRRecoRes> reco_res = PBField.initRepeatMessage(cmd67.ASRRecoRes.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBInt32Field sr_seq = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  public final PBStringField voice_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd67.cmd67.VoiceAssistASRContactResp
 * JD-Core Version:    0.7.0.1
 */