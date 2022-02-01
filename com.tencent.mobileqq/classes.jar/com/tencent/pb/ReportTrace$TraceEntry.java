package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportTrace$TraceEntry
  extends MessageMicro<TraceEntry>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field extra1 = PBField.initUInt32(0);
  public final PBUInt32Field extra2 = PBField.initUInt32(0);
  public final PBUInt32Field extra3 = PBField.initUInt32(0);
  public final PBUInt32Field feature_id = PBField.initUInt32(0);
  public final PBStringField from_uid = PBField.initString("");
  public ReportTrace.reportStat result = new ReportTrace.reportStat();
  public final PBUInt64Field server_timestamp = PBField.initUInt64(0L);
  public final PBRepeatMessageField<ReportTrace.SpanEntry> span_list = PBField.initRepeatMessage(ReportTrace.SpanEntry.class);
  public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
  public final PBStringField to_uid = PBField.initString("");
  public final PBUInt64Field trace_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 64, 72, 80, 88 }, new String[] { "feature_id", "trace_id", "from_uid", "to_uid", "time_stamp", "span_list", "result", "extra1", "extra2", "extra3", "server_timestamp" }, new Object[] { localInteger, localLong, "", "", localLong, null, null, localInteger, localInteger, localInteger, localLong }, TraceEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.TraceEntry
 * JD-Core Version:    0.7.0.1
 */