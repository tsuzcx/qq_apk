package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hw_get_homework_info$ReqGetHomeworkInfo
  extends MessageMicro<ReqGetHomeworkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "hw_id" }, new Object[] { Long.valueOf(0L) }, ReqGetHomeworkInfo.class);
  public final PBUInt64Field hw_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_get_homework_info.ReqGetHomeworkInfo
 * JD-Core Version:    0.7.0.1
 */