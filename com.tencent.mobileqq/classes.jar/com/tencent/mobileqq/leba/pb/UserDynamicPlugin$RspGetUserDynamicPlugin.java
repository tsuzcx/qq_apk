package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserDynamicPlugin$RspGetUserDynamicPlugin
  extends MessageMicro<RspGetUserDynamicPlugin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "plugin_id", "last_time", "ret", "plugin_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetUserDynamicPlugin.class);
  public final PBUInt32Field last_time = PBField.initUInt32(0);
  public final PBRepeatField<Integer> plugin_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.pb.UserDynamicPlugin.RspGetUserDynamicPlugin
 * JD-Core Version:    0.7.0.1
 */