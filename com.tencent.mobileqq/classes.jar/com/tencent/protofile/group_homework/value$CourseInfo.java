package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class value$CourseInfo
  extends MessageMicro<CourseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "course_id", "course_name" }, new Object[] { Integer.valueOf(0), "" }, CourseInfo.class);
  public final PBUInt32Field course_id = PBField.initUInt32(0);
  public final PBStringField course_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.CourseInfo
 * JD-Core Version:    0.7.0.1
 */