package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportTrace$SpanEntry
  extends MessageMicro<SpanEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "span_id", "time_stamp", "result", "param_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, SpanEntry.class);
  public final PBRepeatMessageField<ReportTrace.ExtParam> param_list = PBField.initRepeatMessage(ReportTrace.ExtParam.class);
  public ReportTrace.reportStat result = new ReportTrace.reportStat();
  public final PBUInt32Field span_id = PBField.initUInt32(0);
  public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.SpanEntry
 * JD-Core Version:    0.7.0.1
 */