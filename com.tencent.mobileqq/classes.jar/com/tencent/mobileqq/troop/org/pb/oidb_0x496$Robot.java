package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$Robot
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58 }, new String[] { "version", "uin_range", "fire_keywords", "start_keywords", "end_keywords", "session_timeout", "subscribe_categories" }, new Object[] { Integer.valueOf(0), null, "", "", "", Integer.valueOf(0), null }, Robot.class);
  public final PBRepeatField end_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField fire_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field session_timeout = PBField.initUInt32(0);
  public final PBRepeatField start_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField subscribe_categories = PBField.initRepeatMessage(oidb_0x496.RobotSubscribeCategory.class);
  public final PBRepeatMessageField uin_range = PBField.initRepeatMessage(oidb_0x496.UinRange.class);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot
 * JD-Core Version:    0.7.0.1
 */