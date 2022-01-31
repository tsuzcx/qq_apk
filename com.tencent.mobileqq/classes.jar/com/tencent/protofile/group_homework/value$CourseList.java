package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class value$CourseList
  extends MessageMicro<CourseList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "course_info" }, new Object[] { null }, CourseList.class);
  public final PBRepeatMessageField<value.CourseInfo> course_info = PBField.initRepeatMessage(value.CourseInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.CourseList
 * JD-Core Version:    0.7.0.1
 */