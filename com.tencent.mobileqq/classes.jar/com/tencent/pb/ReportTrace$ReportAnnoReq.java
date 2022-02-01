package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ReportTrace$ReportAnnoReq
  extends MessageMicro<ReportAnnoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "anno_list" }, new Object[] { null, null }, ReportAnnoReq.class);
  public final PBRepeatMessageField<ReportTrace.TraceAnnoEntry> anno_list = PBField.initRepeatMessage(ReportTrace.TraceAnnoEntry.class);
  public ReportTrace.ReportHead head = new ReportTrace.ReportHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.ReportAnnoReq
 * JD-Core Version:    0.7.0.1
 */