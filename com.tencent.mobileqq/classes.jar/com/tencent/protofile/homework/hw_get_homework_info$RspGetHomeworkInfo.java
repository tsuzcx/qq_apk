package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.protofile.group_homework.value.HomeworkInfo;

public final class hw_get_homework_info$RspGetHomeworkInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "errinfo", "info" }, new Object[] { null, null }, RspGetHomeworkInfo.class);
  public hw_get_homework_info.ErrorInfo errinfo = new hw_get_homework_info.ErrorInfo();
  public value.HomeworkInfo info = new value.HomeworkInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_get_homework_info.RspGetHomeworkInfo
 * JD-Core Version:    0.7.0.1
 */