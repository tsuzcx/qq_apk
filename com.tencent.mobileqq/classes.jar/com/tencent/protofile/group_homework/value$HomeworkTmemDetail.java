package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class value$HomeworkTmemDetail
  extends MessageMicro<HomeworkTmemDetail>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field created = PBField.initInt64(0L);
  public final PBBytesField feed_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public value.HomeworkInfo info = new value.HomeworkInfo();
  public final PBInt32Field status = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "info", "status", "created", "feed_topic_id" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, HomeworkTmemDetail.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HomeworkTmemDetail
 * JD-Core Version:    0.7.0.1
 */