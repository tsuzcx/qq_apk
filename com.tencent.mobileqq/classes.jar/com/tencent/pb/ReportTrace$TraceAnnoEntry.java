package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportTrace$TraceAnnoEntry
  extends MessageMicro<TraceAnnoEntry>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field feature_id = PBField.initUInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBUInt64Field server_timestamp = PBField.initUInt64(0L);
  public final PBRepeatMessageField<ReportTrace.SpanAnnoEntry> span_anno_list = PBField.initRepeatMessage(ReportTrace.SpanAnnoEntry.class);
  public final PBUInt64Field trace_id = PBField.initUInt64(0L);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48 }, new String[] { "uid", "trace_id", "span_anno_list", "ret", "server_timestamp", "feature_id" }, new Object[] { "", localLong, null, localInteger, localLong, localInteger }, TraceAnnoEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.TraceAnnoEntry
 * JD-Core Version:    0.7.0.1
 */