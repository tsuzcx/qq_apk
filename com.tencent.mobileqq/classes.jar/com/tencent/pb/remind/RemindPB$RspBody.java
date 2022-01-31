package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RemindPB$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "int32_ret", "uint32_method", "msg_result", "msg_quota", "rep_set_info", "rep_clear_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, null, Long.valueOf(0L) }, RspBody.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public RemindPB.RemindQuota msg_quota = new RemindPB.RemindQuota();
  public final PBStringField msg_result = PBField.initString("");
  public final PBRepeatField<Long> rep_clear_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<RemindPB.RemindItem> rep_set_info = PBField.initRepeatMessage(RemindPB.RemindItem.class);
  public final PBUInt32Field uint32_method = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.remind.RemindPB.RspBody
 * JD-Core Version:    0.7.0.1
 */