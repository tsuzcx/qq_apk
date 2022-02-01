package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$GetPadListRspBody
  extends MessageMicro<GetPadListRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_endflag = PBField.initBool(false);
  public final PBBytesField bytes_timestamp = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<TimDocSSOMsg.PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg.PadInfo.class);
  public final PBUInt32Field uint32_auto_fresh_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64 }, new String[] { "uint32_retcode", "uint32_total_count", "uint32_timestamp", "uint32_offset", "bool_endflag", "rpt_msg_pad_list", "bytes_timestamp", "uint32_auto_fresh_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, localByteStringMicro, Integer.valueOf(0) }, GetPadListRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.GetPadListRspBody
 * JD-Core Version:    0.7.0.1
 */