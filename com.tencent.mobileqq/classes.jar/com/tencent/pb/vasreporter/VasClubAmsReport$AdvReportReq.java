package com.tencent.pb.vasreporter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VasClubAmsReport$AdvReportReq
  extends MessageMicro<AdvReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "report_type", "report_url" }, new Object[] { Integer.valueOf(0), "" }, AdvReportReq.class);
  public final PBInt32Field report_type = PBField.initInt32(0);
  public final PBStringField report_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.vasreporter.VasClubAmsReport.AdvReportReq
 * JD-Core Version:    0.7.0.1
 */