package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow$TimTodoNotification
  extends MessageMicro<TimTodoNotification>
{
  public static final int SHARE_TODO = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_notice_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_remind_end = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_remind_start = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "enum_notice_type", "bytes_todo_id", "uint64_author_uin", "bytes_title", "uint64_remind_start", "uint64_remind_end" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localLong, localByteStringMicro2, localLong, localLong }, TimTodoNotification.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.TimTodoNotification
 * JD-Core Version:    0.7.0.1
 */