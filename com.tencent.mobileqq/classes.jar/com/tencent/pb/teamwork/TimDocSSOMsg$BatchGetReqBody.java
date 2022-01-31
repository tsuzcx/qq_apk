package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$BatchGetReqBody
  extends MessageMicro<BatchGetReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_appid", "msg_login_info", "rpt_msg_padid_list" }, new Object[] { Integer.valueOf(0), null, null }, BatchGetReqBody.class);
  public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
  public final PBRepeatMessageField<TimDocSSOMsg.PadId> rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg.PadId.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.BatchGetReqBody
 * JD-Core Version:    0.7.0.1
 */