package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$RemindTimer
  extends MessageMicro<RemindTimer>
{
  public static final int AFTER_START_TIME = 2;
  public static final int BEFORE_START_TIME = 1;
  public static final int EVERY_DAY = 2;
  public static final int EVERY_FORTNIGHT = 4;
  public static final int EVERY_MONTH = 5;
  public static final int EVERY_WEEK = 3;
  public static final int EVERY_WORKDAY = 6;
  public static final int EVERY_YEAR = 7;
  public static final int NO_REPEATE = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_start_time", "uint64_end_time", "enum_remind_offset_type", "uint32_remind_offset", "rpt_msg_observers", "enum_repeat_type", "uint32_remind_flag", "rpt_msg_repeated_effective_timespan" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1), Integer.valueOf(0), null }, RemindTimer.class);
  public final PBEnumField enum_remind_offset_type = PBField.initEnum(1);
  public final PBEnumField enum_repeat_type = PBField.initEnum(1);
  public final PBRepeatMessageField<Qworkflow.Observer> rpt_msg_observers = PBField.initRepeatMessage(Qworkflow.Observer.class);
  public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_repeated_effective_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
  public final PBUInt32Field uint32_remind_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remind_offset = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.RemindTimer
 * JD-Core Version:    0.7.0.1
 */