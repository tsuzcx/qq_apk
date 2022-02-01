package com.tencent.mobileqq.qassistant.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd67$VoiceAssistantResp
  extends MessageMicro<VoiceAssistantResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_contact_count = PBField.initInt32(0);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public cmd67.VoiceAssistantASRResp msg_asr_resp = new cmd67.VoiceAssistantASRResp();
  public cmd67.VoiceAssistantNLPResp msg_nlp_resp = new cmd67.VoiceAssistantNLPResp();
  public final PBRepeatMessageField<cmd67.UserInfo> msg_user_info = PBField.initRepeatMessage(cmd67.UserInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "int32_ret_code", "msg_asr_resp", "msg_nlp_resp", "msg_user_info", "int32_contact_count" }, new Object[] { localInteger, null, null, null, localInteger }, VoiceAssistantResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.proto.cmd67.VoiceAssistantResp
 * JD-Core Version:    0.7.0.1
 */