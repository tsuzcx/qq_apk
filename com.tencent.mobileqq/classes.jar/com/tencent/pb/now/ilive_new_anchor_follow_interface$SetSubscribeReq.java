package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_new_anchor_follow_interface$SetSubscribeReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uin", "flag1", "flag2", "anchor_uin_list", "flag_open_sound", "flag_open_vibration", "flag_ios_push" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SetSubscribeReq.class);
  public final PBRepeatField anchor_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field flag1 = PBField.initUInt32(0);
  public final PBUInt32Field flag2 = PBField.initUInt32(0);
  public final PBUInt32Field flag_ios_push = PBField.initUInt32(0);
  public final PBUInt32Field flag_open_sound = PBField.initUInt32(0);
  public final PBUInt32Field flag_open_vibration = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.SetSubscribeReq
 * JD-Core Version:    0.7.0.1
 */