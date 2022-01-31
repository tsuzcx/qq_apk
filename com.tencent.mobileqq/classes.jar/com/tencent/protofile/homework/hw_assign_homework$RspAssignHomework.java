package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hw_assign_homework$RspAssignHomework
  extends MessageMicro<RspAssignHomework>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "errinfo", "hw_id" }, new Object[] { null, Long.valueOf(0L) }, RspAssignHomework.class);
  public hw_assign_homework.ErrorInfo errinfo = new hw_assign_homework.ErrorInfo();
  public final PBUInt64Field hw_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_assign_homework.RspAssignHomework
 * JD-Core Version:    0.7.0.1
 */