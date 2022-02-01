package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$BatchGetRspBody
  extends MessageMicro<BatchGetRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_retcode", "rpt_msg_pad_list" }, new Object[] { Integer.valueOf(0), null }, BatchGetRspBody.class);
  public final PBRepeatMessageField<TimDocSSOMsg.PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg.PadInfo.class);
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.BatchGetRspBody
 * JD-Core Version:    0.7.0.1
 */