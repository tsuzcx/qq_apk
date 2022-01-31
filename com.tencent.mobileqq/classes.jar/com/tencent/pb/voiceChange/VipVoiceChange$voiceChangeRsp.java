package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipVoiceChange$voiceChangeRsp
  extends MessageMicro<voiceChangeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42 }, new String[] { "int32_sub_cmd", "msg_subcmd0x1_rsp_auth" }, new Object[] { Integer.valueOf(0), null }, voiceChangeRsp.class);
  public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
  public VipVoiceChange.subCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new VipVoiceChange.subCmd0x1RspAuth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeRsp
 * JD-Core Version:    0.7.0.1
 */