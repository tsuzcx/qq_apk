package com.tencent.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ReportTrace$ReportTraceRsp
  extends MessageMicro<ReportTraceRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "report_interval", "report_num", "report_fail" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReportTraceRsp.class);
  public final PBUInt32Field report_fail = PBField.initUInt32(0);
  public final PBUInt32Field report_interval = PBField.initUInt32(0);
  public final PBUInt32Field report_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.ReportTrace.ReportTraceRsp
 * JD-Core Version:    0.7.0.1
 */