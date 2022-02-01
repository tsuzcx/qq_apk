package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value$HwFeedbackList
  extends MessageMicro<HwFeedbackList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 800 }, new String[] { "feedback", "total", "rate_noread", "rate_feedback", "is_hw_exist", "need_feedback", "hw_publisher", "gid", "team_id", "hw_type", "unreview_num", "reviewed_num", "feedback_num", "comment_num", "single_remind_limit", "onekey_remind_limit", "version" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HwFeedbackList.class);
  public final PBUInt32Field comment_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<value.HwFeedback> feedback = PBField.initRepeatMessage(value.HwFeedback.class);
  public final PBUInt32Field feedback_num = PBField.initUInt32(0);
  public final PBUInt64Field gid = PBField.initUInt64(0L);
  public final PBUInt64Field hw_publisher = PBField.initUInt64(0L);
  public final PBUInt32Field hw_type = PBField.initUInt32(0);
  public final PBInt32Field is_hw_exist = PBField.initInt32(0);
  public final PBInt32Field need_feedback = PBField.initInt32(0);
  public final PBInt32Field onekey_remind_limit = PBField.initInt32(0);
  public final PBInt32Field rate_feedback = PBField.initInt32(0);
  public final PBInt32Field rate_noread = PBField.initInt32(0);
  public final PBUInt32Field reviewed_num = PBField.initUInt32(0);
  public final PBInt32Field single_remind_limit = PBField.initInt32(0);
  public final PBUInt64Field team_id = PBField.initUInt64(0L);
  public final PBInt32Field total = PBField.initInt32(0);
  public final PBUInt32Field unreview_num = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HwFeedbackList
 * JD-Core Version:    0.7.0.1
 */