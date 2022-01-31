package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$GetSharedPadListRspBody
  extends MessageMicro<GetSharedPadListRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_retcode", "uint32_total_count", "uint32_timestamp", "rpt_msg_pad_list", "uint32_offset", "bool_endflag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false) }, GetSharedPadListRspBody.class);
  public final PBBoolField bool_endflag = PBField.initBool(false);
  public final PBRepeatMessageField<TimDocSSOMsg.PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg.PadInfo.class);
  public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.GetSharedPadListRspBody
 * JD-Core Version:    0.7.0.1
 */