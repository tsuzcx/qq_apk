package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportTrace$SpanAnnoEntry
  extends MessageMicro<SpanAnnoEntry>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField anno_msg = PBField.initString("");
  public final PBInt32Field errCode = PBField.initInt32(0);
  public final PBUInt32Field span_id = PBField.initUInt32(0);
  public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "span_id", "time_stamp", "anno_msg", "errCode" }, new Object[] { localInteger, Long.valueOf(0L), "", localInteger }, SpanAnnoEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.SpanAnnoEntry
 * JD-Core Version:    0.7.0.1
 */