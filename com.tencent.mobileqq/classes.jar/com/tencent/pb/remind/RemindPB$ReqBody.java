package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RemindPB$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_method", "rep_set_info", "rep_clear_uin" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, ReqBody.class);
  public final PBRepeatField<Long> rep_clear_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<RemindPB.RemindItem> rep_set_info = PBField.initRepeatMessage(RemindPB.RemindItem.class);
  public final PBUInt32Field uint32_method = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.remind.RemindPB.ReqBody
 * JD-Core Version:    0.7.0.1
 */