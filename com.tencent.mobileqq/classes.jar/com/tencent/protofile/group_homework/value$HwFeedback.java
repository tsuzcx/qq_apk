package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value$HwFeedback
  extends MessageMicro<HwFeedback>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 82, 88, 96, 106, 162, 168 }, new String[] { "uin", "nick", "head", "status", "remind_ts", "review_ts", "feedback_ts", "content", "content_storage", "correct_rate", "openId", "relation", "user_status" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0) }, HwFeedback.class);
  public value.HwFeedback.FbContent content = new value.HwFeedback.FbContent();
  public final PBInt32Field content_storage = PBField.initInt32(0);
  public final PBUInt32Field correct_rate = PBField.initUInt32(0);
  public final PBUInt64Field feedback_ts = PBField.initUInt64(0L);
  public final PBStringField head = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField openId = PBField.initString("");
  public final PBRepeatMessageField<value.HwFeedback.Relation> relation = PBField.initRepeatMessage(value.HwFeedback.Relation.class);
  public final PBUInt64Field remind_ts = PBField.initUInt64(0L);
  public final PBUInt64Field review_ts = PBField.initUInt64(0L);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field user_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HwFeedback
 * JD-Core Version:    0.7.0.1
 */