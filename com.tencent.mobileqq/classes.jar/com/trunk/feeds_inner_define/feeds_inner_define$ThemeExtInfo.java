package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_inner_define$ThemeExtInfo
  extends MessageMicro<ThemeExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "rpt_talker_uins", "uint64_open_uin", "uint32_msg_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ThemeExtInfo.class);
  public final PBRepeatField<Long> rpt_talker_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_msg_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_open_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.ThemeExtInfo
 * JD-Core Version:    0.7.0.1
 */