package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipVoiceChange$voiceChangeReq
  extends MessageMicro<voiceChangeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 82 }, new String[] { "int32_sub_cmd", "int32_platform", "str_qq_version", "msg_subcmd0x1_req_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, voiceChangeReq.class);
  public final PBInt32Field int32_platform = PBField.initInt32(0);
  public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
  public VipVoiceChange.subCmd0x1ReqAuth msg_subcmd0x1_req_auth = new VipVoiceChange.subCmd0x1ReqAuth();
  public final PBStringField str_qq_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.voiceChange.VipVoiceChange.voiceChangeReq
 * JD-Core Version:    0.7.0.1
 */