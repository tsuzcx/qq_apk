package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class value$GroupUserCourse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "course_list", "last_course", "default_exclude" }, new Object[] { null, null, null }, GroupUserCourse.class);
  public value.CourseList course_list = new value.CourseList();
  public value.CourseList default_exclude = new value.CourseList();
  public value.CourseInfo last_course = new value.CourseInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.GroupUserCourse
 * JD-Core Version:    0.7.0.1
 */