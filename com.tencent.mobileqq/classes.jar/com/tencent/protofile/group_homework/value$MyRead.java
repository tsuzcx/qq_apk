package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class value$MyRead
  extends MessageMicro<MyRead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "hw_ids" }, new Object[] { Long.valueOf(0L) }, MyRead.class);
  public final PBRepeatField<Long> hw_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.MyRead
 * JD-Core Version:    0.7.0.1
 */