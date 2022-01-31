package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class value$HomeworkLimit
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "count", "ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, HomeworkLimit.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HomeworkLimit
 * JD-Core Version:    0.7.0.1
 */