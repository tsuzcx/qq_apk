package com.tencent.protofile.oidb_0xe21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe21$ADItem
  extends MessageMicro<ADItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rowkey", "read_duration", "read_time" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L) }, ADItem.class);
  public final PBUInt64Field read_duration = PBField.initUInt64(0L);
  public final PBUInt64Field read_time = PBField.initUInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe21.oidb_0xe21.ADItem
 * JD-Core Version:    0.7.0.1
 */