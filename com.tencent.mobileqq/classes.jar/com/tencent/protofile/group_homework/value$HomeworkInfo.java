package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value$HomeworkInfo
  extends MessageMicro<HomeworkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field course_id = PBField.initUInt32(0);
  public final PBStringField course_name = PBField.initString("");
  public final PBUInt64Field create_ts = PBField.initUInt64(0L);
  public final PBStringField date = PBField.initString("");
  public value.ExamMsg exam_msg = new value.ExamMsg();
  public final PBUInt32Field feedback = PBField.initUInt32(0);
  public final PBUInt32Field feedback_num = PBField.initUInt32(0);
  public final PBUInt64Field feedback_ts = PBField.initUInt64(0L);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt64Field hw_id = PBField.initUInt64(0L);
  public final PBUInt32Field hw_type = PBField.initUInt32(0);
  public final PBBoolField is_read = PBField.initBool(false);
  public value.MultiMedia multi_media = new value.MultiMedia();
  public final PBBoolField need_feedback = PBField.initBool(false);
  public final PBUInt64Field push_time = PBField.initUInt64(0L);
  public final PBRepeatField<Long> syncgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field team_id = PBField.initUInt64(0L);
  public final PBStringField title = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 80, 90, 96, 104, 114, 120, 128, 136, 144, 152, 160, 168 }, new String[] { "group_id", "uin", "course_id", "course_name", "title", "content", "date", "need_feedback", "push_time", "feedback_ts", "multi_media", "team_id", "hw_type", "exam_msg", "syncgids", "hw_id", "appid", "feedback_num", "is_read", "feedback", "create_ts" }, new Object[] { localLong, localLong, localInteger, "", "", localByteStringMicro, "", localBoolean, localLong, localLong, null, localLong, localInteger, null, localLong, localLong, localInteger, localInteger, localBoolean, localInteger, localLong }, HomeworkInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HomeworkInfo
 * JD-Core Version:    0.7.0.1
 */