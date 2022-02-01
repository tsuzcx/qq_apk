package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ReportTrace$ReportTraceReq
  extends MessageMicro<ReportTraceReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "trace_list" }, new Object[] { null, null }, ReportTraceReq.class);
  public ReportTrace.ReportHead head = new ReportTrace.ReportHead();
  public final PBRepeatMessageField<ReportTrace.TraceEntry> trace_list = PBField.initRepeatMessage(ReportTrace.TraceEntry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.ReportTraceReq
 * JD-Core Version:    0.7.0.1
 */